package com.lwp.arrear;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hclhrm.util.Util;

/**
 * Servlet implementation class Lwp_emp_fetching
 */
public class Lwp_emp_fetching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lwp_emp_fetching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi This is Lwp Arrear Caliculation Part Start...!");
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "Post-Check=0");
		response.addHeader("Cache-Control", "Pre-Check=0");
		response.addHeader("Expires", "Mon, 1 Jan 2006 05:00:00 GMT");
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet Res=null;
		conn = Util.getConnection();
		com.hhclhrm.globaldb.GetDbData DataObj=new com.hhclhrm.globaldb.GetDbData();
		HttpSession session=request.getSession();
		StringBuffer GetBuIds=new StringBuffer();
		StringBuffer GetBuIds_Result=new StringBuffer();
		StringBuffer TxnDate=new StringBuffer();
		StringBuffer GetEmployeeData=new StringBuffer();
		StringBuffer GetLopData_emp=new StringBuffer();
		StringBuffer Lop_Data=new StringBuffer();
		
		ArrayList GetBuIds_list=new ArrayList();
		ArrayList GetLopData_emp_list=new ArrayList();
		
		ArrayList Final_emp_list=new ArrayList();
		String lwp_arrear_status="FALSE";
		int Record_cnt=0;
		
		
		  Map Global=new HashMap();
		  String RoutingPage=(String)request.getAttribute("Routing");
		  String BU=(String)request.getAttribute("BU");
		  String ProcessedBy=(String)request.getParameter("PayPeriod");
		  //Pby
		  String LOGINBY=(String)session.getAttribute("LOGINBY");
		  
		  String PayPeriod=ProcessedBy;
		  String CurrPayPeriod="00008";
		  
		  System.out.println(LOGINBY +"~!!!!!~"+ProcessedBy);
		  
		  GetBuIds.append(" SELECT b.employeesequenceno,a.EMPLOYEEID, a.BUSINESSUNITID ");
		  GetBuIds.append(" FROM hclhrm_prod.tbl_employee_businessunit a  ");
		  GetBuIds.append(" left join hclhrm_prod.tbl_employee_primary b on a.employeeid=b.employeeid where b.employeeid="+LOGINBY+ " and a.BUSINESSUNITID!=0" );
    	 
		  Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData(GetBuIds.toString(), "GetBuIds", Res ,conn);
				while(Res.next()){
					GetBuIds_Result.append(Res.getString(3));
					GetBuIds_Result.append(",");
					GetBuIds_list.add(Res.getString(3));
				}
				GetBuIds_Result.append("100");
				
		    }catch(SQLException exp){
		    	System.out.println("SQL ERROR AT 1:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT 1:"+exp);
		    }
		    TxnDate.append(" select businessunitid,FROMDATE,TODATE from hcladm_prod.tbl_transaction_dates where ");
			TxnDate.append(" transactiontypeid=1 and transactionduration="+PayPeriod+" ");
			TxnDate.append(" and businessunitid in("+GetBuIds_Result.toString()+") ");
			System.out.println(TxnDate.toString()+":TxnDate");
			Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData(TxnDate.toString(), "TxnDate", Res ,conn);
				while(Res.next()){
					Global.put(Res.getString(1)+"_FD", Res.getString(2));
					Global.put(Res.getString(1)+"_TD", Res.getString(3));
				}
		    }catch(SQLException exp){
		    	System.out.println("SQL ERROR AT 2:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT 2:"+exp);
		    }
		    
		    
		    Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData("Select count(*) from  hclhrm_prod_others.tbl_emp_lwp_arrear_payperiod where payment="+PayPeriod+" and  BUSINESSUNITID in("+GetBuIds_Result.toString()+") ", "INSERT_STATUS", Res ,conn);
				if(Res.next()){
					 Record_cnt=Res.getInt(1);
					
				}
		    }catch(SQLException exp){
		    	System.out.println(Record_cnt+"SQL ERROR AT Record_cnt:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT Record_cnt:"+exp);
		    }
		    
		    
		    Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData("select max(payperiod)+1 from hclhrm_prod.tbl_employee_pay_data where status=1001 and businessunitid in("+GetBuIds_Result.toString()+");", "GET MAIN PAY PERIOD", Res ,conn);
				if(Res.next()){
					CurrPayPeriod=Res.getString(1);
					
				}
		    }catch(SQLException exp){
		    	System.out.println(Record_cnt+"SQL ERROR AT Record_cnt:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT Record_cnt:"+exp);
		    }
		    
		    
		    
		    System.out.println("Global:::1"+Global.toString());
		    ListIterator Iterator_bu = GetBuIds_list.listIterator();
		    while(Iterator_bu.hasNext()){
		    // While Start
		    	String BuID=Iterator_bu.next().toString();
		    	
		    	if(!BuID.equalsIgnoreCase("100")){  // IF Start for 100 Bu Elimination
		    	GetEmployeeData=new StringBuffer();
				GetEmployeeData.append(" select a.employeeid ,d.callname,a.employeesequenceno ,b.dateofjoin,a.businessunitid ");
				GetEmployeeData.append(",DATEDIFF('"+Global.get(BuID+"_TD")+"','"+Global.get(BuID+"_FD")+"')+1 actualdays,DATEDIFF('"+Global.get(BuID+"_TD")+"' , b.dateofjoin)+1 Eligibledays ");
				GetEmployeeData.append(",ifnull(c.lopcount,0) lopcount ");
				GetEmployeeData.append("from hclhrm_prod.tbl_employee_payperiod_details a ");
				GetEmployeeData.append(" left join hclhrm_prod.tbl_employee_profile b on ");
				GetEmployeeData.append(" b.employeeid=a.employeeid ");
				GetEmployeeData.append(" left join hclhrm_prod.tbl_employee_lop c on c.employeeid=b.employeeid ");
				GetEmployeeData.append(" left join hclhrm_prod.tbl_employee_primary d on d.employeeid=b.employeeid ");
				GetEmployeeData.append(" where b.dateofjoin between ");
				GetEmployeeData.append(" '"+Global.get(BuID+"_FD")+"' and '"+Global.get(BuID+"_TD")+"' and a.payperiod="+PayPeriod+" and ");
				GetEmployeeData.append(" a.businessunitid in("+BuID+") ");
				GetEmployeeData.append(" and d.status=1001 ");
		    	System.out.println(GetEmployeeData.toString()+"::Main Query");
		    	Res=null;
			    try {
					Res=(ResultSet)DataObj.FetchData(GetEmployeeData.toString(), "GetEmployeeData", Res ,conn);
					while(Res.next()){
						Global.put(Res.getString(1)+"_EMPID", Res.getString("employeesequenceno"));
						Global.put(Res.getString(1)+"_EMPNAME", Res.getString("callname"));
						Global.put(Res.getString(1)+"_EMPDOJ", Res.getString("dateofjoin"));
						Global.put(Res.getString(1)+"_EMPACTDAYS", Res.getString("actualdays"));
						Global.put(Res.getString(1)+"_EMPELIGIBLEDAYS", Res.getString("Eligibledays"));
						Global.put(Res.getString(1)+"_EMPLOP", Res.getString("lopcount"));
						
						Global.put(Res.getString(1)+"_EMPSEQ", Res.getString("employeesequenceno"));
						
						Global.put(Res.getString(1)+"_BDAYS","0");
						Global.put(Res.getString(1)+"_PDAYS","0");
						
						Global.put(Res.getString(1)+"_DIFFDAYS","0");
						
						GetLopData_emp.append(Res.getString(1)+",");
						GetLopData_emp_list.add(Res.getString(1));
					}
					
			    }catch(SQLException exp){
			    	System.out.println("SQL ERROR AT 3:"+exp);
			    }catch(Exception exp){
			    	System.out.println("ERROR AT 3:"+exp);
			    } 
		   // while end 	
		  
		    GetLopData_emp.append("0");
		    	  } // Main If Close
		 }
		    Lop_Data.append(" select employeeid,basedays,payabledays from hclhrm_prod.tbl_employee_pay_data where status=1001 ");
		    Lop_Data.append(" and payperiod="+PayPeriod+" and componentid=22 and employeeid in("+GetLopData_emp.toString()+") ");
		    
		    Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData(Lop_Data.toString(), "Lop_Data", Res ,conn);
				while(Res.next()){
					// Geting Data From Pay Data for compare actual paid are ..!
					Global.put(Res.getString(1)+"_BDAYS",Res.getString("basedays"));
					Global.put(Res.getString(1)+"_PDAYS",Res.getString("payabledays"));
					try{
						double pay_Days=Double.parseDouble(Res.getString("payabledays").toString());
						double lop_count=Double.parseDouble(Global.get(Res.getString(1)+"_EMPLOP").toString());
						double emp_eligibleDays=Double.parseDouble(Global.get(Res.getString(1)+"_EMPELIGIBLEDAYS").toString());
						double total_acc=pay_Days+lop_count;
						double lop_diff=emp_eligibleDays-total_acc;
						
						if(lop_diff>0 || 0<lop_diff){
							
							Final_emp_list.add(Res.getString(1));
							lwp_arrear_status="TRUE";
						}
						
						Global.put(Res.getString(1)+"_DIFFDAYS",lop_diff);
						// Pending Data  //_EMPELIGIBLEDAYS
						
					}catch(Exception Expr){
						System.out.println("Exception at Paydata::" +Expr);
					}
					
				}
				
				
		    }catch(SQLException exp){
		    	System.out.println("SQL ERROR AT 4:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT 4:"+exp);
		    }    
		    
		    
		    
		session.setAttribute("MAIN_DATA",Global);
		session.setAttribute("MAIN_EMP_BUFFER",GetLopData_emp);
		session.setAttribute("MAIN_EMP_LIST",GetLopData_emp_list);
		
		session.setAttribute("FINAL_EMP_LIST",Final_emp_list);
		
		request.setAttribute("MAIN_DATA",Global);
		request.setAttribute("MAIN_EMP_BUFFER",GetLopData_emp);
		request.setAttribute("MAIN_EMP_LIST",GetLopData_emp_list);
		
		request.setAttribute("FINAL_EMP_LIST",Final_emp_list);
		
		System.out.println("Global::"+Global.toString());    
		System.out.println("GetBuIds_Result::"+GetBuIds_Result.toString());    
		System.out.println("Hi This is Lwp Arrear Caliculation Part Start...!");
		session.setAttribute("PayPeriod", PayPeriod);
		session.setAttribute("CurrPayPeriod", CurrPayPeriod);
		
		session.setAttribute("ALLBUS", GetBuIds_Result);
		session.setAttribute("LOGINBY", LOGINBY);
		
		request.setAttribute("lwp_arrear_status",lwp_arrear_status);
		request.setAttribute("Record_cnt",Record_cnt);
		
		request.getRequestDispatcher("lwp_arrear.jsp").forward(request, response);
	}

}
