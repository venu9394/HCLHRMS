package com.dashboard.dao;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.hclhrm.util.Util;

public class ExcelDao {
	
	
	static String BUID=null;
	
	  Connection  conn= Util.getConnection();
	    ResultSet rs = null;
		PreparedStatement ps = null;
      String query=null;
	
	public ExcelDao(String LOGINBY) throws SQLException
	{
		
	ArrayList al=new ArrayList();
		
		String employeeid="SELECT b.employeesequenceno,a.EMPLOYEEID, a.BUSINESSUNITID "
				+ "FROM hclhrm_prod.tbl_employee_businessunit a  "
				+ "left join hclhrm_prod.tbl_employee_primary b on a.employeeid=b.employeeid where b.employeesequenceno="+LOGINBY+"";
		
		System.out.println(employeeid); 

			ps = conn.prepareStatement(employeeid);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				al.add(rs.getString(3));

			}
			
			
			BUID=al.toString().replace("[", "").replace("]", "");
	}
	
	
	
	
	public String Excel(String filename,String type,String name){
	 try {
     	
		// Connection conn=null;
        FileWriter fw = new FileWriter(filename);
       // conn= Util.getConnection();
        String query=null;
        
        
        
        
        
        
        if(type.equalsIgnoreCase("query1")){
         query = "SELECT b.employeesequenceno,b.callname,c.name FROM HCLHRM_PROD.TBL_EMPLOYEE_PERSONAL_CONTACT A "
        		+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
        		+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID WHERE LENGTH(TRIM("+name+")) in (0,1) AND B.STATUS=1001 and b.companyid in ("+BUID+")";
        
        }else if(type.equalsIgnoreCase("query2")){
        	
         query="SELECT distinct b.employeesequenceno,b.callname,c.name FROM HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL A "
         		+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
         		+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
         		+ "WHERE LENGTH(TRIM("+name+")) in (0,1) AND B.STATUS=1001 and b.companyid in ("+BUID+") and A.bankid!=6";
        	
        }else if(type.equalsIgnoreCase("query3")){
        	
        	  query="SELECT b.employeesequenceno,b.callname,c.name FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS A "
               		+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY B ON A.EMPLOYEEID=B.EMPLOYEEID "
               		+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT C ON B.COMPANYID=C.BUSINESSUNITID "
               		+ "WHERE  LENGTH(TRIM("+name+")) in (0,1) AND B.STATUS=1001 and b.companyid in ("+BUID+")";
              	
        }
      
        System.out.println(query);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
	
	 
        fw.append("EmployeeId");
    	fw.append(',');
    	fw.append("CallName");
    	fw.append(',');
    	fw.append("Division");
    	fw.append(',');
    	fw.append('\n');

        while (rs.next()) {
        	
            fw.append(rs.getString(1));
            fw.append(',');
            fw.append(rs.getString(2));
            fw.append(',');
            fw.append(rs.getString(3));
            fw.append('\n');
           }
        
        fw.flush();
        fw.close();
        conn.close();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	return filename;
	 
	}

}
