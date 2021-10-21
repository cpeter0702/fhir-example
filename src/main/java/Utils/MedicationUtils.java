package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MedicationDao;

public class MedicationUtils {
	private DBUtils dbUtils = new DBUtils();
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM MYSCHEMA.FHIR_MEDICATION ");
		return sb.toString();
	}
	
	public List<MedicationDao> select(){
		List<MedicationDao> list = new ArrayList<>();
		MedicationDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new MedicationDao();
                dao.setMedicationId(rs.getString("MEDICATION_ID"));
                dao.setIdentifierValue(rs.getString("IDENTIFIER_VALUE"));
                dao.setMedicationCode(rs.getString("MEDICATION_CODE"));
                dao.setMedicationStatus(rs.getString("MEDICATION_STATUS"));
                dao.setMedicationOrg(rs.getString("MEDICATION_ORG"));
                dao.setMedicationForm(rs.getString("MEDICATION_FORM"));
                dao.setMedicationAmount(rs.getBigDecimal("MEDICATION_AMOUNT"));
                dao.setMedicationIngredientCode(rs.getString("MEDICATION_INGREDIENT_CODE"));
                dao.setMedicationIngredientReference(rs.getString("MEDICATION_INGREDIENT_REFERENCE"));
                dao.setMedicationIsActive(rs.getBoolean("MEDICATION_IS_ACTIVE"));
                dao.setMedicationStrength(rs.getBigDecimal("MEDICATION_STRENGTH"));
                dao.setBatchNumber(rs.getString("BATCH_NUMBER"));
                dao.setBatchDate(rs.getDate("BATCH_DATE"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
