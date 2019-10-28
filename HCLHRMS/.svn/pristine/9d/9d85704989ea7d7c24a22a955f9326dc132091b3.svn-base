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
public class Employee_Reports_services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Reports_services() {
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
	    
	    ArrayList BusinesUnit=new ArrayList();
	    ArrayList State_Codes=new ArrayList();
	    ArrayList Gender=new ArrayList();
	    
	    ArrayList EMTYPE=new ArrayList();
	    
	    ArrayList title=new ArrayList();
	    
	    ArrayList Status=new ArrayList();
	    
	    PayrollStatus.append(" SELECT BUSINESSUNITID,NAME FROM HCLADM_PROD.TBL_BUSINESSUNIT WHERE PARENTBUSINESSUNITID!=0 AND STATUS=1001 AND BUSINESSUNITID IN("+BU+") ");
	   	    
	    emp_lop.append("select distinct payperiod from HCLHRM_PROD.tbl_employee_pay_data order by payperiod desc limit 12");
	   
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(emp_lop.toString(), "PayrollStatus", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			//BusinesUnit.add("Select#--Select One--");
			while(Res.next()){
				
				jason = new JSONObject();
				jason.put("PAYPERIOD",Res.getString(1));
				jason.put("PAYPERIOD_KEY",Res.getString(1));
				//BusinesUnit.add(Res.getString("BUSINESSUNITID") + "#" + Res.getString("NAME"));
				
				//payroll=Res.getInt(1);
				 values.add(jason);
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
	    request.setAttribute("PAYPERIOD", values.toString());
	   
	  //**************************************************************************** 
	    System.out.println("RoutingPage[LOP_Servicess]::"+RoutingPage);
	    request.getRequestDispatcher("Common_Reports.jsp").forward(request, response);
	}

}
