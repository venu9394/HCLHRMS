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
<script>

function DisAnB(enobj){
	
	var name=enobj.id;
	if(enobj.checked){
		//alert(1);
		document.getElementById(""+name+"_ELOP").disabled=false;
	}else{
		//alert(2);
		document.getElementById(""+name+"_DIFF").value=0;
		document.getElementById(""+name+"_ELOP").value=0;
		document.getElementById(""+name+"_ELOP").disabled=true;
	}
	
	
}
function CalLateLOp(objs){
	
	//alert(objs.id+"~~"+objs.value);
	var EMPID=objs.alt;
	document.getElementById(""+EMPID+"_DIFF").value=0;
	var Exlop=objs.value;
	var EMPLOP=document.getElementById(""+EMPID+"_LOP").value;
	var EMP_EDIT_LOP=document.getElementById(""+EMPID+"_ELOP").value;
	
	if(Number(EMP_EDIT_LOP) && eval(EMP_EDIT_LOP)>=0 ){
		
     document.getElementById(""+EMPID+"_ELOP").value=EMP_EDIT_LOP;
     EMP_EDIT_LOP=EMP_EDIT_LOP;
	var CALLOP=0;
	var CALLOP=EMPLOP-EMP_EDIT_LOP;
	
	
	document.getElementById(""+EMPID+"_DIFF").value=CALLOP;
	
	try{
		
	var EDDAYS=document.getElementById(""+EMPID+"_ED").value;
	
	if(eval(EDDAYS)>=(Math.abs(EMP_EDIT_LOP))){
		
		document.getElementById(EMPID).value=objs.name.concat(CALLOP);
		
	}else{
		document.getElementById(EMPID).value=objs.name.concat("0");
		document.getElementById(""+EMPID+"_DIFF").value=0;
		document.getElementById(""+EMPID+"_ELOP").value=0;
		alert("Invalid LOP Adjustment...!");
		
	}
		
	
	
	}catch(err){
		alert(err);
	}
	
	}else{
		document.getElementById(""+EMPID+"_ELOP").value=0;
		alert("Invalid Entery");
		return false;
		
	}
	<%-- id="<%=empid %>_ED" 
		id="<%=empid %>_LOP"
		id="<%=empid %>_ED"	
		alt="<%=empid %>" id="<%=empid %>_ELOP"
		id="<%=empid%>_DIFF" --%>
		
		
	
}


function myFunction() {
	  //alert("ven");
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("tblNeedsScrolling1");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>

  <script   
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js">
    </script>
    <script>

    function scrolify(tblAsJQueryObject, height){
        var oTbl = tblAsJQueryObject;

        // for very large tables you can remove the four lines below
        // and wrap the table with <div> in the mark-up and assign
        // height and overflow property  
        var oTblDiv = $("<div/>");
        oTblDiv.css('height', height);
        oTblDiv.css('overflow','scroll');               
        oTbl.wrap(oTblDiv);

        // save original width
        oTbl.attr("data-item-original-width", oTbl.width());
        oTbl.find('thead tr td').each(function(){
            $(this).attr("data-item-original-width",$(this).width());
        }); 
        oTbl.find('tbody tr:eq(0) td').each(function(){
            $(this).attr("data-item-original-width",$(this).width());
        });                 


        // clone the original table
        var newTbl = oTbl.clone();

        // remove table header from original table
        oTbl.find('thead tr').remove();                 
        // remove table body from new table
        newTbl.find('tbody tr').remove();   

        oTbl.parent().parent().prepend(newTbl);
        newTbl.wrap("<div/>");

        // replace ORIGINAL COLUMN width                
        newTbl.width(newTbl.attr('data-item-original-width'));
        newTbl.find('thead tr td').each(function(){
            $(this).width($(this).attr("data-item-original-width"));
        });     
        oTbl.width(oTbl.attr('data-item-original-width'));      
        oTbl.find('tbody tr:eq(0) td').each(function(){
            $(this).width($(this).attr("data-item-original-width"));
        });                 
    }

    $(document).ready(function(){
        scrolify($('#tblNeedsScrolling'), 400); // 160 is height
    });


    
    function  FrmSubmit(){
 	   
 	   var CheckData=$('input:checkbox:checked').length;
 	   //var chk2=$('input:checkbox:not(":checked")').length;
 	   //alert(CheckData +"~~"+chk2);
 	    if(CheckData==0){
 	    	alert("Please check atleast one record for update..");
 	    	return false;
 	    }else{
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
         width: 100%; 
        
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

<form method='post' action='Arrear_lop_caliculation' >

<div align='right'>
Search By Id &nbsp;&nbsp;<input type="text" id="myInput" style="width:135px;" title="Location Search" onkeyup="myFunction()" >
</div><br/>
<div id="" style="overflow:scroll; height:400px;">


<table align='center' border='1' id="tblNeedsScrolling1">
<thead>
   <tr style="color:white;" ><th>SNO</th><th>EMPID</th> <th>NAME</th> <th>DOJ</th> <th>ACTUAL PAYPERIOD<br> DAYS</th> <th>EMP PAID<br> DAYS</th> <th>EXIST PAID<br> DAYS</th> <th>LOP</th> <th>ACTUAL <br>LOP</th> <th>DIFF</th> </tr>
 </thead>
  <tbody>
   <% 
   int cnt=1;
    while(emp_sub.hasNext()){
    	String empid= emp_sub.next().toString(); 
  %>
    <tr>
    <td><%=cnt%> &nbsp; <input type='checkbox' name='checkboxlwp' id="<%=empid %>" value='<%=empid+"~"+MAIN_DATA.get(empid+"_EMPSEQ")+"~"+MAIN_DATA.get(empid+"_DIFFDAYS") %>' onclick='DisAnB(this)' ></td>
    <td><%=MAIN_DATA.get(empid+"_EMPSEQ") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPNAME") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPDOJ") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPACTDAYS") %> <input type='hidden' id="<%=empid %>_PD" value="<%=MAIN_DATA.get(empid+"_EMPACTDAYS") %> "> </td>
    <td><%=MAIN_DATA.get(empid+"_EMPELIGIBLEDAYS") %> <input type='hidden' id="<%=empid %>_ED" value="<%=MAIN_DATA.get(empid+"_EMPELIGIBLEDAYS") %> ">  </td>
    <td><%=MAIN_DATA.get(empid+"_PDAYS") %></td>
    <td><%=MAIN_DATA.get(empid+"_EMPLOP") %> <input type='hidden' id="<%=empid %>_LOP" value="<%=MAIN_DATA.get(empid+"_EMPLOP") %> "> </td>
    
    <td align='center'>  <input type='text'  name='<%=empid+"~"+MAIN_DATA.get(empid+"_EMPSEQ")+"~" %>'  alt="<%=empid %>" id="<%=empid %>_ELOP" onblur="CalLateLOp(this);" style='width:60px' disabled=true;> </td>
    
    <td align='center' > <input type='text' value='0' id="<%=empid%>_DIFF" style='width:60px' readonly> </td>
   <%--  <td><%=MAIN_DATA.get(empid+"_DIFFDAYS") %></td> --%>
    </tr>
  <%
    cnt++;
    }%>
     </tbody>
</table>

</div>
<% if(Record_cnt==0 && lwp_arrear_status!=null && lwp_arrear_status.equalsIgnoreCase("TRUE")){%>
<div align='center'> <p>All checked Employess will be processed for Arrear  calculation ,Please press Submit. </p></div>

<div align='center'> <p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a> &nbsp; &nbsp; <input type='button' value='Submit' onclick="FrmSubmit();"></p></div>
<%}else if(Record_cnt==0){ %>
     <!-- <div align='center'> <p>NO RECORDS...!</p> -->
     <div align='center'> <p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a> &nbsp; &nbsp; <input type='button' value='Submit' onclick="FrmSubmit();" ></p></div>
 <!--     <p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a></p> -->
     </div>
  
 <%}%>
  </form>
 <%if(Record_cnt>0){ %>
 <form name='report' method='post' action='Arrear_lop_caliculation?ROUTING=REPORT' >
     <div align='center'> <p>Lop arrear Already processed for this payperiod,Please Download & cross check the Report Before Process..! OR Re generate</p></div>

   <script>
   function ReportSubmit(){
	   document.forms.report.submit();
   }
   </script>
  
<div align='center'> <p><p><input type='button' value='Download' onclick="ReportSubmit()" > &nbsp; <input type='button' value='Submit' onclick="FrmSubmit();" > </p>
<p> <a href='lwp_arrear_load.jsp' style='text-decoration:none;'><B> Home </B> </a></p>

</form>
 <%}%>
 
</div>
</body>
</html>