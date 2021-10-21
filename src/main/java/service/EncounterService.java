package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.fhir.model.resource.Encounter;
import com.ibm.fhir.model.resource.Encounter.ClassHistory;
import com.ibm.fhir.model.resource.Encounter.Hospitalization;
import com.ibm.fhir.model.resource.Encounter.Location;
import com.ibm.fhir.model.resource.Encounter.Participant;
import com.ibm.fhir.model.resource.Encounter.StatusHistory;
import com.ibm.fhir.model.type.Code;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.Period;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Uri;

import Utils.EncounterUtils;
import Utils.FhirObjUtils;
import dao.EncounterDao;

public class EncounterService {
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	private Map<String, List<ClassHistory>> filterClassHistoryToMap(List<EncounterDao> list){
		Map<String, List<ClassHistory>> map = new HashMap<>();
		for (EncounterDao dao : list) {
			String id = String.of(dao.getEncounterId());
			List<ClassHistory> thisList = map.keySet().contains(id) ? map.get(id) : new ArrayList<>();
			Coding classCoding = objUtils.setCoding(dao.getClassSystem(), null, dao.getClassCode(), dao.getClassDisplay(), null);
			Period period = objUtils.setPeriod(dao.getClassStart(), dao.getClassEnd());
			
			ClassHistory classHistory = ClassHistory.builder()
					.clazz(classCoding)
					.period(period)
					.build();
			
			if (!thisList.contains(classHistory)) {
				thisList.add(classHistory);
				map.put(id, thisList);
			}
		}
		
		return map;
	}
	
	private Map<String, Hospitalization> filterHospitalizationToMap(List<EncounterDao> list){
		Map<String, Hospitalization> map = new HashMap<>();
		
		for (EncounterDao dao : list) {
			String id = String.of(dao.getEncounterId());
			 
			List<Coding> thisList = map.keySet().contains(id) ? map.get(id).getAdmitSource().getCoding() : new ArrayList<>();
			
			Coding thisCoding = objUtils.setCoding(dao.getHospitalizationSystem(), null, dao.getHospitalizationCode(), dao.getHospitalizationDisplay(), null);
			
			if (!thisList.contains(thisCoding)) {
				thisList.add(thisCoding);
				
				CodeableConcept cc = objUtils.setCodeableConcept(thisList, null);
				Hospitalization thisHospitalization = Hospitalization.builder()
						.admitSource(cc).build();
				map.put(id, thisHospitalization);
			}
		}
		return map;
		
	}
	
	private Map<String, Location> filterLocationToMap(List<EncounterDao> list){
		Map<String, Location> map = new HashMap<>();
		for (EncounterDao dao : list) {
			String id = String.of(dao.getEncounterId());
			
			Period period = objUtils.setPeriod(dao.getLocationStart(), dao.getLocationEnd());
			Reference locationRef = objUtils.setReference(null, null, null, dao.getLocationDisplay());
			
			Location location = Location.builder()
				.location(locationRef)
				.status(objUtils.mapLocationStatus(dao.getLocationStatus()))
				.period(period)
				.build();
			
			if (!map.keySet().contains(id)) {
				map.put(id, location);
			}
			
		}
		
		return map;
	}
	
	private Map<String, List<StatusHistory>> filterStatusHistoryToMap(List<EncounterDao> list){
		
		Map<String, List<StatusHistory>> map = new HashMap<>();
		
		for (EncounterDao dao : list) {
			String id = String.of(dao.getEncounterId());
			List<StatusHistory> thisList = map.keySet().contains(id) ? map.get(id) : new ArrayList<>();
			Period period = objUtils.setPeriod(dao.getStatusHistoryStart(), dao.getStatusHistoryEnd());
			
			StatusHistory statusHistory = StatusHistory.builder()
					.status(objUtils.mapEncounterStatus(dao.getStatusHistoryValue()))
					.period(period)
					.build();
			
			if (!thisList.contains(statusHistory)) {
				thisList.add(statusHistory);
				map.put(id, thisList);
			}
			
		}
		
		return map;
	}
	
	
	public List<Encounter> generateEncounterJSON() {
		EncounterUtils utils = new EncounterUtils();
		List<EncounterDao> hisList = utils.select();
		
		Map<String, List<Encounter>> encounterMap = new HashMap<>();
		Map<String, List<StatusHistory>> statusHistoryMap = this.filterStatusHistoryToMap(hisList);
		Map<String, List<ClassHistory>> classHistoryMap = this.filterClassHistoryToMap(hisList);
		Map<String, Hospitalization> hospitalizationMap = this.filterHospitalizationToMap(hisList);
		Map<String, Location> locationMap = this.filterLocationToMap(hisList);
		
		List<Encounter> list = null;
		
		for (EncounterDao dao : hisList) {
			String encounterId = String.of(dao.getEncounterId());
			list = encounterMap.keySet().contains(encounterId) ? encounterMap.get(encounterId) : new ArrayList<>();
			Period period = objUtils.setPeriod(dao.getPeriodStart(), dao.getPeriodEnd());
			
			Coding encounterCoding = Coding.builder()
					.system(Uri.of(dao.getEncounterSystem()))
					.code(Code.of(dao.getEncounterCode()))
					.display(String.of(dao.getEncounterDisplay()))
					.build();
			
			Coding.builder().system(Uri.of(dao.getEncounterSystem())).code(Code.of(dao.getEncounterCode())).build();
			
			Participant participant = Participant.builder()
					.individual(Reference.builder().display(String.of("Practitioner/17c97281ece-cd355d72-73ae-4d99-a274-a4bfb2501462")).build())
					.build();
					
			Encounter encounter = Encounter.builder()
					.status(objUtils.mapEncounterStatus(dao.getStatus()))
					.statusHistory(statusHistoryMap.get(encounterId))
					.classHistory(classHistoryMap.get(encounterId))
					.clazz(encounterCoding)
					.subject(Reference.builder().reference(String.of(dao.getSubjectType() + "/" + dao.getSubjectUrl())).build())
					.period(period)
					.hospitalization(hospitalizationMap.get(encounterId))
					.location(locationMap.get(encounterId))
					.participant(participant)
					.build();
			list.add(encounter);
			
		}
		return list;
	}
	
}
