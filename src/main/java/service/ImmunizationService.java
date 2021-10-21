package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.fhir.model.resource.Immunization;
import com.ibm.fhir.model.resource.Immunization.Performer;
import com.ibm.fhir.model.resource.Immunization.ProtocolApplied;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.Decimal;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.PositiveInt;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.SimpleQuantity;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Boolean;
import com.ibm.fhir.model.type.Uri;

import Utils.FhirObjUtils;
import Utils.ImmunizationUtils;
import dao.ImmunizationDao;


public class ImmunizationService {
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	public List<Immunization> generateImmunizationJSON() {
		ImmunizationUtils utils = new ImmunizationUtils();
		List<ImmunizationDao> hisList = utils.select();
		List<Immunization> list = new ArrayList<>();
		
		for (ImmunizationDao dao : hisList) {
			
			Identifier iden1 = Identifier.builder()
					.system(Uri.of(dao.getIdentifierSystem1()))
					.value(String.of(dao.getIdentifierValue1())).build();
			Identifier iden2 = Identifier.builder()
					.system(Uri.of(dao.getIdentifierSystem2()))
					.value(String.of(dao.getIdentifierValue2())).build();		
			
			List<Identifier> identifierList = Arrays.asList(iden1, iden2);
			
			Coding vaccineCoding = objUtils.setCoding(dao.getVaccinecodeSystem(), null, dao.getVaccinecodeCode(), dao.getVaccinecodeDisplay(), null);
			CodeableConcept vaccineCode = objUtils.setCodeableConcept(vaccineCoding, null);
			
			Coding siteCoding = objUtils.setCoding(dao.getSiteSystem(), null, dao.getSiteCode(), dao.getSiteDisplay(), null);
			CodeableConcept site = objUtils.setCodeableConcept(siteCoding, null);

			Coding routeCoding = objUtils.setCoding(dao.getRouteSystem(), null, dao.getRouteCode(), dao.getRouteDisplay(), null);
			CodeableConcept route = objUtils.setCodeableConcept(routeCoding, null);
			
			SimpleQuantity doseQuantity = SimpleQuantity.builder()
					.value(Decimal.of(dao.getDoseQuantityValue()))
					.system(Uri.of(dao.getDoseQuantitySystem()))
					.code(Code.of(dao.getDoseQuantityCode()))
					.build();
			
			Coding functionCoding = objUtils.setCoding(dao.getPerformerFunctionSystem(), null, dao.getPerformerFunctionCode(), null, null);
			CodeableConcept functionCode = objUtils.setCodeableConcept(functionCoding, null);

			Reference actorRef = objUtils.setReference(dao.getPerformerActorReference(), dao.getPerformerActorType(), null, dao.getPerformerActorDisplay());
			
			
			Performer performer = Performer.builder()
					.function(functionCode)
					.actor(actorRef)
					.build();
			
			Coding programEligibilityCoding = objUtils.setCoding(dao.getProgramEligibilitySystem(), null, dao.getProgramEligibilityCode(), null, null);
			CodeableConcept programEligibility = objUtils.setCodeableConcept(programEligibilityCoding, null);
			
			Coding fundingSourceCoding = objUtils.setCoding(dao.getFundingSourceSystem(), null, dao.getFundingSourceCode(), null, null);
			CodeableConcept fundingSource = objUtils.setCodeableConcept(fundingSourceCoding, null);
			
			List<Coding> protocolCodeList = Arrays.asList(
					objUtils.setCoding(dao.getProtocolAppliedSystem(), null, dao.getProtocolAppliedCode(), null, null)
					);
			
			ProtocolApplied protocolApplied = ProtocolApplied.builder()
					.series(String.of(dao.getProtocolAppliedSeries()))
					.targetDisease(CodeableConcept.builder()
						.coding(protocolCodeList)
						.text(String.of(dao.getProtocolAppliedText())).build())
					.doseNumber(PositiveInt.of(dao.getDoseNumberPositiveInt().toString()))
					.build();
			
			Reference patient = objUtils.setReference(null, dao.getPatientType(), null, dao.getPatientDisplay());
			
			Immunization immunization = Immunization.builder()
					.identifier(identifierList)
					.status(objUtils.mapImmunizationStatus(dao.getImmunizationStatus()))
					.vaccineCode(vaccineCode)
					.patient(patient)
					.encounter(Reference.builder().reference(String.of(dao.getEncounterReference())).build())
					.occurrence(String.of(objUtils.sdf.format(dao.getOccurrenceDateTime())))
					.primarySource(Boolean.of(dao.getPrimarySource()))
					.location(Reference.builder()
							.reference(String.of(dao.getLocationReference()))
							.display(String.of(dao.getLocationDisplay())).build())
					.manufacturer(Reference.builder()
							.reference(String.of(dao.getManufacturerReference()))
							.display(String.of(dao.getManufacturerDisplay())).build())
					.lotNumber(String.of(dao.getLotNumber()))
					.site(site)
					.route(route)
					.doseQuantity(doseQuantity)
					.performer(performer)
					.isSubpotent(Boolean.of(dao.getIsSubpotent()))
					.programEligibility(programEligibility)
					.fundingSource(fundingSource)
					.protocolApplied(protocolApplied)
					.build();
			
			list.add(immunization);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
}
