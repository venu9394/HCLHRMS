package com.hclhrm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.hclhrm.util.Util;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String type=request.getParameter("type");
	     System.out.println(type);
		 String employeecode=request.getParameter("Employeecode");
		 String Division=request.getParameter("Division");
		 
		 
		// System.out.println(employeecode+""+Division);
		 
		 
		    ResultSet rs = null;
			Connection con = null;
			//Connection con1 = null;
			PreparedStatement pstmt = null;
			
			//String division=request.getParameter("Division1");
			
			
			 
			 
			 
			 
			 String searchFristName=request.getParameter("searchFristName");
			 
			 
			 String employementtype=request.getParameter("employementtype");
			 
			 String ActiveStatus=request.getParameter("ActiveStatus");
			 
			 String doj=request.getParameter("doj");
			 
			 String Department=request.getParameter("Department");
			// String searchFristName=request.getParameter("searchFristName");
			 
			 HttpSession session=request.getSession();
			 
			// System.out.println(Field2);
			 PrintWriter out=response.getWriter();
			 
			/* try {
					//conn =dataSource.getConnection();
					con=(java.sql.Connection)session.getAttribute("ConnectionObj");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
				}*/
			 con = Util.getConnection();

			JSONArray jsonArray=new JSONArray();
			
			
			
		//	String sql=null;
			
			StringBuffer Buffer=new StringBuffer();
			
			     //InputStream is = null;
		        Properties prop = null;
		        
		        try {
		            prop = new Properties();
		            
		            prop.load(getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
		            
		           
		            Buffer.append(prop.getProperty("sql1"));
		            
		            
		           
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			
			
			
			
			try
			{
				
		 
		
		if(type.equalsIgnoreCase("search1")){
			
			 
	//		System.out.println("employeeId::");
			Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=?");
			 
			pstmt = con.prepareStatement(Buffer.toString());
			 
			pstmt.setString(1, Division);
			pstmt.setString(2, employeecode);
			 
			rs = pstmt.executeQuery();
			
			//System.out.println("1--->"+pstmt);
	     }
		
		 
		else if(type.equalsIgnoreCase("search2"))
		{
			
	//		System.out.println("employeeId::1");
			
			Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?)");
			
			  // sql=prop.getProperty("sql2");
			   //System.out.println("employeeId::"+sql);
			pstmt = con.prepareStatement(Buffer.toString());
			
			pstmt.setString(1, Division);
			pstmt.setString(2, "%" +searchFristName +"%");
			pstmt.setString(3, "%"+searchFristName +"%");
			 //  System.out.println("employeeId::"+pstmt);
			 rs = pstmt.executeQuery();
		 
			
		}
		 else if(type.equalsIgnoreCase("search3")){
			
			Buffer.append("A.COMPANYID=? AND  A.EMPLOYMENTTYPEID=?");
			
			
			System.out.println("employeeId::2");
			pstmt = con.prepareStatement(Buffer.toString());
			
			pstmt.setString(1, Division);
			pstmt.setString(2, employementtype);
		//	System.out.println("employeeId::"+pstmt);
			 rs = pstmt.executeQuery();
			
		}
		 else if(type.equalsIgnoreCase("search4")){
		
			System.out.println("employeeId::3");
			
			Buffer.append("A.COMPANYID=? AND  A.STATUS=?");
			
			pstmt = con.prepareStatement(Buffer.toString());
			
			pstmt.setString(1, Division);
			pstmt.setString(2, ActiveStatus);
			//System.out.println("employeeId::"+pstmt);
			 rs = pstmt.executeQuery();
		}
		
		 else if(type.equalsIgnoreCase("search5")){
				
				System.out.println("employeeId::4");
				
				Buffer.append("A.COMPANYID=? AND  B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);
				pstmt.setString(2, doj);
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search6")){
				
				System.out.println("employeeId::4");
				
				Buffer.append("A.COMPANYID=? AND  C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);
				pstmt.setString(2, Department);
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search7")){
			
			System.out.println("employeeId::5");
			Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?)");
			
			pstmt = con.prepareStatement(Buffer.toString());
			
			pstmt.setString(1, Division);		
			pstmt.setString(2, employeecode);
			pstmt.setString(3, "%" +searchFristName +"%");
			pstmt.setString(4, "%" +searchFristName +"%");
	//		System.out.println("employeeId::"+pstmt);
			 rs = pstmt.executeQuery();
		}
		 
		 else if(type.equalsIgnoreCase("search8")){
				
				System.out.println("employeeId::6");
				Buffer.append("A.COMPANYID=? AND a.EMPLOYEESEQUENCENO=? AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, doj);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search9")){
				
				System.out.println("employeeId::7");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND A.EMPLOYMENTTYPEID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, employementtype);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search10")){
				
				System.out.println("employeeId::10");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, Department);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search11")){
				
				System.out.println("employeeId::11");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, ActiveStatus);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search12")){
				
				System.out.println("employeeId::12");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, doj);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search13")){
				
				System.out.println("employeeId::13");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND A.EMPLOYMENTTYPEID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, employementtype);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search14")){
				
				System.out.println("employeeId::14");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, Department);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search15")){
				
				System.out.println("employeeId::15");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, ActiveStatus);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search16")){
				
				System.out.println("employeeId::16");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, doj);
				pstmt.setString(3, employementtype);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search17")){
				
				System.out.println("employeeId::17");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=? AND C.DEPARTMENTID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, doj);
				pstmt.setString(3, Department);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search18")){
				
				System.out.println("employeeId::18");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=? AND A.STATUS=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, doj);
				pstmt.setString(3, ActiveStatus);
				
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search19")){
				
				System.out.println("employeeId::19");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employementtype);
				pstmt.setString(3, Department);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search20")){
				
				System.out.println("employeeId::20");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=? AND A.STATUS=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employementtype);
				pstmt.setString(3, ActiveStatus);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search21")){
				
				System.out.println("employeeId::21");
				Buffer.append("A.COMPANYID=? AND C.DEPARTMENTID=? AND A.STATUS=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, Department);
				pstmt.setString(3, ActiveStatus);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search22")){
				
				System.out.println("employeeId::22");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode );
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search23")){
				
				System.out.println("employeeId::23");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode );
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				pstmt.setString(6, employementtype);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search24")){
				
				System.out.println("employeeId::24");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode );
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				pstmt.setString(6, employementtype);
				pstmt.setString(7, Department);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		
		 else if(type.equalsIgnoreCase("search25")){
				
				System.out.println("employeeId::25");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=? AND A.STATUS=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode );
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				pstmt.setString(6, employementtype);
				pstmt.setString(7, Department);
				pstmt.setString(8, ActiveStatus);
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search26")){
				
				System.out.println("employeeId::26");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, doj);
				pstmt.setString(5, employementtype);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search27")){
				
				System.out.println("employeeId::27");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=?  ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, doj);
				pstmt.setString(5, employementtype);
				pstmt.setString(6, Department);
								
				//System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search28")){
				
				System.out.println("employeeId::28");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND  B.DATEOFJOIN=? AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=? AND A.STATUS=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, doj);
				pstmt.setString(5, employementtype);
				pstmt.setString(6, Department);
				pstmt.setString(7, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search29")){
				
				System.out.println("employeeId::29");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				
				pstmt.setString(4, employementtype);
				pstmt.setString(5, Department);
				
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search30")){
				
				System.out.println("employeeId::30");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND A.EMPLOYMENTTYPEID=? AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				
				pstmt.setString(4, employementtype);
				pstmt.setString(5, Department);
				pstmt.setString(6, ActiveStatus);
				
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search31")){
				
				System.out.println("employeeId::31");
				Buffer.append("A.COMPANYID=? AND ( a.firstname like ? || a.lastname like ?) AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, "%"+searchFristName+"%");
				pstmt.setString(3, "%"+searchFristName+"%");
				
				
				pstmt.setString(4, Department);
				pstmt.setString(5, ActiveStatus);
				
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search32")){
				
				System.out.println("employeeId::32");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=?  AND C.DEPARTMENTID=? AND A.EMPLOYMENTTYPEID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, doj);
				pstmt.setString(3, Department);
				pstmt.setString(4, employementtype);
				
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search33")){
				
				System.out.println("employeeId::33");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=?  AND C.DEPARTMENTID=? AND A.EMPLOYMENTTYPEID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, doj);
				pstmt.setString(3, Department);
				pstmt.setString(4, employementtype);
				pstmt.setString(5, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search34")){
				
				System.out.println("employeeId::34");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=?  AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, doj);
				pstmt.setString(3, Department);
				pstmt.setString(4, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search35")){
				
				System.out.println("employeeId::35");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, Department);
				pstmt.setString(4, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search36")){
				
				System.out.println("employeeId::36");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND B.DATEOFJOIN=? AND A.EMPLOYEESEQUENCENO=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, doj);
				pstmt.setString(4, employeecode);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search37")){
				
				System.out.println("employeeId::37");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND B.DATEOFJOIN=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, doj);
				pstmt.setString(4, employeecode);
				pstmt.setString(5, Department);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search38")){
				
				System.out.println("employeeId::38");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND B.DATEOFJOIN=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, doj);
				pstmt.setString(4, employeecode);
				pstmt.setString(5, Department);
				pstmt.setString(6, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search39")){
				
				System.out.println("employeeId::39");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, Department);
				pstmt.setString(5, ActiveStatus);
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search40")){
				
				System.out.println("employeeId::40");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, Department);
				
								
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search41")){
				
				System.out.println("employeeId::41");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=?  AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND ( a.firstname like ? || a.lastname like ?)");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				pstmt.setString(2, employementtype);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, Department);
				pstmt.setString(5, "%"+searchFristName+"%");
				pstmt.setString(6, "%"+searchFristName+"%");
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search42")){
				
				System.out.println("employeeId::42");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND B.DATEOFJOIN=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				
				pstmt.setString(2, employeecode);
				pstmt.setString(3, Department);
				pstmt.setString(4, doj);
				
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search43")){
				
				System.out.println("employeeId::43");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND B.DATEOFJOIN=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				
				pstmt.setString(2, employeecode);
				pstmt.setString(3, Department);
				pstmt.setString(4, doj);
				pstmt.setString(5, ActiveStatus);
				
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search44")){
				
				System.out.println("employeeId::44");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				
				pstmt.setString(2, employeecode);
				pstmt.setString(3, Department);
				
				pstmt.setString(4, ActiveStatus);
				
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search45")){
				
				System.out.println("employeeId::45");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND A.EMPLOYMENTTYPEID=?  AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				
				pstmt.setString(2, employeecode);
				pstmt.setString(3, employementtype);
				
				pstmt.setString(4, ActiveStatus);
				
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search46")){
				
				System.out.println("employeeId::46");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND C.DEPARTMENTID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				
				
				pstmt.setString(2, employeecode);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, Department);
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search47")){
				
				System.out.println("employeeId::47");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=? AND ( a.firstname like ? || a.lastname like ?) AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employementtype);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, ActiveStatus);
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search48")){
				
				System.out.println("employeeId::48");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYMENTTYPEID=? AND ( a.firstname like ? || a.lastname like ?) AND A.STATUS=? AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employementtype);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, ActiveStatus);
				pstmt.setString(6, doj);
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search49")){
				
				System.out.println("employeeId::49");
				Buffer.append("A.COMPANYID=? AND C.DEPARTMENTID=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, Department);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
								
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search50")){
				
				System.out.println("employeeId::50");
				Buffer.append("A.COMPANYID=? AND C.DEPARTMENTID=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, Department);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				pstmt.setString(6, ActiveStatus);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search51")){
				
				System.out.println("employeeId::51");
				Buffer.append("A.COMPANYID=? AND B.DATEOFJOIN=? AND A.STATUS=? AND A.EMPLOYMENTTYPEID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, doj);
				pstmt.setString(3, ActiveStatus);
				pstmt.setString(4, employementtype);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search52")){
				
				System.out.println("employeeId::52");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND A.EMPLOYMENTTYPEID=? AND ( a.firstname like ? || a.lastname like ?) AND C.DEPARTMENTID=? AND A.EMPLOYEESEQUENCENO=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, employementtype);
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, "%"+searchFristName+"%");
				pstmt.setString(6, Department);
				pstmt.setString(7, employeecode);
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search53")){
				
				System.out.println("employeeId::53");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND A.EMPLOYMENTTYPEID=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=? AND A.EMPLOYEESEQUENCENO=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, employementtype);
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, "%"+searchFristName+"%");
				pstmt.setString(6, doj);
				pstmt.setString(7, employeecode);
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search54")){
				
				System.out.println("employeeId::54");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, doj);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		 else if(type.equalsIgnoreCase("search55")){
				
				System.out.println("employeeId::55");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND A.EMPLOYEESEQUENCENO=? AND A.EMPLOYMENTTYPEID=? AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, employementtype);
				pstmt.setString(5, doj);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search56")){
				
				System.out.println("employeeId::56");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, "%"+searchFristName+"%");
				pstmt.setString(6, doj);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search57")){
				
				System.out.println("employeeId::57");
				Buffer.append("A.COMPANYID=? AND A.STATUS=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND B.DATEOFJOIN=? AND  C.DEPARTMENTID=? ");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, ActiveStatus);
				pstmt.setString(3, employeecode);
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, "%"+searchFristName+"%");
				pstmt.setString(6, doj);
				pstmt.setString(7, Department);
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search58")){
				
				System.out.println("employeeId::58");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND A.EMPLOYMENTTYPEID=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, employementtype);
				
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search59")){
				
				System.out.println("employeeId::59");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND C.DEPARTMENTID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, Department);
				pstmt.setString(6, ActiveStatus);
				
				
		//		System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		 else if(type.equalsIgnoreCase("search60")){
				
				System.out.println("employeeId::60");
				Buffer.append("A.COMPANYID=? AND A.EMPLOYEESEQUENCENO=? AND ( a.firstname like ? || a.lastname like ?) AND A.EMPLOYMENTTYPEID=? AND A.STATUS=?");
				
				pstmt = con.prepareStatement(Buffer.toString());
				
				pstmt.setString(1, Division);		
				pstmt.setString(2, employeecode);
				pstmt.setString(3, "%"+searchFristName+"%");
				pstmt.setString(4, "%"+searchFristName+"%");
				pstmt.setString(5, employementtype);
				pstmt.setString(6, ActiveStatus);
				
				
			//	System.out.println("employeeId::"+pstmt);
				 rs = pstmt.executeQuery();
			}
		
		if (!rs.isBeforeFirst()) {
		      
			  JSONObject obj=new JSONObject();
				 
			     obj.put("SNO","NODATA");
				 obj.put("EMPLOYEESEQUENCENO", "NODATA");
				 obj.put("CALLNAME","NODATA");
				// obj.put("LASTNAME", "NODATA");
				 obj.put("GENDER", "NODATA");
				 obj.put("DATEOFBIRTH", "NODATA");
				 obj.put("DATEOFJOIN", "NODATA");
				 obj.put("EMPLOYMENTTYPEID","NODATA");
				 obj.put("DEPARTMENT", "NODATA");
				 obj.put("DESINGNATION", "NODATA");
				 obj.put("STATUS", "NODATA");
				 obj.put("EDIT", "NODATA");
				 jsonArray.add(obj);
		 }
		int Count=1;
		while(rs.next())
		{
			
			
			
			//System.out.println(rs.getString(1)+""+rs.getString(2));
           JSONObject obj=new JSONObject();
			 
           
           obj.put("SNO", Count);
			 obj.put("EMPLOYEESEQUENCENO", rs.getString("EMPLOYEESEQUENCENO"));
			/* obj.put("FIRSTNAME", rs.getString("FIRSTNAME"));
			 obj.put("LASTNAME", rs.getString("LASTNAME"));*/
			 obj.put("CALLNAME", rs.getString("CALLNAME"));
			 obj.put("GENDER", rs.getString("GENDER"));
			 obj.put("DATEOFBIRTH", rs.getString("DATEOFBIRTH"));
			 obj.put("DATEOFJOIN", rs.getString("DATEOFJOIN"));
			 obj.put("EMPLOYMENTTYPEID", rs.getString("EMPLOYMENTTYPEID"));
			 obj.put("DEPARTMENT", rs.getString("DEPARTMENT"));
			 obj.put("DESINGNATION", rs.getString("DESINGNATION"));
			 obj.put("STATUS", rs.getString("STATUS"));
			 
			// System.out.println(""+rs.getString("EMPLOYMENTTYPEID"));
			 String Data=rs.getString("EMPLOYEESEQUENCENO")+"#"+rs.getString("FIRSTNAME")+"#"+rs.getString("LASTNAME")+"#"
					 +rs.getString("GenderId")+"#"+ rs.getString("DATEOFBIRTH")+"#"+
					 rs.getString("DATEOFJOIN")+"#"+ rs.getString("EMPLOYMENTID")+
					 "#"+ rs.getString("DEPARTMENT")+"#"+rs.getString("DESINGNATION")+"#"+rs.getString("STATUS")+
					 "#"+rs.getString("COMPANYID")+"#"+rs.getString("COSTCENTERID")+"#"+rs.getString("TITLE")+"#"+rs.getString("STATE_CODE")+
					 "#"+rs.getString("CALLNAME")+"#"+rs.getString("ACTIVESTATUS")+"#"+rs.getString("EMPLOYEEID")+"#"+rs.getString("EMAIL")+"#"+rs.getString("MOBILE")+"#"+rs.getString("SALESDISTICT")+"#"+rs.getString("SALESOFFFICE")+"#"+rs.getString("SALESGROUP");
			 obj.put("EDIT", "<input type='button' id='"+Data+"' value='Edit' onclick='Edit(this)' class='btn btn-success12 btn-edit three-btn'>");
			 
		//	 System.out.println(""+rs.getString("EMPLOYMENTTYPEID"));
		//	 System.out.println(""+rs.getString("EMPLOYMENTID"));
			 jsonArray.add(obj);
			 
			 Count++;
		}

		
		
		
		
		
		
		
		
		/*else if(employeecode==null&&type.equalsIgnoreCase("Employmenttype"))
		{
			
			
			String r="SELECT A.EMPLOYEESEQUENCENO as EMPLOYEESEQUENCENO,A.FIRSTNAME,A.LASTNAME,"
					+ "F.NAME GENDER,DATE_FORMAT(A.DATEOFBIRTH,'%d-%m-%Y') DATEOFBIRTH,"
					+ "DATE_FORMAT(B.DATEOFJOIN,'%d-%m-%Y') DATEOFJOIN,G.NAME EMPLOYMENTTYPEID,"
					+ "D.NAME DEPARTMENT,E.NAME DESINGNATION,H.NAME STATUS,A.COMPANYID,A.EMPLOYMENTTYPEID as EMPLOYMENTID,A.GENDER As GenderId ,A.COSTCENTERID,A.TITLE AS TITLE,I.STATE_CODE "
					+ "FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE B ON A.EMPLOYEEID=B.EMPLOYEEID "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS C ON A.EMPLOYEEID=C.EMPLOYEEID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON C.DEPARTMENTID=D.DEPARTMENTID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION E ON C.DESIGNATIONID=E.DESIGNATIONID "
					+ "LEFT JOIN HCLADM_PROD.TBL_GENDER F ON A.GENDER=F.GENDER "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYMENT_TYPES G ON A.EMPLOYMENTTYPEID=G.EMPLOYMENTTYPEID "
					+ "LEFT JOIN hcladm_prod.tbl_status_codes H ON A.STATUS=H.STATUS "
					+ " LEFT JOIN test.empl_states I ON A.EMPLOYEEID=I.EMPLOYEEID WHERE A.COMPANYID='"+Field2+"' AND  A.EMPLOYMENTTYPEID='"+Field+"'";

			
			
			pstmt = con.prepareStatement(r);
			 
			
			 rs = pstmt.executeQuery();
		 System.out.println("employeeId::"+r);
			

		 
		 
			if (!rs.isBeforeFirst()) {
			      
				  JSONObject obj=new JSONObject();
					 
				  obj.put("SNO","NODATA");
					 obj.put("EMPLOYEESEQUENCENO", "NODATA");
					 obj.put("FIRSTNAME","NODATA");
					 obj.put("LASTNAME", "NODATA");
					 obj.put("GENDER", "NODATA");
					 obj.put("DATEOFBIRTH", "NODATA");
					 obj.put("DATEOFJOIN", "NODATA");
					 obj.put("EMPLOYMENTTYPEID","NODATA");
					 obj.put("DEPARTMENT", "NODATA");
					 obj.put("DESINGNATION", "NODATA");
					 obj.put("STATUS", "NODATA");
					 obj.put("EDIT", "NODATA");
					 jsonArray.add(obj);
			 }
			int Count=1;
			while(rs.next())
			{
				
				
				
				//System.out.println(rs.getString(1)+""+rs.getString(2));
                 JSONObject obj=new JSONObject();
				 
                 
                 obj.put("SNO", Count);
				 obj.put("EMPLOYEESEQUENCENO", rs.getString("EMPLOYEESEQUENCENO"));
				 obj.put("FIRSTNAME", rs.getString("FIRSTNAME"));
				 obj.put("LASTNAME", rs.getString("LASTNAME"));
				 obj.put("GENDER", rs.getString("GENDER"));
				 obj.put("DATEOFBIRTH", rs.getString("DATEOFBIRTH"));
				 obj.put("DATEOFJOIN", rs.getString("DATEOFJOIN"));
				 obj.put("EMPLOYMENTTYPEID", rs.getString("EMPLOYMENTTYPEID"));
				 obj.put("DEPARTMENT", rs.getString("DEPARTMENT"));
				 obj.put("DESINGNATION", rs.getString("DESINGNATION"));
				 obj.put("STATUS", rs.getString("STATUS"));
				 
				 
				 String Data=rs.getString("EMPLOYEESEQUENCENO")+"#"+rs.getString("FIRSTNAME")+"#"+rs.getString("LASTNAME")+"#"
						 +rs.getString("GenderId")+"#"+ rs.getString("DATEOFBIRTH")+"#"+
						 rs.getString("DATEOFJOIN")+"#"+ rs.getString("EMPLOYMENTTYPEID")+
						 "#"+ rs.getString("DEPARTMENT")+"#"+rs.getString("DESINGNATION")+"#"+rs.getString("STATUS")+
						 "#"+rs.getString("COMPANYID")+"#"+rs.getString("COSTCENTERID")+"#"+rs.getString("TITLE")+"#"+rs.getString("STATE_CODE")+"";
				 obj.put("EDIT", "<input type='button' id='"+Data+"' value='Edit' onclick='Edit(this)' class='btn btn-success12 three-btn'>");
				 
				 jsonArray.add(obj);
				 
				 Count++;
			}

			 
			
			
			
		}
		
		else if(employeecode==null&&type.equalsIgnoreCase("searchStatus"))
		{
			
			
			String r="SELECT A.EMPLOYEESEQUENCENO as EMPLOYEESEQUENCENO,A.FIRSTNAME,A.LASTNAME,"
					+ "F.NAME GENDER,DATE_FORMAT(A.DATEOFBIRTH,'%d-%m-%Y') DATEOFBIRTH,"
					+ "DATE_FORMAT(B.DATEOFJOIN,'%d-%m-%Y') DATEOFJOIN,G.NAME EMPLOYMENTTYPEID,"
					+ "D.NAME DEPARTMENT,E.NAME DESINGNATION,H.NAME STATUS,A.COMPANYID,A.EMPLOYMENTTYPEID as EMPLOYMENTID,A.GENDER As GenderId ,A.COSTCENTERID,A.TITLE AS TITLE,I.STATE_CODE "
					+ "FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE B ON A.EMPLOYEEID=B.EMPLOYEEID "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS C ON A.EMPLOYEEID=C.EMPLOYEEID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON C.DEPARTMENTID=D.DEPARTMENTID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION E ON C.DESIGNATIONID=E.DESIGNATIONID "
					+ "LEFT JOIN HCLADM_PROD.TBL_GENDER F ON A.GENDER=F.GENDER "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYMENT_TYPES G ON A.EMPLOYMENTTYPEID=G.EMPLOYMENTTYPEID "
					+ "LEFT JOIN hcladm_prod.tbl_status_codes H ON A.STATUS=H.STATUS "
					+ " LEFT JOIN test.empl_states I ON A.EMPLOYEEID=I.EMPLOYEEID WHERE A.COMPANYID='"+Field2+"' AND  A.STATUS='"+Field+"'";

			
			
			pstmt = con.prepareStatement(r);
			 
			
			 rs = pstmt.executeQuery();
		 System.out.println("employeeId::"+r);
			

		 
		 
			if (!rs.isBeforeFirst()) {
			      
				  JSONObject obj=new JSONObject();
					 
				  
				  
				  
				  
				  
				     obj.put("SNO","NODATA");
					 obj.put("EMPLOYEESEQUENCENO", "NODATA");
					 obj.put("FIRSTNAME","NODATA");
					 obj.put("LASTNAME", "NODATA");
					 obj.put("GENDER", "NODATA");
					 obj.put("DATEOFBIRTH", "NODATA");
					 obj.put("DATEOFJOIN", "NODATA");
					 obj.put("EMPLOYMENTTYPEID","NODATA");
					 obj.put("DEPARTMENT", "NODATA");
					 obj.put("DESINGNATION", "NODATA");
					 obj.put("STATUS", "NODATA");
					 obj.put("EDIT", "NODATA");
					 jsonArray.add(obj);
					 
					 
			     
			 }
			int Count=1;
			while(rs.next())
			{
				
				
				
				//System.out.println(rs.getString(1)+""+rs.getString(2));
                 JSONObject obj=new JSONObject();
				 
                 
                 obj.put("SNO", Count);
				 obj.put("EMPLOYEESEQUENCENO", rs.getString("EMPLOYEESEQUENCENO"));
				 obj.put("FIRSTNAME", rs.getString("FIRSTNAME"));
				 obj.put("LASTNAME", rs.getString("LASTNAME"));
				 obj.put("GENDER", rs.getString("GENDER"));
				 obj.put("DATEOFBIRTH", rs.getString("DATEOFBIRTH"));
				 obj.put("DATEOFJOIN", rs.getString("DATEOFJOIN"));
				 obj.put("EMPLOYMENTTYPEID", rs.getString("EMPLOYMENTTYPEID"));
				 obj.put("DEPARTMENT", rs.getString("DEPARTMENT"));
				 obj.put("DESINGNATION", rs.getString("DESINGNATION"));
				 obj.put("STATUS", rs.getString("STATUS"));
				 
				 String Data=rs.getString("EMPLOYEESEQUENCENO")+"#"+rs.getString("FIRSTNAME")+"#"+rs.getString("LASTNAME")+"#"
						 +rs.getString("GenderId")+"#"+ rs.getString("DATEOFBIRTH")+"#"+
						 rs.getString("DATEOFJOIN")+"#"+ rs.getString("EMPLOYMENTTYPEID")+
						 "#"+ rs.getString("DEPARTMENT")+"#"+rs.getString("DESINGNATION")+"#"+rs.getString("STATUS")+
						 "#"+rs.getString("COMPANYID")+"#"+rs.getString("COSTCENTERID")+"#"+rs.getString("TITLE")+"#"+rs.getString("STATE_CODE")+"";
				 obj.put("EDIT", "<input type='button' id='"+Data+"' value='Edit' onclick='Edit(this)'>");
				 
				 jsonArray.add(obj);
				 
				 Count++;
			}
	
		}
		
		
		else if(employeecode!=null&&type.equalsIgnoreCase("FIRST/LASTNAME"))
		{
			
			
			String r="SELECT A.EMPLOYEESEQUENCENO as EMPLOYEESEQUENCENO,A.FIRSTNAME,A.LASTNAME,"
					+ "F.NAME GENDER,DATE_FORMAT(A.DATEOFBIRTH,'%d-%m-%Y') DATEOFBIRTH,"
					+ "DATE_FORMAT(B.DATEOFJOIN,'%d-%m-%Y') DATEOFJOIN,G.NAME EMPLOYMENTTYPEID,"
					+ "D.NAME DEPARTMENT,E.NAME DESINGNATION,H.NAME STATUS,A.COMPANYID,A.EMPLOYMENTTYPEID as EMPLOYMENTID,A.GENDER As GenderId ,A.COSTCENTERID,A.TITLE AS TITLE,I.STATE_CODE "
					+ "FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE B ON A.EMPLOYEEID=B.EMPLOYEEID "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS C ON A.EMPLOYEEID=C.EMPLOYEEID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON C.DEPARTMENTID=D.DEPARTMENTID "
					+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION E ON C.DESIGNATIONID=E.DESIGNATIONID "
					+ "LEFT JOIN HCLADM_PROD.TBL_GENDER F ON A.GENDER=F.GENDER "
					+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYMENT_TYPES G ON A.EMPLOYMENTTYPEID=G.EMPLOYMENTTYPEID "
					+ "LEFT JOIN hcladm_prod.tbl_status_codes H ON A.STATUS=H.STATUS "
					+ " LEFT JOIN test.empl_states I ON A.EMPLOYEEID=I.EMPLOYEEID WHERE A.COMPANYID='"+Field2+"' AND ( a.firstname like '%"+type+"%' || a.lastname like '%"+type+"%') and a.EMPLOYEESEQUENCENO='"+employeecode+"'";

			
			
			pstmt = con.prepareStatement(r);
			 
			
			 rs = pstmt.executeQuery();
		 System.out.println("employeeId::"+r);
			

		 
		 
			if (!rs.isBeforeFirst()) {
			      
				  JSONObject obj=new JSONObject();
					 
				  obj.put("SNO","NODATA");
					 obj.put("EMPLOYEESEQUENCENO", "NODATA");
					 obj.put("FIRSTNAME","NODATA");
					 obj.put("LASTNAME", "NODATA");
					 obj.put("GENDER", "NODATA");
					 obj.put("DATEOFBIRTH", "NODATA");
					 obj.put("DATEOFJOIN", "NODATA");
					 obj.put("EMPLOYMENTTYPEID","NODATA");
					 obj.put("DEPARTMENT", "NODATA");
					 obj.put("DESINGNATION", "NODATA");
					 obj.put("STATUS", "NODATA");
					 obj.put("EDIT", "NODATA");
					 jsonArray.add(obj);
			     
			 }
			int Count=1;
			while(rs.next())
			{
				
				
				
				//System.out.println(rs.getString(1)+""+rs.getString(2));
                 JSONObject obj=new JSONObject();
				 
                 
                 obj.put("SNO", Count);
				 obj.put("EMPLOYEESEQUENCENO", rs.getString("EMPLOYEESEQUENCENO"));
				 obj.put("FIRSTNAME", rs.getString("FIRSTNAME"));
				 obj.put("LASTNAME", rs.getString("LASTNAME"));
				 obj.put("GENDER", rs.getString("GENDER"));
				 obj.put("DATEOFBIRTH", rs.getString("DATEOFBIRTH"));
				 obj.put("DATEOFJOIN", rs.getString("DATEOFJOIN"));
				 obj.put("EMPLOYMENTTYPEID", rs.getString("EMPLOYMENTTYPEID"));
				 obj.put("DEPARTMENT", rs.getString("DEPARTMENT"));
				 obj.put("DESINGNATION", rs.getString("DESINGNATION"));
				 obj.put("STATUS", rs.getString("STATUS"));
				 
				 String Data=rs.getString("EMPLOYEESEQUENCENO")+"#"+rs.getString("FIRSTNAME")+"#"+rs.getString("LASTNAME")+"#"
						 +rs.getString("GenderId")+"#"+ rs.getString("DATEOFBIRTH")+"#"+
						 rs.getString("DATEOFJOIN")+"#"+ rs.getString("EMPLOYMENTTYPEID")+
						 "#"+ rs.getString("DEPARTMENT")+"#"+rs.getString("DESINGNATION")+"#"+rs.getString("STATUS")+
						 "#"+rs.getString("COMPANYID")+"#"+rs.getString("COSTCENTERID")+"#"+rs.getString("TITLE")+"#"+rs.getString("STATE_CODE")+"";
				 obj.put("EDIT", "<input type='button' id='"+Data+"' value='Edit' onclick='Edit(this)'>");
				 
				 jsonArray.add(obj);
				 
				 Count++;
			}

			 
			
			
			
		}*/
		
		     Gson gson = new Gson();
			String messages = gson.toJson(jsonArray);
			
			
			//System.out.println("messages from Servlet Search::" +messages);
			out.println(messages);
		
			}catch(Exception e)
			{
				   System.out.println(e);
			}
			
			
			finally
			{
				
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
