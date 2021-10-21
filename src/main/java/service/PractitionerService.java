package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.fhir.model.resource.Practitioner;
import com.ibm.fhir.model.resource.Practitioner.Qualification;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Address;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Date;
import com.ibm.fhir.model.type.ContactPoint;
import com.ibm.fhir.model.type.HumanName;
import com.ibm.fhir.model.type.Uri;

import Utils.FhirObjUtils;
import Utils.PractitionerUtils;
import dao.PractitionerDao;

public class PractitionerService {
	private SimpleDateFormat birthDateFmt = new SimpleDateFormat("yyyy-MM-dd");
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	public List<Practitioner> generatePractitionerJSON() {
		PractitionerUtils utils = new PractitionerUtils();
		List<PractitionerDao> hisList = utils.select();
		List<Practitioner> list = new ArrayList<>();
		
		for (PractitionerDao dao : hisList) {
			Identifier iden1 = Identifier.builder()
					.use(objUtils.mapIdentifierUse(dao.getIdentifierUse1()))
					.system(Uri.of(dao.getIdentifierSystem1()))
					.value(String.of(dao.getIdentifierValue1()))
					.build();
			
			Identifier iden2 = Identifier.builder()
					.use(objUtils.mapIdentifierUse(dao.getIdentifierUse2()))
					.system(Uri.of(dao.getIdentifierSystem2()))
					.value(String.of(dao.getIdentifierValue2()))
					.build();
			List<Identifier> identifierList = Arrays.asList(iden1, iden2);
			
			HumanName humanName = HumanName.builder()
					.use(objUtils.mapHumanNameUse(dao.getNameUse()))
					.family(String.of(dao.getNameFamily()))
					.given(Arrays.asList(String.of(dao.getNameGiven())))
					.suffix(Arrays.asList(String.of(dao.getNameSuffix())))
					.build();
			
			ContactPoint telecom1 = ContactPoint.builder()
					.system(objUtils.mapTelcomType(dao.getTelecomSystem1()))
					.value(String.of(dao.getTelecomValue1()))
					.use(objUtils.mapTelcomUse(dao.getTelecomUse1()))
					.build();
			
			ContactPoint telecom2 = ContactPoint.builder()
					.system(objUtils.mapTelcomType(dao.getTelecomSystem2()))
					.value(String.of(dao.getTelecomValue2()))
					.use(objUtils.mapTelcomUse(dao.getTelecomUse2()))
					.build();
			
			ContactPoint telecom3 = ContactPoint.builder()
					.system(objUtils.mapTelcomType(dao.getTelecomSystem3()))
					.value(String.of(dao.getTelecomValue3()))
					.use(objUtils.mapTelcomUse(dao.getTelecomUse3()))
					.build();
			
			Address address = Address.builder()
					.use(objUtils.mapAddressUse(dao.getAddressUse()))
					.line(Arrays.asList(String.of(dao.getAddressLine())))
					.city(String.of(dao.getAddressCity()))
					.postalCode(String.of(dao.getAddressPostalCode()))
					.country(String.of(dao.getAddressCountry()))
					.build();
			
			Identifier qualificationIdentifier = Identifier.builder()
					.system(Uri.of(dao.getQualificationIdentifierSystem()))
					.value(String.of(dao.getQualificationIdentifierValue()))
					.build();
			
			CodeableConcept qualificationCoding = 
					objUtils.setCodeableConcept(dao.getQualificationCodingSystem(), null, dao.getQualificationCodingCode(), null, null, null);
			
			Qualification qualification = Qualification.builder()
					.identifier(Arrays.asList(qualificationIdentifier))
					.code(qualificationCoding)
					.period(objUtils.setPeriod(dao.getQualificationPeriodStart(), dao.getQualificationPeriodEnd()))
					.issuer(Reference.builder().display(String.of(dao.getQualificationIssuerDisplay())).build())
					.build();
			
			CodeableConcept communication 
				= objUtils.setCodeableConcept(dao.getCommunicationSystem(), null, dao.getCommunicationCode(), dao.getCommunicationDisplay(), null, null);
			
			Practitioner practitioner = Practitioner.builder()
					.identifier(identifierList)
					.active(Boolean.of(dao.getPractitionerActive()))
					.name(Arrays.asList(humanName))
					.telecom(Arrays.asList(telecom1, telecom2, telecom3))
					.address(Arrays.asList(address))
					.gender(objUtils.mapGender(dao.getGender()))
					.birthDate(Date.of(birthDateFmt.format(dao.getBirthdate())))
					.qualification(Arrays.asList(qualification))
					.communication(Arrays.asList(communication))
					.build();
			
			list.add(practitioner);
			
		}
		
		return list;
	}
}
