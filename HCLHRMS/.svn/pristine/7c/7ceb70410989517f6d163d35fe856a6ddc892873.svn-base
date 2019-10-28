<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<% 


    Map MAIN_DATA=(Map)session.getAttribute("FetchData_Map");

    Set linkedHashSet_title=(Set)session.getAttribute("linkedHashSet_title");
    Set linkedHashSet_employee=(Set)session.getAttribute("linkedHashSet_employee");
    
    Iterator Titles = linkedHashSet_title.iterator(); 
    Iterator empdata = linkedHashSet_employee.iterator();
%>

<style type="text/css">
  body{
  
  font-family:calibri;
  font-size:14px;
  }
    table{
         width: 80%; 
        
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
  
  <tr style="color:white;"><th>SNO</th><th>EMPID</th> <th>NAME</th> <th>BUSINESSUNIT</th> <th>NODAYS</th> <th>PAYPERIOD</th>
  
  
  <% 
    while(Titles.hasNext()){
    	String component= Titles.next().toString();
    %> 	
    	<th><%=MAIN_DATA.get(component) %></th>
    	
    <% }%>
    </tr>
   <% 
   int cnt=1;
    while(empdata.hasNext()){
    	String empid= empdata.next().toString();
    	Titles = linkedHashSet_title.iterator(); 
  %>
     <tr>
     <td><%=cnt%> &nbsp;</td>
     <td><%=MAIN_DATA.get(empid+"_ID") %></td>
     <td><%=MAIN_DATA.get(empid+"_NAME") %></td>
     <td><%=MAIN_DATA.get(empid+"_BU") %></td>
     <td><%=MAIN_DATA.get(empid+"_NOD") %></td>
     <td><%=MAIN_DATA.get(empid+"_PD") %></td>
     <% 
    while(Titles.hasNext()){
    	String Component=Titles.next().toString();
      %>
    <td><%=MAIN_DATA.get(empid+"_"+Component) %></td>
     
    <%
    }%>
    
    </tr>
    
  
  <%
    cnt++;
    }%>
    
</table>
<div align='center'> <p>Please cross check the Report Before Process..!</p></div>

<div align='center'> <p><a href="download_lop.jsp">Download Report</a></div>

</form>
</body>
</html>