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
public class Emp_prof_services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Emp_prof_services() {
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
		  
		  StringBuffer EMPLIST_UPDATE=(StringBuffer)request.getAttribute("Record_employee");
		  
		  
		  System.out.println("EMPLIST_UPDATE:::"+EMPLIST_UPDATE);
		  
		  
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
		  
		
		try {
			//conn =dataSource.getConnection();
			conn=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
	   // String RoutingPage=(String)request.getAttribute("Routing");
	  //****************************************************************************  
	    StringBuffer Over_All_Emp_Count=new StringBuffer();
	    StringBuffer Active_emp_list=new StringBuffer();
	    StringBuffer emp_lop=new StringBuffer();
	    StringBuffer BankName=new StringBuffer();
	    
	    
	    BankName.append(" select count(*) from hclhrm_prod.tbl_businessunit_payroll_process where payperiod="+ProcessedBy+" and businessunitid in ("+BU+") ");
	   	    
	   // emp_lop.append(" select employeeid,lopcount from hclhrm_prod.tbl_employee_lop where LOPTRANSACTIONID="+ProcessedBy+" and BUSINESSUNITID in("+BU+") and employeeid!=0 ");
	   
	    emp_lop.append(" select a.employeesequenceno,b.employeeid, ifnull(b.PFNO,0) EPFNO,ifnull(b.PFUAN,0) EPFUAN ,ifnull(b.ESINO,0) EESINO ");
	    emp_lop.append(" from hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL b,hclhrm_prod.tbl_employee_primary a ");
	    emp_lop.append(" where a.employeeid=b.employeeid and a.status=1001 and a.companyid="+BU+"   ");
	    
	    if(QueryMode.equalsIgnoreCase("Y")){
	    	
	    	 emp_lop.append(" and  b.employeeid in("+EMPLIST_UPDATE+")   ");
	    }
	    
	    
	    Over_All_Emp_Count.append(" select employeesequenceno,employeeid  from hclhrm_prod.tbl_employee_primary where status=1001 and companyid in("+BU+")");
	    
	    Active_emp_list.append(" select ep.employeesequenceno seqno,ep.employeeid,ep.callname,epf.DATEOFJOIN   from ");
	    Active_emp_list.append(" hclhrm_prod.tbl_employee_primary ep,hclhrm_prod.tbl_employee_profile epf ");
	    Active_emp_list.append(" where epf.employeeid=ep.employeeid and ep.status=1001 ");
	    Active_emp_list.append(" and ep.employeesequenceno not in(1) and ep.companyid in("+BU+") ");
	    
	    if(QueryMode.equalsIgnoreCase("Y")){
	    	
	    	Active_emp_list.append(" and  ep.employeeid in("+EMPLIST_UPDATE+")   ");
	    }
	    
	    Active_emp_list.append(" order by epf.DATEOFJOIN desc ");
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(BankName.toString(), "BankName", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			while(Res.next()){
				
				payroll=Res.getInt(1);
				
			}
		
		payroll=0;
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
				
				
				
				Emp_Data.put(Res.getString("employeesequenceno")+"_BANKID", "0"); // From LOP Master
				Emp_Data.put(Res.getString("employeesequenceno")+"_BANKACC", "0");   // FROM iconnect Data
				//Emp_Data.put(Res.getString("employeesequenceno")+"_P", "0");   // FROM iconnect Data
				//Emp_Data.put(Res.getString("employeesequenceno")+"_R", "0");   // FROM iconnect Data
				
				Emp_Data.put(Res.getString("employeeid")+"_BANKID", "0"); // From LOP Master
				Emp_Data.put(Res.getString("employeeid")+"_BANKACC", "0");   // FROM iconnect Data
				
				
				Emp_Data.put(Res.getString("employeeid")+"_ESINO", "0");   // FROM iconnect Data
				Emp_Data.put(Res.getString("employeesequenceno")+"_ESINO", "0");   // FROM iconnect Data
				
				//Emp_Data.put(Res.getString("employeeid")+"_LOP", "0"); // From LOP Master
				//Emp_Data.put(Res.getString("employeeid")+"_A", "0");   // FROM iconnect Data
				//Emp_Data.put(Res.getString("employeeid")+"_P", "0");   // FROM iconnect Data
				//Emp_Data.put(Res.getString("employeeid")+"_R", "0");   // FROM iconnect Data
				
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
			while(Res.next()){
				
				Emp_Data.put(Res.getString("employeeid")+"_BANKID", Res.getString("EPFNO")); // From LOP Master
				Emp_Data.put(Res.getString("employeeid")+"_BANKACC", Res.getString("EPFUAN")); // From LOP Master
				Emp_Data.put(Res.getString("employeeid")+"_ESINO", Res.getString("EESINO")); // From LOP Master
				
			}
			
	    }catch(Exception er2){
	    	
	    	System.out.println("Exception er2::" +er2);
	    }
	    
	    Res=null;
	    try {
			Res=(ResultSet)DataObj.FetchData(Active_emp_list.toString(), "employeelit", Res ,conn);
			// rsmd =(ResultSetMetaData)Res.getMetaData();
			// String name = rsmd.getColumnName(1);
			//int columnCount = rsmd.getColumnCount();
			while(Res.next()){
				
				
				 jason = new JSONObject();
				  jason.put("CALLNAME", Res.getString("callname"));
				  jason.put("DATEOFJOIN", Res.getString("DATEOFJOIN"));
				  jason.put("SEQNO", Res.getString("seqno"));
				  jason.put("EMPID", Res.getString("employeeid"));
				  jason.put("BANKID", Emp_Data.get(Res.getString("employeeid")+"_BANKID"));
				  jason.put("BANKACC", Emp_Data.get(Res.getString("employeeid")+"_BANKACC"));
				  
				  jason.put("ESINO", Emp_Data.get(Res.getString("employeeid")+"_ESINO"));
				  
				  jason.put("BANKCK_"+Emp_Data.get(Res.getString("employeeid")+"_BANKID") , "Selected");
				 
				  /*if(Emp_Data.get(Res.getString("employeeid")+"_BANKACC").toString().equalsIgnoreCase("0")){
					 
					  jason.put("CHECKBOX" , "checked");
					  
				  }*/
				 
				  values.add(jason);
				  
				/*if(QueryMode.equalsIgnoreCase("Y")){
					
					if(!((String) Emp_Data.get(Res.getString("employeeid")+"_LOP")).equalsIgnoreCase("0")){
					  jason = new JSONObject();
					  jason.put("CALLNAME", Res.getString("callname"));
					  jason.put("DATEOFJOIN", Res.getString("DATEOFJOIN"));
					  jason.put("SEQNO", Res.getString("seqno"));
					  jason.put("EMPID", Res.getString("employeeid"));
					  jason.put("BANKID", Emp_Data.get(Res.getString("employeeid")+"_BANKID"));
					  jason.put("_BANKACC", Emp_Data.get(Res.getString("employeeid")+"_BANKACC"));
					  values.add(jason);
					}
			    	
			    }else{
			    	jason = new JSONObject();
					jason.put("CALLNAME", Res.getString("callname"));
					jason.put("DATEOFJOIN", Res.getString("DATEOFJOIN"));
					jason.put("SEQNO", Res.getString("seqno"));
					jason.put("EMPID", Res.getString("employeeid"));
					jason.put("LOP", Emp_Data.get(Res.getString("employeeid")+"_LOP"));
					values.add(jason);
			    	
			    }
				*/
				
			}
			
	    }catch(Exception er){
	    	
	    	System.out.println("Exception(LAST)::" +er);
	    }
	    System.out.println("LOPLIST" +values.toString());
	    request.setAttribute("LOPLIST",values.toString());
	    
	   
	  //**************************************************************************** 
	    System.out.println("RoutingPage[LOP_Servicess]::"+RoutingPage);
	    request.getRequestDispatcher("Professional_updation.jsp").forward(request, response);
	}

}
