package com.hclhrm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.hclhrm.util.Util;
import com.mysql.jdbc.ResultSetMetaData;

public class Fectch_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Fectch_Data() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String type = request.getParameter("type");

		JSONArray values;
		values = new JSONArray();
		JSONObject jason = new JSONObject();
		
		JSONObject Thread = new JSONObject();
		
		
		   HttpSession session=request.getSession();
		// System.out.println(type);
		String EmployeeCode = request.getParameter("EmployeeCode");
		String BUSINESSUNITID = request.getParameter("BUSINESSUNITID");
		
		
		String BU=(String) session.getAttribute("BU");
		
		System.out.println(type+ "-->1111111111<---"+BU);
		
		//*********below two added by venu
		//String Report=request.getParameter("routing");
		String PayPeriod=request.getParameter("PayPeriod");

		// String title=request.getParameter("title");
		//String division = request.getParameter("division");

		ArrayList<String> al = new ArrayList<String>();
		ResultSet rs = null;
		Connection con = null;
		// Connection con1 = null;
		PreparedStatement pstmt = null;

		//con = Util.LIVEConnection();
		
		
		
		/*try {
			//conn =dataSource.getConnection();
			con=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}*/
		
		 con=Util.getConnection();

		try {
			
			//******************this is add by venu for payperiod*****************************
			
			if (type.equalsIgnoreCase("Reports")) {
				String r = "SELECT distinct A.BUSINESSUNITID,A.NAME FROM HCLADM_PROD.TBL_BUSINESSUNIT A,HCLHRM_PROD.tbl_employee_pay_data B "
                           +"where A.BUSINESSUNITID=B.BUSINESSUNITID and B.payperiod="+PayPeriod+" order by A.BUSINESSUNITID";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();
			//	al.add("Select#--Select One--");
				while (rs.next()) {
					jason = new JSONObject();
					jason.put("BUID",rs.getString(1));
					jason.put("BUNAME",rs.getString(2));
					 values.add(jason);
				}
              System.out.println(pstmt.toString()+"ooooooooo"+values.toString());
			}
			
			
			else if (type.equalsIgnoreCase("Reports_PF")) {
				
				StringBuffer pfQuery=new StringBuffer();
				pfQuery.append(" SELECT A.EMPLOYEESEQUENCENO ID,B.PFUAN,A.CALLNAME 'MEMBER NAME',  ");
				pfQuery.append(" MAX(CASE WHEN C.COMPONENTID=22 THEN C.NETVALUE END)'GROSS WAGES', ");
				pfQuery.append(" MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END)'EPF WAGES', ");
				pfQuery.append(" IF(MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END)<=21000,MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END),21000.00)'EPS WAGES', ");
				pfQuery.append(" IF(MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END)<=21000,MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END),21000.00)'EDLI Wages', ");
				pfQuery.append(" MAX(CASE WHEN C.COMPONENTID=31 THEN C.NETVALUE END)'EPF Contribution_EE_Share_due', ");
				pfQuery.append(" ROUND(IF(MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END)<=21000,MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END),21000)*0.0833)'EPS_Contribution_due', ");
				pfQuery.append(" ROUND((MAX(CASE WHEN C.COMPONENTID=31 THEN C.NETVALUE END))-(ROUND(IF(MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END)<=21000,MAX(CASE WHEN C.COMPONENTID=24 THEN C.NETVALUE END),21000)*0.0833)))'Diff EPF and EPS Contrbution_ER_Share_due', ");
				pfQuery.append(" IFNULL(D.LOPCOUNT,'') AS 'NCP Days', ");
				pfQuery.append(" '' as 'Refund of Advances' ");
				pfQuery.append(" FROM ");
				pfQuery.append(" HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A ");
				pfQuery.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_OTHER_DETAIL B ON A.EMPLOYEEID=B.EMPLOYEEID ");
				pfQuery.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PAY_DATA C ON A.EMPLOYEEID=C.EMPLOYEEID ");
				pfQuery.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_LOP D ON A.EMPLOYEEID=D.EMPLOYEEID AND D.LOPTRANSACTIONID=201704 ");
				pfQuery.append(" WHERE A.COMPANYID IN (3,5,13,11) AND A.STATUS=1001 AND C.PAYPERIOD=201704 AND A.EMPLOYMENTTYPEID!=7 ");
				pfQuery.append(" GROUP BY A.EMPLOYEESEQUENCENO ");
				
				
				pstmt = con.prepareStatement(pfQuery.toString());
				rs = pstmt.executeQuery();
			//	al.add("Select#--Select One--");
				java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int threadCnc=0;
				while (rs.next()) {
					jason = new JSONObject();
					
					for (int i = 1; i <= columnCount; i++ ) {
						  
						String name = rsmd.getColumnName(i);
						  if(threadCnc==0){
						  Thread.put(name, name);
						  }
						  jason.put(name,rs.getString(name));
						  // Do stuff with name
						}
					 values.add(jason);
					
					/*jason.put("BUID",rs.getString(1));
					jason.put("BUNAME",rs.getString(2));
					 values.add(jason);*/
					 threadCnc++;
				}
              System.out.println(Thread.toString()+"ooooooooo12"+values.toString());
			
			}
			
			
			
			
			//***********************************************

			if (type.equalsIgnoreCase("HQLIST")
					|| type.equalsIgnoreCase("Division1")) {
				String r = "SELECT BUSINESSUNITID,NAME FROM HCLADM_PROD.TBL_BUSINESSUNIT WHERE PARENTBUSINESSUNITID!=0 AND STATUS=1001 AND BUSINESSUNITID IN("+BU+")";
				pstmt = con.prepareStatement(r);
				
				
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
              System.out.println(pstmt.toString()+"ooooooooo"+al.toString());
			}

			else if (type.equalsIgnoreCase("STATES")) {
				String r = "SELECT DISTINCT STATE_CODE,STATE FROM test.tbl_pt_deviation_ranges where status=1001 ORDER BY STATE ASC";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			else if (type.equalsIgnoreCase("EMPOLYEECODE")) {
				String r = "SELECT * FROM hclhrm_prod.tbl_employee_primary where EMPLOYEESEQUENCENO='"
						+ EmployeeCode + "'";

				// System.out.println("r"+r);
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				// boolean reg=rs.next();

				if (rs.isBeforeFirst()) {

					// System.out.println("123");
					al.add("1");

				} else {
					// System.out.println("1234");
					al.add("0");
				}

			}

			else if (type.equalsIgnoreCase("Filed")) {

				String r = "SELECT b.costcenterid,b.NAME FROM hcladm_prod.tbl_businessunit a,hcladm_prod.tbl_costcenter b  where a.BUSINESSUNITID=b.BUSINESSUNITID and a.BUSINESSUNITID='"
						+ BUSINESSUNITID + "'";

				// System.out.println(r+"---------");

				pstmt = con.prepareStatement(r);

				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			else if (type.equalsIgnoreCase("Fetch")) {
				String r = "SELECT B.DEPARTMENTID,B.NAME FROM hcladm_prod.tbl_businessunit_departments A "
						+ "LEFT JOIN hcladm_prod.tbl_department B ON A.DEPARTMENTID=B.DEPARTMENTID where A.businessunitid='"
						+ BUSINESSUNITID + "'";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			else if (type.equalsIgnoreCase("Gender")) {
				String r = "select * FROM hcladm_prod.tbl_gender";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			else if (type.equalsIgnoreCase("title")) {
				String r = "select * FROM hcladm_prod.tbl_title ";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}
			
			
			
			//---sales
			
			
			else if (type.equalsIgnoreCase("SalesOffice")) {
				
				String SalesOffice=request.getParameter("SalesOffice");

				String r ="SELECT SALESGROUPCODE,SALESGROUPNAME FROM hclhrm_prod_others.salesoffice_group_relation WHERE SALESOFFICECODE='"+SalesOffice+"'";

				System.out.println(r+"---------");

				pstmt = con.prepareStatement(r);

				rs = pstmt.executeQuery();

				al.add("0#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
				
				System.out.println(al.toString());
			}

			/*
			 * else if(type.equalsIgnoreCase("Change_Tile")) { String r =
			 * "SELECT TITLE,IF(TITLE='1','MALE',IF(TITLE='2','FEMALE',IF(TITLE='3','FEMALE','MALE'))) FROM HCLADM_PROD.TBL_TITLE WHERE ='"
			 * +title+"'"; pstmt = con.prepareStatement(r); rs =
			 * pstmt.executeQuery();
			 * 
			 * //al.add("Select#--Select One--");
			 * 
			 * while (rs.next()) {
			 * 
			 * 
			 * al.add(rs.getString(1)+"#"+rs.getString(2));
			 * 
			 * } }
			 */

			else if (type.equalsIgnoreCase("Status")
					|| type.equalsIgnoreCase("Status1")) {
				String r = "select * FROM hclhrm_prod.tbl_employment_types ";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			else if (type.equalsIgnoreCase("StatusCodes")) {
				String r = "select * FROM hcladm_prod.tbl_status_codes WHERE BASESTATUS=1 and STATUS not in(1081,1082,1071,1091) ";
				pstmt = con.prepareStatement(r);
				rs = pstmt.executeQuery();

				al.add("Select#--Select One--");

				while (rs.next()) {

					al.add(rs.getString(1) + "#" + rs.getString(2));

				}
			}

			Gson gson = new Gson();
			String messages = gson.toJson(al);
			
			if(type.equalsIgnoreCase("Reports") ){
				
				out.println(values.toString());
				
			}else if(type.equalsIgnoreCase("Reports_PF")){
			
				
				//System.out.println( Thread.toString()+"##"+values.toString() );
				//out.println(Thread.toString()+"##"+values.toString());
				
				 out.println(values.toString());
				
			}
			
			else{
			    out.println(messages);
			}
			 System.out.println(messages);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if(rs!=null)
				rs.close();
				if(pstmt!=null)
				pstmt.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}

}
