package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PatientDao;

public class PatientUtils {
	
	private DBUtils dbUtils = new DBUtils();
	
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT PIDNO, PNAMEC, PNAME, PSEX, PADDR1, PPATZIP, PPHONNO1, PADDR2, PPHONNO2 FROM  MYSCHEMA.PBASINFO ");
		return sb.toString();
	}
	
	public List<PatientDao> select(){
		List<PatientDao> list = new ArrayList<>();
		PatientDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new PatientDao();
                dao.setPidNo(rs.getString("PIDNO"));
                dao.setpNameC(rs.getString("PNAMEC"));
                dao.setpName(rs.getString("PNAME"));
                dao.setpSex(rs.getString("PSEX"));
                dao.setpAddr1(rs.getString("PADDR1"));
                dao.setPpatZip(rs.getString("PPATZIP"));
                dao.setpPhoneNo1(rs.getString("PPHONNO1"));
                dao.setpAddr2(rs.getString("PADDR2"));
                dao.setpPhone2(rs.getString("PPHONNO2"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
