package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PractitionerDao;

public class PractitionerUtils {
	private DBUtils dbUtils = new DBUtils();
	
	public String getSQL() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT * FROM FHIR_PRACTITIONER ");
		return sb.toString();
	}
	
	public List<PractitionerDao> select(){
		List<PractitionerDao> list = new ArrayList<>();
		PractitionerDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getSQL());
            while (rs.next()) {
                dao = new PractitionerDao();
                dao.setPracttitionerId(rs.getString("PRACTITIONER_ID"));
                dao.setIdentifierUse1(rs.getString("IDENTIFIER_USE1"));
                dao.setIdentifierSystem1(rs.getString("IDENTIFIER_SYSTEM1"));
                dao.setIdentifierValue1(rs.getString("IDENTIFIER_VALUE1"));
                dao.setIdentifierUse2(rs.getString("IDENTIFIER_USE2"));
                dao.setIdentifierSystem2(rs.getString("IDENTIFIER_SYSTEM2"));
                dao.setIdentifierValue2(rs.getString("IDENTIFIER_VALUE2"));
                dao.setPractitionerActive(rs.getBoolean("PRACTITIONER_ACTIVE"));
                dao.setNameUse(rs.getString("NAME_USE"));
                dao.setNameFamily(rs.getString("NAME_FAMILY"));
                dao.setNameGiven(rs.getString("NAME_GIVEN"));
                dao.setNameSuffix(rs.getString("NAME_SUFFIX"));
                dao.setTelecomSystem1(rs.getString("TELECOM_SYSTEM1"));
                dao.setTelecomValue1(rs.getString("TELECOM_VALUE1"));
                dao.setTelecomUse1(rs.getString("TELECOM_USE1"));
                dao.setTelecomSystem2(rs.getString("TELECOM_SYSTEM2"));
                dao.setTelecomValue2(rs.getString("TELECOM_VALUE2"));
                dao.setTelecomUse2(rs.getString("TELECOM_USE2"));
                dao.setTelecomSystem3(rs.getString("TELECOM_SYSTEM3"));
                dao.setTelecomValue3(rs.getString("TELECOM_VALUE3"));
                dao.setTelecomUse3(rs.getString("TELECOM_USE3"));
                dao.setAddressUse(rs.getString("ADDRESS_USE"));
                dao.setAddressLine(rs.getString("ADDRESS_LINE"));
                dao.setAddressCity(rs.getString("ADDRESS_CITY"));
                dao.setAddressPostalCode(rs.getString("ADDRESS_POSTAL_CODE"));
                dao.setAddressCountry(rs.getString("ADDRESS_COUNTRY"));
                dao.setGender(rs.getString("GENDER"));
                dao.setBirthdate(rs.getDate("BIRTHDATE"));
                dao.setQualificationIdentifierSystem(rs.getString("QUALIFICATION_IDENTIFIER_SYSTEM"));
                dao.setQualificationIdentifierValue(rs.getString("QUALIFICATION_IDENTIFIER_VALUE"));
                dao.setQualificationCodingSystem(rs.getString("QUALIFICATION_CODING_SYSTEM"));
                dao.setQualificationCodingCode(rs.getString("QUALIFICATION_CODING_CODE"));
                dao.setQualificationText(rs.getString("QUALIFICATION_TEXT"));
                dao.setQualificationPeriodStart(rs.getDate("QUALIFICATION_PERIOD_START"));
                dao.setQualificationPeriodEnd(rs.getDate("QUALIFICATION_PERIOD_END"));
                dao.setQualificationIssuerDisplay(rs.getString("QUALIFICATION_ISSUER_DISPLAY"));
                dao.setCommunicationSystem(rs.getString("COMMUNICATION_SYSTEM"));
                dao.setCommunicationCode(rs.getString("COMMUNICATION_CODE"));
                dao.setCommunicationDisplay(rs.getString("COMMUNICATION_DISPLAY"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
}
