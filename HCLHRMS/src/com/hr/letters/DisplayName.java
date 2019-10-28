package com.hr.letters;

import com.hclhrm.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DisplayName extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
    doPost(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.setHeader("Pragma", "no-cache");
    
    PrintWriter pw = response.getWriter();
    Connection con = null;
    PreparedStatement pstmt = null;
    String employeeid = request.getParameter("employeeid");
    String bu = request.getParameter("AllDivisions");
    String lettertype = request.getParameter("lettertype");
    String division = request.getParameter("division");
    String name = "0";
    int flag = 0;
    int flag1 = 0;
    int flag2 = 0;
    con = Util.getConnection();
    String q = null;
    ResultSet rs = null;
    String probationperiod = null;
    String offerdate = null;
    String relievingperiod = null;
    


    if (con != null) {
      try {
        q = "SELECT count(*) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY WHERE trim(EMPLOYEESEQUENCENO)=trim(" + employeeid + ") limit 1";
        pstmt = con.prepareStatement(q);
        rs = pstmt.executeQuery();
        if (rs.next()) {
          flag = rs.getInt(1);
        }
      }
      catch (Exception e) {
        flag = 102;
        e.printStackTrace();
      }
      rs = null;
      
      q=null;
      try
      {
        if (flag != 1) {
        	
        }
        if (lettertype.equalsIgnoreCase("AppointmentLetter"))
        {
          q ="SELECT A.CALLNAME,COUNT(*),COUNT(APP.EMPLOYEEID),IFNULL(PROBATION,'0'),date_format(IFNULL(app.OFFERDATE,'0'),'%d-%m-%Y'),IFNULL(RELIEVING,'0') FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS B ON A.EMPLOYEEID=B.EMPLOYEEID LEFT JOIN HCLADM_PROD.TBL_DESIGNATION C ON B.DESIGNATIONID=C.DESIGNATIONID LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON B.DEPARTMENTID=D.DEPARTMENTID JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE E ON A.EMPLOYEEID=E.EMPLOYEEID LEFT JOIN test.appointmentletter APP ON A.EMPLOYEESEQUENCENO=APP.EMPLOYEEID WHERE A.COMPANYID IN (" + bu + ") AND B.DESIGNATIONID!=0 AND B.DEPARTMENTID!=0 " + "and a.employeesequenceno in (" + employeeid + ") AND E.DATEOFJOIN!='0000-00-00'";
        }
       
        else if ((lettertype.equalsIgnoreCase("PromotionLetter")) && (division.equalsIgnoreCase("Select")))
        {
        	q = "SELECT A.CALLNAME,COUNT(*),COUNT(PRO.EMPLOYEEID),IFNULL(PRO.OLDCTC,''),IFNULL(PRO.NEWCTC,''),IFNULL(PRO.STATUS,'') FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_TRANSFERS T ON A.EMPLOYEEID=T.EMPLOYEEID LEFT JOIN TEST.PROMOTIONLETTER PRO ON A.EMPLOYEESEQUENCENO=PRO.EMPLOYEEID WHERE  A.EMPLOYEESEQUENCENO IN (" + employeeid + ") AND A.COMPANYID IN (" + bu + ") GROUP BY A.EMPLOYEEID";
        }
        else if ((lettertype.equalsIgnoreCase("PromotionLetter")) && (!division.equalsIgnoreCase("Select")))
        {

          q ="SELECT A.CALLNAME,COUNT(*),COUNT(PRO.EMPLOYEEID),IFNULL(PRO.OLDCTC,''),IFNULL(PRO.NEWCTC,''),IFNULL(PRO.STATUS,'') FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_TRANSFERS T ON A.EMPLOYEEID=T.EMPLOYEEID LEFT JOIN TEST.PROMOTIONLETTER PRO ON A.EMPLOYEESEQUENCENO=PRO.EMPLOYEEID WHERE AND A.EMPLOYEESEQUENCENO IN (" + employeeid + ") AND A.COMPANYID IN (" + division + ") GROUP BY A.EMPLOYEEID";
        }
        else if (!division.equalsIgnoreCase("Select"))
        {
          q = "SELECT CALLNAME,count(*),count(b.employeeid),IFNULL(b.probation,'0'),date_format(IFNULL(B.OFFERDATE,'0'),'%d-%m-%Y') employeeid,IFNULL(b.relieving,'0') FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY a left join test.appointmentletter b on a.employeesequenceno=b.employeeid WHERE trim(EMPLOYEESEQUENCENO)=trim(" + employeeid + ") " + "AND COMPANYID IN (" + division + ") limit 1";
        }
        else {
          q =   "SELECT CALLNAME,count(*),count(b.employeeid),IFNULL(b.probation,'0'),date_format(IFNULL(B.OFFERDATE,'0'),'%d-%m-%Y') employeeid,IFNULL(b.relieving,'0') FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY a left join test.appointmentletter b on a.employeesequenceno=b.employeeid WHERE trim(EMPLOYEESEQUENCENO)=trim(" + employeeid + ") " + "AND COMPANYID IN (" + bu + ") limit 1";
        }
        
        pstmt = con.prepareStatement(q);
        rs = pstmt.executeQuery();
        if (rs.next()){
        	name = rs.getString(1);
        	flag1 = rs.getInt(2);
        	flag2 = rs.getInt(3);
        	probationperiod = rs.getString(4);
        	offerdate = rs.getString(5);
        	relievingperiod = rs.getString(6);
        }

      }
      catch (Exception e)
      {
        flag = 102;
        e.printStackTrace();
      }
    } else {
      flag = 102;
      flag1 = 102; }
    if (flag == 0) {
    	pw.write("0~EmployeeID Not Exists");
    } 
    else if ((flag1 == 0) && (flag == 1) && (flag2 == 0)) {
    	pw.write("2~EmployeeID Not Belongs to this BU");
    } 
    else if ((flag1 >= 1) && (flag == 1) && (flag2 >= 1)) {
    	pw.write("100~" + name + "~" + lettertype + "~" + probationperiod + "~" + offerdate + "~" + relievingperiod);
    	System.out.println("Mycase");
    } 
    else if ((flag1 >= 1) && (flag == 1) && (flag2 >= 0)) {
    	pw.write("101~" + name + "~" + lettertype + "~" + probationperiod + "~" + offerdate + "~" + relievingperiod);
    } 
    else if ((flag1 == 102) && (flag == 102)) {
    	pw.write("103~Server couldn't be connected. Please Contact Admin!..");
    } 
    else {
    	pw.write("102~Invalid Data.");
    }
  }
}
