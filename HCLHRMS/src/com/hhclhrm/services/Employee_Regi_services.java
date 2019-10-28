package com.hhclhrm.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.io.IOException;
import java.net.InetAddress;

import com.google.gson.Gson;
import com.hclhrm.util.Util;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.json.JSONException;


/**
 * Servlet implementation class LOP_Servicess
 */
public class Employee_Regi_services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Regi_services() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet Res=null;
		String GlobalMsg=null;
		DataSource dataSource=null;
		java.sql.Connection conn=null;
		java.sql.PreparedStatement ps=null;
		String RecordLen="0";
		com.hhclhrm.globaldb.GetDbData DataObj=new com.hhclhrm.globaldb.GetDbData();
		JSONArray values;
		values = new JSONArray();
		JSONObject jason = new JSONObject();
		Map Emp_Data=new HashMap();
		JSONObject LOPLIST = new JSONObject();
		
		HttpSession session=request.getSession();
		
		  String RoutingPage=(String)request.getAttribute("Routing");
		  String BU=(String)request.getAttribute("BU");
		  String ProcessedBy=(String)request.getAttribute("Pby");
		  String LOGINBY=(String)request.getAttribute("LOGINBY");
		  
		 GlobalMsg=(String)request.getAttribute("GlobalMsg");
		 System.out.println("GlobalMsg:::~"+GlobalMsg);
		 String QueryMode="N";
		 int payroll=0;
		 
		 RecordLen=(String)request.getAttribute("RecordLen");
		 
		 System.out.println("RecordLen:::"+RecordLen);
		 
		 if(RecordLen==null){
			 RecordLen="0"; 
		 }
		 
		 int RecordLe=Integer.parseInt(RecordLen.toString());
		 
		  if(GlobalMsg!=null){
			  request.setAttribute("GlobalMsg",GlobalMsg);
			  if(RecordLe>0){
			  QueryMode="Y";
			  }
		  }else{
			  request.setAttribute("GlobalMsg",null);
		  }
		  
		  
		  
		  session.setAttribute("Routing", RoutingPage);
		  session.setAttribute("BU", BU);
		  session.setAttribute("Pby", ProcessedBy);
		  session.setAttribute("LOGINBY", LOGINBY);
		  
		/*
		try {
			//conn =dataSource.getConnection();
			conn=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}*/
		  
		  conn = Util.getConnection();
		
	   // String RoutingPage=(String)request.getAttribute("Routing");
	  //****************************************************************************  
	    StringBuffer Over_All_Emp_Count=new StringBuffer();
	    
	    StringBuffer Active_emp_list=new StringBuffer();
	    StringBuffer emp_lop=new StringBuffer();
	    StringBuffer PayrollStatus=new StringBuffer();
	    
	    
	    ////////-----Sales
	    
	    StringBuffer Sales_Office=new StringBuffer();
	    StringBuffer Sales_District=new StringBuffer();
	    
	    
	    
	    ArrayList SalesDistrictLoad=new ArrayList();
	    
	    ArrayList SalesOfficeLoad=new ArrayList();
	    
	    
	    
	    
	    ArrayList BusinesUnit=new ArrayList();
	    ArrayList State_Codes=new ArrayList();
	    ArrayList Gender=new ArrayList();
	    
	    ArrayList EMTYPE=new ArrayList();
	    
	    ArrayList title=new ArrayList();
	    
	    ArrayList Status=new ArrayList();
	    
	    PayrollStatus.append(" SELECT BUSINESSUNITID,NAME FROM HCLADM_PROD.TBL_BUSINESSUNIT WHERE PARENTBUSINESSUNITID!=0 AND STATUS=1001 AND BUSINESSUNITID IN("+BU+") ");
	   	    
	    emp_lop.append("SELECT DISTINCT STATE_CODE,STATE FROM test.tbl_pt_deviation_ranges ORDER BY STATE ASC");
	    Over_All_Emp_Count.append(" select employeesequenceno,employeeid  from hclhrm_prod.tbl_employee_primary where status=1001 and companyid in("+BU+")");
	    
	    Active_emp_list.append(" select ep.employeesequenceno seqno,ep.employeeid,ep.callname,epf.DATEOFJOIN   from ");
	    Active_emp_list.append(" hclhrm_prod.tbl_employee_primary ep,hclhrm_prod.tbl_employee_profile epf ");
	    Active_emp_list.append(" where epf.employeeid=ep.employeeid and ep.status=1001 ");
	    Active_emp_list.append(" and ep.employeesequenceno not in(1) and ep.companyid in("+BU+") ");
	    Active_emp_list.append(" order by epf.DATEOFJOIN ");
	    
	    
	    ///---Sales
	    
	   
	    Sales_District.append("SELECT SALESDISTCODE, SALESDISTNAME FROM hclhrm_prod_others.tbl_salesdistrict WHERE STATUS=1001");
	    
	    Sales_Office.append("SELECT SALESOFFICECODE, SALESOFFICENAME FROM hclhrm_prod_others.tbl_salesOFFICE WHERE STATUS=1001");
	    
	    
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(PayrollStatus.toString(), "PayrollStatus", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			BusinesUnit.add("Select#--Select One--");
			while(Res.next()){
				
				BusinesUnit.add(Res.getString("BUSINESSUNITID") + "#" + Res.getString("NAME"));
				
				//payroll=Res.getInt(1);
				
			}
			
		if(payroll>0){
			GlobalMsg="Payroll";
			RecordLe=1;
			if(GlobalMsg!=null){
				  request.setAttribute("GlobalMsg","Payroll already processed...!");
				  if(RecordLe>0){
				  QueryMode="Y";
				  }
			  }else{
				  request.setAttribute("GlobalMsg",null);
			  }
		}
			
	    }catch(Exception er2){
	    	
	    	System.out.println("Exception er2::" +er2);
	    }
	    
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Over_All_Emp_Count.toString(), "All Employee List", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			while(Res.next()){
				
				Emp_Data.put(Res.getString("employeesequenceno")+"_LOP", "0"); // From LOP Master
				Emp_Data.put(Res.getString("employeesequenceno")+"_A", "0");   // FROM iconnect Data
				Emp_Data.put(Res.getString("employeesequenceno")+"_P", "0");   // FROM iconnect Data
				Emp_Data.put(Res.getString("employeesequenceno")+"_R", "0");   // FROM iconnect Data
				
				Emp_Data.put(Res.getString("employeeid")+"_LOP", "0"); // From LOP Master
				Emp_Data.put(Res.getString("employeeid")+"_A", "0");   // FROM iconnect Data
				Emp_Data.put(Res.getString("employeeid")+"_P", "0");   // FROM iconnect Data
				Emp_Data.put(Res.getString("employeeid")+"_R", "0");   // FROM iconnect Data
				
			}
			
	    }catch(Exception er2){
	    	
	    	System.out.println("Exception er2::" +er2);
	    }
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(emp_lop.toString(), "All Employee LOP", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			State_Codes.add("Select#--Select One--");
			while(Res.next()){
				
				State_Codes.add(Res.getString(1) + "#" + Res.getString(2));
				
				//Emp_Data.put(Res.getString("employeeid")+"_LOP", Res.getString("lopcount")); // From LOP Master
				
				
			}
			
	    }catch(Exception er2){
	    	
	    	System.out.println("Exception er2::" +er2);
	    }
	    
	    
	 ///******************************************************************************************   
	StringBuffer Query_Gender=new StringBuffer();
	StringBuffer Query_Title=new StringBuffer();
	StringBuffer Query_EMTYPE=new StringBuffer();
	StringBuffer Query_EMP_STATUS=new StringBuffer();
	
	
	
	Query_Gender.append("select * FROM hcladm_prod.tbl_gender ");
	
	Query_Title.append("select * FROM hcladm_prod.tbl_title");
	
	Query_EMTYPE.append("select * FROM hclhrm_prod.tbl_employment_types ; ");
	
	Query_EMP_STATUS.append("select * FROM hcladm_prod.tbl_status_codes WHERE BASESTATUS=1 and STATUS not in (1081,1082,1071,1091)");
	
	
	
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Query_Gender.toString(), "Query_Gender", Res ,conn);
			
			Gender.add("Select#--Select One--");
			
			while(Res.next()){
				
				
				Gender.add(Res.getString(1) + "#" + Res.getString(2));
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	 
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Query_Title.toString(), "Query_Title", Res ,conn);
			
			
			title.add("Select#--Select One--");
			while(Res.next()){
				
				
				title.add(Res.getString(1) + "#" + Res.getString(2));
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Query_EMTYPE.toString(), "Query_EMTYPE", Res ,conn);
			
			EMTYPE.add("Select#--Select One--");
			while(Res.next()){
				
				
				EMTYPE.add(Res.getString(1) + "#" + Res.getString(2));
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Query_EMP_STATUS.toString(), "Query_EMP_STATUS", Res ,conn);
			
			
			Status.add("Select#--Select One--");
			while(Res.next()){
				
				Status.add(Res.getString(1) + "#" + Res.getString(2));
			
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    
	    
	    ///----Sales--
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Sales_Office.toString(), "Sales_Office", Res ,conn);
			
			
			SalesOfficeLoad.add("0#--Select One--");
			while(Res.next()){
				
				SalesOfficeLoad.add(Res.getString(1) + "#" + Res.getString(2));
			
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Sales_District.toString(), "Sales_District", Res ,conn);
			
			
			SalesDistrictLoad.add("0#--Select One--");
			while(Res.next()){
				
				SalesDistrictLoad.add(Res.getString(1) + "#" + Res.getString(2));
			
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    
	    
	   /* Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Sales_Group.toString(), "Sales_Group", Res ,conn);
			
			
			SalesGrouptLoad.add("Select#--Select One--");
			while(Res.next()){
				
				SalesGrouptLoad.add(Res.getString(1) + "#" + Res.getString(2));
			
				
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    */
	    
//*********************************************************************************************************
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    Gson gson = new Gson();
		String messages = gson.toJson(BusinesUnit);
		
		
	    System.out.println("LOPLIST" +values.toString());
	    request.setAttribute("BusinesUnit",messages);
	    
	    messages = gson.toJson(State_Codes);
	    
	    request.setAttribute("StateCode",messages);
	    
	    
         messages = gson.toJson(Gender);
	    
	    request.setAttribute("Gender",messages);
	    
	    
         messages = gson.toJson(title);
	    
	    request.setAttribute("title",messages);
	    
	    
        messages = gson.toJson(EMTYPE);
	    
	    request.setAttribute("EMTYPE",messages);
	    
          messages = gson.toJson(Status);
	    
	    request.setAttribute("Status",messages);
	    
	    
	    ///---Sales
	    
	    
          messages = gson.toJson(SalesDistrictLoad);
	    
	    request.setAttribute("SalesDistrictLoad",messages);
	    
        messages = gson.toJson(SalesOfficeLoad);
	    
	    request.setAttribute("SalesOfficeLoad",messages);
	    
	   
	    
	   
	    
	    
	    
	    
	   
	  //**************************************************************************** 
	    System.out.println("RoutingPage[LOP_Servicess]::"+RoutingPage);
	    request.getRequestDispatcher("EmpRegistration.jsp").forward(request, response);
	}

}
