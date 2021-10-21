package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.EncounterDao;

public class EncounterUtils {
	private DBUtils dbUtils = new DBUtils();
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ");
		sb.append(		" fe.ENCOUNTER_ID, fe.IDENDIFIER, fe.STATUS, fe.ENCOUNTER_SYSTEM, fe.CODE, fe.DISPLAY, fe.SUBJECT_TYPE, ");
		sb.append(		" fe.SUBJECT_URL, fe.HOSPITALIZATION_SYSTEM, fe.HOSPITALIZATION_CODE, fe.HOSPITALIZATION_DISPLAY, ");
		sb.append(		" fe.PERIOD_START, fe.PERIOD_END, ");
		sb.append(		" fec.CLASS_SYSTEM, fec.CLASS_CODE, fec.CLASS_DISPLAY, fec.CLASS_START, fec.CLASS_END, ");
		sb.append(		" fel.LOCATION_DISPLAY, fel.LOCATION_STATUS, fel.LOCATION_START, fel.LOCATION_END, ");
		sb.append(		" fesh.STATUS_VALUE, fesh.STATUS_HISTORY_START , fesh.STATUS_HISTORY_END ");
		sb.append(" FROM MYSCHEMA.FHIR_ENCOUNTER fe ");
		sb.append(" LEFT JOIN MYSCHEMA.FHIR_ENCOUNTER_CLASS_HISTORY fec ON fe.ENCOUNTER_ID = fec.ENCOUNTER_ID  ");
		sb.append(" LEFT JOIN MYSCHEMA.FHIR_ENCOUNTER_LOCATION fel ON fe.ENCOUNTER_ID = fel.ENCOUNTER_ID ");
		sb.append(" LEFT JOIN MYSCHEMA.FHIR_ENCOUNTER_STATUS_HISTORY fesh ON fe.ENCOUNTER_ID = fesh.ENCOUNTER_ID ");
		
		return sb.toString();
	}
	
	public List<EncounterDao> select(){
        List<EncounterDao> list = new ArrayList<>();
        EncounterDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new EncounterDao();
                dao.setEncounterId(rs.getString("ENCOUNTER_ID"));
                dao.setIdentifier(rs.getString("IDENDIFIER"));
                dao.setStatus(rs.getString("STATUS"));
                dao.setEncounterSystem(rs.getString("ENCOUNTER_SYSTEM"));
                dao.setEncounterCode(rs.getString("CODE"));
                dao.setEncounterDisplay(rs.getString("DISPLAY"));
                dao.setSubjectType(rs.getString("SUBJECT_TYPE"));
                dao.setSubjectUrl(rs.getString("SUBJECT_URL"));
                dao.setHospitalizationSystem(rs.getString("HOSPITALIZATION_SYSTEM"));
                dao.setHospitalizationCode(rs.getString("HOSPITALIZATION_CODE"));
                dao.setHospitalizationDisplay(rs.getString("HOSPITALIZATION_DISPLAY"));
                dao.setPeriodStart(rs.getDate("PERIOD_START"));
                dao.setPeriodEnd(rs.getDate("PERIOD_END"));
                dao.setClassSystem(rs.getString("CLASS_SYSTEM"));
                dao.setClassCode(rs.getString("CLASS_CODE"));
                dao.setClassDisplay(rs.getString("CLASS_DISPLAY"));
                dao.setClassStart(rs.getDate("CLASS_START"));
                dao.setClassEnd(rs.getDate("CLASS_END"));
                dao.setLocationDisplay(rs.getString("LOCATION_DISPLAY"));
                dao.setLocationStatus(rs.getString("LOCATION_STATUS"));
                dao.setLocationStart(rs.getDate("LOCATION_START"));
                dao.setLocationEnd(rs.getDate("LOCATION_END"));
                dao.setStatusHistoryValue(rs.getString("STATUS_VALUE"));
                dao.setStatusHistoryStart(rs.getDate("STATUS_HISTORY_START"));
                dao.setStatusHistoryEnd(rs.getDate("STATUS_HISTORY_END"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
