package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.fhir.model.resource.Patient;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.code.ContactPointUse;
import com.ibm.fhir.model.type.code.NameUse;
import com.ibm.fhir.model.type.Address;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.ContactPoint;
import com.ibm.fhir.model.type.HumanName;

import Utils.FhirObjUtils;
import Utils.PatientUtils;
import dao.PatientDao;

public class PatientService {
	private FhirObjUtils objUtils = new FhirObjUtils();
	private HumanName setEnglishHumanName(java.lang.String enName) {
		if (enName == null || enName.length() == 0) {
			return null;
		}
		HumanName humanName = null;
		
		java.lang.String[] nameArray = enName.split(" ");
		
		if (nameArray.length == 1) {
			humanName = 
					HumanName.builder()
					.use(NameUse.USUAL)
					.family(String.of(enName))
					.build();
		} else {
			java.lang.String family = nameArray[0];
			java.lang.String given = "";
			for (int i = 0 ; i < nameArray.length; i++) {
				given += nameArray[i] + " ";
			}
			given = given.substring(0, given.length() - 2);
			humanName = HumanName.builder()
					.use(NameUse.USUAL)
					.family(String.of(family))
					.given(String.of(given))
					.build();
		}
		
		
		return humanName;
	}
	
	private HumanName setChineseHumanName(java.lang.String chineseName) {
		if (chineseName == null || chineseName.length() == 0) {
			return null;
		}
		
		HumanName humanName = null;
		if (chineseName.length() == 1) {
			humanName = HumanName.builder()
					.use(NameUse.USUAL)
					.family(String.of(chineseName))
					.build();
		} else {
			java.lang.String family = chineseName.substring(0, 1);
			java.lang.String given = chineseName.substring(1, chineseName.length() - 1);
			humanName = HumanName.builder()
					.use(NameUse.USUAL)
					.family(String.of(family))
					.given(String.of(given))
					.build();
		}
		
		return humanName;
		
	}
	
	public List<Patient> generatePatientJSON() {
		PatientUtils utils = new PatientUtils();
		List<PatientDao> hisList = utils.select();
		List<Patient> list = new ArrayList<>();
		
		for (PatientDao dao : hisList) {
			
			List<HumanName> humanNameList = Arrays.asList(
					this.setChineseHumanName(dao.getpNameC()), 
					this.setEnglishHumanName(dao.getpName()));
			
			List<Address> addressList = Arrays.asList(
					Address.builder().line(String.of(dao.getpAddr1())).build(),
					Address.builder().line(String.of(dao.getpAddr2())).build()
					);
			
			List<ContactPoint> telecomList = new ArrayList<>();
			if (dao.getpPhoneNo1() != null) {
				telecomList.add(ContactPoint.builder().use(ContactPointUse.WORK).value(String.of(dao.getpPhoneNo1())).build());
			}
			
			if (dao.getpPhone2() != null && dao.getpPhone2().length() >= 1) {
				telecomList.add(ContactPoint.builder().use(ContactPointUse.WORK).value(String.of(dao.getpPhone2())).build());
			}
			
			Patient patient = Patient.builder()
					.identifier(Identifier.builder().value(String.of(dao.getPidNo())).build())
					.active(Boolean.TRUE)
					.name(humanNameList)
					.gender(objUtils.mapPatientGender(dao.getpSex()))
					.address(addressList)
					.telecom(telecomList)
					.build();
			
			
			list.add(patient);
			
		}
		
		return list;
	}
}
