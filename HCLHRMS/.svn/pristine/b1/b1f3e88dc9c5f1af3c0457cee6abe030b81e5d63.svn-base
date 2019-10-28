package com.hr.letters.source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hclhrm.util.Util;


/**
 * Servlet implementation class DisplayName
 */
public class DisplayName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");

		PrintWriter pw=response.getWriter();
		Connection con=null;
		PreparedStatement pstmt=null;
		String employeeid=request.getParameter("employeeid");
		String bu=request.getParameter("AllDivisions");
		String lettertype=request.getParameter("lettertype");
		String division=request.getParameter("division");
		String name="0";
		int flag=0,flag1=0,flag2=0;
		System.out.println(bu+"::"+employeeid+"::"+lettertype+"::"+division);
		con=Util.getConnection();
		String q=null;
		ResultSet rs=null;
		String probationperiod=null;
		/*
		 * flag =0 Employeeid not exist
		 * flag =102 Sql Exception
		 * flag =1 Employeeid EXIST
		 * flag =2 Employeeid NOT Belongs to BU
		 * flag =103 connection not established
		 */
		if(con!=null){
			try{
				q="SELECT count(*) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE"
				  +" trim(EMPLOYEESEQUENCENO)=trim("+employeeid+") limit 1";
				System.out.println("TEST--->"+q);
				pstmt=con.prepareStatement(q);
				rs=pstmt.executeQuery();
				if(rs.next()){
					flag=rs.getInt(1);
				}		

			}catch(Exception e){
				flag =102;
				e.printStackTrace();
			}
			rs=null;
			try{
				
				
					
				if(flag==1){
					if(lettertype.equalsIgnoreCase("AppointmentLetter")){
					/*q="SELECT CALLNAME,count(*) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE trim(EMPLOYEESEQUENCENO)=trim("+employeeid+")"
					  +" AND COMPANYID IN ("+bu+") limit 1";*/

					q="SELECT CALLNAME,count(*),count(b.employeeid),IFNULL(b.probation,'0') employeeid FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY a "
							+ "left join test.appointmentletter b on a.employeesequenceno=b.employeeid WHERE trim(EMPLOYEESEQUENCENO)=trim("+employeeid+") "
							+ "AND COMPANYID IN ("+bu+") limit 1";
				}else if(!division.equalsIgnoreCase("Select")){
					
					q="SELECT CALLNAME,count(*),count(b.employeeid),IFNULL(b.probation,'0') employeeid FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY a "
							+ "left join test.appointmentletter b on a.employeesequenceno=b.employeeid WHERE trim(EMPLOYEESEQUENCENO)=trim("+employeeid+") "
							+ "AND COMPANYID IN ("+division+") limit 1";
				}else{
					
					q="SELECT CALLNAME,count(*),count(b.employeeid),IFNULL(b.probation,'0') employeeid FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY a "
							+ "left join test.appointmentletter b on a.employeesequenceno=b.employeeid WHERE trim(EMPLOYEESEQUENCENO)=trim("+employeeid+") "
							+ "AND COMPANYID IN ("+bu+") limit 1";
					
				}
					System.out.println("test2"+q);
					pstmt=con.prepareStatement(q);
					rs=pstmt.executeQuery();
					if(rs.next()){
						flag2=rs.getInt(3);
						flag1=rs.getInt(2);
						name=rs.getString(1);
						probationperiod = rs.getString(4);
					}
				}
			}catch(Exception e){
				flag =102;
				e.printStackTrace();
			}
		}else{ // Connection verification
			flag=102;
			flag1=102;
		}
		if(flag==0){
			pw.write("0~EmployeeID Not Exists"); // Employee id not Exist
		}else if(flag1==0 && flag==1 && flag2==0){
			pw.write("2~EmployeeID Not Belongs to this BU"); //Employeeid NOT Belongs to BU
		}else if(flag1==1 && flag==1 && flag2==1){
			pw.write("100~"+name+"~"+lettertype+"~"+probationperiod); //Employeeid Exists in this table test_mum.appointmentletter 
		}else if(flag1==1 && flag==1 && flag2==0){
			pw.write("101~"+name+"~"+lettertype+"~"+probationperiod); //Employeeid Exists
		}else if(flag1==102 && flag==102){
			pw.write("103~Server couldn't be connected. Please Contact Admin!.."); //connection not established
		}else{
			pw.write("102~Invalid Data."); // Sql Error;
		}
	}
}

