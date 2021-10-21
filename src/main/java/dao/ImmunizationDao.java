package dao;

import java.math.BigDecimal;
import java.util.Date;

public class ImmunizationDao {
	private String immunizationId;
	private String identifierSystem1;
	private String identifierValue1;
	private String identifierSystem2;
	private String identifierValue2;
	private String immunizationStatus;
	private String vaccinecodeSystem;
	private String vaccinecodeCode;
	private String vaccinecodeDisplay;
	private String vaccinecodeText;
	private String patientReference;
	private String patientType;
	private String patientDisplay;
	private String encounterReference;
	private Date occurrenceDateTime;
	private boolean primarySource;
	private String locationReference;
	private String locationDisplay;
	private String manufacturerReference;
	private String manufacturerDisplay;
	private String lotNumber;
	private String siteSystem;
	private String siteCode;
	private String siteDisplay;
	private String routeSystem;
	private String routeCode;
	private String routeDisplay;
	private BigDecimal doseQuantityValue;
	private String doseQuantitySystem;
	private String doseQuantityCode;
	private String performerFunctionSystem;
	private String performerFunctionCode;
	private String performerActorReference;
	private String performerActorType;
	private String performerActorDisplay;
	private boolean isSubpotent;
	private String programEligibilitySystem;
	private String programEligibilityCode;
	private String fundingSourceSystem;
	private String fundingSourceCode;
	private String protocolAppliedSeries;
	private String protocolAppliedSystem;
	private String protocolAppliedCode;
	private String protocolAppliedText;
	private BigDecimal doseNumberPositiveInt;
	private Date created;
	
	
	public String getImmunizationId() {
		return immunizationId;
	}
	public void setImmunizationId(String immunizationId) {
		this.immunizationId = immunizationId;
	}
	public String getIdentifierSystem1() {
		return identifierSystem1;
	}
	public void setIdentifierSystem1(String identifierSystem1) {
		this.identifierSystem1 = identifierSystem1;
	}
	public String getIdentifierValue1() {
		return identifierValue1;
	}
	public void setIdentifierValue1(String identifierValue1) {
		this.identifierValue1 = identifierValue1;
	}
	public String getIdentifierSystem2() {
		return identifierSystem2;
	}
	public void setIdentifierSystem2(String identifierSystem2) {
		this.identifierSystem2 = identifierSystem2;
	}
	public String getIdentifierValue2() {
		return identifierValue2;
	}
	public void setIdentifierValue2(String identifierValue2) {
		this.identifierValue2 = identifierValue2;
	}
	public String getImmunizationStatus() {
		return immunizationStatus;
	}
	public void setImmunizationStatus(String immunizationStatus) {
		this.immunizationStatus = immunizationStatus;
	}
	public String getVaccinecodeSystem() {
		return vaccinecodeSystem;
	}
	public void setVaccinecodeSystem(String vaccinecodeSystem) {
		this.vaccinecodeSystem = vaccinecodeSystem;
	}
	public String getVaccinecodeCode() {
		return vaccinecodeCode;
	}
	public void setVaccinecodeCode(String vaccinecodeCode) {
		this.vaccinecodeCode = vaccinecodeCode;
	}
	public String getVaccinecodeDisplay() {
		return vaccinecodeDisplay;
	}
	public void setVaccinecodeDisplay(String vaccinecodeDisplay) {
		this.vaccinecodeDisplay = vaccinecodeDisplay;
	}
	public String getVaccinecodeText() {
		return vaccinecodeText;
	}
	public void setVaccinecodeText(String vaccinecodeText) {
		this.vaccinecodeText = vaccinecodeText;
	}
	public String getPatientReference() {
		return patientReference;
	}
	public void setPatientReference(String patientReference) {
		this.patientReference = patientReference;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public String getPatientDisplay() {
		return patientDisplay;
	}
	public void setPatientDisplay(String patientDisplay) {
		this.patientDisplay = patientDisplay;
	}
	public String getEncounterReference() {
		return encounterReference;
	}
	public void setEncounterReference(String encounterReference) {
		this.encounterReference = encounterReference;
	}
	public Date getOccurrenceDateTime() {
		return occurrenceDateTime;
	}
	public void setOccurrenceDateTime(Date occurrenceDateTime) {
		this.occurrenceDateTime = occurrenceDateTime;
	}
	public boolean getPrimarySource() {
		return primarySource;
	}
	public void setPrimarySource(boolean primarySource) {
		this.primarySource = primarySource;
	}
	public String getLocationReference() {
		return locationReference;
	}
	public void setLocationReference(String locationReference) {
		this.locationReference = locationReference;
	}
	public String getLocationDisplay() {
		return locationDisplay;
	}
	public void setLocationDisplay(String locationDisplay) {
		this.locationDisplay = locationDisplay;
	}
	public String getManufacturerReference() {
		return manufacturerReference;
	}
	public void setManufacturerReference(String manufacturerReference) {
		this.manufacturerReference = manufacturerReference;
	}
	public String getManufacturerDisplay() {
		return manufacturerDisplay;
	}
	public void setManufacturerDisplay(String manufacturerDisplay) {
		this.manufacturerDisplay = manufacturerDisplay;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getSiteSystem() {
		return siteSystem;
	}
	public void setSiteSystem(String siteSystem) {
		this.siteSystem = siteSystem;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getSiteDisplay() {
		return siteDisplay;
	}
	public void setSiteDisplay(String siteDisplay) {
		this.siteDisplay = siteDisplay;
	}
	public String getRouteSystem() {
		return routeSystem;
	}
	public void setRouteSystem(String routeSystem) {
		this.routeSystem = routeSystem;
	}
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public String getRouteDisplay() {
		return routeDisplay;
	}
	public void setRouteDisplay(String routeDisplay) {
		this.routeDisplay = routeDisplay;
	}
	
	public String getDoseQuantitySystem() {
		return doseQuantitySystem;
	}
	public void setDoseQuantitySystem(String doseQuantitySystem) {
		this.doseQuantitySystem = doseQuantitySystem;
	}
	public String getDoseQuantityCode() {
		return doseQuantityCode;
	}
	public void setDoseQuantityCode(String doseQuantityCode) {
		this.doseQuantityCode = doseQuantityCode;
	}
	public String getPerformerFunctionSystem() {
		return performerFunctionSystem;
	}
	public void setPerformerFunctionSystem(String performerFunctionSystem) {
		this.performerFunctionSystem = performerFunctionSystem;
	}
	public String getPerformerFunctionCode() {
		return performerFunctionCode;
	}
	public void setPerformerFunctionCode(String performerFunctionCode) {
		this.performerFunctionCode = performerFunctionCode;
	}
	public String getPerformerActorReference() {
		return performerActorReference;
	}
	public void setPerformerActorReference(String performerActorReference) {
		this.performerActorReference = performerActorReference;
	}
	public String getPerformerActorType() {
		return performerActorType;
	}
	public void setPerformerActorType(String performerActorType) {
		this.performerActorType = performerActorType;
	}
	public String getPerformerActorDisplay() {
		return performerActorDisplay;
	}
	public void setPerformerActorDisplay(String performerActorDisplay) {
		this.performerActorDisplay = performerActorDisplay;
	}
	public boolean getIsSubpotent() {
		return isSubpotent;
	}
	public void setIsSubpotent(boolean isSubpotent) {
		this.isSubpotent = isSubpotent;
	}
	public String getProgramEligibilitySystem() {
		return programEligibilitySystem;
	}
	public void setProgramEligibilitySystem(String programEligibilitySystem) {
		this.programEligibilitySystem = programEligibilitySystem;
	}
	public String getProgramEligibilityCode() {
		return programEligibilityCode;
	}
	public void setProgramEligibilityCode(String programEligibilityCode) {
		this.programEligibilityCode = programEligibilityCode;
	}
	public String getFundingSourceSystem() {
		return fundingSourceSystem;
	}
	public void setFundingSourceSystem(String fundingSourceSystem) {
		this.fundingSourceSystem = fundingSourceSystem;
	}
	public String getFundingSourceCode() {
		return fundingSourceCode;
	}
	public void setFundingSourceCode(String fundingSourceCode) {
		this.fundingSourceCode = fundingSourceCode;
	}
	public String getProtocolAppliedSeries() {
		return protocolAppliedSeries;
	}
	public void setProtocolAppliedSeries(String protocolAppliedSeries) {
		this.protocolAppliedSeries = protocolAppliedSeries;
	}
	public String getProtocolAppliedSystem() {
		return protocolAppliedSystem;
	}
	public void setProtocolAppliedSystem(String protocolAppliedSystem) {
		this.protocolAppliedSystem = protocolAppliedSystem;
	}
	public String getProtocolAppliedCode() {
		return protocolAppliedCode;
	}
	public void setProtocolAppliedCode(String protocolAppliedCode) {
		this.protocolAppliedCode = protocolAppliedCode;
	}
	public String getProtocolAppliedText() {
		return protocolAppliedText;
	}
	public void setProtocolAppliedText(String protocolAppliedText) {
		this.protocolAppliedText = protocolAppliedText;
	}
	
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public BigDecimal getDoseQuantityValue() {
		return doseQuantityValue;
	}
	public void setDoseQuantityValue(BigDecimal doseQuantityValue) {
		this.doseQuantityValue = doseQuantityValue;
	}
	public BigDecimal getDoseNumberPositiveInt() {
		return doseNumberPositiveInt;
	}
	public void setDoseNumberPositiveInt(BigDecimal doseNumberPositiveInt) {
		this.doseNumberPositiveInt = doseNumberPositiveInt;
	}	
	
}
