package com.dashboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dashboard.dao.FetchDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.json.JSONException;


public class EmployeePendingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		RequestDispatcher rd=null;
		
		FetchDao Fetch;

		  
		
		   
		  String LOGINBY=(String)request.getAttribute("LOGINBY");
		  
		   
		  
		 
		  
		 System.out.println(LOGINBY+"<3>");
		  
		  
		   
		  
		  
		/*String Email=null;
		String Address=null;
		String Mobile=null;
		String Department=null;
		String Designation=null;
		String WorkLocation=null;
		String BankAccount=null;
		String PFNo=null;
		String EsiNo=null;*/
		
		Map<String,String> hm=new HashMap<String,String>();
		Map<String,String> hm2=new HashMap<String,String>();
		Map<String,String> hm3=new HashMap<String,String>();
		Map<String,String> hm4=new HashMap<String,String>();
		Map<String,String> hm5=new HashMap<String,String>();
		Map<String,String> hm6=new HashMap<String,String>();
		Map<String,String> hm7=new HashMap<String,String>();
		Map<String,String> hm8=new HashMap<String,String>();
		Map<String,String> hm9=new HashMap<String,String>();
	
		JSONArray values;
		values = new JSONArray();
		JSONObject CommanJason = new JSONObject();
		
		try {
			 Fetch = new FetchDao(LOGINBY);
			 CommanJason = new JSONObject();
			
			 //hm=Fetch.Address();
			 CommanJason=Fetch.Address();
			 values.add(CommanJason);
			
			CommanJason = new JSONObject();
			//hm2=Fetch.Mobile();
			
			CommanJason=Fetch.Mobile();
			
			values.add(CommanJason);
			
			
			CommanJason = new JSONObject();
			CommanJason=Fetch.EmailId();
			values.add(CommanJason);
			CommanJason = new JSONObject();
			CommanJason=Fetch.BankAccount();
			values.add(CommanJason);
			
			CommanJason = new JSONObject();
			CommanJason=Fetch.PFNo();
			values.add(CommanJason);
			CommanJason = new JSONObject();
			CommanJason=Fetch.EsiNo();
			values.add(CommanJason);
			CommanJason = new JSONObject();
			CommanJason=Fetch.Department();
			values.add(CommanJason);
			CommanJason = new JSONObject();
			CommanJason=Fetch.Designation();
			values.add(CommanJason);
			CommanJason = new JSONObject();
			CommanJason=Fetch.WorkLocation();
			values.add(CommanJason);
			 
			/*Email=Fetch.Email();
			Address=Fetch.Address();
			Mobile=Fetch.MobileCount();
			Department=Fetch.Department();
			Designation=Fetch.Designation();
			WorkLocation=Fetch.WorkLoaction();
			BankAccount=Fetch.BankAccount();
			PFNo=Fetch.PFNo();
			EsiNo=Fetch.EsiNo();*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		finally
		{
			
			
			request.setAttribute("Address", hm);
			request.setAttribute("Mobile", hm2);
			request.setAttribute("Email", hm3);
			request.setAttribute("BankAccount", hm4);
			request.setAttribute("PFNo", hm5);
			request.setAttribute("EsiNo", hm6);
			request.setAttribute("Department", hm7);
			request.setAttribute("Designation", hm8);
			request.setAttribute("WorkLocation", hm9);
			/*request.setAttribute("Email", Email);
			request.setAttribute("Address", Address);
			request.setAttribute("Mobile", Mobile);
			request.setAttribute("Department", Department);
			request.setAttribute("Designation", Designation);
			request.setAttribute("WorkLocation", WorkLocation);
			request.setAttribute("BankAccount", BankAccount);
			request.setAttribute("PFNo", PFNo);
			request.setAttribute("EsiNo", EsiNo);*/
			// rd=request.getRequestDispatcher("NewFile.jsp");  
			
			//rd=request.getRequestDispatcher("NewFile.jsp");
			
			request.setAttribute("DASHBOARD", values.toString());
			
			System.out.println("values::"+values.toString());
			
			rd=request.getRequestDispatcher("PendingDashBoard_2.jsp");
			
			 rd.forward(request, response); 
			
		}

		
	}

}
