package com.hhclhrm.services;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.hclhrm.util.Util;
import com.mysql.jdbc.Statement;
//@WebServlet("")
public class ConnectionRouting extends HttpServlet {
	    
	    private DataSource dataSource;
	    private Connection connection;
	    private Statement statement;
	    boolean ConnFlag=true;
	    String Divert_Page=null;
	public ConnectionRouting() {
        super();
     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session=request.getSession();
	 
	   System.out.println("LOGIN Servlet Invoked...!");
	   java.sql.Connection conn=null;
	   DataSource dataSource=null;
	   String Reason=null;
	   
	  String GlobalMsg=null; 
	  String RoutingPage=(String)request.getParameter("Routing");
	  String BU=(String)request.getParameter("BU");
	  String ProcessedBy=(String)request.getParameter("Pby");
	  String LOGINBY=(String)request.getParameter("LOGINBY");
	  
	  request.setAttribute("Routing", RoutingPage);
	  request.setAttribute("BU", BU);
	  request.setAttribute("Pby", ProcessedBy);
	  request.setAttribute("LOGINBY", LOGINBY);
	  
	  
	  session.setAttribute("Routing", RoutingPage);
	  session.setAttribute("BU", BU);
	  session.setAttribute("Pby", ProcessedBy);
	  session.setAttribute("LOGINBY", LOGINBY);
	  
	  System.out.println("RoutingPage::"+RoutingPage);
	  /* DataSource_Cls ConnObj=null;
		try {
			 ConnObj=new DataSource_Cls();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			//conn =dataSource.getConnection();
			conn=ConnObj.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	 try {
           	Context initContext = new InitialContext();
           	Context envContext = (Context) initContext.lookup("java:comp/env");
           	DataSource ds = (DataSource) envContext.lookup("jdbc/HHCL_DESK");
           	conn = ds.getConnection();
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
	  
	 /*  conn = Util.getConnection();
	   System.out.println("Before Login Connection Status:: " +conn);*/
	   try{
		      session.removeAttribute("Routing");
			  session.removeAttribute("BU");
			  session.removeAttribute("Pby");
			  session.removeAttribute("LOGINBY");
		   }catch(Exception Sessionerr){
			   
			   Sessionerr.printStackTrace();
		   }
	  /* try {
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(ClassNotFoundException ex) {
		   System.out.println("Error: unable to load driver class!");
		}catch(IllegalAccessException ex1) {
		   System.out.println("Error: access problem while loading!");
		}catch(InstantiationException ex2) {
		   System.out.println("Error: unable to instantiate driver!");
		   System.exit(3);
		}catch(Exception er){
	         System.out.println("AT LOGIN"+er);
	     }
	   	try{
	   		
	   		String URL = "jdbc:mysql://192.168.30.105:3306/";
	   		String USER = "hcluser";
	   		String PASS = "hcluser!23";
	   		conn = DriverManager.getConnection(URL, USER, PASS);
	   		
	   	}catch(Exception EDF){
	   		System.out.println("AT LOGIN PAGE::"+EDF);
	   	}*/
	   if(conn!=null){
		   
		   session.setAttribute("ConnectionObj", (java.sql.Connection)conn);
		   
	   }else{
		   
	   }
		
	   //java.sql.Connection conpool=(Connection) context.getAttribute("dataSource");
	   
	   // System.out.println("conpool :::" +conpool);
	   
	  /*  DataSource dataSource=null; 
	
	 Context initContext = null;
	 if(conn==null){
		 context.removeAttribute("dataSource");
		try {
			initContext = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Context envContext = null;
		try {
			envContext = (Context)initContext.lookup("java:/comp/env");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 dataSource = (DataSource)envContext.lookup("jdbc/HHCL_DESK");
			 context.setAttribute("dataSource", dataSource);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }*/
		
	  /* try{
	   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
	    if (ipAddress == null) {  
	 	   ipAddress = request.getRemoteAddr();  
	    }
	    
	    
	    
	    
	    LOGGER.info("This is a logging statement from log4j");
	    LOGGER.info("Client System Login IP::->"+ipAddress);
	   }catch(Exception loginerr){
		   
		   loginerr.printStackTrace();
	   }*/
	   
	   
	  // ServletContext c = getServletContext();
	   //ResourceBundle bundle_info =(ResourceBundle)(c.getAttribute("bundle"));
	    //c.setAttribute("Venu","Venu");
	     //String ipAddress = request.getHeader("X-FORWARDED-FOR");  
	    //if (ipAddress == null) {  
	 	 //  ipAddress = request.getRemoteAddr();  
	    //}
	    
	    //LOGGER.info("This is a logging statement from log4j");
	    //LOGGER.info("Client System Login IP::->"+ipAddress);
	    
	    
       /* Date creationTime = new Date(session.getCreationTime() );
        Date lastAccessed = new Date(session.getLastAccessedTime());
        
        System.out.println(creationTime +"~~~"+lastAccessed);
        
	   try {
		   dataSource=(DataSource)(c.getAttribute("dataSource"));
           connection=dataSource.getConnection();
         
         System.out.println("dataSource  " +dataSource);
         System.out.println("connection  " +connection);
         */
         //  Divert_Page=bundle_info.getString("HHCL_DESK_LOGIN_SP");
        /* } catch (Exception e) {
       	   ConnFlag=false;
       	   Divert_Page=bundle_info.getString("HHCL_DESK_LOGIN_FP");
           e.printStackTrace();
       }*/
	 
	   System.out.println("Login Success Page Rout to Authentication::" +conn);
	   if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("LOP")){
	   request.getRequestDispatcher("LOP_Servicess").forward(request, response);
	   }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("LOPINSERT")){
		   request.getRequestDispatcher("LOP_Servicess").forward(request, response);
	  }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("BANKACC")){
		   request.getRequestDispatcher("Bank_services").forward(request, response);
	  }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("PFUAN")){
			   request.getRequestDispatcher("PFUAN_services").forward(request, response);
	  }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("EMPPROFDETAILS")){
		   request.getRequestDispatcher("Emp_prof_services").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("EMPREG")){
    	  
    	  
		   request.getRequestDispatcher("Employee_Regi_services").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("REPORTS")){
    	  
    	  
		   request.getRequestDispatcher("Employee_Reports_services").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("DASHBOARD")){
    	  
    	  
    	  request.getRequestDispatcher("EmployeePendingDetails").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("DASHBOARD")){
    	  
    	  
    	  request.getRequestDispatcher("DOWNS").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("LWP")){
    	  
    	  System.out.println("LWP");
    	  //Arrear_load_options
    	  request.getRequestDispatcher("Arrear_load_options").forward(request, response);
    	 // request.getRequestDispatcher("Lwp_emp_fetching").forward(request, response);
      }else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("LETTERS")){
    	  
    	  System.out.println("LETTERS");
    	  //Arrear_load_options
    	  session.setAttribute("Routing", RoutingPage);
    	  session.setAttribute("BU", BU);
    	  session.setAttribute("Pby", ProcessedBy);
    	  session.setAttribute("LOGINBY", LOGINBY);
    	  request.getRequestDispatcher("letters/Letters.jsp").forward(request, response);
    	  
    	  //request.getRequestDispatcher("Arrear_load_options").forward(request, response);
    	 // request.getRequestDispatcher("Lwp_emp_fetching").forward(request, response);
      }
      else if(conn!=null &&  RoutingPage!=null && RoutingPage.equalsIgnoreCase("ALLOWANCES")){
    	  
    	  RoutingPage = request.getParameter("Routing");
          String empid = request.getParameter("empid");
          String empname = request.getParameter("empname");
          LOGINBY = request.getParameter("LOGINBY");
          
          request.setAttribute("Routing", RoutingPage);
          request.setAttribute("empid", empid);
          request.setAttribute("empname", empname);
          session.setAttribute("LOGINBY", LOGINBY);
          request.setAttribute("LOGINBY", LOGINBY);
    	  
    	  request.getRequestDispatcher("allowances/BasicComponent.jsp").forward(request, response);
      }
	   
	   else{
		   
		   request.getRequestDispatcher("/connError.jsp").forward(request, response);
	   }
	   
	   /*try{
		    conn.close();
	   }catch(Exception err){
		   
	   }*/
	   
	   
	}
}
