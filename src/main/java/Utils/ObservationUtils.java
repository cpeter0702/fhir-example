package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ObservationDao;

public class ObservationUtils {
	
	private DBUtils dbUtils = new DBUtils();
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ");
		sb.append(	" fo.OBS_ID, fo.OBS_STATUS, fo.OBS_SUBJECT_TYPE, fo.OBS_SUBJECT_ID, fo.OBS_EFFECTIVE_START, fo.OBS_EFFECTIVE_END, ");
		sb.append(	" fo.OBS_PERFORMER_TYPE, fo.OBS_PERFORMER_ID, fo.OBS_VALUE, fo.OBS_CREATED, fs.SYSTEM_URL, fs.SYSTEM_CODE, fs.SYSTEM_DISPLAY ");
		sb.append(" FROM MYSCHEMA.FHIR_OBSERVATION fo ");
		sb.append(" LEFT JOIN MYSCHEMA.FHIR_SYSTEMS fs ON fo.OBS_ID = fs.SYSTEM_REF_ID ");
		return sb.toString();
	}
	
	public List<ObservationDao> select(){
        List<ObservationDao> list = new ArrayList<>();
        ObservationDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new ObservationDao();
                dao.setObsId(rs.getString("OBS_ID"));
                dao.setObsStatus(rs.getString("OBS_STATUS"));
                dao.setObsSubjectType(rs.getString("OBS_SUBJECT_TYPE"));
                dao.setObsSubjectId(rs.getString("OBS_SUBJECT_ID"));
                dao.setObsEffectiveStart(rs.getTimestamp("OBS_EFFECTIVE_START"));
                dao.setObsEffectiveEnd(rs.getTimestamp("OBS_EFFECTIVE_END"));
                dao.setObsPerformerType(rs.getString("OBS_PERFORMER_TYPE"));
                dao.setObsPerformerId(rs.getString("OBS_PERFORMER_ID"));
                dao.setObsValue(rs.getString("OBS_VALUE"));
                dao.setObsCreated(rs.getTimestamp("OBS_CREATED"));
                dao.setSystemUrl(rs.getString("SYSTEM_URL"));
                dao.setSystemCode(rs.getString("SYSTEM_CODE"));
                dao.setSystemDisplay(rs.getString("SYSTEM_DISPLAY"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
