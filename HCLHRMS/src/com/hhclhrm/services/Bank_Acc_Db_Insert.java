package com.hhclhrm.services;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class LOP_Db_insertion
 */
public class Bank_Acc_Db_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bank_Acc_Db_Insert() {
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
		java.sql.PreparedStatement preparedStatement2=null;
		com.hhclhrm.globaldb.GetDbData DataObj=new com.hhclhrm.globaldb.GetDbData();
		JSONArray values;
		values = new JSONArray();
		JSONObject jason = new JSONObject();
		JSONObject LOPLIST = new JSONObject();
		 HttpSession session=request.getSession();
		String empty[]=null;
	    ArrayList emp_lop_list=new ArrayList();
	    StringBuffer employe_list=new StringBuffer();
	    
	    Map BankN_Acc=new HashMap();
	    
	      String RoutingPage=(String)session.getAttribute("Routing");
		  String BU=(String)session.getAttribute("BU");
		  String ProcessedBy=(String)session.getAttribute("Pby");
		  String LOGINBY=(String)session.getAttribute("LOGINBY");
		  
		  request.setAttribute("Routing", RoutingPage);
		  request.setAttribute("BU", BU);
		  request.setAttribute("Pby", ProcessedBy);
		  request.setAttribute("LOGINBY", LOGINBY);
		  request.setAttribute("GlobalMsg","Bank Accounts Update Faild please contact admin.");
	   
		try {
			//conn =dataSource.getConnection();
			conn=(java.sql.Connection)session.getAttribute("ConnectionObj");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		
		 
		  
		  
    //*******************************Execute Queries *******************************
		  StringBuffer InserQuery=new StringBuffer();
		  StringBuffer InserQuery_history=new StringBuffer();
		  StringBuffer InserQuery_IFC=new StringBuffer();
		  
		  StringBuffer InserQuery_IFC_history=new StringBuffer();
		  
		 /* InserQuery.append(" insert into hclhrm_prod.tbl_employee_lop(LOPTRANSACTIONID, BUSINESSUNITID, EMPLOYEEID, LOPCOUNT,STATUS, EMPLOYEESTATUS,CREATEDBY) ");
		  InserQuery.append(" values(?,?,?,?,'C',1001,?) ON DUPLICATE KEY UPDATE LOPCOUNT=?  ");
		  */
		  InserQuery.append(" insert into hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL(EMPLOYEEID,BANKID,ACCOUNTNO,MODIFIEDBY) ");
		  InserQuery.append(" values(?,?,?,?) ON DUPLICATE KEY UPDATE BANKID=?, ACCOUNTNO=? ");

		  
		  
		  //SELECT * FROM hclhrm_prod_others.tbl_emp_bank_ifc t;
		 // SNO, EMPID, BANKID, BANKIFC, BANKACC, STATUS, LUPDATE;
		  
		  
		  InserQuery_IFC.append(" insert into hclhrm_prod_others.tbl_emp_bank_ifc(EMPID, BANKID, BANKIFC, BANKACC) ");
		  InserQuery_IFC.append(" values(?,?,?,?) ON DUPLICATE KEY UPDATE BANKID=?, BANKIFC=?,BANKACC=? ");
		  
		  
	//******************************************************************************
		String[] Data_Acc=(String[])request.getParameterValues("ChkBox");
		
		int EmployeeSelectedSize=Data_Acc.length;
		
		System.out.println("Data Length "+EmployeeSelectedSize);
		
		for(int i=0 ;i<Data_Acc.length;i++){
			System.out.println("Data :"+Data_Acc[i]);
			String ParamBankName=request.getParameter(Data_Acc[i]+"_BN");
		    String ParamBankAcc=request.getParameter(Data_Acc[i]+"_BA");
		    String ParamBankIFC=request.getParameter(Data_Acc[i]+"_IFC");
			
		    BankN_Acc.put(Data_Acc[i]+"_BN",ParamBankName);
		    BankN_Acc.put(Data_Acc[i]+"_BA",ParamBankAcc);
		    BankN_Acc.put(Data_Acc[i]+"_IFC",ParamBankIFC);
		    emp_lop_list.add(Data_Acc[i]);
		    employe_list.append(Data_Acc[i]);
		    employe_list.append(',');
		    System.out.println(ParamBankAcc +"::"+ParamBankName + "Data :"+Data_Acc[i]);
			
		    }
		 employe_list.append("0");
		 
		  InserQuery_history.append(" insert into hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL_history(EMPLOYEEID, PFNO, ESINO, PFUAN, INSURANCENO, BANKID, ACCOUNTNO,FILEID, CREATEDBY, DATECREATED, MODIFIEDBY, DATEMODIFIED,VERIFIEDBY, DATEVERIFIED, LOGID, LUPDATE) ");
		  InserQuery_history.append(" select * from  hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL where employeeid in("+employe_list.toString()+")  and employeeid!=0 ");
		  
		  
		  
		  InserQuery_IFC_history.append(" insert into hclhrm_prod_others.tbl_emp_bank_ifc_history(EMPID, BANKID, BANKIFC, BANKACC,STATUS) ");
		  InserQuery_IFC_history.append(" select EMPID, BANKID, BANKIFC, BANKACC,STATUS from  hclhrm_prod_others.tbl_emp_bank_ifc where EMPID in("+employe_list.toString()+")  and EMPID!=0 ");
		
		  
		  
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
		int[] affectedRecords_ifc={0};
		int addCont=0,ElseCont=0;
		
		/*while(empitr.hasNext()){  
			System.out.println(empitr.next());  
		
		}*/ 
		
		
		
	try{		
			
		
		    try {
		    	
		    	conn.setAutoCommit(false);
		    	
		    	preparedStatement =conn.prepareStatement(InserQuery_history.toString());
			    preparedStatement.addBatch();
			    preparedStatement.executeBatch();
			    
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

           try {
		    	
		    	
		    	
		    	preparedStatement =conn.prepareStatement(InserQuery_IFC_history.toString());
			    preparedStatement.addBatch();
			    preparedStatement.executeBatch();
			    
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    preparedStatement =conn.prepareStatement(InserQuery.toString());
		    preparedStatement2 =conn.prepareStatement(InserQuery_IFC.toString());
		    
		    
		    while(empitr.hasNext()){
				Param=empitr.next().toString();
				try{
					
					 /* InserQuery.append(" inserted into hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL(EMPLOYEEID,BANKID,ACCOUNTNO,MODIFIEDBY) ");
					  InserQuery.append(" values(?,?,?,?) ON DUPLICATE KEY UPDATE BANKID=? ,ACCOUNTNO=? ");
				*/
					
					/*InserQuery.append(" inserted into hclhrm_prod.TBL_EMPLOYEE_OTHER_DETAIL(EMPLOYEEID,BANKID,ACCOUNTNO,MODIFIEDBY) ");
					  InserQuery.append(" values(?,?,?,?) ON DUPLICATE KEY UPDATE BANKID=? , ACCOUNTNO=? ");
					  */
					  
				addCont++;
				
				System.out.println(Param +"~"+ BankN_Acc.get(Param+"_BA").toString()+"~"+ BankN_Acc.get(Param+"_BN").toString());
				
				preparedStatement.setInt(1, Integer.parseInt(Param));
			    preparedStatement.setInt(2, Integer.parseInt(BankN_Acc.get(Param+"_BN").toString()));
			    preparedStatement.setString(3, BankN_Acc.get(Param+"_BA").toString());
			    preparedStatement.setInt(4, Integer.parseInt(LOGINBY.toString()));
			    preparedStatement.setInt  (5, Integer.parseInt(BankN_Acc.get(Param+"_BN").toString()));
			    preparedStatement.setString  (6, BankN_Acc.get(Param+"_BA").toString());
			    preparedStatement.addBatch();
			   
			  //SELECT * FROM hclhrm_prod_others.tbl_emp_bank_ifc t;
				 // EMPID, BANKID, BANKIFC, BANKACC, STATUS, LUPDATE;
			    
			    
			    preparedStatement2.setInt(1, Integer.parseInt(Param));
			    preparedStatement2.setString(2, BankN_Acc.get(Param+"_BN").toString());
			    preparedStatement2.setString(3, BankN_Acc.get(Param+"_IFC").toString());
			    preparedStatement2.setString(4, BankN_Acc.get(Param+"_BA").toString());
			    
			    preparedStatement2.setString(5, BankN_Acc.get(Param+"_BN").toString());
			    preparedStatement2.setString(6, BankN_Acc.get(Param+"_IFC").toString());
			    preparedStatement2.setString(7, BankN_Acc.get(Param+"_BA").toString());
			    
			    preparedStatement2.addBatch();
			    
				}catch(Exception set){
					
					System.out.println("Exception set::"+ set);
				}
			    
			    
			    //empty=null;
			    
				
		    }
		    System.out.println(addCont +":~addCont~ElseCont~:"+ElseCont);
			
		    affectedRecords = preparedStatement.executeBatch();
		    affectedRecords_ifc=preparedStatement2.executeBatch();
		    System.out.println("affectedRecords"+affectedRecords.length);
             
		       if(affectedRecords.length>0 && affectedRecords_ifc.length>0){
		        conn.commit();
		        }else{
		        	conn.rollback();
		        }
		
				}catch(Exception ERrr){
					
	               System.out.println("Exception ERrr ::"+ERrr);
					
				}finally {
		    if(preparedStatement != null) {
		        try {
					preparedStatement.close();
					preparedStatement2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		
	if(affectedRecords.length>0){
		
		 request.setAttribute("GlobalMsg","Bank account Updated successfully...!");
		
		 request.setAttribute("RecordLen",""+affectedRecords.length+"");
		 
		 request.setAttribute("Record_employee",employe_list);
		 
		
	}else{
		request.setAttribute("GlobalMsg","Bank account  Update Faild please contact system admin.");
	}
	
	 try{
	      session.removeAttribute("Routing");
		  session.removeAttribute("BU");
		  session.removeAttribute("Pby");
		  session.removeAttribute("LOGINBY");
	   }catch(Exception Sessionerr){
		   
		   Sessionerr.printStackTrace();
	   }
		
	    
	    
	    System.out.println("LOP DB INSERTION [RoutingPage] :: "+RoutingPage);
	    
	    request.getRequestDispatcher("Bank_services").forward(request, response);
	    
	}

}
