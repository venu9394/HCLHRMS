package com.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.hclhrm.util.Util;

/**
 * Servlet implementation class EmployeeDetails
 */
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		JSONArray jsonArray=new JSONArray();
		String ColumNames=request.getParameter("Colums");
		String BussinessUnit=request.getParameter("Bussinessunit");
		
		 PrintWriter out=response.getWriter();
		 
		System.out.println(ColumNames);
		System.out.println(BussinessUnit);
		
		ArrayList<String> al=new ArrayList<String>();
		Connection con=null;
		PreparedStatement pstmt=null;
	
	StringBuffer bf=new StringBuffer();
	ResultSet rs=null;
	
	con=Util.getConnection();
	
	try {
		ResultSetMetaData metadata = rs.getMetaData();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try{
		
		bf.append("SELECT "+ColumNames+" FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A ");
		bf.append("LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT B ON A.COMPANYID=B.BUSINESSUNITID WHERE A.COMPANYID IN ("+BussinessUnit+")");
	
		pstmt=con.prepareStatement(bf.toString());
		
		System.out.println(pstmt);
		rs=pstmt.executeQuery();
		 String row = "";
		while(rs.next())
		{
			
			
			
			//System.out.println(rs.getString(1)+""+rs.getString(2));
             JSONObject obj=new JSONObject();
			 
             for(int i=0;i<ColumNames.split(",").length;i++)
             {
            	  row += rs.getString(i) + ", ";  
            	 obj.put("EmployeeName", rs.getString(""+ColumNames.split(",")[i])+"");
             }
           
			
			  
			 
			 jsonArray.add(obj);
			 
			 
		}
		
		
		  Gson gson = new Gson();
			String messages = gson.toJson(jsonArray);
			out.println(messages);
		System.out.println(messages);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	}

}
