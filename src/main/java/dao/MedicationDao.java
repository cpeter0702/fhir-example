package dao;

import java.math.BigDecimal;
import java.util.Date;

public class MedicationDao {
	
	private String medicationId;
	private String identifierValue;
	private String medicationCode;
	private String medicationStatus;
	private String medicationOrg;
	private String medicationForm;
	private BigDecimal medicationAmount;
	private String medicationIngredientCode;
	private String medicationIngredientReference;
	private boolean medicationIsActive;
	private BigDecimal medicationStrength;
	private String batchNumber;
	private Date batchDate;
	
	public String getMedicationId() {
		return medicationId;
	}
	public void setMedicationId(String medicationId) {
		this.medicationId = medicationId;
	}
	public String getIdentifierValue() {
		return identifierValue;
	}
	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}
	public String getMedicationCode() {
		return medicationCode;
	}
	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}
	public String getMedicationStatus() {
		return medicationStatus;
	}
	public void setMedicationStatus(String medicationStatus) {
		this.medicationStatus = medicationStatus;
	}
	public String getMedicationOrg() {
		return medicationOrg;
	}
	public void setMedicationOrg(String medicationOrg) {
		this.medicationOrg = medicationOrg;
	}
	public String getMedicationForm() {
		return medicationForm;
	}
	public void setMedicationForm(String medicationForm) {
		this.medicationForm = medicationForm;
	}
	public BigDecimal getMedicationAmount() {
		return medicationAmount;
	}
	public void setMedicationAmount(BigDecimal medicationAmount) {
		this.medicationAmount = medicationAmount;
	}
	public String getMedicationIngredientCode() {
		return medicationIngredientCode;
	}
	public void setMedicationIngredientCode(String medicationIngredientCode) {
		this.medicationIngredientCode = medicationIngredientCode;
	}
	public String getMedicationIngredientReference() {
		return medicationIngredientReference;
	}
	public void setMedicationIngredientReference(String medicationIngredientReference) {
		this.medicationIngredientReference = medicationIngredientReference;
	}
	public boolean getMedicationIsActive() {
		return medicationIsActive;
	}
	public void setMedicationIsActive(boolean medicationIsActive) {
		this.medicationIsActive = medicationIsActive;
	}
	public BigDecimal getMedicationStrength() {
		return medicationStrength;
	}
	public void setMedicationStrength(BigDecimal medicationStrength) {
		this.medicationStrength = medicationStrength;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Date getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}
	
	
	
}
