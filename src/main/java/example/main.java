package example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import com.ibm.fhir.client.FHIRClient;
import com.ibm.fhir.client.FHIRClientFactory;
import com.ibm.fhir.client.FHIRResponse;
import com.ibm.fhir.model.resource.Bundle;
import com.ibm.fhir.model.resource.Encounter;
import com.ibm.fhir.model.resource.Immunization;
import com.ibm.fhir.model.resource.Medication;
import com.ibm.fhir.model.resource.Observation;
import com.ibm.fhir.model.resource.Organization;
import com.ibm.fhir.model.resource.Patient;
import com.ibm.fhir.model.resource.Practitioner;
import com.ibm.fhir.model.resource.Resource;
import com.ibm.fhir.model.resource.ValueSet;
import com.ibm.fhir.model.resource.SubstanceSpecification.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.Uri;
import com.ibm.fhir.model.type.code.ObservationStatus;

import Utils.FhirObjUtils;
import Utils.HttpUtils;
import Utils.ImmunizationUtils;
import Utils.ObservationUtils;
import Utils.OrganizationUtils;
import dao.ObservationDao;
import service.EncounterService;
import service.ImmunizationService;
import service.MedicationService;
import service.ObservationService;
import service.OrganizationService;
import service.PatientService;
import service.PractitionerService;

public class main {
	public static void main(String[] args) throws Exception {
		
		OrganizationService orgService = new OrganizationService();
		List<Organization> orgList = orgService.generateOrganizationJSON();
		System.out.println("Organization: " + orgList.size());
		
		PractitionerService pService = new PractitionerService();
		List<Practitioner> pList = pService.generatePractitionerJSON();
		System.out.println("Practitioner: " + pList.size());
		
		PatientService patientService = new PatientService();
		List<Patient> patientList = patientService.generatePatientJSON();
		System.out.println("Patient: " + patientList.size());
		
		ImmunizationService immService = new ImmunizationService();
		List<Immunization> immList = immService.generateImmunizationJSON();
		System.out.println("Immunization: " + immList.size());
		
		ObservationService obsService = new ObservationService();
		List<Observation> obsList = obsService.generateObservationJSON();
		System.out.println("Observation: " + obsList.size());
		
		MedicationService service = new MedicationService();
		List<Medication> list = service.generateMedicationJSON();
		System.out.println("Medication: " + list.size());
		
		EncounterService encounterService = new EncounterService();
		List<Encounter> encounterList = encounterService.generateEncounterJSON();
		System.out.println("Encounter: " + encounterList.size());
//		
		
		
		
		
//		HttpUtils httpUtils = new HttpUtils();
//		FHIRResponse response = httpUtils.create(list.get(0));
//		System.out.println(response.getStatus());
		
		

	}

}
