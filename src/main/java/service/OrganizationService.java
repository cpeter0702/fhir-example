package service;

import Utils.FhirObjUtils;
import Utils.OrganizationUtils;
import dao.OrgContactDao;
import dao.OrganizationDao;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.resource.Organization;
import com.ibm.fhir.model.resource.Organization.Contact;
import com.ibm.fhir.model.type.Address;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.ContactPoint;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.AddressUse;
import com.ibm.fhir.model.type.code.IdentifierUse;

import java.util.*;

public class OrganizationService {
	private OrganizationUtils orgUtils = new OrganizationUtils();
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	public List<Organization> generateOrganizationJSON() {
		
		List<Organization> orgList = new ArrayList<>();
		List<OrganizationDao> hisOrgList = orgUtils.select();
		List<OrgContactDao> hisOrgContactList = orgUtils.selectContact();
		List<String> orgIdList = this.getOrgIdList(hisOrgList);
		Organization org = null;

		for (String thisOrgId : orgIdList) {

			Map<String, List<String>> identifierMap = this.filterIdentifierToMap(hisOrgList);
			Map<String, List<String>> aliasMap = this.filterOrgAliasToMap(hisOrgList);
			Map<String, List<ContactPoint>> telcomMap = this.filterTelecomIdentifierToMap(hisOrgList);
			Map<String, List<Address>> addrMap = this.filterAddressToMap(hisOrgList);
			Map<String, String> nameMap = this.filterNameToMap(hisOrgList);
			Map<String, List<Contact>> contactMap = this.filterContactAddressToMap(hisOrgContactList);
			
			List<Identifier> identifierList = this.setIdendifierObj(identifierMap, thisOrgId);
			
			org = Organization.builder()
				.identifier(identifierList)
				.active(Boolean.of(true))
				.name(nameMap.get(thisOrgId))
				.alias(aliasMap.get(thisOrgId))
				.telecom(telcomMap.get(thisOrgId))
				.address(addrMap.get(thisOrgId))
				.contact(contactMap.get(thisOrgId))
				.build();

			orgList.add(org);
		}

		return orgList;
	}

	// get orgIds
	public List<String> getOrgIdList(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		List<String> list = new ArrayList<>();

		for (OrganizationDao dao : daoList) {
			if (false == list.contains(String.of(dao.getOrgId()))) {
				list.add(String.of(dao.getOrgId()));
			}
		}
		return list;
	}

	// filter Name
	public Map<String, String> filterNameToMap(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		Map<String, String> hmap = new HashMap<>();
		
		for (OrganizationDao dao : daoList) {
			String thisOrgId = String.of(dao.getOrgId());
			if (hmap.keySet().contains(thisOrgId)) {
				continue;
			}
			hmap.put(thisOrgId, String.of(dao.getOrgName()));
		}
		
		return hmap;
	}
	
	
	// filter Contact
	public Map<String, List<Contact>> filterContactAddressToMap(List<OrgContactDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		
		Coding coding = objUtils.setCoding("http://terminology.hl7.org/CodeSystem/contactentity-type", null, "PRESS", null, null);
		
		Map<String, List<String>> orgMapContactIds = new HashMap<>();
		Map<String, HumanName> contactIdMapNames = new HashMap<>();
		Map<String, List<ContactPoint>> contactIdMapTelcom = new HashMap<>();
		Map<String, List<Address>> contactIdMapAddress = new HashMap<>();
		
		for (OrgContactDao dao : daoList) {
			String orgId = String.of(dao.getConOrgId());
			String contactId = String.of(dao.getConId());
			
			// get relationship between orgId and contactId
			if (orgMapContactIds.keySet().contains(orgId)) {
				List<String> contactIdList = orgMapContactIds.get(orgId);
				if (false == contactIdList.contains(contactId)) {
					contactIdList.add(contactId);
					orgMapContactIds.put(orgId, contactIdList);
				}
			} else {
				List<String> list = new ArrayList<>();
				list.add(contactId);
				orgMapContactIds.put(orgId, list);
			}
			
			// name
			HumanName humanName = HumanName.builder()
					.use(objUtils.mapHumanNameUse(dao.getConNameUse()))
					.text(String.of(dao.getConNameText()))
					.family(String.of(dao.getConNameFmaily()))
					.given(Arrays.asList(String.of(dao.getConNameGiven())))
					.prefix(Arrays.asList(String.of(dao.getConNamePrefix())))
					.build();
			
			if (false == contactIdMapNames.keySet().contains(contactId)) {
				contactIdMapNames.put(contactId, humanName);
			}
			
			// telcom
			ContactPoint contactPoint = ContactPoint.builder()
					.system(objUtils.mapTelcomType(dao.getTelType()))
					.value(String.of(dao.getTelValue()))
					.use(objUtils.mapTelcomUse(dao.getTelPurpose()))
					.build();
			
			if (contactIdMapTelcom.keySet().contains(contactId)) {
				List<ContactPoint> telcomList = contactIdMapTelcom.get(contactId);
				if (false == telcomList.contains(contactPoint)) {
					telcomList.add(contactPoint);
					contactIdMapTelcom.put(contactId, telcomList);
				}
			} else {
				List<ContactPoint> contactList = new ArrayList<>();
				contactList.add(contactPoint);
				contactIdMapTelcom.put(contactId, contactList);
			}
			
			// address
			List<String> lineList = new ArrayList<>();
			if (dao.getAddr1() != null) {
				lineList.add(String.of(dao.getAddr1()));
			}
			
			if (dao.getAddr2() != null) {
				lineList.add(String.of(dao.getAddr2()));
			}
			
			Address address = Address.builder()
					.use(AddressUse.WORK)
					.line(lineList)
					.city(String.of(dao.getAddrCity()))
					.district(String.of(dao.getAddrDist()))
					.state(String.of(dao.getAddrState()))
					.postalCode(String.of(dao.getAddrZipcode()))
					.country(String.of(dao.getAddrCountry()))
					.build();
			
			if (contactIdMapAddress.keySet().contains(contactId)) {
				List<Address> addrList = contactIdMapAddress.get(contactId);
				if (false == addrList.contains(address)) {
					addrList.add(address);
					contactIdMapAddress.put(contactId, addrList);
				}
			} else {
				List<Address> list = new ArrayList<>();
				list.add(address);
				contactIdMapAddress.put(contactId, list);
			}
			
		}
		
		Map<String, List<Contact>> contactMap = new HashMap<>();
		for (OrgContactDao dao : daoList) {
			String thisOrgId = String.of(dao.getConOrgId());
			String thisContactId = String.of(dao.getConId());
			
			Contact contact = Contact.builder()
					.purpose(CodeableConcept.builder().coding(coding).build())
					.name(contactIdMapNames.get(thisContactId))
					.telecom(contactIdMapTelcom.get(thisContactId))
					.address(contactIdMapAddress.get(thisContactId).get(0))
					.build();
			
			List<Contact> contactList = contactMap.get(thisOrgId) == null
					? new ArrayList<>() : contactMap.get(thisOrgId);
					
			if (false == contactList.contains(contact)) {
				contactList.add(contact);
				contactMap.put(thisOrgId, contactList);
			}
		}
		
		return contactMap;
	}
	
	// filter Addr
	public Map<String, List<Address>> filterAddressToMap(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		Map<String, List<Address>> hmap = new HashMap<>();
		for (OrganizationDao dao : daoList) {
			String thisOrgId = String.of(dao.getOrgId());
			List<Address> thisList = hmap.get(thisOrgId) == null 
					? new ArrayList<>() : hmap.get(thisOrgId);
			
			Address addr = Address.builder()
					.use(AddressUse.WORK)
					.line(Arrays.asList(String.of(dao.getAddr1()), String.of(dao.getAddr2())))
					.city(String.of(dao.getAddrCity()))
					.district(String.of(dao.getAddrDist()))
					.state(String.of(dao.getAddrState()))
					.postalCode(String.of(dao.getAddrZipCode()))
					.country(String.of(dao.getAddrCountry()))
					.build();
			
			if (false == thisList.contains(addr)) {
				thisList.add(addr);
				hmap.put(thisOrgId, thisList);
			}
		}
		
		
		return hmap;
	}
	// filter Telcom
	public Map<String, List<ContactPoint>> filterTelecomIdentifierToMap(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		Map<String, List<ContactPoint>> hmap = new HashMap<>();
		
		for (OrganizationDao dao : daoList) {
			String thisOrgId = String.of(dao.getOrgId());
			List<ContactPoint> thisList = hmap.get(thisOrgId) == null 
					? new ArrayList<>() : hmap.get(thisOrgId);
			
			ContactPoint cp = ContactPoint.builder()
				.system(objUtils.mapTelcomType(dao.getTelcomType()))
				.value(String.of(dao.getTelcomVal()))
				.use(objUtils.mapTelcomUse(dao.getTelcomPurpose()))
				.build();
			if (false == thisList.contains(cp)) {
				thisList.add(cp);
				hmap.put(thisOrgId, thisList);
			}
		}
		
		
		return hmap;
	}
	
	// filter Identifier
	public Map<String, List<String>> filterIdentifierToMap(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}

		Map<String, List<String>> map = new HashMap<>();
		String preOrgId = null;

		for (OrganizationDao dao : daoList) {
			if (preOrgId == null) {
				preOrgId = String.of(dao.getOrgId());
				map.put(String.of(dao.getOrgId()), Arrays.asList(String.of(dao.getOrgName()), String.of(dao.getOrgNameEn())));
			} else if (preOrgId.equals(String.of(dao.getOrgId()))) {
				continue;
			} else {
				preOrgId = String.of(dao.getOrgId());
				map.put(String.of(dao.getOrgId()), Arrays.asList(String.of(dao.getOrgName()), String.of(dao.getOrgNameEn())));
			}

		}

		return map;
	}

	// filter alias
	public HashMap<String, List<String>> filterOrgAliasToMap(List<OrganizationDao> daoList) {
		if (daoList == null || daoList.size() == 0) {
			return null;
		}
		
		HashMap<String, List<String>> hmap = new HashMap<>();

		for (OrganizationDao dao : daoList) {
			if (false == dao.getOrgNameType().equals("alias")) {
				continue;
			}

			String thisOrgId = String.of(dao.getOrgId());
			List<String> thisList = hmap.get(thisOrgId) == null 
					? new ArrayList<>() : hmap.get(thisOrgId);

			String aliasName = String.of(dao.getOrgNameDisplay());
			if (false == thisList.contains(aliasName)) {
				thisList.add(aliasName);
				hmap.put(thisOrgId, thisList);
			}

		}
		return hmap;
	}
	
	// set Identifier Object
	public List<Identifier> setIdendifierObj(Map<String, List<String>> identifierMap, String orgId) {
		if (identifierMap == null || identifierMap.keySet().size() == 0) {
			return null;
		}

		List<String> list = identifierMap.get(orgId);
		if (list == null || list.size() == 0) {
			return null;
		}

		List<Identifier> returnList = new ArrayList<>();

		for (String identifierStr : list) {
			Identifier identifier = Identifier.builder().use(IdentifierUse.OFFICIAL)
					.system(Uri.of("https://www.vghtpe.gov.tw/"))
					.value(identifierStr).build();
			returnList.add(identifier);

		}

		return returnList;

	}
	
	public List<OrganizationDao> getOrgs() {
		OrganizationUtils utils = new OrganizationUtils();
		return utils.select();
	}
	
	

}
