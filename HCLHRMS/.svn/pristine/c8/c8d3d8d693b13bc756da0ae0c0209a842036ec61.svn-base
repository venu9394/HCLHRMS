package com.hclhrm.allowances;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class EmployeeCTC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String type=request.getParameter("type");
		
		
		
		
		String employeeid=request.getParameter("employeeid");
		//String fuelmaintenance=request.getParameter("fuelmaintenance");
		
		String componentid=request.getParameter("componentid");
		
		String componentvalue=request.getParameter("componentvalue");
		
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		PrintWriter out=response.getWriter();
		
		
		 try {
	           	Context initContext = new InitialContext();
	           	Context envContext = (Context) initContext.lookup("java:comp/env");
	           	DataSource ds = (DataSource) envContext.lookup("jdbc/HHCL_DESK");
	           	con = ds.getConnection();
	       } catch (SQLException  SQLEx) {
	           	
	    	   System.err.println(SQLEx);
	    	   System.out.println("There was a problem with the database connection.");
	    	   System.out.println(SQLEx);
	    	   
	    	   System.out.println(SQLEx.getCause());	
	           request.setAttribute("Reason", SQLEx.getCause());
	    	   
	       } catch (NamingException ex) {
	            System.err.println(ex);
	            request.setAttribute("Reason", ex);
	       }
		
		
		System.out.println(type+"::"+employeeid);
		
		//List<String> Al=new ArrayList<String>();
		
		String Values="";
		
		
	
		//	Properties prop = loadPropertiesFile();
		//	String ctcgross=prop.getProperty("ctcgross");
		
		
		if(con!=null){
			 
			try{
			
				con.setAutoCommit(false);
			if(type.equalsIgnoreCase("viewctc")){
				
				StringBuffer qry = new StringBuffer();

				qry.append(" SELECT E.COUNT,A.EMPLOYEESEQUENCENO 'EmployeeID',CAST(C.GROSS AS DECIMAL(50,2)) as Gross,IFNULL(E.NAME,'') compoid,ifnull(D.COMPONENTVALUE,'') componentvalue,DATE_FORMAT(C.EFFECTIVEDATE,'%d-%m-%Y')  EffectiveDate,C.GROSS*12 as CTC ");
				qry.append(" FROM  ");
				qry.append(" HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A  ");
				qry.append(" LEFT JOIN (  ");
				qry.append(" SELECT EMPLOYEEID,MAX(CTCTRANSACTIONID) TID FROM HCLHRM_PROD.TBL_EMPLOYEE_CTC GROUP BY EMPLOYEEID  ");
				qry.append(" ) B ON A.EMPLOYEEID=B.EMPLOYEEID  ");
				qry.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_CTC C ON B.TID=C.CTCTRANSACTIONID  ");
				qry.append(" LEFT JOIN test.fuel_maintenance D ON A.EMPLOYEEID=D.EMPLOYEEID AND B.TID=D.CTCTRANSACTIONID" );
				qry.append(" LEFT JOIN test.tbl_new_components E ON D.COMPONENTID=E.COMPONENTID");
				qry.append(" LEFT JOIN (SELECT COUNT(*) COUNT,CTCTRANSACTIONID FROM test.fuel_maintenance GROUP BY CTCTRANSACTIONID) E ON B.TID=E.CTCTRANSACTIONID ");
				qry.append(" WHERE A.EMPLOYEESEQUENCENO="+employeeid+"");	
				
				
				 pstmt=con.prepareStatement(qry.toString());
					rs = pstmt.executeQuery();
					System.out.println(pstmt.toString());
					  
					
					boolean flag=false;
					al.add("<tr><th>EmployeeID</th><th>Gross</th><th>Effective Date</th><th>Name</th><th>Value</th></tr>");
					int count=1;
					while(rs.next()){
						if(rs.getInt("CTC")>1500000)
						{
							if(count==1)
							{
								al.add(" <tr><td rowspan='"+rs.getString(1)+"'>"+rs.getString("EmployeeID")+"</td><td rowspan='"+rs.getString(1)+"'>"+rs.getString("Gross")+"</td><td rowspan='"+rs.getString(1)+"'>"+rs.getString("EffectiveDate")+"</td><td>"+rs.getString("compoid")+"</td><td style='text-align:right'>"+rs.getString("componentvalue")+"</td></tr>");
							}
							else{
								al.add("<tr><td>"+rs.getString("compoid")+"</td><td style='text-align:right';>"+rs.getString("componentvalue")+"</td></tr>");
							}
							flag=true;
						}
						count++;
					}
					
					if(flag)
					{
						out.println(al.toString().replace("[", "").replace("]", "").replace(",", "").replaceAll("\\s+$", ""));
					}
					else
					{
						out.println("102");
					}
				     				
			}
			else if(type.equalsIgnoreCase("DisplayComponents")){
					System.out.println("pageHit");
					try{
					StringBuffer qry = new StringBuffer();
					
					qry.append(" SELECT COMPONENTID,NAME FROM TEST.TBL_NEW_COMPONENTS WHERE STATUS=1001 ");
				
					
					 pstmt=con.prepareStatement(qry.toString());
						rs = pstmt.executeQuery();
						System.out.println(pstmt.toString());
						
						String comma="~";
						
						
						al1.add("<tr><th>chk</th><th>Name</th><th>Value</th></tr>");
						
						
						while(rs.next()){
							
							
							//al.add(rs.getString(2)+"#"+rs.getString(1))	;
							
							al1.add("<tr><td><input type='checkbox' name='FM' id='"+rs.getString(1)+"' value='"+rs.getString(1)+"'  onclick='ComponentCheck(this)'></td><td>"+rs.getString(2)+"</td><td><input type='text' name='FMVALUE'  alt='"+rs.getString(2)+"' id='"+rs.getString(1)+"_B'"
									+ " onkeypress='return isNumber(event)'  disabled></td></tr>");
						
						}
						
								}catch(Exception e){
						
					}
					
					out.println(al1.toString().replace("[", "").replace("]", "").replace(",", "").replaceAll("\\s+$", ""));
					///System.out.println(al);
				 
			}
			
			
			
			else if(type.equalsIgnoreCase("insert_fuel")){
				
				
				
				String fmvalues=request.getParameter("fmvalues");
				
				//System.out.println(fmvalues);
				
				
				 
				 StringBuffer qry = new StringBuffer();
				
				qry.append(" SELECT A.EMPLOYEESEQUENCENO 'EmployeeID',A.EMPLOYEEID ID,b.tid CTCID,C.GROSS as gross,IFNULL(D.COMPONENTID,'') compoid,IFNULL(D.COMPONENTVALUE,'0') FuelMaintenance,DATE_FORMAT(C.EFFECTIVEDATE,'%d-%m-%Y')  EffectiveDate ");
				qry.append(" FROM  ");
				qry.append(" HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A  ");
				qry.append(" LEFT JOIN (  ");
				qry.append(" SELECT EMPLOYEEID,MAX(CTCTRANSACTIONID) TID FROM HCLHRM_PROD.TBL_EMPLOYEE_CTC GROUP BY EMPLOYEEID  ");
				qry.append(" ) B ON A.EMPLOYEEID=B.EMPLOYEEID  ");
				qry.append(" LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_CTC C ON B.TID=C.CTCTRANSACTIONID  ");
				qry.append(" LEFT JOIN test.fuel_maintenance D ON A.EMPLOYEEID=D.EMPLOYEEID AND B.TID=D.CTCTRANSACTIONID" );
				qry.append(" WHERE A.EMPLOYEESEQUENCENO="+employeeid+" ");	
				
				try
				{
					
				 
				 pstmt=con.prepareStatement(qry.toString());
					rs = pstmt.executeQuery();
					String ctcid=null,id=null;
					String compoid=null;
					String Date=null;
				
					while(rs.next()){
					
						 id=rs.getString("ID");
						 ctcid=rs.getString("CTCID");
						 Date=rs.getString("EffectiveDate");
						 compoid=rs.getString("compoid");
						 //System.out.println(ctcid+"::"+fuel+"::"+Date);
					}
					
					
					//System.out.println(ctcid+"CTCid");
					StringBuffer CheckQry = new StringBuffer();
					
					CheckQry.append(" SELECT COUNT(*) FROM TEST.FUEL_MAINTENANCE WHERE ");
					CheckQry.append(" EMPLOYEEID IN (SELECT EMPLOYEEID FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO="+employeeid+") GROUP BY EMPLOYEEID");
					
					 pstmt=con.prepareStatement(CheckQry.toString());
					 rs = pstmt.executeQuery();
					 int CheckCount=0;
					 
					 if(rs.next()){
						 
						 CheckCount=rs.getInt(1);
						 
					 }
					 
			
				if(CheckCount>0){
				
					System.out.println("BEEEEEE");
					StringBuffer InsertHistory=new StringBuffer();
					
					InsertHistory.append(" INSERT INTO TEST.TBL_FUEL_MAINTENANCE_HISTORY (CTCTRANSACTIONID, EMPLOYEEID, COMPONENTID, COMPONENTVALUE, EFFECTIVEDATE, STATUS, ACTIONDATE) ");
					InsertHistory.append("	SELECT * FROM TEST.FUEL_MAINTENANCE ");
					InsertHistory.append("	WHERE EMPLOYEEID IN (SELECT EMPLOYEEID FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE EMPLOYEESEQUENCENO=?) ");
					InsertHistory.append("	AND CTCTRANSACTIONID=? ");
					
					pstmt=con.prepareStatement(InsertHistory.toString());
					pstmt.setString(1, employeeid);
					pstmt.setString(2, ctcid);
					int j=0;
					j=pstmt.executeUpdate();
					
					
					StringBuffer qry2 = new StringBuffer();
					
					qry2.append(" INSERT INTO test.fuel_maintenance (CTCTRANSACTIONID, EMPLOYEEID, COMPONENTID, COMPONENTVALUE, EFFECTIVEDATE) ");
					qry2.append(" VALUES (?,?,?,?,DATE_FORMAT(STR_TO_DATE(?,'%d-%m-%Y'),'%Y-%m-%d')) ON DUPLICATE KEY UPDATE  COMPONENTID=?,COMPONENTVALUE=?,EFFECTIVEDATE=DATE_FORMAT(STR_TO_DATE(?,'%d-%m-%Y'),'%Y-%m-%d')");
					
					pstmt=con.prepareStatement(qry2.toString());
					 
					for(int i=0;i<fmvalues.split(",").length;i++)
					{
						 
						 pstmt.setString(1, ctcid);
						 pstmt.setString(2, id);
						 pstmt.setString(3,fmvalues.split(",")[i].split("~")[0]);
						 pstmt.setString(4,fmvalues.split(",")[i].split("~")[1]);
						 pstmt.setString(5,Date);
						 pstmt.setString(6,fmvalues.split(",")[i].split("~")[0]);
						 pstmt.setString(7,fmvalues.split(",")[i].split("~")[1] );
						 pstmt.setString(8,Date);
						// System.out.println(pstmt);
						 
						 pstmt.addBatch();
					}
					 
					 int i[];
					 i=pstmt.executeBatch();
					 
					 if(j>0 && i.length>0)
					 {
						 con.commit();
						 out.println("1");
					 }else{
						 con.rollback();					
					 }
					 
				}else{
					
					System.out.println("HENNNNNNNNN");
					StringBuffer qry2 = new StringBuffer();
					
					qry2.append(" INSERT INTO test.fuel_maintenance (CTCTRANSACTIONID, EMPLOYEEID, COMPONENTID, COMPONENTVALUE, EFFECTIVEDATE) ");
					qry2.append(" VALUES (?,?,?,?,DATE_FORMAT(STR_TO_DATE(?,'%d-%m-%Y'),'%Y-%m-%d')) ");
					
					pstmt=con.prepareStatement(qry2.toString());
					 
					for(int i=0;i<fmvalues.split(",").length;i++)
					{
						 
						 pstmt.setString(1, ctcid);
						 pstmt.setString(2, id);
						 pstmt.setString(3,fmvalues.split(",")[i].split("~")[0]);
						 pstmt.setString(4,fmvalues.split(",")[i].split("~")[1]);
						 pstmt.setString(5,Date);
						 /*	 pstmt.setString(6,fmvalues.split(",")[i].split("~")[0]);
						 pstmt.setString(7,fmvalues.split(",")[i].split("~")[1] );
						 pstmt.setString(8,Date);*/
						// System.out.println(pstmt);
						 
						 pstmt.addBatch();
					}
					 
					 int i[];
					 i=pstmt.executeBatch();
					 
					 if(i.length>0)
					 {
						 con.commit();
						 out.println("1");
					 }else{
						 con.rollback();					
					 }
					
				}
					 
				}catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				      out.println("2");
				  }catch(Exception e){
					System.out.println(e);
				}
				
				
				
			}

			}catch(Exception e){
				e.printStackTrace();
			}
			 
		}else{
			//out.println("<a href=\"upload.jsp\">Go to JSP form</a>");
			out.print("2");
		}
	}


	

}
