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

import com.google.gson.Gson;
import com.hclhrm.util.Util;

public class Hhcl_BasicScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hhcl_BasicScreen() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "Post-Check=0");
		response.addHeader("Cache-Control", "Pre-Check=0");
		response.addHeader("Expires", "Mon, 1 Jan 2006 05:00:00 GMT");
		String Type = request.getParameter("type");
		String Employeecode = request.getParameter("EmployeeCode");
		String title = request.getParameter("title");
		String Gender = request.getParameter("Gender");
		
		int addBc1[]={};
		
		String FirstName = request.getParameter("FristName");
		
		//String LastName = request.getParameter("MiddleName").concat(" ").concat(request.getParameter("LastName"));
		String LastName = request.getParameter("LastName");
		
		String MiddleName=request.getParameter("MiddleName");
		
		String Actiondate=request.getParameter("Lwdate");
		String ReasonCode=request.getParameter("updatetype");
		String Reasontype=request.getParameter("updatetype_reson");
		
		
		
		
		
		  HttpSession session=request.getSession();
		
		  String RoutingPage=(String)session.getAttribute("Routing");
		  String BU=(String)session.getAttribute("BU");
		  String ProcessedBy=(String)session.getAttribute("Pby");
		  String LOGINBY=(String)session.getAttribute("LOGINBY");
		  
		   if(ProcessedBy==null){
			   session.invalidate();
		   }
		  
		  request.setAttribute("Routing", RoutingPage);
		  request.setAttribute("BU", BU);
		  request.setAttribute("Pby", ProcessedBy);
		  request.setAttribute("LOGINBY", LOGINBY);
		  
		  
		  session.setAttribute("Routing", RoutingPage);
		  session.setAttribute("BU", BU);
		  session.setAttribute("Pby", ProcessedBy);
		  session.setAttribute("LOGINBY", LOGINBY);
		  
		  
		System.out.println(MiddleName.length()+":MiddleName::" +MiddleName);
		
		 System.out.println(FirstName.length()+":FirstName::" +FirstName);
		
		String FullName=null;
		 if(MiddleName==null || (MiddleName.trim()).length()==0){
			 
			 FullName =FirstName.trim().concat(" "+LastName.trim());
		 }else{
		
		  FullName =FirstName.trim().concat(" "+MiddleName.trim()).concat(" "+LastName.trim());
		  
		  
		 }
		 
		 System.out.println(FullName.length()+":FullName::" +FullName);
		 
		//String FullName = FirstName.concat(" ").concat(LastName);
		
		
		String Field = request.getParameter("Field");
		String Dateofjoin = request.getParameter("Date");
		String DATEOFBIRTH = request.getParameter("DATEOFBIRTH");
		String COMPANYID = request.getParameter("COMPANYID");
		String EMPLOYMENTTYPEID = request.getParameter("Status");
		String STATE_CODE = request.getParameter("STATE_CODE");
		String STATE = request.getParameter("state");
		// System.out.println("STATE-------->"+STATE);
		String Digit = request.getParameter("Digit");

		String EMP_ID = request.getParameter("Emp_Id");
		//String LogID = "10451";

		String AtciveStatus = request.getParameter("AtciveStatus");

		String Mobileno = request.getParameter("mobileno");
		String Emailid = request.getParameter("emailid");
		
		 
		 LOGINBY=(String) session.getAttribute("LOGINBY");
		 
		 
		 //Sales Office
		 
		/* String Sales_Zone=request.getParameter("Sales_Zone");*/
		 String SalesDistict=request.getParameter("SalesDistict");
		 String SalesOffice=request.getParameter("SalesOffice");
		 String SalesGroup=request.getParameter("SalesGroup");
		 
		 

		// System.out.println(Emailid + "***********" + Mobileno);

		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<String> al = new ArrayList<String>();
		
		
		// HttpSession session=request.getSession();
		
		/*try {
			//conn =dataSource.getConnection();
			con=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}*/
		
		System.out.println("con at Modify:::"+con);
		
		 con = Util.getConnection();

		StringBuffer Buff = new StringBuffer();

		System.out.println("TypeTypeType::"+Type);
		int History1 = 0;
		int History2 = 0;
		int History3 = 0;
		int History4 = 0;
		int History5 = 0;
		
		

		Gson gson = new Gson();
		String messages = null;

		try {
			con.setAutoCommit(false);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {

			int i = 0;
			int i1 = 0;
			int i2 = 0;
			int i3 = 0;
			int i4=0;

			if (Type.equalsIgnoreCase("Manual")) {

				String r = "SELECT count(*) FROM hclhrm_prod.tbl_employee_primary where EMPLOYEESEQUENCENO="+Employeecode+ " ";

				pstmt = con.prepareStatement(r);
                int fetchRow=-1;
				rs = pstmt.executeQuery();
				if(rs.next()){
					
					fetchRow=rs.getInt(1);
					
				}
                 //if (!rs.isBeforeFirst())
				if (fetchRow==0) {
					
					
					
					
					

					String r1 = "insert into hclhrm_prod.tbl_employee_primary(COSTCENTERID, FIRSTNAME,LASTNAME,CALLNAME,GENDER,TITLE,DATEOFBIRTH,COMPANYID,EMPLOYMENTTYPEID,EMPLOYEESEQUENCENO,CREATEDBY,DATECREATED) VALUES (?,?,?,?,?,?,?,?,?,?,?,NOW())";

					pstmt = con.prepareStatement(r1,PreparedStatement.RETURN_GENERATED_KEYS);

					pstmt.setString(1, Field);
					pstmt.setString(2, FirstName);
					pstmt.setString(3, LastName);
					pstmt.setString(4, FullName);
					pstmt.setString(5, Gender);
					pstmt.setString(6, title);
					pstmt.setString(7, DATEOFBIRTH);
					pstmt.setString(8, COMPANYID);
					pstmt.setString(9, EMPLOYMENTTYPEID);
					pstmt.setString(10, Employeecode);
					pstmt.setString(11, LOGINBY);

					// System.out.println(pstmt);
					i = pstmt.executeUpdate();

					ResultSet K = pstmt.getGeneratedKeys();
					int EMPLOYEEID = 0;

					boolean reg = false;
                    
					
					/*if (!K.isBeforeFirst()) {
						
						System.out.println("Loaded K.isBeforeFirst().....!");
						al.add("Invalid_Data" + "#"
								+ "Invalid Data Please Contact to Admin...");
					}*/
                   System.out.println("After employeeid Generate::"+i);
					if (K.next() && i>0) {

						EMPLOYEEID = K.getInt(1);

						System.out.println("getGeneratedKeys :: "+EMPLOYEEID);
						reg = true;

					}else{
						
						al.add("Unable to generate EMPLOYEEID " + "#"
								+ "Invalid Data Please Contact to Admin...");
						
					}
					
				try{
					Thread.sleep(100);
				}catch(Exception ert){
					System.out.println("Exception At Thread Calss::"+ert);
				}

				System.out.println("Bafore insert other Tables reg ::"+reg);
				
					if (reg) {
						
						

						String c = "INSERT INTO hclhrm_prod.tbl_employee_personal_contact (EMPLOYEEID,EMAIL,MOBILE) VALUES ('"
								+ EMPLOYEEID
								+ "','"
								+ Emailid
								+ "','"
								+ Mobileno + "')";

						// System.out.println(2);
						// System.out.println("c------>"+c);
						pstmt = con.prepareStatement(c);
						// pstmt.setInt(1, EMPLOYEEID);
						// pstmt.setString(2, Emailid);
						// pstmt.setString(3, Mobileno);

						// System.out.println(pstmt);

						//pstmt.addBatch();
						i3 = pstmt.executeUpdate();

						String b1 = "insert into hclhrm_prod.tbl_employee_profile(EMPLOYEEID,DATEOFJOIN,GROUPDOJ,FIRSTDAYOFWORK) values(?,?,?,?)";

						pstmt = con.prepareStatement(b1);
						pstmt.setInt(1, EMPLOYEEID);
						pstmt.setString(2, Dateofjoin);
						pstmt.setString(3, Dateofjoin);
						pstmt.setString(4, Dateofjoin);
						// System.out.println(pstmt);

						//pstmt.addBatch();
						i2 = pstmt.executeUpdate();

						String b = "insert into test.empl_states(EMPLOYEEID,EMPLOYEESEQUENCENO,STATE,STATE_CODE,COMPANYID) values(?,?,?,?,?)";

						pstmt = con.prepareStatement(b);
						pstmt.setInt(1, EMPLOYEEID);
						pstmt.setString(2, Employeecode);
						pstmt.setString(3, STATE);
						if(Gender.equalsIgnoreCase("1")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
							pstmt.setString(4, "MH");
						}
						else if(Gender.equalsIgnoreCase("2")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
							
							pstmt.setString(4, "MHF");
						
						}
						else{
							pstmt.setString(4, STATE_CODE);
						}
					
						pstmt.setString(5, COMPANYID);

						// System.out.println(pstmt);

						// System.out.println(1);

						//pstmt.addBatch();
						i1 = pstmt.executeUpdate();
						
						
						
						String Log="INSERT INTO HCLHRM_PROD.tbl_report_print_log(REPORTID, ID, USERID, LUPDATE) SELECT 29,EMPLOYEEID,"+LOGINBY+",NOW() FROM HCLHRM_PROD.tbl_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO="+Employeecode+" LIMIT 1";
                       
						
						pstmt = con.prepareStatement(Log);
						
						//pstmt.addBatch();
						i4 = pstmt.executeUpdate();
						

						String Log1="insert into hclhrm_prod.tbl_employee_login(EMPLOYEEID, EMPLOYEECODE, PASSWORD, STATUS, CREATEDBY, DATECREATED) select employeeid,employeesequenceno, MD5(concat(employeesequenceno,'@',DATE_FORMAT(dateofbirth,'%d%Y'))),1001,"+LOGINBY+"  ,now() from hclhrm_prod.tbl_employee_primary where employeesequenceno in("+Employeecode+") limit 1";
                        
						pstmt = con.prepareStatement(Log1);
						
						pstmt.addBatch();
						
						//int execB[]=pstmt.executeBatch();
						
						
						//System.out.println(execB.length+"Length-------");
					int i5 = pstmt.executeUpdate();
					
					
					
					
					///----SalesOffice-GroupMapping
				 
					 
					String SalesQuery="insert into hclhrm_prod_others.tbl_employee_salesoffice(EMPLOYEEID, SALESDISTICT, SALESOFFFICE, SALESGROUP) "
							+ "VALUES("+EMPLOYEEID+",'"+SalesDistict+"','"+SalesOffice+"','"+SalesGroup+"')";
           			
                    
					pstmt = con.prepareStatement(SalesQuery);
					
					
					int i6 = pstmt.executeUpdate();
					
					
					

					System.out.println("~i1~"+i1+"~i2~"+i2+"~i3~"+i3+"~i4~"+i4+"~i5~"+i5+"~i6~"+i6);
					//i > 0 && i1 > 0 && i2 > 0 && i3 > 0&&i4>0&&	

						if (i > 0 && i1 > 0 && i2 > 0 && i3 > 0 && i4>0 && i5>0&&i6>0) {
							
							
							con.commit();

							al.add("Insert_Success" + "#"
									+ "Successfully Inserted....");

						} else {
							al.add("Invalid_Data" + "#"
									+ "Invalid Data Please Contact to Admin...");
						}

					}

				} else {
					al.add("Employee_Exist" + "#"
							+ "EmployeeCode Already Existed...");
				}

			}

			else if (Type.equalsIgnoreCase("Update")) {
				
				
				System.out.println("My Update");

				String Check = "SELECT IF(B.employeesequenceno=A.employeesequenceno, '1', '0') as history FROM hclhrm_prod.tbl_employee_primary A LEFT JOIN hclhrm_prod.tbl_employee_primary_history B ON  A.EMPLOYEEID=B.EMPLOYEEID where A.employeesequenceno='"
						+ Employeecode + "'";

				String ProfileCheck = "SELECT IF(B.EMPLOYEEID=C.EMPLOYEEID,'1','0') FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFILE B "
						+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE_HISTORY C ON B.EMPLOYEEID=C.EMPLOYEEID "
						+ "WHERE B.EMPLOYEEID=" + EMP_ID;

				String StateCheck = "SELECT IF(B.employeesequenceno=A.employeesequenceno, '1', '0') as history FROM test.empl_states A "
						+ "LEFT JOIN test.empl_states_history B ON  A.EMPLOYEEID=B.EMPLOYEEID where A.employeesequenceno='"
						+ Employeecode + "'";

				String ContactCheck = " SELECT IF(A.EMPLOYEEID=B.EMPLOYEEID,'1','0') FROM hclhrm_prod.tbl_employee_personal_contact A "
						+ "LEFT JOIN hclhrm_prod.tbl_employee_personal_contact_history B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.EMPLOYEEID="
						+ EMP_ID;
				
				
				String SalesCheck ="SELECT IF(A.EMPLOYEEID=B.EMPLOYEEID,'1','0') FROM hclhrm_prod_others.tbl_employee_salesoffice A "
				           +" LEFT JOIN hclhrm_prod_others.tbl_employee_salesoffice_history B ON A.EMPLOYEEID=B.EMPLOYEEID WHERE A.EMPLOYEEID="
						   + EMP_ID;

				// System.out.println("Stat*************" + StateCheck);

				try{
				pstmt = con.prepareStatement(Check);
				}catch(Exception sql1){
					
					System.out.println("Exception sql1::"+sql1);
					
				}
				
				// System.out.println("1-->" + pstmt);
				String InsertBackup = null;

				rs = pstmt.executeQuery();

			
				
				try{
					pstmt = con.prepareStatement(ProfileCheck);
					}catch(Exception sql2){
						
						System.out.println("Exception sql2::"+sql2);
						
					}
				
				
				// System.out.println("2-->" + pstmt);
				String InsertBackupprofile = null;
				rs1 = pstmt.executeQuery();

				
				
				try{
					pstmt = con.prepareStatement(StateCheck);
					}catch(Exception sql3){
						
						System.out.println("Exception sql3::"+sql3);
						
					}
				
				
				// System.out.println("3-->" + pstmt);
				String InsertBackupstates = null;
				rs2 = pstmt.executeQuery();

				
				
				
				try{
					pstmt = con.prepareStatement(ContactCheck);
					}catch(Exception sql4){
						
						System.out.println("Exception sql4::"+sql4);
						
					}
				
				
				// System.out.println("4-->" + pstmt);
				String InsertBackupcontact = null;
				rs3 = pstmt.executeQuery();
				
				
				//----Sales---
				
				try{
					pstmt = con.prepareStatement(SalesCheck.toString());
					}catch(Exception sql4){
						
						System.out.println("Exception sql4::"+sql4);
						
					}
				
				
				// System.out.println("4-->" + pstmt);
				String InsertBackupSales = null;
				rs4 = pstmt.executeQuery();
				

				if (rs.next()) {

					History1 = rs.getInt(1);
				}

				if (rs1.next()) {
					History2 = rs1.getInt(1);
				}

				if (rs2.next()) {

					History3 = rs2.getInt(1);
				}

				if (rs3.next()) {

					History4 = rs3.getInt(1);
				}
				
				if (rs4.next()) {

					History5 = rs4.getInt(1);
				}

				
				System.out.println(History1 +"~"+History2+"~"+History3+"~"+History4);
				
				
				if (History1 == 0|| History1 == 1 ) {
					InsertBackup = "insert into hclhrm_prod.tbl_employee_primary_history(EMPLOYEEID,COSTCENTERID,FIRSTNAME,LASTNAME,CALLNAME,GENDER,TITLE,"
							+ "DATEOFBIRTH,COMPANYID,EMPLOYMENTTYPEID,EMPLOYEESEQUENCENO,STATUS) "
							+ "Select A.EMPLOYEEID,A.COSTCENTERID,A.FIRSTNAME,A.LASTNAME,A.CALLNAME,A.GENDER,A.TITLE,A.DATEOFBIRTH,A.COMPANYID,A.EMPLOYMENTTYPEID,A.employeesequenceno,A.STATUS from hclhrm_prod.tbl_employee_primary A where A.employeesequenceno='"
							+ Employeecode + "'";

				}/* else if (History1 == 1) {
					InsertBackup = "update hclhrm_prod.tbl_employee_primary A,hclhrm_prod.tbl_employee_primary_history B set B.COSTCENTERID=A.COSTCENTERID,B.FIRSTNAME=A.FIRSTNAME,B.LASTNAME=A.LASTNAME,B.CALLNAME=A.CALLNAME,B.GENDER=A.GENDER,B.TITLE=A.TITLE,B.DATEOFBIRTH=A.DATEOFBIRTH,B.COMPANYID=A.COMPANYID,B.EMPLOYMENTTYPEID=A.EMPLOYMENTTYPEID,B.STATUS=A.STATUS where A.EMPLOYEESEQUENCENO='"
							+ Employeecode + "' and A.EMPLOYEEID=B.EMPLOYEEID";

				}*/

				if (History2 == 0||History2 == 1) {

					InsertBackupprofile = "insert into hclhrm_prod.tbl_employee_profile_HISTORY (EMPLOYEEID,DATEOFJOIN,GROUPDOJ,FIRSTDAYOFWORK)"
							+ " SELECT EMPLOYEEID,DATEOFJOIN,GROUPDOJ,FIRSTDAYOFWORK"
							+ " FROM HCLHRM_PROD.TBL_EMPLOYEE_PROFILE WHERE EMPLOYEEID="
							+ EMP_ID;

				} /*else if (History2 == 1) {

					InsertBackupprofile = "UPDATE HCLHRM_PROD.TBL_EMPLOYEE_PROFILE A,hclhrm_prod.tbl_employee_profile_HISTORY B "
							+ "SET B.DATEOFJOIN=A.DATEOFJOIN,B.GROUPDOJ=A.GROUPDOJ,B.FIRSTDAYOFWORK=A.FIRSTDAYOFWORK WHERE A.EMPLOYEEID=B.EMPLOYEEID AND A.EMPLOYEEID="
							+ EMP_ID;

				}*/

				if (History3 == 0||History3 == 1) {
					InsertBackupstates = "insert into test.empl_states_history(EMPLOYEEID,EMPLOYEESEQUENCENO,STATE,STATE_CODE,COMPANYID) select EMPLOYEEID,EMPLOYEESEQUENCENO,STATE,STATE_CODE,COMPANYID from test.empl_states where employeesequenceno='"
							+ Employeecode + "'";

				} /*else if (History3 == 1) {

					InsertBackupstates = "update test.empl_states a,test.empl_states_history b set  b.STATE=a.state,b.STATE_CODE=a.state_code,b.COMPANYID=a.companyid where A.EMPLOYEESEQUENCENO='"
							+ Employeecode + "' and A.EMPLOYEEID=B.EMPLOYEEID";

				}*/

				if (History4 == 0||History4 == 1) {

					InsertBackupcontact = "insert into hclhrm_prod.tbl_employee_personal_contact_history (EMPLOYEEID,EMAIL,MOBILE) select EMPLOYEEID,EMAIL,MOBILE from hclhrm_prod.tbl_employee_personal_contact where employeeid="
							+ EMP_ID;
				}
				if (History5 == 0||History5 == 1) {
					InsertBackupSales = "insert into hclhrm_prod_others.tbl_employee_salesoffice_history (EMPLOYEEID,SALESDISTICT, SALESOFFFICE, SALESGROUP) "
                           +" select EMPLOYEEID, SALESDISTICT, SALESOFFFICE, SALESGROUP from hclhrm_prod_others.tbl_employee_salesoffice where employeeid="+EMP_ID;
				}
				
				
				
				/*else if (History4 == 1) {

					InsertBackupcontact = "update hclhrm_prod.tbl_employee_personal_contact a,hclhrm_prod.tbl_employee_personal_contact_history b "
							+ "set b.EMAIL=a.EMAIL,b.MOBILE=a.MOBILE where A.EMPLOYEEID=B.EMPLOYEEID AND a.employeeid="
							+ EMP_ID;
					// System.out.println(""+InsertBackupcontact);
				}*/

				
				pstmt = con.prepareStatement(InsertBackup);
				// System.out.println("5-->" + pstmt);
				
				try{
					pstmt.addBatch();
					}catch(Exception sql5){
						
						System.out.println("Exception sql5::"+sql5);
						
					}
				
				
				
				//i = pstmt.executeUpdate();

				pstmt = con.prepareStatement(InsertBackupprofile);
				// System.out.println("6-->" + pstmt);
				try{
					pstmt.addBatch();
					}catch(Exception sql6){
						
						System.out.println("Exception sql6::"+sql6);
						
					}
				//i1 = pstmt.executeUpdate();

				
				pstmt = con.prepareStatement(InsertBackupstates);
				// System.out.println("7-->" + pstmt);
				try{
					pstmt.addBatch();
					}catch(Exception sql7){
						
						System.out.println("Exception sql7::"+sql7);
						
					}
				//i2 = pstmt.executeUpdate();

				pstmt = con.prepareStatement(InsertBackupcontact);
				// System.out.println("8-->" + pstmt);
				
				try{
					pstmt.addBatch();
					}catch(Exception sql8){
						
						System.out.println("Exception sql8::"+sql8);
						
					}
				
				
				//----Sales
				
				pstmt = con.prepareStatement(InsertBackupSales);
				// System.out.println("8-->" + pstmt);
				
				try{
					pstmt.addBatch();
					}catch(Exception sql8){
						
						System.out.println("Exception sql9::"+sql8);
						
					}
				
				
				
				//i3 = pstmt.executeUpdate();

				 int addbacth[]={};
						
				try{
			     addbacth = pstmt.executeBatch();

				}catch(Exception Sql2Last){
					
					System.out.println("Sql2Last:::"+Sql2Last);
					
				}
				 System.out.println(addbacth.length+"Prasad..............");

				String Update = null;

				// System.out.println(i+"<--1-->"+i1+"<--2-->"+i2+"<--3-->"+i3);
                //i > 0 && i1 > 0 && i2 > 0 && i3 > 0
				
				if (addbacth.length>0) {
					Update = "update hclhrm_prod.tbl_employee_primary set COSTCENTERID=?,FIRSTNAME=?,LASTNAME=?,CALLNAME=?,GENDER=?,TITLE=?,DATEOFBIRTH=?,COMPANYID=?,EMPLOYMENTTYPEID=?,STATUS=? where EMPLOYEESEQUENCENO="
							+ Employeecode + "";

					pstmt = con.prepareStatement(Update);

					// System.out.println("9-->" + pstmt);
					pstmt.setString(1, Field);
					pstmt.setString(2, FirstName);
					pstmt.setString(3, LastName);
					pstmt.setString(4, FullName);
					pstmt.setString(5, Gender);
					pstmt.setString(6, title);
					pstmt.setString(7, DATEOFBIRTH);
					pstmt.setString(8, COMPANYID);
					pstmt.setString(9, EMPLOYMENTTYPEID);
					pstmt.setString(10, AtciveStatus);

					
				System.out.println("pstmt::"+pstmt.toString());
					//pstmt.addBatch();
					i = pstmt.executeUpdate();

					/*Update = "UPDATE HCLHRM_PROD.TBL_EMPLOYEE_PROFILE "
							+ "SET DATEOFJOIN='" + Dateofjoin + "',GROUPDOJ='"
							+ Dateofjoin + "',FIRSTDAYOFWORK='" + Dateofjoin
							+ "' WHERE EMPLOYEEID=" + EMP_ID;*/
				
					/*Update = "INSERT INTO HCLHRM_PROD.TBL_EMPLOYEE_PROFILE(DATEOFJOIN,GROUPDOJ,FIRSTDAYOFWORK)"
							   + "VALUES('"+Dateofjoin+"','"+Dateofjoin+"','"+Dateofjoin+"')ON DUPLICATE KEY UPDATE DATEOFJOIN='"+Dateofjoin+"',GROUPDOJ='"+Dateofjoin+"',FIRSTDAYOFWORK='"+Dateofjoin+"' "
							   + "WHERE EMPLOYEEID="+EMP_ID;*/
				
					if(AtciveStatus.equalsIgnoreCase("1061")){
						
						Update = "insert into HCLHRM_PROD.TBL_EMPLOYEE_PROFILE (EMPLOYEEID, TERMOFSERVICE, DATEOFJOIN, GROUPDOJ, FIRSTDAYOFWORK,MODIFIEDBY, DATEMODIFIED, LUPDATE,DATEOFRESIGNATION)"
								+"select EMPLOYEEID,'0','"+Dateofjoin+"','"+Dateofjoin+"','"+Dateofjoin+"','"+LOGINBY+"', now(),now(),'"+Actiondate+"'"
								+"FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY where EMPLOYEEID in ("+EMP_ID+")"
								+" ON DUPLICATE KEY UPDATE DATEOFJOIN='"+Dateofjoin+"', GROUPDOJ='"+Dateofjoin+"',FIRSTDAYOFWORK='"+Dateofjoin+"',DATEOFRESIGNATION='"+Actiondate+"' ";
							
						
						}else if(AtciveStatus.equalsIgnoreCase("1001")){
						
							String Actiondate1="0000-00-00";
							Update = "insert into HCLHRM_PROD.TBL_EMPLOYEE_PROFILE (EMPLOYEEID, TERMOFSERVICE, DATEOFJOIN, GROUPDOJ, FIRSTDAYOFWORK,MODIFIEDBY, DATEMODIFIED, LUPDATE,DATEOFRESIGNATION)"
									+"select EMPLOYEEID,'0','"+Dateofjoin+"','"+Dateofjoin+"','"+Dateofjoin+"','"+LOGINBY+"', now(),now(),'"+Actiondate1+"'"
									+"FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY where EMPLOYEEID in ("+EMP_ID+")"
									+" ON DUPLICATE KEY UPDATE DATEOFJOIN='"+Dateofjoin+"', GROUPDOJ='"+Dateofjoin+"',FIRSTDAYOFWORK='"+Dateofjoin+"',DATEOFRESIGNATION='"+Actiondate1+"' ";
							
							
							
								
							
					}else{
						
						Update = "insert into HCLHRM_PROD.TBL_EMPLOYEE_PROFILE (EMPLOYEEID, TERMOFSERVICE, DATEOFJOIN, GROUPDOJ, FIRSTDAYOFWORK,MODIFIEDBY, DATEMODIFIED, LUPDATE)"
								+"select EMPLOYEEID,'0','"+Dateofjoin+"','"+Dateofjoin+"','"+Dateofjoin+"','"+LOGINBY+"', now(),now()"
								+"FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY where EMPLOYEEID in ("+EMP_ID+")"
								+" ON DUPLICATE KEY UPDATE DATEOFJOIN='"+Dateofjoin+"', GROUPDOJ='"+Dateofjoin+"',FIRSTDAYOFWORK='"+Dateofjoin+"' ";
						
						
					}

					pstmt = con.prepareStatement(Update);
					
					System.out.println("Update select:::"+Update);
					// System.out.println("10-->" + pstmt);
					// System.out.println("Update Employee"+pstmt);

					//pstmt.addBatch();
					i1 = pstmt.executeUpdate();

					
					if(Gender.equalsIgnoreCase("1")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
						/*Update = "update test.empl_states  set  STATE='" + STATE
								+ "',STATE_CODE='MH',"
								+ "COMPANYID='" + COMPANYID
								+ "' where EMPLOYEESEQUENCENO='" + Employeecode
								+ "' ";*/
						
						STATE_CODE="MH";
								
						//pstmt.setString(4, "MH");
					}
					else if(Gender.equalsIgnoreCase("2")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
						/*Update = "update test.empl_states  set  STATE='" + STATE
								+ "',STATE_CODE='MHF',"
								+ "COMPANYID='" + COMPANYID
								+ "' where EMPLOYEESEQUENCENO='" + Employeecode
								+ "' ";*/
						
						STATE_CODE="MHF";
						
					//	pstmt.setString(4, "MHF");
					
					}
					
					System.out.println("STATE_CODE:::"+STATE_CODE);
					
					Update="insert into test.empl_states(EMPLOYEEID, EMPLOYEESEQUENCENO, STATE, STATE_CODE, COMPANYID, STATUS, LUPDATE)"
							+" select EMPLOYEEID,EMPLOYEESEQUENCENO,'"+STATE+"','"+STATE_CODE+"',COMPANYID,STATUS,now() from HCLHRM_PROD.TBL_EMPLOYEE_Primary where EMPLOYEESEQUENCENO="+Employeecode+""
							+" ON DUPLICATE KEY UPDATE STATE='"+STATE+"', STATE_CODE='"+STATE_CODE+"'" ;
					
					System.out.println("State_Codes:::" +Update);
					pstmt = con.prepareStatement(Update);
					//pstmt.addBatch();
					
					System.out.println("11-->" + pstmt);
				
					i2 = pstmt.executeUpdate();

					/*Update = "update hclhrm_prod.tbl_employee_personal_contact set EMAIL='"
							+ Emailid
							+ "',MOBILE='"
							+ Mobileno
							+ "' where employeeid=" + EMP_ID;*/
					
					Update = " insert into hclhrm_prod.tbl_employee_personal_contact(EMPLOYEEID,EMAIL,MOBILE,MODIFIEDBY,DATEMODIFIED)"
							+" select EMPLOYEEID,'"+Emailid+"','"+Mobileno+"','"+LOGINBY+"',now() from HCLHRM_PROD.TBL_EMPLOYEE_Primary where EMPLOYEEID="+EMP_ID+" "
							+" ON DUPLICATE KEY UPDATE EMAIL='"+Emailid+"',MOBILE='"+Mobileno+"' ";

					// System.out.println("12-->" + pstmt);
					// System.out.println("<---update-->"+Update);
					pstmt = con.prepareStatement(Update);

					//pstmt.addBatch();
					 i3 = pstmt.executeUpdate();//i > 0 && i1 > 0 && i2 > 0 && i3 > 0
				
					// addBc1=pstmt.executeBatch();
					 
					 
					 
					 Update="INSERT INTO hclhrm_prod_others.tbl_employee_basic_action( EMPID, ACTION, REASONCODE, REASONTYPE,ACTIONBY) values('"+Employeecode+"','"+Actiondate+"','"+ReasonCode+"','"+Reasontype+"','"+LOGINBY+"')";
					 
					 try{
					 pstmt = con.prepareStatement(Update);
					 
					 pstmt.executeUpdate();
					 }catch(Exception Err){
						 System.out.println("Exception at hclhrm_prod_others.tbl_employee_basic_action "+Err);
					 }
					 
					 
					 ////---------Sales Office----//
					 
					 
					 Update="insert into hclhrm_prod_others.tbl_employee_salesoffice(EMPLOYEEID,SALESDISTICT, SALESOFFFICE, SALESGROUP) VALUES("+EMP_ID+",'"+SalesDistict+"','"+SalesOffice+"','"+SalesGroup+"')"
					 +" ON DUPLICATE KEY UPDATE  SALESDISTICT='"+SalesDistict+"',SALESOFFFICE='"+SalesOffice+"',SALESGROUP='"+SalesGroup+"'" ;
					 
						
					//  System.out.println("Sales Office:::" +Update);
						pstmt = con.prepareStatement(Update);
						//pstmt.addBatch();
						
						//System.out.println("Sales Office...." + pstmt);
					
						i4 = pstmt.executeUpdate();
					 
					 
					 
					 
					// SNO, EMPID, ACTION, REASONCODE, REASONTYPE, LUPDATE, ACTIONBY
					 
					 System.out.println(i+"~"+i1+"~"+i2+"~"+i3+"~"+i4);

				}

				
				if (i>0&&i1>0&&i2>0&&i3>0&&i4>0) {
					con.commit();
					// al.add("0");//&& i3 > 0

					al.add("Update_Success" + "#" + "Successfully Updated....");
				}

				else {
					al.add("Invalid_Data" + "#"
							+ "Invalid Data Please Contact to Admin...1");
				}

			}

			else if (Type.equalsIgnoreCase("System")) {
				
				//SYSTEM

				String Gen_Code = "SELECT EMPLOYEESEQUENCENO+1 FROM HCLHRM_PROD.TBL_EMPLOYEE_EMPLOYMENT_MAPPING WHERE EMPLOYMENTCODE='"
						+ Digit
						+ "' AND "
						+ "COMPANYID=if('"
						+ COMPANYID
						+ "' in (3,9),2,if('"
						+ COMPANYID
						+ "' IN (7,14,17,18,24) ,3,if("+COMPANYID+" in (25),7,1))) limit 1";
				
				System.out.println("Gen_Code Query:::"+Gen_Code);
				int Key = 0;

				pstmt = con.prepareStatement(Gen_Code);
				rs = pstmt.executeQuery();
                
				/*if (!rs.isBeforeFirst()) {
					al.add("Invalid_Code");
				}*/

				if (rs.next()) {

					Key = rs.getInt(1);
					
					String r = "SELECT count(*) FROM hclhrm_prod.tbl_employee_primary where EMPLOYEESEQUENCENO="+Key +"";

					pstmt = con.prepareStatement(r);
					
					
					System.out.println("from primary Table:::"+pstmt.toString());
					int SeqPass=-1;
					try{
					rs4 = pstmt.executeQuery();
					}catch(SQLException eee){
						System.out.println("rs4::"+eee);
					}
					
					if(rs4.next()){
						
						SeqPass=rs4.getInt(1);
					}

					System.out.println("SeqPass:::"+SeqPass);
					
					if (SeqPass==0) {
						
						

						Buff.append("INSERT INTO HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY (COSTCENTERID, FIRSTNAME, LASTNAME, CALLNAME, GENDER, TITLE, DATEOFBIRTH, STATUS, COMPANYID, EMPLOYMENTTYPEID, EMPLOYEESEQUENCENO,CREATEDBY, DATECREATED,LUPDATE)");
						Buff.append(" SELECT '" + Field + "','" + FirstName
								+ "','" + LastName + "','" + FullName + "','"
								+ Gender + "','" + title + "','" + DATEOFBIRTH
								+ "',1001,'" + COMPANYID + "','"
								+ EMPLOYMENTTYPEID + "'," + Key + " ");

						Buff.append(" ,(SELECT EMPLOYEEID FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO IN ("
								+ LOGINBY + ")),NOW(),NOW()");
						Buff.append(" FROM");
						Buff.append(" HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY limit 1");

						System.out.println("insertQuery:: "+Buff.toString());
						pstmt = con.prepareStatement(Buff.toString());

						try{
						i = pstmt.executeUpdate();
						}catch(SQLException eee){
							System.out.println("i::"+eee);
						}
						ResultSet K = pstmt.getGeneratedKeys();
						int EMPLOYEEID = 0;

						if(K.next()){
							
							EMPLOYEEID = K.getInt(1);
							
						}
						System.out.println("EMPLOYEEID GENERATED::"+EMPLOYEEID );
						
						String UpdateCode = "UPDATE HCLHRM_PROD.TBL_EMPLOYEE_EMPLOYMENT_MAPPING SET EMPLOYEESEQUENCENO=("
								+ Key
								+ ") WHERE "
								+ " EMPLOYMENTCODE='"
								+ Digit
								+ "' AND COMPANYID=if("+COMPANYID+" in (3,9),2,if("+COMPANYID+" IN (7,14,17,18,24) ,3,if("+COMPANYID+" in (25),7,1)))";

						pstmt = con.prepareStatement(UpdateCode);
						//i1 = pstmt.executeUpdate();
						
						try{
							i1 = pstmt.executeUpdate();
							}catch(SQLException eee){
								System.out.println("i1::"+eee);
							}
						

						/*if (!K.isBeforeFirst()) {
							al.add("Invalid_Code");
						}*/

						
						if (EMPLOYEEID>0) {
                            
							
							
							System.out.println("EMPLOYEEID:::"+EMPLOYEEID );

							String b1 = "insert into hclhrm_prod.tbl_employee_profile(EMPLOYEEID,DATEOFJOIN,GROUPDOJ,FIRSTDAYOFWORK) values(?,?,?,?)";

							pstmt = con.prepareStatement(b1);
							pstmt.setInt(1, EMPLOYEEID);
							pstmt.setString(2, Dateofjoin);
							pstmt.setString(3, Dateofjoin);
							pstmt.setString(4, Dateofjoin);
							// System.out.println(pstmt);

							i2 = pstmt.executeUpdate();

							String b = "insert into test.empl_states(EMPLOYEEID,EMPLOYEESEQUENCENO,STATE,STATE_CODE,COMPANYID) values(?,?,?,?,?)";

							pstmt = con.prepareStatement(b);
							pstmt.setInt(1, EMPLOYEEID);
							pstmt.setString(2, String.valueOf(Key));
							pstmt.setString(3, STATE);
				//			pstmt.setString(4, STATE_CODE);
							if(Gender.equalsIgnoreCase("1")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
								pstmt.setString(4, "MH");
							}
							else if(Gender.equalsIgnoreCase("2")&&STATE.equalsIgnoreCase("MAHARASHTRA")){
								
								pstmt.setString(4, "MHF");
							
							}
							else{
								pstmt.setString(4, STATE_CODE);
							}
							
							pstmt.setString(5, COMPANYID);
                            
							try{
							i3 = pstmt.executeUpdate();
							}catch(SQLException ee){
								System.out.println("i3::" +ee);
							}
							
							
							if(Emailid==null){
								Emailid="no_data@xx.com";
							}
							if(Mobileno==null){
								Mobileno="0000000000";
							}
							
							String c = "INSERT INTO hclhrm_prod.tbl_employee_personal_contact (EMPLOYEEID,EMAIL,MOBILE) VALUES (?,?,?)";

							pstmt = con.prepareStatement(c);
							pstmt.setInt(1, EMPLOYEEID);
							pstmt.setString(2, Emailid);
							pstmt.setString(3, Mobileno);

							// System.out.println(pstmt);
							i4 =0;
						 try{
							 i4 = pstmt.executeUpdate();
						 }catch(SQLException eee){
							 
							 System.out.println("i4::"+eee);
						 }
							
							
							String Log="INSERT INTO HCLHRM_PROD.tbl_report_print_log(REPORTID, ID, USERID, LUPDATE) SELECT 29,EMPLOYEEID,"+LOGINBY+",NOW() FROM HCLHRM_PROD.tbl_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO="+Key+" LIMIT 1";
		                       
							
							pstmt = con.prepareStatement(Log);
							
							int i5 = 0;
							
							 try{
									 i5 = pstmt.executeUpdate();
								 }catch(SQLException eee){
									 
									 System.out.println("i5::"+eee);
								 }
							 
							 
							
							String Log1="insert into hclhrm_prod.tbl_employee_login(EMPLOYEEID, EMPLOYEECODE, PASSWORD, STATUS, CREATEDBY, DATECREATED) select employeeid,employeesequenceno, MD5(concat(employeesequenceno,'@',DATE_FORMAT(dateofbirth,'%d%Y'))),1001,"+LOGINBY+"  ,now() from hclhrm_prod.tbl_employee_primary where employeesequenceno in("+Key+") limit 1";
	                        
							pstmt = con.prepareStatement(Log1);
							
							int i6 = 0;
							
							try{
								 i6 = pstmt.executeUpdate();
							 }catch(SQLException eee){
								 
								 System.out.println("i6::"+eee);
							 }
							//ID, EMPLOYEEID, SALESZONE, SALESDISTICT, SALESOFFFICE, SALESGROUP, LUPDATE
							String SalesQuery="insert into hclhrm_prod_others.tbl_employee_salesoffice(EMPLOYEEID, SALESDISTICT, SALESOFFFICE, SALESGROUP) "
									+ "VALUES("+EMPLOYEEID+",'"+SalesDistict+"','"+SalesOffice+"','"+SalesGroup+"')";
		           			
							
							 /* pstmt.setString(1, String.valueOf(EMPLOYEEID));
							  pstmt.setString(2, Sales_Zone);
							  pstmt.setString(3, SalesDistict);
							  pstmt.setString(4, SalesOffice);
							  pstmt.setString(5, SalesGroup);*/
							
							//System.out.println(SalesQuery);
							
							 pstmt = con.prepareStatement(SalesQuery);
							
							int i7 = pstmt.executeUpdate();
							
					System.out.println(i+"~"+i1+"~"+i2+"~"+i3+"~"+i4+"~"+i5+"~"+i6+"~"+i7);
							if (i > 0 && i1 > 0 && i2 > 0 && i3 > 0 && i4 >0 &&i7>0) {
								con.commit();
								al.add("System_Code" + "#"
										+ String.valueOf(Key));
							}

							else {
								try{
								con.rollback();
								}catch(Exception er){
									System.out.println("RollBack ::"+er);
								}
								al.add("Invalid_Data"
										+ "#"
										+ "Invalid Data Please Contact to Admin...");
							}
						}
					}

					else {
						al.add("Employee_Exist" + "#"
								+ "EmployeeCode Already Existed...");
					}
				}
			}

			messages = gson.toJson(al);
			out.println(messages);

		} catch (Exception e) {

			al.add("Improper Data" + "#"
					+ "Improper Data Please Contact to Admin...");
			messages = gson.toJson(al);
			out.println(messages);

			System.out.println("Exception::"+e);

			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		} finally {
			try {

				if(rs!=null)
				rs.close();
				con.close();
			  if(pstmt!=null)
				  pstmt.close();
			

			} catch (SQLException e) {

				al.add("Improper Data" + "#"
						+ "Improper Data Please Contact to Admin...");
				messages = gson.toJson(al);
				out.println(messages);
			}
		}
	}
}
