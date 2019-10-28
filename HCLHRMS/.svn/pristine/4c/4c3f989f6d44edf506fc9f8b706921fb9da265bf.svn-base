package com.hr.letters.source;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import com.hclhrm.util.Util;



public class LettersPrint
{
	public String generateReport(String empid,String filetype,Connection con,String date,String filename) throws SQLException
	{
		String name=null;
		con = Util.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String printFileName=null;
		Map hm=new HashMap();
		//hm.put("empid",empid);
		boolean flag=false;
		 String check=null;
		 String type=null;
		 
		try
		{
			
			int i=1;
			 hm.put("empid",empid);
			 
			 String formatted = String.format("%04d", i);
				hm.put("SNO", formatted);
			 System.out.println("hm-->"+hm);
			 if(filetype.equalsIgnoreCase("AppointmentLetter"))
			 {
				 filename=filetype;
				 flag=true;
				 
				 type=filetype;
                 check=LettersPrint.TransferLetter(empid,type);
			 System.out.println(check);
                 
			 if(check.equalsIgnoreCase("1"))
			 {
				 filename=filetype;
				 flag=true;
			 }
			 else{
				 
				 flag=false;
			 }
				 
			 }else if(filetype.equalsIgnoreCase("OfferLetter")){
				 filename="";
			 }else if(filetype.equalsIgnoreCase("ConfirmationLetter")){
				 System.out.println("ConfirmationLetter");
				 
				 type=filetype;
	             check=LettersPrint.TransferLetter(empid,type);
			 System.out.println(check);
	             
			 if(check.equalsIgnoreCase("1"))
			 {
				 filename=filetype;
				 flag=true;
			 }
			 else{
				 
				 flag=false;
			 }
			 
			 }else if(filetype.equalsIgnoreCase("PromotionLetter")){
				
				 type=filetype;
				 
			 check=LettersPrint.TransferLetter(empid,type);
				 
				 if(check.equalsIgnoreCase("1"))
				 {
					 
					 filename=filetype;
					 flag=true;
				 }
				 else{
					 
					 flag=false;
				 }
				
			 }else if(filetype.equalsIgnoreCase("TransferLetter")){
				 
				 type=filetype;
	                   check=LettersPrint.TransferLetter(empid,type);
				 System.out.println(check);
	                   
				 if(check.equalsIgnoreCase("1"))
				 {
					 filename=filetype;
					 flag=true;
				 }
				 else{
					 
					 flag=false;
				 }
				 
				 
			 }
				 else{
				 
				 System.out.println("NO Report");
				 filename="";
			 }
			 
			 
			 System.out.println(flag+""+filename);
				
			//	hm.put("sno",rs.getString("sno"));
				/*JasperFillManager.fillReportToFile("C:/jasper/induc.jasper/",hm,con);
				printFileName="C:/jasper/induc.jrprint";*/
				
					
					/*	JasperFillManager.fillReportToFile("C:/jasper/induction_report.jasper/",hm,con);
						printFileName="C:/jasper/induction_report.jrprint";*/
				
			 
			 /*if(flag&&type.equalsIgnoreCase("AppointmentLetter")){
				 
				 
				 
				 JasperFillManager.fillReportToFile("C:/HR_Print_Letters/"+filename+".jasper/",hm,con);
				 System.out.println("Done!");

				 printFileName="C:/HR_Print_Letters/"+filename+".jrprint";
			
		
	
	String  path =  "C:/HRLetters_PDF";
	//File theDir = new File(""+path.concat("\\Certificate")+"("+date+")");
	File theDir = new File(path);
	if (!theDir.exists()) {
		theDir.mkdir();
		
	//	 JasperExportManager.exportReportToPdfFile(printFileName, ""+theDir+"\\"+hm.get("empid")+".pdf");
		Exporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(printFileName));
		File exportReportFile = new File(""+theDir+"\\"+hm.get("empid")+".doc");
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
		exporter.exportReport();
		name=theDir.getAbsolutePath();
	}else{
	//	 JasperExportManager.exportReportToPdfFile(printFileName, ""+theDir+"\\"+hm.get("empid")+".pdf");
		Exporter exporter = new JRDocxExporter();
		exporter.setExporterInput(new SimpleExporterInput(printFileName));
		File exportReportFile = new File(""+theDir+"\\"+hm.get("empid")+".doc");
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
		exporter.exportReport();
		name=theDir.getAbsolutePath();
	}
	 }else{*/
				 
			 
						 JasperFillManager.fillReportToFile("C:/PdfFiles_letters/MYREPORTS/"+filename+".jasper/",hm,con);
						 System.out.println("Done!");

						 printFileName="C:/PdfFiles_letters/MYREPORTS/"+filename+".jrprint";
					
				
			
			String  path =  "C:/PdfFiles_letters";
			File theDir = new File(""+path.concat("\\Certificate")+"("+date+")");
			if (!theDir.exists()) {
				theDir.mkdir();
				
				 JasperExportManager.exportReportToPdfFile(printFileName, ""+theDir+"\\"+String.valueOf(hm.get("empid")).concat("_"+date)+".pdf");
			/*	Exporter exporter = new JRDocxExporter();
				exporter.setExporterInput(new SimpleExporterInput(printFileName));
				File exportReportFile = new File(""+theDir+"\\"+hm.get("empid1")+".doc");
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
				exporter.exportReport();*/
				name=theDir.getAbsolutePath();
			}else{
				 JasperExportManager.exportReportToPdfFile(printFileName, ""+theDir+"\\"+String.valueOf(hm.get("empid")).concat("_"+date)+".pdf");
				/*Exporter exporter = new JRDocxExporter();
				exporter.setExporterInput(new SimpleExporterInput(printFileName));
				File exportReportFile = new File(""+theDir+"\\"+hm.get("empid1")+".doc");
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
				exporter.exportReport();*/
				name=theDir.getAbsolutePath();
			}
			 //}
			con.close();
		}
		catch (JRException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return name;
	}
	
	
public static String TransferLetter(String empid,String type) throws SQLException{
		
		String flag="0";
		
		Connection con=null;
		PreparedStatement ps=null;
		
		con=Util.getConnection();
		
		String qry=null;
	if(type.equalsIgnoreCase("TransferLetter")){	
		
		qry="SELECT COUNT(*) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
				+ "LEFT JOIN HCLADM_PROD.TBL_BUSINESSUNIT BU ON A.COMPANYID=BU.BUSINESSUNITID "
				+ "WHERE A.EMPLOYEESEQUENCENO in ("+empid+")";
		
	}else if(type.equalsIgnoreCase("PromotionLetter")){
		
		qry="SELECT IF(COUNT(B.EMPLOYEEID)>=2,1,COUNT(B.EMPLOYEEID)) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
				+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS B ON A.EMPLOYEEID=B.EMPLOYEEID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION DES ON B.DESIGNATIONID=DES.DESIGNATIONID "
				+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS_HISTORY OP ON A.EMPLOYEEID=OP.EMPLOYEEID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION OD ON OP.DESIGNATIONID=OD.DESIGNATIONID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT DEPT ON B.DEPARTMENTID=DEPT.DEPARTMENTID "
				+ "LEFT JOIN HCLADM_PROD.TBL_TITLE TITLE ON A.TITLE=TITLE.TITLE WHERE A.EMPLOYEESEQUENCENO in ("+empid+")";
		
	}else if(type.equalsIgnoreCase("ConfirmationLetter")){
		
		qry="SELECT IF(COUNT(B.EMPLOYEEID)>=2,1,COUNT(B.EMPLOYEEID)) COUNT FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
				+ "JOIN TEST.TBL_EMPLOYEE_CONFIRMATION_DETAILS B ON A.EMPLOYEEID=B.EMPLOYEEID "
				+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS C ON A.EMPLOYEEID=C.EMPLOYEEID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON C.DEPARTMENTID=D.DEPARTMENTID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION E ON C.DESIGNATIONID=E.DESIGNATIONID "
				+ "LEFT JOIN HCLADM_PROD.TBL_TITLE F ON A.TITLE=F.TITLE "
				+ "LEFT JOIN HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY_HISTORY H ON A.EMPLOYEEID=H.EMPLOYEEID "
				+ "WHERE A.EMPLOYEESEQUENCENO in ("+empid+") GROUP BY A.EMPLOYEESEQUENCENO HAVING MAX(B.LUPDATE)";
		
	}else if(type.equalsIgnoreCase("AppointmentLetter")){
		
		qry="SELECT count(*) FROM HCLHRM_PROD.TBL_EMPLOYEE_PRIMARY A "
				+ "JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFESSIONAL_DETAILS B ON A.EMPLOYEEID=B.EMPLOYEEID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DESIGNATION C ON B.DESIGNATIONID=C.DESIGNATIONID "
				+ "LEFT JOIN HCLADM_PROD.TBL_DEPARTMENT D ON B.DEPARTMENTID=D.DEPARTMENTID "
				+ "JOIN HCLHRM_PROD.TBL_EMPLOYEE_PROFILE E ON A.EMPLOYEEID=E.EMPLOYEEID "
				+ "WHERE A.EMPLOYEESEQUENCENO IN ("+empid+") AND B.DESIGNATIONID!=0 AND B.DEPARTMENTID!=0 AND E.DATEOFJOIN!='0000-00-00'";

	}
		System.out.println(""+qry);
		ps=con.prepareStatement(qry);
		 ResultSet rs=ps.executeQuery();
		 
		 if(rs.next())
		 {
			 if(rs.getString(1).equalsIgnoreCase("1"))
				 {
				 flag="1";
				 }
			 else{
				 flag="0";
			 }
		 }
		
		
		return flag;
		 
	 }





   public static String Genratepath(String Employeeid,String lettertype,String path) throws SQLException
   {
	   String Genratepath=null;
	   
	    Connection con=null;
		PreparedStatement ps=null;
		con=Util.getConnection();
		
		String qry="";
		
		qry="INSERT INTO test.lettersdownloadpath (EMPLOYEEID, LETTERTYPE, PATH) VALUES (?,?,?)";
		
		

	 
		ps=con.prepareStatement(qry);
		ps.setString(1, Employeeid);
		ps.setString(2, lettertype);
		ps.setString(3, path);
		
		ps.execute();
	   
	   
	return Genratepath;
	   
   }

	
	
}

