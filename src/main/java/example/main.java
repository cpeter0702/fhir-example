package example;

import java.util.List;

import com.ibm.fhir.client.FHIRResponse;
import com.ibm.fhir.model.resource.Encounter;
import com.ibm.fhir.model.resource.Immunization;
import com.ibm.fhir.model.resource.Medication;
import com.ibm.fhir.model.resource.Observation;
import com.ibm.fhir.model.resource.Organization;
import com.ibm.fhir.model.resource.Patient;
import com.ibm.fhir.model.resource.Practitioner;
import Utils.HttpUtils;
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

		EncounterService encounterService = new EncounterService();
		List<Encounter> encounterList = encounterService.generateEncounterJSON();
		System.out.println("Encounter: " + encounterList.size());
		
		MedicationService service = new MedicationService();
		List<Medication> mlist = service.generateMedicationJSON();
		System.out.println("Medication: " + mlist.size());
		
		HttpUtils httpUtils = new HttpUtils();
		FHIRResponse response = httpUtils.create(mlist.get(0));
		System.out.println(response.getStatus());

	}

}
