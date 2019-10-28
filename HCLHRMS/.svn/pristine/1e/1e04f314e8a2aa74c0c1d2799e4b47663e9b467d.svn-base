<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="allowances/FuelMain.js"></script>
<head>
 <% 
String EmployeeID=null,LoginID=null,EmpName=null;

try{
	EmployeeID=(String)request.getParameter("empid");
	LoginID=(String)request.getParameter("LOGINBY");
	EmpName=(String)request.getParameter("empname");
	
}catch(Exception err){
	System.out.println("Connection Problem");
}

if(EmployeeID==null){
	EmployeeID="";
}else if(EmpName==null){
	EmpName="";
}


%> 

<meta charset="ISO-8859-1">
<title>Other Allowances</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->


<style type="text/css">
fieldset {
	/* display: block; */
	/*  margin-left: 2px;
    margin-right: 2px; */
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 5px groove(internal value);
	background-color: #C7DFFA;
	width: 50%;
	margin: auto;
	border-radius: 10px;
}



</style>

<style>

table#DataTable tr:nth-child(even) {
font-family: "Calibri";
    background-color: #eee;
    font-size: 15px;  
}
table#DataTable tr:nth-child(odd) {
font-family: "Calibri";
   background-color:#fff;
   font-size: 15px;  
}
table#DataTable th {
font-family: "Calibri";
    background-color: black;
    color: white;
    font-size: 15px;  
    text-align:center;
}


table#components tr:nth-child(even) {
font-family: "Calibri";
    background-color: #eee; 
    font-size: 15px;  
    
}
table#components tr:nth-child(odd) {
font-family: "Calibri";
   background-color:#fff;
   font-size: 15px;  
}
table#components th {
	font-family: "Calibri";
    background-color: black;
    color: white;
    font-size: 15px;  
    text-align:center;
}


#components, #components th, #components td,#DataTable , #DataTable th, #DataTable td {
    border: 1px solid black;
    border-collapse: collapse;
}
#components th, #components td,#DataTable th, #DataTable td {
    padding: 5px;
    text-align: left;
} 
</style>



</head>
<body onload="myFunction();">
<br>
<fieldset>
<table>
<tr>
<td >EmployeeId:</td>
<td><%=EmployeeID %>&nbsp;&nbsp;&nbsp;<%=EmpName %>
<input type="hidden" id="employeeid"  value="<%=EmployeeID %>" onkeyup="myFunction();" readonly maxlength="6" onkeypress="return isNumber(event);"></td>
<!-- <td><input type="button" value="Reset" id="Reset" onclick="FormReset();"></td> -->
</tr>

</table>
</fieldset>

<br>

<div id="DataTable_Div">

</div>
<!-- <table id="DataTable" align="center" style="width:50%"></table> -->
<br><br><br>

<p id="error" style="color:red" align="center"></p>

<!-- <form action="EmployeeCTC" method="post"> -->


<div align="center">

<div id="components_Div"></div>
<!-- <table id="components" border="1" > </table> -->

<!-- onclick="MyValidation();" -->
<span id="componentsave" style="display:none">
<br>
<input type="button" value='Save'  onclick="printChecked()"> <input type="button" id="TableReset" value="Reset" onclick="TableReset();"></span>
<!-- </form> -->
</div>
<script>
function isNumber(evt) {
	document.getElementById('error').innerHTML = "";
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode >= 48 && charCode <= 57) {
		return true;
	}
	return false;
}

function DotisNumber(evt) {
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode==46 || charCode >= 48 && charCode <= 57) {
		return true;
	}
	return false;
}

function RateisNumber(evt,val) {

	 document.getElementById('error').innerHTML = "";
	 // alert(evt.id);

   evt = (evt) ? evt : window.event;
 var charCode = (evt.which) ? evt.which : evt.keyCode;   
 
 //alert(charCode);
 
// var charCode=val.keyCode;
 
 
 //alert(charCode);
 // var dat=document.getElementById('VAT').value;
 var y = String.fromCharCode(event.keyCode);
 var Data= document.getElementById(""+val.id+"").value;
 //alert(Data.length);
 if(Data.length==0){

 if(y=="."){
 // alert(1);
 return false;
 }
 }
 Data=Data.concat(y);
 var char='';
 var count=0;
 try{
 for(var i=0;i<Data.length;i++){
 char=Data.charAt(i);

 if(char=="."){

 count=count+1; 
 }
 //alert("char::"+char);

 }
 }catch(err){

 alert(err.message);
 }
 //alert(count+"::count")
 if(count>1){
 return false;
 }


/*  if (charCode > 31 && (charCode < 48 || charCode > 57) && charCode!=46) {
	 return false; 
	 } */
 return true;
 }
 
 
 
</script>




</body>
</html>