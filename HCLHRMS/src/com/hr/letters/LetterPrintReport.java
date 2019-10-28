package com.hr.letters;

import com.hclhrm.util.Util;
import com.hr.letters.source.LettersPrint;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings({"serial","resource","unused"})
public class LetterPrintReport extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doPost(request, response); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		con = Util.getConnection();
		String empid = request.getParameter("PassEmployeeid");
		String finalname = null;
		LettersPrint jsprObj = new LettersPrint();
		String pattern = "dd-MM-yyyy HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		String filetype = request.getParameter("lettertype");
		int empid_length = empid.split(",").length;
		String emp_id = null;
		for (int i = 0; i < empid.split(",").length; i++) {
			emp_id = empid.split(",")[i];
			try {
				finalname = jsprObj.generateReport(emp_id, filetype, con, date, filetype);
			} catch (Exception ER) {
				System.out.println("ER::::" + ER);
			}
		}

		String path = "C:/PdfFiles_letters";
		File theDir = new File(path.concat("\\Certificate") + "(" + date + ")");
		for (int i = 0; i < empid.split(",").length; i++) {
			emp_id = empid.split(",")[i];

			if (empid_length > 1)
			{
				try
				{
					String str1 = LettersPrint.Genratepath(emp_id, filetype, theDir + "\\" + emp_id.concat(new StringBuilder("_").append(date).append(".pdf").toString()));
				} catch (Exception ER) {
					System.out.println("ER::::" + ER);
				}
			}
		}
		File directory = new File(finalname);
		String[] files = directory.list();
		if ((files != null) && (files.length > 0)) {
			byte[] zip;
			if (empid_length > 1)
			{
				zip = zipFiles(directory, files);
				ServletOutputStream sos = response.getOutputStream();
				response.setContentType("application/zip");
				response.setHeader("Content-Disposition", "attachment; filename=\"Download.zip\"");
				sos.write(zip);
				sos.flush();
			}
			else
			{
				try
				{
					String insertpath=LettersPrint.Genratepath(emp_id, filetype,theDir+"\\"+ empid.concat("_"+date+".pdf"));

				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				PrintWriter out = response.getWriter();
				FileInputStream fileInputStream = null;
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + 
						empid.concat(new StringBuilder("_").append(date).append(".pdf").toString()) + "\"");
				fileInputStream = new FileInputStream(theDir + "/" + empid.concat(new StringBuilder("_").append(date).append(".pdf").toString()));
				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
				out.close();
			}
		}
	}
	
	private byte[] zipFiles(File directory, String[] files) throws IOException { ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ZipOutputStream zos = new ZipOutputStream(baos);
	byte[] bytes = new byte[40960000];
	FileInputStream fis = null;
	for (String fileName : files) {
		try {
			fis = new FileInputStream(directory.getPath() + "/" + fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			zos.putNextEntry(new ZipEntry(fileName));
			int bytesRead;
			while ((bytesRead = bis.read(bytes)) != -1) { 
				zos.write(bytes, 0, bytesRead);
			}
			zos.closeEntry();
		} catch (Exception ert) {
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