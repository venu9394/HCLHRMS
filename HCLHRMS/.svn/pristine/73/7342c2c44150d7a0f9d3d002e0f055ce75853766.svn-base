package com.lwp.arrear;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hclhrm.util.Util;

/**
 * Servlet implementation class Arrear_lwp_caliculation
 */
public class Arrear_lwp_caliculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Arrear_lwp_caliculation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "Post-Check=0");
		response.addHeader("Cache-Control", "Pre-Check=0");
		response.addHeader("Expires", "Mon, 1 Jan 2006 05:00:00 GMT");
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet Res=null;
		conn = Util.getConnection();
		com.hhclhrm.globaldb.GetDbData DataObj=new com.hhclhrm.globaldb.GetDbData();
		conn = Util.getConnection();
		int[] str;
		boolean callSelect=false;
		String Filename=null;
		Set  linkedHashSet_title = new LinkedHashSet();
		Set  linkedHashSet_employee = new LinkedHashSet();
		Map  FetchData_Map = new HashMap();
		System.out.println("we are at Arrear_lwp_caliculation ");
		ArrayList Selected_List=new ArrayList();
		StringBuffer Selected_List_buf=new StringBuffer();
		Map Emp_map=new HashMap();
		String message=null;
		HttpSession session=request.getSession();
		 String PayPeriod=(String) session.getAttribute("PayPeriod");
		 String CurrPayPeriod=(String) session.getAttribute("CurrPayPeriod");
		 StringBuffer ALLBUS=(StringBuffer) session.getAttribute("ALLBUS") ;
		 String LOGINBY=(String)session.getAttribute("LOGINBY");
		 
		 
		  if(LOGINBY==null ||PayPeriod==null || CurrPayPeriod==null){
			  message="Your session Expire,Please Relogin..!";
			  session.invalidate();
		  }
		  
		String Routing=request.getParameter("ROUTING");
	
		System.out.println("Routing::"+Routing);
		
		if(Routing==null){
			
		
		String[] Data_Acc=(String[])request.getParameterValues("checkboxlwp");
		int EmployeeSelectedSize=Data_Acc.length;
        System.out.println("Data Length "+EmployeeSelectedSize);
		
       if(EmployeeSelectedSize!=0){
		for(int i=0 ;i<Data_Acc.length;i++){
			System.out.println("Data :"+Data_Acc[i]);
			String Data[]=Data_Acc[i].split("~");
			Selected_List.add(Data[0]);
			Emp_map.put(Data[0]+"_LOP", Data[2]);
			Emp_map.put(Data[0]+"_SEQ", Data[1]);
			Selected_List_buf.append(Data[0]+",");
			
		    }
		  Selected_List_buf.append("00000");
       }
		 
       ListIterator  Empselect=Selected_List.listIterator();
       
       try{
    	   conn.setAutoCommit(false);//commit trasaction manually

    	   String insertTableSQL ="insert into hclhrm_prod_others.tbl_emp_lwp_arrear_payperiod(EMPLOYEEID,BUSINESSUNITID,PAYMENT,PAYPERIOD,PAYSTRUCTUREID,GROSSVALUE,BASEDAYS,PAYABLEDAYS,NOOFDAYS,COMPONENTID,ARREAR)"
    			   +" SELECT EMPLOYEEID,BUSINESSUNITID,"+PayPeriod+" PAYMENT,"+CurrPayPeriod+" PAYPERIOD,PAYSTRUCTUREID,GROSSVALUE,BASEDAYS,PAYABLEDAYS,? NOD,COMPONENTID,"
    			   +" ROUND(GROSSVALUE/BASEDAYS)*? ARREAR "
    			   +" FROM "
    			   +" HCLHRM_PROD.TBL_EMPLOYEE_PAY_DATA t WHERE EMPLOYEEID=? AND PAYPERIOD="+PayPeriod+" AND STATUS=1001 "
    			   +" AND COMPONENTTYPEID IN (1,2) "
    			   +" ON DUPLICATE KEY UPDATE NOOFDAYS=?,ARREAR=ROUND(t.GROSSVALUE/t.BASEDAYS)*? " ;
    	           pstmt = conn.prepareStatement(insertTableSQL);
    	
       
       while(Empselect.hasNext()){
       String EMPID=Empselect.next().toString();
       
          pstmt.setDouble(1, Double.parseDouble(Emp_map.get(EMPID+"_LOP").toString()));
          pstmt.setDouble(2, Double.parseDouble(Emp_map.get(EMPID+"_LOP").toString()));
          pstmt.setInt(3,    Integer.parseInt(EMPID));       
          pstmt.setDouble(4, Double.parseDouble(Emp_map.get(EMPID+"_LOP").toString()));
          pstmt.setDouble(5, Double.parseDouble(Emp_map.get(EMPID+"_LOP").toString()));
          pstmt.addBatch();
          
       }
         str=pstmt.executeBatch();
         System.out.println("Get Data::"+ str.toString());
         if(str.length>=1){
        	 conn.commit(); 
        	 callSelect=true;
        	 message="Request Submited Successfully!";
         }
       
       }catch(SQLException Sql){
    	   System.out.println("SQL Exception at INSERT ::"+Sql);
    	   message=Sql.toString();
       }catch(Exception ERD){
    	   System.out.println("OTHER Exception at INSERT ::"+ERD);
    	   message=ERD.toString();
       }
     // Calling For Data
	}
       if(callSelect || Routing.equals("REPORT")){
    	   
    	   StringBuffer Fetch_Record=new StringBuffer();
		   Fetch_Record.append(" select b.employeesequenceno,b.employeeid,b.callname,d.name buname,c.name componentname,a.noofdays,a.arrear,a.componentid,a.payment from hclhrm_prod_others.tbl_emp_lwp_arrear_payperiod a ");
		   Fetch_Record.append(" left join hclhrm_prod.tbl_employee_primary b on b.employeeid=a.employeeid ");
		   Fetch_Record.append(" left join hcladm_prod.tbl_pay_component c on c.paycomponentid=a.componentid ");
		   Fetch_Record.append(" left join hcladm_prod.tbl_businessunit d on d.businessunitid=b.companyid ");
		   Fetch_Record.append(" where a.payment="+PayPeriod+" and b.companyid in("+ALLBUS.toString()+") ");
		   Fetch_Record.append(" and a.componentid!=30 order by b.employeeid,c.indexno ");
    	   
    	   
    	   Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData(Fetch_Record.toString(), "Fetch_Record", Res ,conn);
				
				while(Res.next()){
					linkedHashSet_title.add(Res.getString("componentid"));
					linkedHashSet_employee.add(Res.getString("employeesequenceno"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_ID",Res.getString("employeesequenceno"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_NAME",Res.getString("callname"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_BU",Res.getString("buname"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_"+Res.getString("componentid"),Res.getString("arrear"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_NOD",Res.getString("noofdays"));
					FetchData_Map.put(Res.getString("employeesequenceno")+"_PD",Res.getString("payment"));
					FetchData_Map.put(Res.getString("componentid").toString(),Res.getString("componentname"));
					
				}
				
				
		    }catch(SQLException exp){
		    	System.out.println("SQL ERROR AT 1:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT 1:"+exp);
		    }
		    try{
    	    Filename=Report_lwp.Report_lwp_Gen(linkedHashSet_title,linkedHashSet_employee,FetchData_Map, LOGINBY);
		    }catch(Exception er){
		    	System.out.println("File Generation Exception ::" +er);
		    }
		    
       }else{
    	   message="Request not processed,please Relogin and try again..!";
       }
       session.setAttribute("linkedHashSet_title", linkedHashSet_title);
       session.setAttribute("linkedHashSet_employee", linkedHashSet_employee);
       session.setAttribute("FetchData_Map", FetchData_Map);
       System.out.println("linkedHashSet::"+linkedHashSet_title.toString());
       request.getRequestDispatcher("lwp_arrear_download.jsp").forward(request, response);	  
	}// Close Do post

}
