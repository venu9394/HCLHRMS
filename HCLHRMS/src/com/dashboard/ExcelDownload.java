package com.dashboard;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dashboard.dao.ExcelDao;
import com.hclhrm.util.Util;

public class ExcelDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		con = Util.getConnection();
		RequestDispatcher rd=null;
		
		
		
		
		
		String type=request.getParameter("type");
		String name=request.getParameter("name");
		
  String LOGINBY=request.getParameter("LOGINBY"); 
  
  
 /* String busid=request.getParameter("busid");
		  System.out.println("hhhhhhhhhhh"+busid);*/
		  System.out.println("PRASAD"+LOGINBY);
		
		
	/*	System.out.println(type+"<1>"+name);*/
		String downloadfile=null;
    	String pattern = "dd-MM-yyyy HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
    	
    	String  path =  "C:/PdfFiles";
		File theDir = new File(""+path.concat("\\Certificate")+"("+date+")");
		
		System.out.println(theDir.toString());
		
		String filename=""+theDir.toString()+"".concat("/Employee_Pending_Reports.csv");
		
		

		if (!theDir.exists()) {
			theDir.mkdir();
			
			 
		}
		

		ExcelDao excel;
		try {
			excel = new ExcelDao(LOGINBY);
			downloadfile=excel.Excel(filename,type,name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	
		
		//System.out.println("d:"+downloadfile);
		 
        File directory = new File(theDir.toString());
		
        FileInputStream inStream = new FileInputStream(filename);
        
        String[] files = directory.list();

		System.out.println("f:"+files);
		if (files != null && files.length > 0) {


			//byte[] zip = zipFiles(directory, files);


			//System.out.println("1::::::::::");
			//ServletOutputStream sos = response.getOutputStream();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=Employee_Pending_Reports.csv");

			   OutputStream outStream = response.getOutputStream();
	         
		        byte[] buffer = new byte[4096 * 1000];
		        int bytesRead = -1;
		         
		        while ((bytesRead = inStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }
		         
		        inStream.close();
		        outStream.close();    
		        
			/*sos.write(zip);
			sos.flush();*/
		}

		 
}
	
	
	  private byte[] zipFiles(File directory, String[] files) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream zos = new ZipOutputStream(baos);
			byte bytes[] = new byte[4096*10000];
			FileInputStream fis=null;
			for (String fileName : files) {
				try {

					fis = new FileInputStream(directory.getPath()+ "/" + fileName);
					BufferedInputStream bis = new BufferedInputStream(fis);
					zos.putNextEntry(new ZipEntry(fileName));
					int bytesRead;
					while ((bytesRead = bis.read(bytes)) != -1) {
						zos.write(bytes, 0, bytesRead);
					}
					zos.closeEntry();
				}catch(Exception ert){
					ert.printStackTrace();
				}
			}
			zos.flush();
			baos.flush();
			zos.close();
			baos.close();
			return baos.toByteArray();
		}   
}