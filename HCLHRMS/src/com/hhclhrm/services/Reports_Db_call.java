package com.hhclhrm.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class LOP_Db_insertion
 */
public class Reports_Db_call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reports_Db_call() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet Res=null;
		DataSource dataSource=null;
		java.sql.Connection conn=null;
		java.sql.PreparedStatement preparedStatement=null;
		com.hhclhrm.globaldb.GetDbData DataObj=new com.hhclhrm.globaldb.GetDbData();
		JSONArray values;
		values = new JSONArray();
		JSONObject jason = new JSONObject();
		JSONObject LOPLIST = new JSONObject();
		 HttpSession session=request.getSession();
		String empty[]=null;
	    ArrayList emp_lop_list=new ArrayList();	
	    
	      String RoutingPage=(String)session.getAttribute("Routing");
		  String BU=(String)session.getAttribute("BU");
		  String ProcessedBy=(String)session.getAttribute("Pby");
		  String LOGINBY=(String)session.getAttribute("LOGINBY");
		  
		  request.setAttribute("Routing", RoutingPage);
		  request.setAttribute("BU", BU);
		  request.setAttribute("Pby", ProcessedBy);
		  request.setAttribute("LOGINBY", LOGINBY);
		  request.setAttribute("GlobalMsg","LOP Updated Faild please contact admin.");
	   
		try {
			//conn =dataSource.getConnection();
			conn=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		 
		  
		  
    //*******************************Execute Queries *******************************
		/*  StringBuffer InserQuery=new StringBuffer();
		  
		  InserQuery.append(" insert into hclhrm_prod.tbl_employee_lop(LOPTRANSACTIONID, BUSINESSUNITID, EMPLOYEEID, LOPCOUNT,STATUS, EMPLOYEESTATUS,CREATEDBY) ");
		  InserQuery.append(" values(?,?,?,?,'C',1001,?) ON DUPLICATE KEY UPDATE LOPCOUNT=?  ");
		  
		  */

		
	//******************************************************************************
		String[] Params=request.getParameterValues("chxbox");
		String payperiod=request.getParameter("payperiod");
		
		String ReportType=request.getParameter("ReportType");
		StringBuffer BuUnits=new StringBuffer();
		
		System.out.println(payperiod+"~~~"+ReportType);
		
		for(int i=0;i<Params.length;i++){
			
			BuUnits.append(Params[i]);
			
			
			BuUnits.append(",");
			
		}
		
		try{
		BuUnits.deleteCharAt(BuUnits.length()-1);
		}catch(Exception err){
			System.out.println("deleteCharAt:::"+err);
		}
		//BuUnits.append("200");
		
		System.out.println("BuUnits::"+BuUnits.toString());
		//Enumeration EMPLOYEE_SEQ_NUM=request.getParameterNames();
		String Param=null,Param_lopval="0";
		
	
		/*while(EMPLOYEE_SEQ_NUM.hasMoreElements()){
			Param_lopval="0";
			Param=EMPLOYEE_SEQ_NUM.nextElement().toString();
			if(!Param.equalsIgnoreCase("Routing")){
			Param_lopval=request.getParameter(Param).toString();
			String Final_Str=Param.concat("_$_").concat(Param_lopval);
			emp_lop_list.add(Final_Str);
			}
		}*/
		
		ListIterator empitr=emp_lop_list.listIterator();	
		int[] affectedRecords={0};
		
		int addCont=0,ElseCont=0;
		
		/*while(empitr.hasNext()){  
			System.out.println(empitr.next());  
		
		}*/ 
		
		
	/*	
	try{		
			
		
		    try {
		    	
		    	conn.setAutoCommit(false);
		    	
		    	preparedStatement =conn.prepareStatement("update hclhrm_prod.tbl_employee_lop set LOPCOUNT=0 where LOPTRANSACTIONID="+ProcessedBy+" and BUSINESSUNITID="+BU+"");
			    preparedStatement.addBatch();
			    preparedStatement.executeBatch();
			    
				preparedStatement =conn.prepareStatement(InserQuery.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    
		    
		    while(EMPLOYEE_SEQ_NUM.hasMoreElements()){
				Param_lopval="0";
				Param=EMPLOYEE_SEQ_NUM.nextElement().toString();
				if(!Param.equalsIgnoreCase("Routing")){
				Param_lopval=request.getParameter(Param).toString();
				
				//System.out.println(Param +"~~~" +Param_lopval);
				//String Final_Str=Param.concat("_$_").concat(Param_lopval);
				//emp_lop_list.add(Final_Str);
				
			//}
				
				try{
					
			   //System.out.println(ProcessedBy +"~" +BU+"~"+Param+"~"+Param_lopval+"~"+LOGINBY);
				if(Float.parseFloat(Param_lopval.toString())>0){
					
					addCont++;
				preparedStatement.setInt(1, Integer.parseInt(ProcessedBy.toString()));
			    preparedStatement.setInt(2, Integer.parseInt(BU));
			    preparedStatement.setInt  (3, Integer.parseInt(Param.toString()));
			    preparedStatement.setFloat  (4, Float.parseFloat(Param_lopval.toString()));
			    preparedStatement.setInt  (5, Integer.parseInt(LOGINBY.toString()));
			    
			    preparedStatement.setFloat  (6, Float.parseFloat(Param_lopval.toString()));
			    
			    preparedStatement.addBatch();
			   } else{
				   
				   ElseCont++;
				   // if close
			   }
			    
				}catch(Exception set){
					
					System.out.println("Exception set::"+ set);
				}
			    
			    
			    //empty=null;
			    
				}
		    }
		    System.out.println(addCont +":~addCont~ElseCont~:"+ElseCont);
			if(addCont==0 && ElseCont>0){
				
				
				
				
				
				
				preparedStatement.setInt(1, Integer.parseInt(ProcessedBy.toString()));
			    preparedStatement.setInt(2, Integer.parseInt(BU));
			    preparedStatement.setInt  (3, 0);
			    preparedStatement.setFloat  (4, 0);
			    preparedStatement.setInt  (5, Integer.parseInt(LOGINBY.toString()));
			    
			    preparedStatement.setFloat  (6, 0);
			    
			    preparedStatement.addBatch();
			    
			    preparedStatement =conn.prepareStatement("update hclhrm_prod.tbl_employee_lop set LOPCOUNT=0 where LOPTRANSACTIONID=201704 and BUSINESSUNITID=9");
			    preparedStatement.addBatch();
			    
			    
			    
				
			}
		    affectedRecords = preparedStatement.executeBatch();
		    
		    System.out.println("affectedRecords"+affectedRecords.length);
             
		       if(affectedRecords.length>0){
		        conn.commit();
		        }
		
				}catch(Exception ERrr){
					
	               System.out.println("Exception ERrr ::"+ERrr);
					
				}finally {
		    if(preparedStatement != null) {
		        try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		
	if(affectedRecords.length>0){
		
		 request.setAttribute("GlobalMsg","LOP Updated successfully...!");
		
		 request.setAttribute("RecordLen",""+affectedRecords.length+"");
		 
		 
		
	}else{
		request.setAttribute("GlobalMsg","LOP Updated Faild please contact system admin.");
	}
	
	 try{
	      session.removeAttribute("Routing");
		  session.removeAttribute("BU");
		  session.removeAttribute("Pby");
		  session.removeAttribute("LOGINBY");
	   }catch(Exception Sessionerr){
		   
		   Sessionerr.printStackTrace();
	   }
		*/
		ServletOutputStream responseOutputStream = response.getOutputStream();
		int bytes=0;
		
	
		responseOutputStream.write(bytes);
	    System.out.println("Reports DB INSERTION [RoutingPage] :: "+RoutingPage);
	    
	   // request.getRequestDispatcher("LOP_Servicess").forward(request, response);
	    
	}

}
