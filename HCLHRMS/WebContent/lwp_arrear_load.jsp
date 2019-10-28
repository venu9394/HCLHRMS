<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<% 

    ArrayList MAIN_PAYPERIOD_LIST=(ArrayList)session.getAttribute("Payperiod_list");
   
    java.util.Iterator emp_main = MAIN_PAYPERIOD_LIST.iterator();
   
    
%>

<script>

function CallSubmit(){
	
	var ArrType=document.getElementById("ArrType").value;
	var PayPeriod=document.getElementById("PayPeriod").value;
	if(PayPeriod=="Select"){
	   alert("Please Select Month / Payperiod");
	   return false;
	 }else if(PayPeriod!="Select" && ArrType!="LWP"){
		
		 document.forms[0].action="Lop_emp_fetching";
		 document.forms[0].submit();
		 //alert(ArrType+"~ Under Development..!");
		 //return false;
	 }else if(PayPeriod!="Select" && ArrType=="LWP"){
		 document.forms[0].submit();
		 
	 }
	
	
}

</script>


<style type="text/css">
  body{
  
  font-family:calibri;
  font-size:14px;
  }
    table{
         width: 40%; 
        
        border-collapse: collapse;
    }
    table, th, td{
        border: 1px solid #cdcdcd;
         
    }
    th{
       background-color:#1161F5;
    }
    
    class1{
        padding: 5px;
        text-align: center;
    }
    
    class2{
        padding: 5px;
        text-align: left;
    }
    
   /*  table th, table td{
        padding: 5px;
        text-align: center;
    }
    
    table th, table td{
        padding: 5px;
        text-align: center;
    } */
    
    
   /*  table tr:nth-child(odd) td{
      color: #CB000F;
    } */
   table tr:nth-child(even) td{
   
     background-color: #e8eaf6;
    }

</style>

</head>
<body>

<form method='post' action='Lwp_emp_fetching' >

<table align='center' border='1'>
  
    <tr>
   <th  style="color:white;" align='center'>ARREAR TYPE :</th>
   <th  style="color:white;" align='left'>
   <select id="ArrType">
   <option value='LWP' selected>LWP(DOJ Modifications)</option>
   <option value='LOP'>LOP(Positive Adjustment) </option>
   </select>
   </th> </tr>
   
   <tr>
    <td colspan='2' align='center'>&nbsp; &nbsp;</td>
     </tr>
    
   <tr style="color:;" >
   <td> Select  Month / Payperiod</td>
   <td>
   <select name='PayPeriod' id='PayPeriod' style='width:180px;'>
   <option value='Select' >Select </option> 
 <%   
   int cnt=1;
    while(emp_main.hasNext()){
    	String empid= emp_main.next().toString(); 
  %>
     <option value='<%=empid %>' ><%=empid %></option>
  <%
    cnt++;
    }%>
    </select>
    </td></tr>
    
    
    <tr>
    <td colspan='2' align='center'>&nbsp; &nbsp;</td>
    
    </tr>
    
    
    <tr>
    <td colspan='2' align='center'><input type='button' value='Submit' Onclick="CallSubmit();"></td>
    
    </tr>
</table>
  </form>
</body>
</html>