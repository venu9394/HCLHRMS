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
public class Arrear_load_options extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Arrear_load_options() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi This is Lwp Arrear get options...!");
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
		System.out.println("Hi This is Lwp Arrear get options...!");
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
		HttpSession session=request.getSession();
		StringBuffer GetBuIds=new StringBuffer();
		StringBuffer GetBuIds_Result=new StringBuffer();
		StringBuffer TxnDate=new StringBuffer();
		StringBuffer GetEmployeeData=new StringBuffer();
		StringBuffer GetLopData_emp=new StringBuffer();
		StringBuffer Lop_Data=new StringBuffer();
		String CurrPayPeriod=null;
		
		ArrayList GetBuIds_list=new ArrayList();
		
		ArrayList Payperiod_list=new ArrayList();
		
		ArrayList GetLopData_emp_list=new ArrayList();
		
		ArrayList Final_emp_list=new ArrayList();
		String lwp_arrear_status="FALSE";
		int Record_cnt=0;
		
		
		  Map Global=new HashMap();
		  String RoutingPage=(String)request.getAttribute("Routing");
		  String BU=(String)request.getAttribute("BU");
		  String ProcessedBy=(String)request.getAttribute("Pby");
		  String LOGINBY=(String)request.getParameter("LOGINBY");
		  
		  request.setAttribute("BU", BU);
		  request.setAttribute("Pby", ProcessedBy);
		  session.setAttribute("LOGINBY", LOGINBY);
		  
		
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
		   
		    
		   
		    
		    
		    Res=null;
		    try {
				Res=(ResultSet)DataObj.FetchData("select distinct payperiod from hclhrm_prod.tbl_employee_pay_data where status=1001 and businessunitid in("+GetBuIds_Result.toString()+")  order by payperiod desc  limit 12;", "GET MAIN PAY PERIOD", Res ,conn);
				while(Res.next()){
					
					Payperiod_list.add(Res.getString(1));
					//CurrPayPeriod=Res.getString(1);
					
				}
		    }catch(SQLException exp){
		    	System.out.println(Record_cnt+"SQL ERROR AT Record_cnt:"+exp);
		    }catch(Exception exp){
		    	System.out.println("ERROR AT Record_cnt:"+exp);
		    }
		    
		    
		    
		  
		
				
		    
		    System.out.println("Payperiod_list :: "+Payperiod_list);
		    request.setAttribute("Payperiod_list",Payperiod_list);
		    session.setAttribute("Payperiod_list",Payperiod_list);
		
		request.getRequestDispatcher("lwp_arrear_load.jsp").forward(request, response);
	}

}
