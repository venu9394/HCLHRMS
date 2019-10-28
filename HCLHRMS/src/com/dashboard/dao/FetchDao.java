package com.dashboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hclhrm.util.Util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.json.JSONException;

public class FetchDao {

	static Connection connection = null;

	static String BUID=null;
	static String AddressQry=null;
	static String MobileQry=null;
	static String EmailQry=null;
	static String EsiNoQry=null;
	static String PFNoQry=null;
	static String BankAccountQry=null;
	static String DepartmentQry=null;
	static String DesignationQry=null;
	static String WorkLocationQry=null;
	
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public FetchDao(String LOGINBY) throws Exception {

		connection = Util.getConnection();
		
		System.out.println("HAIIIIIIIIIIII"+LOGINBY);
		
		JSONObject jason = new JSONObject();
		
		ArrayList al=new ArrayList();
		
		String employeeid="SELECT b.employeesequenceno,a.EMPLOYEEID, a.BUSINESSUNITID "
				+ "FROM hclhrm_prod.tbl_employee_businessunit a  "
				+ "left join hclhrm_prod.tbl_employee_primary b on a.employeeid=b.employeeid where b.employeesequenceno="+LOGINBY+" and a.BUSINESSUNITID!=0";
		
		System.out.println(employeeid); 

			ps = connection.prepareStatement(employeeid);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				al.add(rs.getString(3));

			}
			
			
			BUID=al.toString().replace("[", "").replace("]", "");
			
			
			System.out.println("BUID::"+BUID);
			
			
			
			
			 AddressQry="SELECT C.NAME,COUNT(A.PERMANENTADDRESS) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
                    +" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
                    +" LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID"
                    + " WHERE LENGTH(TRIM(A.PERMANENTADDRESS)) in (0,1) AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID ";
	System.out.println(AddressQry);

	
	 MobileQry = "SELECT C.NAME,COUNT(A.MOBILE) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ " LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.MOBILE)) in (0,1) AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+")  GROUP BY B.COMPANYID ";
	
	
	 EmailQry = "SELECT C.NAME,COUNT(A.EMAIL) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.EMAIL)) in (0,1) AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID ";
	
	
	 EsiNoQry=" SELECT c.name,COUNT(A.ESINO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A  "
			+ " LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
          +" left join hcladm_prod.tbl_businessunit c on b.companyid=c.businessunitid "
          + "WHERE LENGTH(TRIM(A.ESINO)) in (0,1) AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") group by b.companyid";
	
	 PFNoQry = "SELECT C.NAME,COUNT(A.PFNO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.PFNO)) in (0,1)  AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID";
	
	 BankAccountQry = "SELECT C.NAME,COUNT(A.ACCOUNTNO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.ACCOUNTNO)) in (0,1) AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") and a.bankid!=6 GROUP BY B.companyid";
	
	 DepartmentQry = "SELECT C.NAME,COUNT(A.DEPARTMENTID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.DEPARTMENTID))=1 AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID";
	
	 DesignationQry = "SELECT C.NAME,COUNT(A.DESIGNATIONID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID"
			+ " WHERE LENGTH(TRIM(A.DESIGNATIONID))=1  AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID";
	
	 WorkLocationQry = "SELECT C.NAME,COUNT(A.WORKLOCATIONID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE LENGTH(TRIM(A.WORKLOCATIONID))=1  AND B.STATUS=1001 AND B.COMPANYID IN ("+BUID+") GROUP BY B.COMPANYID";
			
			
			
			
		
	}

	
	
	
		 
	 
	
		
	
	
	
	/*String MobileQry = "SELECT COUNT(A.MOBILE) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.MOBILE='' AND B.STATUS=1001;";
	String AddressQry = "SELECT COUNT(A.PERMANENTADDRESS) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.PERMANENTADDRESS='' AND B.STATUS=1001";
	String EmailQry = "SELECT COUNT(A.EMAIL) FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.EMAIL='' AND B.STATUS=1001;";

	String DepartmentQry = "SELECT COUNT(A.DEPARTMENTID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.DEPARTMENTID='' AND B.STATUS=1001";

	String DesignationQry = "SELECT COUNT(A.DESIGNATIONID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.DESIGNATIONID='' AND B.STATUS=1001";

	String WorkLocationQry = "SELECT COUNT(A.WORKLOCATIONID) FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.WORKLOCATIONID='' AND B.STATUS=1001";

	String BankAccountQry = "SELECT COUNT(A.ACCOUNTNO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.ACCOUNTNO='' AND B.STATUS=1001";

	String PFNoQry = "SELECT COUNT(A.PFNO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.PFNO='' AND B.STATUS=1001";

	String EsiNoQry = "SELECT COUNT(A.ESINO) FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.ESINO='' AND B.STATUS=1001";*/
	
	

	/*public Map<String,String> Address_jason() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		
		try {

			ps = connection.prepareStatement(AddressQry);
		//	System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				hm.put(rs.getString(1),rs.getString(2));
				
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		   
		}

		return hm;

	}*/
	
	
	public JSONObject Address() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(AddressQry);
		//	System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		   
		}
		jason1.put("FinalCount",Count);
		jason1.put("ADD",jason);
		return jason1;

	}
	
	
	/*public Map<String,String> Mobile() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		
		try {

			System.out.println("MobileQuery" +MobileQry.toString());
			ps = connection.prepareStatement(MobileQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		 }

		return hm;

	}*/
	
	public JSONObject Mobile() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			System.out.println("MobileQuery" +MobileQry.toString());
			ps = connection.prepareStatement(MobileQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		 }
		jason1.put("FinalCount",Count);
		jason1.put("MOB",jason);
		return jason1;

	}
	
	public JSONObject EmailId() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(EmailQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));
				
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		jason1.put("FinalCount",Count);
		jason1.put("EMAIL",jason);
		return jason1;

	}
	
	public JSONObject BankAccount() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(BankAccountQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		jason1.put("FinalCount",Count);
		jason1.put("BANK",jason);
		return jason1;

	}
	
	public JSONObject PFNo() throws SQLException {

		Map<String,String> hm = new HashMap<String,String>();
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(PFNoQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));
               
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
		jason1.put("FinalCount",Count);
		jason1.put("PF",jason);
		return jason1;

	}
	
	public JSONObject EsiNo() throws SQLException {
		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(EsiNoQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				//hm.put(rs.getString(1),rs.getString(2));
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 

		jason1.put("FinalCount",Count);
		jason1.put("ESI",jason);
		return jason1;

	}
	
	
	public JSONObject Department() throws SQLException {
		
		Map<String,String> hm = new HashMap<String,String>();
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		
		int Count=0;
		try {

			ps = connection.prepareStatement(DepartmentQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				
				//values = new JSONArray();
				jason.put(rs.getString(1) ,rs.getString(2));
			//	jason.put("BUCOUNT",rs.getString(2));

				//jason1.put("DEPART", jason);
				//values.
				
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  

		jason1.put("FinalCount",Count);
		
		jason1.put("DEPART", jason);
		
		return jason1;

	}
	
	
	public JSONObject Designation() throws SQLException {
		Map<String,String> hm = new HashMap<String,String>();
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(DesignationQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  

		jason1.put("FinalCount",Count);
		jason1.put("DES",jason);
		return jason1;

	}
	public JSONObject WorkLocation() throws SQLException {
		Map<String,String> hm = new HashMap<String,String>();
		
		JSONObject jason = new JSONObject();
		JSONObject jason1 = new JSONObject();
		int Count=0;
		try {

			ps = connection.prepareStatement(WorkLocationQry);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Count=Count+ Integer.parseInt(rs.getString(2).toString());
				jason.put(rs.getString(1),rs.getString(2));

			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}  
		

		jason1.put("FinalCount",Count);
		jason1.put("WLC", jason);
		return jason1;

	}
	/*public Map<String,String> DivisionCount(String type) throws SQLException {
		
		
		System.out.println(type+"Aleeee");
		Map<String,String> Hm=new HashMap<String,String>();
		String MobileDivisionQry=null;
		
if(type.equalsIgnoreCase("a.permanentaddress")||type.equalsIgnoreCase("a.mobile")||type.equalsIgnoreCase("a.email")){
		 MobileDivisionQry="SELECT C.NAME,COUNT("+type+") FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
				+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
				+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
				+ "WHERE TRIM("+type+") IS NULL OR LENGTH("+type+")=0  AND B.STATUS=1001 GROUP BY B.COMPANYID";
		 
		 
}else if(type.equalsIgnoreCase("a.accountno")||type.equalsIgnoreCase("a.pfno")||type.equalsIgnoreCase("a.esino")){
	
	MobileDivisionQry="SELECT C.NAME,COUNT("+type+") FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID"
			+ "	LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE TRIM("+type+") IS NULL OR LENGTH("+type+")=0 AND B.STATUS=1001 GROUP BY B.COMPANYID";
}else{
	MobileDivisionQry="SELECT C.NAME,COUNT("+type+") FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
			+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
			+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
			+ "WHERE TRIM("+type+") IS NULL OR LENGTH("+type+")=0 OR "+type+"='' AND B.STATUS=1001 GROUP BY B.COMPANYID";
}
		ps = connection.prepareStatement(MobileDivisionQry);
		ps.setString(1, type);
		ps.setString(2, type);
		ps.setString(3, type);
		System.out.println(""+ps);
		rs = ps.executeQuery();
		
	
		
		while (rs.next()) {
			
			Hm.put(rs.getString(1),rs.getString(2));

		}

		return Hm;
	
	}
	*/
	/*
	 * public String MobileCount() { String Mobile = null; try {
	 * 
	 * ps = connection.prepareStatement(MobileQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { Mobile=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * Mobile; }
	 * 
	 * 
	 * public String Address() { String Address = null; try {
	 * 
	 * ps = connection.prepareStatement(AddressQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { Address=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * Address; }
	 * 
	 * public String Email() { String Email = null; try {
	 * 
	 * ps = connection.prepareStatement(EmailQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { Email=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * Email; }
	 * 
	 * public String Department() { String Department = null; try {
	 * 
	 * ps = connection.prepareStatement(DepartmentQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { Department=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * Department; }
	 * 
	 * public String Designation() { String Designation = null; try {
	 * 
	 * ps = connection.prepareStatement(DesignationQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { Designation=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * Designation; }
	 * 
	 * public String WorkLoaction() { String WorkLoaction = null; try {
	 * 
	 * ps = connection.prepareStatement(WorkLocationQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { WorkLoaction=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * WorkLoaction; }
	 * 
	 * public String BankAccount() { String BankAccount = null; try {
	 * 
	 * ps = connection.prepareStatement(BankAccountQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { BankAccount=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * BankAccount; }
	 * 
	 * public String PFNo() { String PFNo = null; try {
	 * 
	 * ps = connection.prepareStatement(PFNoQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { PFNo=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * PFNo; }
	 * 
	 * public String EsiNo() { String EsiNo = null; try {
	 * 
	 * ps = connection.prepareStatement(EsiNoQry);
	 * 
	 * rs = ps.executeQuery(); if (rs.next()) { EsiNo=rs.getString(1);
	 * 
	 * }
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * EsiNo; }
	 */
	
	
	

}