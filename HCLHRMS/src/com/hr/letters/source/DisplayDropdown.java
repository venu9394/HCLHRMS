package com.hr.letters.source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hclhrm.util.Util;



public class DisplayDropdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Condition=request.getParameter("condition");
	System.out.println("Condition-->"+Condition);
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
	//	String UserID=(String) session.getAttribute("UserID");
		
		
		//String Businessunitid= (String)session.getAttribute("BU");
		String UserID=null;
				
				try{
					UserID=(String)session.getAttribute("LOGINBY");
				}catch(Exception er){
					System.out.println("Error at Get Values"+er);
				}
		  
		//String UserID="10505";
        System.out.println("::UserID--->::" +UserID);
		//JSONArray JassonGlobal_Array = new JSONArray();
		//JSONArray Divisions=new JSONArray();
		PreparedStatement pstmt = null;
		 
		Connection con=null;
		//QueryBuilder QB=new QueryBuilder();
		ArrayList<String> al = new ArrayList<String>();

		try{
			con=Util.getConnection();
		}catch(Exception Er){
			Er.printStackTrace();
		}

		if(con!=null){
			if(Condition.equalsIgnoreCase("Dropdown")){
				try{
					StringBuffer qry = new StringBuffer();
					qry.append("SELECT B.NAME,B.BUSINESSUNITID BUNAME FROM");
					qry.append(" HCLHRM_PROD.TBL_EMPLOYEE_BUSINESSUNIT A");
					qry.append(" JOIN HCLADM_PROD.TBL_BUSINESSUNIT B ON A.BUSINESSUNITID=B.BUSINESSUNITID");
					qry.append(" WHERE");
					qry.append(" B.STATUS=1001 AND B.PARENTBUSINESSUNITID!=0 AND A.EMPLOYEEID IN");
					qry.append("(");
					qry.append(UserID);
					qry.append(")");
					//qry.append(" (SELECT EMPLOYEEID FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO IN ("+UserID+") ORDER BY B.BUSINESSUNITID)");
					
					System.out.println(qry.toString());
							pstmt=con.prepareStatement(qry.toString());
							ResultSet rs=pstmt.executeQuery();
							al.add("--Select One--#Select");
							while(rs.next()){
								al.add(rs.getString(1)+"#"+rs.getString(2))	;
							}
				 
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		 
			Gson gson = new Gson();
			String messages = gson.toJson(al);
			out.println(messages);
			//out.write(al.toString());
		}else{  
			out.write("Unable to Connect Server  Please Try again/contact sys admin..!");
		} 
	}
}