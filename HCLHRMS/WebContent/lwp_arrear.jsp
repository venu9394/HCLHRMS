<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<% 


    Map MAIN_DATA=(Map)request.getAttribute("MAIN_DATA");
    String lwp_arrear_status=request.getAttribute("lwp_arrear_status").toString();
    int Record_cnt=0;
    	try{
    		Record_cnt=Integer.parseInt(request.getAttribute("Record_cnt").toString());
    	}catch(Exception ert){
    		System.out.println("ert:"+ert);
    	}
    ArrayList MAIN_EMP_LIST=(ArrayList)request.getAttribute("MAIN_EMP_LIST");
    ArrayList FINAL_EMP_LIST=(ArrayList)request.getAttribute("FINAL_EMP_LIST");
   
    java.util.Iterator emp_main = MAIN_EMP_LIST.iterator();
    java.util.Iterator emp_sub = FINAL_EMP_LIST.iterator();
    
%>

<style type="text/css">
  body{
  
  font-family:calibri;
  font-size:14px;
  }
    table{
         width: 90%; 
        
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

<form method='post' action='Arrear_lwp_caliculation' >
<table align='center' border='1'>
   <tr style="color:white;" ><th>SNO</th><th>EMPID</th> <th>NAME</th> <th>DOJ</th> <th>ACTUAL PAYPERIOD DAYS</th> <th>EMP PAID DAYS</th> <th>EXIST PAID DAYS</th> <th>LOP</th> <th>DIFF</th> </tr>
   <% 
   int cnt=1;
    while(emp_sub.hasNext()){
    	String empid= emp_sub.next().toString(); 
  %>
    <tr>
    <td><%=cnt%> &nbsp; <input type='checkbox' name='checkboxlwp' value='<%=empid+"~"+MAIN_DATA.get(empid+"_EMPSEQ")+"~"+MAIN_DATA.get(empid+"_DIFFDAYS") %>' checked='true'></td>
    <td><%=MAIN_DATA.get(empid+"_EMPSEQ") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPNAME") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPDOJ") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPACTDAYS") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPELIGIBLEDAYS") %></td>
    <td><%=MAIN_DATA.get(empid+"_PDAYS") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPLOP") %></td>
    <td><%=MAIN_DATA.get(empid+"_DIFFDAYS") %></td>
    </tr>
  <%
    cnt++;
    }%>
</table>
<% if(Record_cnt==0 && lwp_arrear_status!=null && lwp_arrear_status.equalsIgnoreCase("TRUE")){%>
<div align='center'> <p>All checked Employess will be processed for Arrear  calculation ,Please press Submit. </p></div>

<div align='center'> <p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a> &nbsp; &nbsp; <input type='submit' value='Submit' ></p></div>
<%}else if(Record_cnt==0){ %>
     <div align='center'> <p>NO RECORDS...!</p>
     <p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a></p>
     </div>
  
 <%}%>
  </form>
 <%if(Record_cnt>0){ %>
 <form name='report' method='post' action='Arrear_lwp_caliculation?ROUTING=REPORT' >
     <div align='center'> <p>Lwp arrear Already processed for this payperiod,Please Download &cross check the Report Before Process..!</p></div>

   <script>
   function ReportSubmit(){
	   document.forms.report.submit();
   }
   </script>
  
<div align='center'> <p><p><input type='button' value='Download' onclick="ReportSubmit()" ></p>
<p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a></p>
</div>
</form>
 <%}%>
 

</body>
</html>