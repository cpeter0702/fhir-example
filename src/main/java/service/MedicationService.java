package service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ibm.fhir.model.resource.Medication;
import com.ibm.fhir.model.resource.Medication.Batch;
import com.ibm.fhir.model.resource.Medication.Ingredient;
import com.ibm.fhir.model.type.DateTime;
import com.ibm.fhir.model.type.Decimal;
import com.ibm.fhir.model.type.Identifier;
import com.ibm.fhir.model.type.Quantity;
import com.ibm.fhir.model.type.Ratio;
import com.ibm.fhir.model.type.String;
import com.ibm.fhir.model.type.Boolean;

import Utils.FhirObjUtils;
import Utils.MedicationUtils;
import dao.MedicationDao;

public class MedicationService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+08:00");
	private FhirObjUtils objUtils = new FhirObjUtils();
	
	public List<Medication> generateMedicationJSON() {
		MedicationUtils utils = new MedicationUtils();
		List<MedicationDao> hisList = utils.select();
		List<Medication> list = new ArrayList<>();
		
		for (MedicationDao dao : hisList) {
			
			Ingredient ingredient = Ingredient.builder()
					.item(objUtils.setCodeableConcept(null, null, dao.getMedicationIngredientCode(), null, null, null))
					.isActive(Boolean.of(dao.getMedicationIsActive()))
					.strength(Ratio.builder()
							.numerator(Quantity.builder().value(Decimal.of(dao.getMedicationStrength())).build())
							.denominator(Quantity.builder().value(Decimal.of(BigDecimal.TEN)).build())
							.build())
					.build();
			
			Medication medication = Medication.builder()
					.identifier(Identifier.builder().value(String.of(dao.getIdentifierValue())).build())
					.code(objUtils.setCodeableConcept(null, null, dao.getMedicationCode(), null, null, null))
					.status(objUtils.mapMedicationStatus(dao.getMedicationStatus()))
					.manufacturer(objUtils.setReference(dao.getMedicationOrg(), null, null, null))
					.form(objUtils.setCodeableConcept(null, null, dao.getMedicationForm(), null, null, null))
					.amount(Ratio.builder()
							.numerator(Quantity.builder().value(Decimal.of(dao.getMedicationAmount())).build())
							.denominator(Quantity.builder().value(Decimal.of(BigDecimal.TEN)).build())
							.build())
					.ingredient(ingredient)
					.batch(Batch.builder()
							.lotNumber(String.of(dao.getBatchNumber()))
							.expirationDate(DateTime.of(sdf.format(dao.getBatchDate()))).build())
					.build();
			
			list.add(medication);
		}
		
		
		return list;
	}
}
