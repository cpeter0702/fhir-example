package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrgContactDao;
import dao.OrganizationDao;

public class OrganizationUtils {

    private DBUtils dbUtils = new DBUtils();
    
    public List<OrgContactDao> selectContact () {
    	List<OrgContactDao> list = new ArrayList<>();
    	OrgContactDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getOrgContactSQL().toString());
            while (rs.next()) {
                dao = new OrgContactDao();
                dao.setConId(rs.getString("CON_ID"));
                dao.setConOrgId(rs.getString("CON_ORG_ID"));
                dao.setConNameUse(rs.getString("CON_NAME_USE"));
                dao.setConNameText(rs.getString("CON_NAME_TEXT"));
                dao.setConNameFmaily(rs.getString("CON_NAME_FAMILY"));
                dao.setConNameGiven(rs.getString("CON_NAME_GIVEN"));
                dao.setConNamePrefix(rs.getString("CON_NAME_PREFIX"));
                dao.setAddr1(rs.getString("ADDR_1"));
                dao.setAddr2(rs.getString("ADDR_2"));
                dao.setAddrCity(rs.getString("ADDR_CITY"));
                dao.setAddrDist(rs.getString("ADDR_DISTRICT"));
                dao.setAddrState(rs.getString("ADDR_STATE"));
                dao.setAddrZipcode(rs.getString("ADDR_ZIPCODE"));
                dao.setAddrCountry(rs.getString("ADDR_COUNTRY"));
                dao.setTelType(rs.getString("T_TYPE"));
                dao.setTelValue(rs.getString("T_VALUE"));
                dao.setTelPurpose(rs.getString("T_PURPOSE"));
                
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        
    	return list;
    }
    
    public List<OrganizationDao> select(){
        List<OrganizationDao> list = new ArrayList<>();
        OrganizationDao dao = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            stmt = conn.createStatement();
			rs = stmt.executeQuery(this.getOrganizationSQL().toString());
            while (rs.next()) {
                dao = new OrganizationDao();
                dao.setOrgId(rs.getString("ORG_ID"));
                dao.setOrgName(rs.getString("ORG_NAME"));
                dao.setOrgNameEn(rs.getString("ORG_NAME_EN"));
                dao.setOrgNameType(rs.getString("org_name_type"));
                dao.setOrgNameDisplay(rs.getString("org_name_display"));
                dao.setTelcomType(rs.getString("telcom_type"));
                dao.setTelcomVal(rs.getString("telcom_val"));
                dao.setTelcomPurpose(rs.getString("telcom_purpose"));
                dao.setAddr1(rs.getString("ADDR_1"));
                dao.setAddr2(rs.getString("ADDR_2"));
                dao.setAddrCity(rs.getString("ADDR_CITY"));
                dao.setAddrDist(rs.getString("ADDR_DISTRICT"));
                dao.setAddrState(rs.getString("ADDR_STATE"));
                dao.setAddrZipCode(rs.getString("ADDR_ZIPCODE"));
                dao.setAddrCountry(rs.getString("ADDR_COUNTRY"));
                list.add(dao);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return list;
    }
    
	public String getOrgContactSQL() {
    	StringBuffer sqlSb = new StringBuffer();
        sqlSb.append(" SELECT ");
        sqlSb.append(	" ft.T_TYPE, ft.T_VALUE, ft.T_PURPOSE, ");
        sqlSb.append(	" fc.CON_ID, fc.CON_ORG_ID, fc.CON_NAME_USE, fc.CON_NAME_TEXT, ");
        sqlSb.append(	" fc.CON_NAME_FAMILY, fc.CON_NAME_GIVEN, fc.CON_NAME_PREFIX, ");
        sqlSb.append(	" fa.ADDR_1, fa.ADDR_2, fa.ADDR_CITY, fa.ADDR_DISTRICT, ");
        sqlSb.append(	" fa.ADDR_STATE, fa.ADDR_ZIPCODE, fa.ADDR_COUNTRY ");
        sqlSb.append(" FROM MYSCHEMA.FHIR_CONTACT fc ");
        sqlSb.append(" LEFT JOIN MYSCHEMA.FHIR_ADDRESS fa ON fc.CON_ID = fa.ADDR_CONTACT_ID ");
        sqlSb.append(" LEFT JOIN MYSCHEMA.FHIR_TELCOM ft ON ft.T_CONTACT_ID = fc.CON_ID ");
        return sqlSb.toString();
    }
    
    public String getOrganizationSQL (){
        StringBuffer sqlSb = new StringBuffer();
        sqlSb.append(" SELECT ");
        sqlSb.append(   " fo.ORG_ID, fo.ORG_NAME, fo.ORG_NAME_EN, ");
        sqlSb.append(   " fon.ON_TYPE AS org_name_type, fon.ON_DISPLAY AS org_name_display,  ");
        sqlSb.append(   " ft.T_TYPE AS telcom_type, ft.T_VALUE AS telcom_val, ft.T_PURPOSE AS telcom_purpose, ");
        sqlSb.append(   " fa.ADDR_1 , fa.ADDR_2, fa.ADDR_CITY, fa.ADDR_DISTRICT, fa.ADDR_STATE, fa.ADDR_ZIPCODE, fa.ADDR_COUNTRY  ");
        sqlSb.append(" FROM MYSCHEMA.FHIR_ORGANIZATION fo ");
        sqlSb.append(" LEFT JOIN MYSCHEMA.FHIR_ORGANIZATION_NAME fon ON fo.ORG_ID = fon.ORG_ID  ");
        sqlSb.append(" LEFT JOIN MYSCHEMA.FHIR_TELCOM ft ON fo.ORG_ID = ft.T_ORG_ID  ");
        sqlSb.append(" LEFT JOIN MYSCHEMA.FHIR_ADDRESS fa ON fo.ORG_ID = fa.ADDR_ORG_ID  ");
        return sqlSb.toString();
    }

    public String getWhereConditions (OrganizationDao orgDao){
        if (orgDao == null){
            return "";
        }

        StringBuffer whereSb = new StringBuffer(" WHERE 1 = 1 ");

        if (orgDao.getOrgId() != null){
            whereSb.append(" AND fo.ORG_ID = '").append(orgDao.getOrgId()).append("' ");
        }

        if (orgDao.getOrgName() != null){
            whereSb.append(" AND fo.ORG_NAME = '").append(orgDao.getOrgName()).append("' ");
        }

        if (orgDao.getOrgNameEn() != null){
            whereSb.append(" AND fo.ORG_NAME_EN = '").append(orgDao.getOrgNameEn()).append("' ");
        }

        if (orgDao.getOrgNameType() != null){
            whereSb.append(" AND fon.ON_TYPE = '").append(orgDao.getOrgNameType()).append("' ");
        }

        if (orgDao.getOrgNameDisplay() != null){
            whereSb.append(" AND fon.ON_DISPLAY = '").append(orgDao.getOrgNameDisplay()).append("' ");
        }

        if (orgDao.getOrgId() != null){
            whereSb.append(" AND fo.ORG_ID = '").append(orgDao.getOrgId()).append("' ");
        }

        if (orgDao.getTelcomType() != null){
            whereSb.append(" AND ft.T_TYPE = '").append(orgDao.getTelcomType()).append("' ");
        }

        if (orgDao.getTelcomVal() != null){
            whereSb.append(" AND ft.T_VALUE = '").append(orgDao.getTelcomVal()).append("' ");
        }

        if (orgDao.getTelcomPurpose() != null){
            whereSb.append(" AND ft.T_PURPOSE = '").append(orgDao.getTelcomPurpose()).append("' ");
        }

        if (orgDao.getAddr1() != null){
            whereSb.append(" AND fa.ADDR_1 = '").append(orgDao.getAddr1()).append("' ");
        }

        if (orgDao.getAddr2() != null){
            whereSb.append(" AND fa.ADDR_2 = '").append(orgDao.getAddr2()).append("' ");
        }

        if (orgDao.getAddrCity() != null){
            whereSb.append(" AND fa.ADDR_CITY = '").append(orgDao.getAddrCity()).append("' ");
        }

        if (orgDao.getAddrDist() != null){
            whereSb.append(" AND fa.ADDR_DISTRICT = '").append(orgDao.getAddrDist()).append("' ");
        }

        if (orgDao.getAddrState() != null){
            whereSb.append(" AND fa.ADDR_STATE = '").append(orgDao.getAddrState()).append("' ");
        }

        if (orgDao.getAddrZipCode() != null){
            whereSb.append(" AND fa.ADDR_ZIPCODE = '").append(orgDao.getAddrZipCode()).append("' ");
        }

        if (orgDao.getAddrCountry() != null){
            whereSb.append(" AND fa.ADDR_COUNTRY = '").append(orgDao.getAddrCountry()).append("'");
        }

        return whereSb.toString();
    }
}
