package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.fhir.model.resource.Observation;
import com.ibm.fhir.model.type.CodeableConcept;
import com.ibm.fhir.model.type.Coding;
import com.ibm.fhir.model.type.Reference;
import com.ibm.fhir.model.type.String;

import Utils.FhirObjUtils;
import Utils.ObservationUtils;
import dao.ObservationDao;

public class ObservationService {
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	private Map<String, CodeableConcept> filterCodesToMap(List<ObservationDao> list){
		Map<String, CodeableConcept> map = new HashMap<>();
		List<Coding> codingList = null;
		
		for (ObservationDao dao : list) {
			String obsId = String.of(dao.getObsId());
			
			Coding coding = objUtils.setCoding(dao.getSystemUrl(), null, dao.getSystemCode(), dao.getSystemDisplay(), null);
			
			
			codingList = new ArrayList<>();
			if (map.containsKey(obsId)) {
				for (Coding c : map.get(obsId).getCoding()) {
					codingList.add(c);
				}
			} 
			
			codingList.add(coding);
			map.put(obsId, objUtils.setCodeableConcept(codingList, null));
		}
		
		return map;
	}
	
	public List<Observation> generateObservationJSON() {
		ObservationUtils obsUtils = new ObservationUtils();
		List<Observation> obsList = new ArrayList<>();
		List<String> idList = new ArrayList<>();
		List<ObservationDao> list = obsUtils.select();
		Map<String, CodeableConcept> ccMap = this.filterCodesToMap(list);
		
		for (ObservationDao dao : list) {
			String obsId = String.of(dao.getObsId());
			if (idList.contains(obsId)) {
				continue;
			}
			
			Observation obs = Observation.builder()
					.status(objUtils.mapObservationStatus(dao.getObsStatus()))
					.code(ccMap.get(obsId))
					.subject(Reference.builder()
							.reference(String.of(dao.getObsSubjectType() + "/" + dao.getObsSubjectId())).build())
					.effective(objUtils.setPeriod(dao.getObsEffectiveStart(), dao.getObsEffectiveEnd()))
					.performer(objUtils.setReference(dao.getObsPerformerType() + "/" + dao.getObsPerformerId(), null, null, null))
					.value(String.of(dao.getObsValue()))
					.method(ccMap.get(obsId))
					.build();
			
			idList.add(obsId);
			obsList.add(obs);
		}
		
		
		return obsList;
	}
}
