package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ImmunizationDao;

public class ImmunizationUtils {
	
	private DBUtils dbUtils = new DBUtils();
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM FHIR_IMMUNIZATION ");
		return sb.toString();
	}
	
	public List<ImmunizationDao> select(){
        List<ImmunizationDao> list = new ArrayList<>();
        ImmunizationDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new ImmunizationDao();
                dao.setImmunizationId(rs.getString("IMMUNIZATION_ID"));
                dao.setIdentifierSystem1(rs.getString("IDENTIFIER_SYSTEM_1"));
                dao.setIdentifierValue1(rs.getString("IDENTIFIER_VALUE_1"));
                dao.setIdentifierSystem2(rs.getString("IDENTIFIER_SYSTEM_2"));
                dao.setIdentifierValue2(rs.getString("IDENTIFIER_VALUE_2"));
                dao.setImmunizationStatus(rs.getString("IMMUNIZATION_STATUS"));
                dao.setVaccinecodeSystem(rs.getString("VACCINECODE_SYSTEM"));
                dao.setVaccinecodeCode(rs.getString("VACCINECODE_CODE"));
                dao.setVaccinecodeDisplay(rs.getString("VACCINECODE_DISPLAY"));
                dao.setVaccinecodeText(rs.getString("VACCINECODE_TEXT"));
                dao.setPatientReference(rs.getString("PATIENT_REFERENCE"));
                dao.setPatientType(rs.getString("PATIENT_TYPE"));
                dao.setPatientDisplay(rs.getString("PATIENT_DISPLAY"));
                dao.setEncounterReference(rs.getString("ENCOUNTER_REFERENCE"));
                dao.setOccurrenceDateTime(rs.getDate("OCCURRENCE_DATETIME"));
                dao.setPrimarySource(rs.getBoolean("PRIMARY_SOURCE"));
                dao.setLocationReference(rs.getString("LOCATION_REFERENCE"));
                dao.setLocationDisplay(rs.getString("LOCATION_DISPLAY"));
                dao.setManufacturerReference(rs.getString("MANUFACTURER_REFERENCE"));
                dao.setManufacturerDisplay(rs.getString("MANUFACTURER_DISPLAY"));
                dao.setLotNumber(rs.getString("LOT_NUMBER"));
                dao.setSiteSystem(rs.getString("SITE_SYSTEM"));
                dao.setSiteCode(rs.getString("SITE_CODE"));
                dao.setSiteDisplay(rs.getString("SITE_DISPLAY"));
                dao.setRouteSystem(rs.getString("ROUTE_SYSTEM"));
                dao.setRouteCode(rs.getString("ROUTE_CODE"));
                dao.setRouteDisplay(rs.getString("ROUTE_DISPLAY"));
                dao.setDoseQuantityValue(rs.getBigDecimal("DOSE_QUANTITY_VALUE"));
                dao.setDoseQuantitySystem(rs.getString("DOSE_QUANTITY_SYSTEM"));
                dao.setDoseQuantityCode(rs.getString("DOSE_QUANTITY_CODE"));
                dao.setPerformerFunctionSystem(rs.getString("PERFORMER_FUNCTION_SYSTEM"));
                dao.setPerformerFunctionCode(rs.getString("PERFORMER_FUNCTION_CODE"));
                dao.setPerformerActorReference(rs.getString("PERFORMER_ACTOR_REFERENCE"));
                dao.setPerformerActorType(rs.getString("PERFORMER_ACTOR_TYPE"));
                dao.setPerformerActorDisplay(rs.getString("PERFORMER_ACTOR_DISPLAY"));
                dao.setIsSubpotent(rs.getBoolean("IS_SUBPOTENT"));
                dao.setProgramEligibilitySystem(rs.getString("PROGRAM_ELIGIBILITY_SYSTEM"));
                dao.setProgramEligibilityCode(rs.getString("PROGRAM_ELIGIBILITY_CODE"));
                dao.setFundingSourceSystem(rs.getString("FUNDING_SOURCE_SYSTEM"));
                dao.setFundingSourceCode(rs.getString("FUNDING_SOURCE_CODE"));
                dao.setProtocolAppliedSeries(rs.getString("PROTOCOL_APPLIED_SERIES"));
                dao.setProtocolAppliedSystem(rs.getString("PROTOCOL_APPLIED_SYSTEM"));
                dao.setProtocolAppliedCode(rs.getString("PROTOCOL_APPLIED_CODE"));
                dao.setProtocolAppliedText(rs.getString("PROTOCOL_APPLIED_TEXT"));
                dao.setDoseNumberPositiveInt(rs.getBigDecimal("DOSE_NUMBER_POSITIVE_INT"));
                dao.setCreated(rs.getDate("CREATED"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
	
}
