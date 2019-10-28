package com.hr.letters;

import com.google.gson.Gson;
import com.hclhrm.util.Util;
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

@SuppressWarnings("serial")
public class DisplayDropdown extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String Condition = request.getParameter("condition");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String UserID = null;
		try
		{
			UserID = (String)session.getAttribute("LOGINBY");
		} catch (Exception er) {
			System.out.println("Error at Get Values" + er);
		}
		PreparedStatement pstmt = null;
		Connection con = null;
		ArrayList<String> al = new ArrayList<String>();
		try
		{
			con = Util.getConnection();
		} catch (Exception Er) {
			Er.printStackTrace();
		}
		if (con != null) {
			if (Condition.equalsIgnoreCase("Dropdown")) {
				try {
					StringBuffer qry = new StringBuffer();
					qry.append("SELECT B.NAME,B.BUSINESSUNITID BUNAME FROM");
					qry.append(" HCLHRM_PROD.TBL_EMPLOYEE_BUSINESSUNIT A");
					qry.append(" JOIN HCLADM_PROD.TBL_BUSINESSUNIT B ON A.BUSINESSUNITID=B.BUSINESSUNITID");
					qry.append(" WHERE");
					qry.append(" B.STATUS=1001 AND B.PARENTBUSINESSUNITID!=0 AND A.EMPLOYEEID IN");
					qry.append("(");
					qry.append(UserID);
					qry.append(")");

					pstmt = con.prepareStatement(qry.toString());
					ResultSet rs = pstmt.executeQuery();
					al.add("--Select One--#Select");
					while (rs.next()) {
						al.add(rs.getString(1) + "#" + rs.getString(2));
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			Gson gson = new Gson();
			String messages = gson.toJson(al);
			out.println(messages);
		}
		else {
			out.write("Unable to Connect Server  Please Try again/contact sys admin..!");
		}
	}
}
