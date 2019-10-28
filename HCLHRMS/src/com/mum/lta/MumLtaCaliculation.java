package com.mum.lta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MumLtaCaliculation {
      
	Map map=new HashMap();
	ArrayList Caliculate_lt=new ArrayList();
	ArrayList Comman_Payperiods=new ArrayList();
	long total_LTA=0;
	public void dataMin(String dateFrom,String DateTo,String EmployeeID,Connection Conn,ResultSet rs,PreparedStatement pstmt){
		
	   // Map map=new HashMap();
	    StringBuffer BufferMin=new StringBuffer(); 
	    
	    BufferMin.append( " select min(A.transactionduration) As minID, A.businessunitid,A.transactionduration,A.fromdate,A.todate,DATEDIFF(A.todate,A.fromdate)+1 daysdiff ");
		BufferMin.append( "  ,b.employeeid,b.employeesequenceno, DATEDIFF(A.todate,'"+dateFrom+"')+1 ACTDAYS from hclhrm_prod.tbl_employee_primary B ");
		BufferMin.append( " left join hcladm_prod.tbl_transaction_dates A ON a.businessunitid=b.companyid ");
		BufferMin.append( "   where A.transactiontypeid=1 and ");
		BufferMin.append( "  b.employeesequenceno in("+EmployeeID+")  ");
		//BufferMin.append( "  and A.transactionduration>=date_format('"+dateFrom+"','%Y%m%') ");
		BufferMin.append( "  and '"+dateFrom+"' between A.fromdate and A.todate ");
		BufferMin.append( "  group by A.transactionduration ");
 try{ 
	    	pstmt=Conn.prepareStatement(BufferMin.toString());
			rs = pstmt.executeQuery();
		//	System.out.println(pstmt.toString());
			while(rs.next()){
				map.put("MIN_PERIOD", rs.getString("minID"));
				map.put("MIN_FROM", rs.getString("fromdate"));
				map.put("MIN_TO", rs.getString("todate"));
				map.put("MIN_BETDAYS", rs.getString("daysdiff"));
				map.put("MIN_ACTDAYS", rs.getString("ACTDAYS"));
				map.put("MINEMPID", rs.getString("employeeid"));
			}
			
	     }catch(Exception err){
	    	 
	    	 err.printStackTrace();
	     }
	     
	 //    return map;
		
	 }// Main Function
	
public void dataMax(String dateFrom,String DateTo,String EmployeeID,Connection Conn,ResultSet rs,PreparedStatement pstmt){
		
	    //Map map=new HashMap();
	    StringBuffer BufferMin=new StringBuffer(); 
	    
	    BufferMin.append( " select max(A.transactionduration) As minID, A.businessunitid,A.transactionduration,A.fromdate,A.todate,DATEDIFF(A.todate,A.fromdate)+1 daysdiff ");
		BufferMin.append( "  ,b.employeeid,b.employeesequenceno, DATEDIFF('"+DateTo+"',A.fromdate)+1 ACTDAYS from hclhrm_prod.tbl_employee_primary B ");
		BufferMin.append( " left join hcladm_prod.tbl_transaction_dates A ON a.businessunitid=b.companyid ");
		BufferMin.append( "   where A.transactiontypeid=1 and ");
		BufferMin.append( "  b.employeesequenceno in("+EmployeeID+")  ");
		//BufferMin.append( "  and A.transactionduration>=date_format('"+dateFrom+"','%Y%m%') ");
		BufferMin.append( "  and '"+DateTo+"' between A.fromdate and A.todate ");
		BufferMin.append( "  group by A.transactionduration ");
	    
	    
	     try{
	    	 
	    	pstmt=Conn.prepareStatement(BufferMin.toString());
			rs = pstmt.executeQuery();
		//	System.out.println(pstmt.toString());
			
			while(rs.next()){
				map.put("MAX_PERIOD", rs.getString("minID"));
				map.put("MAX_FROM", rs.getString("fromdate"));
				map.put("MAX_TO", rs.getString("todate"));
				map.put("MAX_BETDAYS", rs.getString("daysdiff"));
				map.put("MAX_ACTDAYS", rs.getString("ACTDAYS"));
				map.put("MAXEMPID", rs.getString("employeeid"));
			}
			
	     }catch(Exception err){
	    	 err.printStackTrace();
	     
	     }
	     
	  //   return map;
		
	 }// Main Function

public void dataAllperiods(String dateFrom,String DateTo,String EmployeeID,Connection Conn,ResultSet rs,PreparedStatement pstmt){
	
    //Map map=new HashMap();
    StringBuffer BufferMin=new StringBuffer(); 
    
    String Maxid=map.get("MAX_PERIOD").toString();
    String Minid=map.get("MIN_PERIOD").toString();
    ArrayList list=new ArrayList();
    
    BufferMin.append( " select A.transactionduration As minID, A.businessunitid,A.transactionduration,A.fromdate,A.todate ");
	BufferMin.append( "  ,b.employeeid,b.employeesequenceno from hclhrm_prod.tbl_employee_primary B ");
	BufferMin.append( " left join hcladm_prod.tbl_transaction_dates A ON a.businessunitid=b.companyid ");
	BufferMin.append( "   where A.transactiontypeid=1 and ");
	BufferMin.append( "  b.employeesequenceno in("+EmployeeID+")  ");
	BufferMin.append( "  and A.transactionduration between date_format('"+dateFrom+"','%Y%m%') and date_format('"+DateTo+"','%Y%m%') ");
	BufferMin.append( "  and  A.transactionduration not in("+Maxid+","+Minid+")");
	BufferMin.append( "  group by A.transactionduration ");
    
    
     try{
    	 
    	pstmt=Conn.prepareStatement(BufferMin.toString());
		rs = pstmt.executeQuery();
		System.out.println(pstmt.toString());
		boolean addflg=false;
		while(rs.next()){
			
			list.add(rs.getString("minID"));
			map.put("BOTH_PERIOD_"+rs.getString("minID")+"", rs.getString("minID"));
			map.put("BOTH_FROM_"+rs.getString("minID")+"", rs.getString("fromdate"));
			map.put("BOTH_TO_"+rs.getString("minID")+"", rs.getString("todate"));
			addflg=true;
			
		}
		if(list.size()>0 && addflg){
		map.put("ALLPAYPERIODS", list);
		}
     }catch(Exception err){
    	 err.printStackTrace();
     
     }
     
  //   return map;
	
 }// Main Function
public void Cal_End(Map mpa,String Mode, Connection Conn,ResultSet rs,PreparedStatement pstmt){
	
        StringBuffer BufferMin=new StringBuffer(); 
        Comman_Payperiods.add(mpa.get("MAX_PERIOD"));
		BufferMin.append( " select a.componentvalue,round(a.componentvalue/12) AS LTA from hclhrm_prod.tbl_employee_ctc_details A ");
		BufferMin.append( " join( ");
		BufferMin.append( "  select max(ctctransactionid) maxid from hclhrm_prod.tbl_employee_ctc ");
		BufferMin.append( " where employeeid="+mpa.get("MAXEMPID")+" ");
		BufferMin.append( " and effectivedate<='"+mpa.get("MAX_TO")+"' ");
		BufferMin.append( " )XX ON XX.maxid=A.ctctransactionid ");
		BufferMin.append( " where A.componentid=24 ");
 
     try{
    	 
    	pstmt=Conn.prepareStatement(BufferMin.toString());
		rs = pstmt.executeQuery();
		//System.out.println(pstmt.toString());
		
		while(rs.next()){
			
			double LTAC=Double.parseDouble(rs.getString("LTA").toString());
			       LTAC=LTAC/Double.parseDouble(mpa.get("MAX_BETDAYS").toString());
			       LTAC=LTAC * Double.parseDouble(mpa.get("MAX_ACTDAYS").toString());
			       LTAC=Math.round(LTAC);
			       total_LTA=(long) (total_LTA+LTAC);
			map.put("LTA_"+mpa.get("MAX_PERIOD")+"" ,  LTAC);
			map.put("BASIC_"+mpa.get("MAX_PERIOD")+"" , rs.getString("componentvalue"));
			
			
			/*map.put("BOTH_PERIOD_"+rs.getString("minID")+"", rs.getString("minID"));
			map.put("BOTH_FROM_"+rs.getString("minID")+"", rs.getString("fromdate"));
			map.put("BOTH_TO_"+rs.getString("minID")+"", rs.getString("todate"));*/
			
		}
     }catch(Exception err){
    	 err.printStackTrace();
     }
 }// Main Function
public void Cal_From(Map mpa,String Mode, Connection Conn,ResultSet rs,PreparedStatement pstmt){
	
    StringBuffer BufferMin=new StringBuffer(); 
    Comman_Payperiods.add(mpa.get("MIN_PERIOD"));
	BufferMin.append( " select a.componentvalue,round(a.componentvalue/12) AS LTA from hclhrm_prod.tbl_employee_ctc_details A ");
	BufferMin.append( " join( ");
	BufferMin.append( "  select max(ctctransactionid) maxid from hclhrm_prod.tbl_employee_ctc ");
	BufferMin.append( " where employeeid="+mpa.get("MINEMPID")+" ");
	BufferMin.append( " and effectivedate<='"+mpa.get("MIN_TO")+"' ");
	BufferMin.append( " )XX ON XX.maxid=A.ctctransactionid ");
	BufferMin.append( " where A.componentid=24 ");

 try{
	 
	pstmt=Conn.prepareStatement(BufferMin.toString());
	rs = pstmt.executeQuery();
	System.out.println("CALLFROM DATA"+pstmt.toString());
	
	while(rs.next()){
		
		double LTAC=Double.parseDouble(rs.getString("LTA").toString());
		       LTAC=LTAC/Double.parseDouble(mpa.get("MIN_BETDAYS").toString());
		       LTAC=LTAC * Double.parseDouble(mpa.get("MIN_ACTDAYS").toString());
		       LTAC=Math.round(LTAC);
		       total_LTA=(long) (total_LTA+LTAC);
		map.put("LTA_"+mpa.get("MIN_PERIOD")+"" ,  LTAC);
		map.put("BASIC_"+mpa.get("MIN_PERIOD")+"" , rs.getString("componentvalue"));
		
		
		/*map.put("BOTH_PERIOD_"+rs.getString("minID")+"", rs.getString("minID"));
		map.put("BOTH_FROM_"+rs.getString("minID")+"", rs.getString("fromdate"));
		map.put("BOTH_TO_"+rs.getString("minID")+"", rs.getString("todate"));*/
		
	}
 }catch(Exception err){
	 err.printStackTrace();
 }
}// Main Function

public void AllperiodCal(Map mpa,String Period, Connection Conn,ResultSet rs,PreparedStatement pstmt){
	
    StringBuffer BufferMin=new StringBuffer(); 
    Comman_Payperiods.add(Period);
    
   /* BOTH_TO_201702
    BOTH_PERIOD_201702
    BOTH_TO_201702*/
    
	BufferMin.append( " select a.componentvalue,round(a.componentvalue/12) AS LTA from hclhrm_prod.tbl_employee_ctc_details A ");
	BufferMin.append( " join( ");
	BufferMin.append( "  select max(ctctransactionid) maxid from hclhrm_prod.tbl_employee_ctc ");
	BufferMin.append( " where employeeid="+mpa.get("MINEMPID")+" ");
	BufferMin.append( " and effectivedate<='"+mpa.get("BOTH_TO_"+Period+"")+"' ");
	BufferMin.append( " )XX ON XX.maxid=A.ctctransactionid ");
	BufferMin.append( " where A.componentid=24 ");

 try{
	 
	pstmt=Conn.prepareStatement(BufferMin.toString());
	rs = pstmt.executeQuery();
	System.out.println("CALLFROM DATA"+pstmt.toString());
	
	while(rs.next()){
		
		double LTAC=Double.parseDouble(rs.getString("LTA").toString());
		       LTAC=Math.round(LTAC);
		       total_LTA=(long) (total_LTA+LTAC);
		map.put("LTA_"+Period+"" ,  LTAC);
		map.put("BASIC_"+Period+"" , rs.getString("componentvalue"));

		/*map.put("BOTH_PERIOD_"+rs.getString("minID")+"", rs.getString("minID"));
		map.put("BOTH_FROM_"+rs.getString("minID")+"", rs.getString("fromdate"));
		map.put("BOTH_TO_"+rs.getString("minID")+"", rs.getString("todate"));*/
		
	}
 }catch(Exception err){
	 err.printStackTrace();
 }
}// Main Function
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	//302967  21st dec-2016-dec -mar-2017
	//Map data1=new HashMap();
	//Map Main=new HashMap();
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	Connection Conn=null;
	Conn=com.hclhrm.util.Util.getConnection();
	String dateFrom="2016-12-21" ;
	String DateTo="2017-01-31" ;
	String EmployeeID="302967";
	MumLtaCaliculation Obj=new MumLtaCaliculation();
	try{
	Obj.dataMax(dateFrom, DateTo, EmployeeID, Conn, rs, pstmt);
	System.out.println(Obj.map.toString());
	Obj.dataMin(dateFrom, DateTo, EmployeeID, Conn, rs, pstmt);
	Obj.dataAllperiods(dateFrom, DateTo, EmployeeID, Conn, rs, pstmt);
	Obj.Cal_From(Obj.map ,EmployeeID, Conn, rs, pstmt);
	if(Obj.map.get("MAX_PERIOD")!=null && Obj.map.get("MIN_PERIOD")!=null && !Obj.map.get("MAX_PERIOD").toString().equalsIgnoreCase(""+Obj.map.get("MIN_PERIOD").toString()+""))
	{
	Obj.Cal_End(Obj.map ,EmployeeID, Conn, rs, pstmt);
	}
	if(Obj.map.get("ALLPAYPERIODS")!=null){
	ArrayList ListS=(ArrayList) Obj.map.get("ALLPAYPERIODS");
	Iterator period_list=ListS.iterator();
	while(period_list.hasNext()){
		String Period=period_list.next().toString();
		
		System.out.println("Period::"+Period);
		Obj.AllperiodCal(Obj.map, Period, Conn, rs, pstmt);
		
	 }
	}
	
	System.out.println(Obj.map.toString());
	
	System.out.println("TOTAL_LTA :: "+Obj.total_LTA);
	}catch(Exception err){
		err.printStackTrace();
	}

	}

}
