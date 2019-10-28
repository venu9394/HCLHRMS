
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html >
<head>
<meta charset="ISO-8859-1">


<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />


<%
  String Buunit=(String)request.getAttribute("BusinesUnit");

String StateCode=(String)request.getAttribute("StateCode");

String Gender=(String)request.getAttribute("Gender");

String title=(String)request.getAttribute("title");

String EMTYPE=(String)request.getAttribute("EMTYPE");

String Status=(String)request.getAttribute("Status");

String BU= (String)session.getAttribute("BU");



/////-----


String Sales_Office=(String)request.getAttribute("SalesOfficeLoad");

String Sales_District=(String)request.getAttribute("SalesDistrictLoad");

 /* String Sales_Group=(String)request.getAttribute("SalesGrouptLoad"); */ 


//System.out.println(BU+"****************");

response.addHeader("Pragma", "no-cache");
response.addHeader("Cache-Control", "no-cache");
response.addHeader("Cache-Control", "no-store");
response.addHeader("Cache-Control", "must-revalidate");
response.addHeader("Cache-Control", "Post-Check=0");
response.addHeader("Cache-Control", "Pre-Check=0");
response.addHeader("Expires", "Mon, 1 Jan 2006 05:00:00 GMT");//in the past


%>

<title>Insert title here</title>

<style type="text/css">
  body{
  
  font-family:calibri;
  font-size:12px;
  
  }
    table{
    
        font-family:calibri;
        font-size:12px;
       /*  width: 75%; */
        align:center;
       /*  margin: 20px 0; */
        border-collapse: collapse;
    }
    table, th, td{
        border: 1px solid #cdcdcd;
         
    }
    th{
     background-color:#1161F5;
    }
    table th, table td{
        padding: 5px;
        text-align: left;
    }
    
   /*  table tr:nth-child(odd) td{
      color: #CB000F;
    } */
   table tr:nth-child(even) td{
   
    /*  //background-color: #11F5A9; */
    }
input,select{
        font-family:calibri;
        font-size:12px;
}
</style>


 
 <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> -->
 
<!--  <link rel="stylesheet" media="all" href="css/tablesorter.css" type="text/css"> -->
 
 <link rel="stylesheet" href="css/jqueryui.css" type="css"/>
<link rel="stylesheet" href="jquery-ui-1.12.1.custom/jquery-ui.css"> 
  <script src="jquery-ui-1.12.1.custom/jquery-1.12.4.js"></script>
   <script src="jquery-ui-1.12.1.custom/jquery-ui.js"></script>

<script>
$( document ).ready(function() {


	//alert("load");
	
	//DropDownLoad();
	
	DropDownLoad("Division","HQLIST",'<%=Buunit%>');
	
	DropDownLoad("Division1","HQLIST",'<%=Buunit%>');
	
	
	DropDownLoad("state","STATES",'<%=StateCode%>');
	
	DropDownLoad("Gender","Gender",'<%=Gender%>');
	
	DropDownLoad("title","title",'<%=title%>');
	
	
	
	DropDownLoad("Status","Status",'<%=EMTYPE%>');
	
	DropDownLoad("Status1","Status",'<%=EMTYPE%>');
	
	
	DropDownLoad("searchStatus","StatusCodes",'<%=Status%>');
	DropDownLoad("AtciveStatus","StatusCodes",'<%=Status%>');
	
	
	
	/////---------
	
	
    DropDownLoad("SalesDistict","SalesDistict",'<%=Sales_District%>');
	
	DropDownLoad("SalesOffice","SalesOffice",'<%=Sales_Office%>');
	
	<%-- DropDownLoad("SalesGroup","SalesGroup",'<%=Sales_Group%>'); --%>
	
	
	//Fetch_Data();
   // console.log( "ready!" );
    CallCheck();
});
function CallCheck(){
	
	
	if('9'=='<%=BU%>'|| '10'=='<%=BU%>' || '11'=='<%=BU%>'|| '14'=='<%=BU%>'|| '15'=='<%=BU%>'|| '16'=='<%=BU%>'|| '17'=='<%=BU%>'|| '18'=='<%=BU%>'|| '19'=='<%=BU%>'|| '20'=='<%=BU%>'|| '21'=='<%=BU%>'|| '22'=='<%=BU%>'|| '24'=='<%=BU%>'||'25'=='<%=BU%>' ||'26'=='<%=BU%>'||'27'=='<%=BU%>'||'28'=='<%=BU%>'||'29'=='<%=BU%>' ){
		  document.getElementById('System_Check').disabled=false;
		  document.getElementById('Manual_Check').disabled=true;
		  document.getElementById('System_Check').checked=true;
		  
		  document.getElementById('Man').style.display='none';
		  document.getElementById('Sys').style.display='';
		  $('#Digits').show();
		  //$("input[name=Manual_Check]").prop('checked', true);;
	}else{
		
		document.getElementById('Sys').style.display='none';
		document.getElementById('Man').style.display='';
		 $('#Digits').hide();
		 
		document.getElementById('System_Check').disabled=true;
		document.getElementById('Manual_Check').disabled=false;
		document.getElementById('Manual_Check').checked=true;
		//Fetch_Data1();
	}
	
	<%-- if("9,10,11,14,15,16,17,18,19,20,21,22,24,25,26,27,28,29".indexOf(<%=BU%>)!=-1){
	  document.getElementById('System_Check').disabled=false;
	  document.getElementById('Manual_Check').disabled=true;
	  document.getElementById('System_Check').checked=true;
	 // Fetch_Data1();
	}else{
		document.getElementById('System_Check').disabled=true;
		document.getElementById('Manual_Check').disabled=false;
		document.getElementById('Manual_Check').checked=true;
		//Fetch_Data1();
	} --%>
}
function updateResion(val){
	 //  alert(val.value);
	if(val.value!="5007"){
		document.getElementById("updatetype_reson").style.display='none';
		document.getElementById("updatetype_reson").value=val.options[val.selectedIndex].text;
	}else{
		document.getElementById("updatetype_reson").style.display='';
		document.getElementById("updatetype_reson").value="";
		
	}
	//updatetype_reson
}

function StatuSup(val){
	
	// alert(val.value);
	 
	/* if(val.value!="1001"){
		document.getElementById("LastWorkingDate_t").style.display='';
		document.getElementById("LastWorkingDate").style.display='';
	}else{
		document.getElementById("LastWorkingDate_t").style.display='none';
		document.getElementById("LastWorkingDate").style.display='none';
		
	} */
}
function Dat_Validate(dat){
	
	/* var date=new Date("2013/13/30");
	//var timestamp=date.parse(dat.value);
	alert("timestamp::"+date); */
	try{
	var Dates=Dat_Validate_call(dat.value);
	if(!Dates){
		
		$('#errorMsg').html('Invalid date formate..');
		try{
		//document.getElementById(dat.id).focus();
		}catch(err){
			
		}
    	//return false;
		//alert("Invalid date formate..");
		//return false;
	}else{
		$('#errorMsg').html('');
	}
	
	}catch(err){
		
	}
	//alert("Date::"+Date);
	
}



function Dat_Validate_DOB(dat){
	
	/* var date=new Date("2013/13/30");
	//var timestamp=date.parse(dat.value);
	alert("timestamp::"+date); */
	/* try{ */
	var Dates=Dat_Validate_call(dat.value);
	
	//alert("Dates::"+Dates);
	
	if(!Dates){
		$('#errorMsg').html('Invalid date formate..');
		//$('#DATEOFBIRTH').focus();
		//return false;
	}else{
		$('#errorMsg').html('');
	}
	

	/* 
	if(!Dates){
		
		$('#errorMsg').html('Invalid date formate..');
		
		try{
		document.getElementById(dat.id).focus();
		}catch(err){
			alert(err.message);
		}
    	return false;
		//alert("Invalid date formate..");
		//return false;
	}else{
		$('#errorMsg').html(' ');
	}
	
	}catch(err){
		
		alert(err.message);
		
	} */
	//alert("Date::"+Date);
	
}
</script>

</head>
<body  onload="CallCheck();"  >
<!-- <body  onload="Fetch_Data();"> -->


<table  width="100%">
<tr style="background-color:#7FFFD4">
<th >
<span style='color:white;'>Employee Basic Details </span>
</th>
<th >
<span style='color:white;'>EMPID:</span><span id="displayempid" style='color:white;'></span>
</th>
<th  >
<span style='color:white;'>NAME:</span><span id="displayname" style='color:white;' ></span>
</th>


<th>&nbsp;</th><th> &nbsp; </th> <th> &nbsp; </th>
</tr>

<!-- <tr>
   <td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
 
 
</tr> -->
</table>

<form id="myform" name="myform">
 
	<input type="hidden" id="Emp_Id">
	
	*
	<span id='Man' style='display:none;'>
	<input type="radio" name="Manual_Check" id="Manual_Check"   onclick="CallCheck();">Manual
	
	</span>
	<span id='Sys' style='display:none;'>
	<input type="radio" id="System_Check" name="Manual_Check" onclick="CallCheck();" >
	System &nbsp; 
	</span>
	<span style='font-size:10px;'>
	<p> <i>If Manual is checked employee id should be Manual entry (Usefull for Mumbai Location) / If System is Checked auto employeeid is generated(Usefull for Hyd Location)</i> </i></p>
	
	</span>
	<span id="employee_code_v1"></span> 
	<span id="errorMsg" style="color: red;"></span>
	 
	<table id='mytblf' width="100%">
		<tr>
			<td>Gender* </td><td> <select   name="Gender"
				id="Gender" onchange="Change_Title(this)" style='width:180px;'>
					<option value="Select" >--Select One--</option>
			</select>
			</td>
			<td>Title* </td><td> <select   id="title"
				style="display: none" style='width:180px;'>
			</select> <select   id="title1" name="title1" style='width:180px;'>
					<option value="Select">--Select One--</option>

			</select>
			</td>
			<td>First Name* </td><td> <input type="text" 
				name="FristName" id="FristName" placeholder="Enter Your Firstname"
				onblur="ChangeData(this);" style='width:180px;'>
			</td>
		</tr>
		<tr>
			<td>Middle Name </td><td> <input type="text"  
				name="MiddleName" id="MiddleName"
				placeholder="Enter Your Middle Name" onblur="ChangeData(this);" style='width:180px;'>
			</td>
			<td>Last Name* </td><td> <input type="text"  
				name="LastName" id="LastName" placeholder="Enter Your Lastname"
				onblur="ChangeData(this);" style='width:180px;' >
			</td>
			<td>Call/Full Name </td><td><span id="CallNameDispaly"></span>
			</td>
		</tr>
		<tr>
			<td>Division* </td><td> <select   id="Division"
				name="Division" onchange="Change_Field(this)" style='width:180px;' >
					<option value="Select">--Select One--</option>
			</select>
			</td>
			<td>Cost Center* </td><td> <select id="Field"
				name="Field" style='width:180px;'>
					<option value="Select">--Select One--</option>
			</select> 
			<span style="display:;" id="Digits">
		<input type="radio" name="RadioButton" id="5_Digits" value="5">5 Digi 
		<input type="radio" name="RadioButton" id="6_Digits" value="6">6 Digi

	</span>
			</td>
			<td>Date Of Birth* </td><td> <input type="text"  
				name="DATEOFBIRTH" id="DATEOFBIRTH" placeholder="Date Of Birth" style='width:180px;'  > (YYYY-MM-DD)  <!-- readonly Onblur=Dat_Validate(this);-->
			</td>
		</tr>
		<tr>
			<td>Date Of Join* </td><td> <input type="text" 
				id="Date" name="Date" placeholder="Date Of Join"   style='width:180px;'>(YYYY-MM-DD)
			</td>
			<td>Employment Type* </td><td> <select  id="Status"
				name="Status" style='width:180px;'>
			</select>
			</td>
			<td>PT State* </td><td> <select  id="state"
				name="state" style='width:180px;'>
			</select>
			</td>
		</tr>
		<tr>
			<td>Mobile No* </td><td> <input type="text"  
				id="Mobile_no" name="Mobile_no" placeholder="Number" maxlength="10" style='width:180px;'>
			</td>
			<td>Email ID </td><td> <input type="text"  
				id="Email_id" name="Email_id" placeholder="Email" style='width:180px;'>
			</td>
			<td>Employee Code </td><td > <input type="text" 
				name="EmployeeCode" maxlength="6" id="EmployeeCode"
				placeholder="Enter Your Employee Code" onblur="Employee_Code();" style='width:180px;'>
				<span id="EmployeeCodeDisplay"></span>
			</td>
		</tr>
		<tr>
		<td>
		<div style="display: none" id="EditStatus">
		 Status: </div>
		 </td><td>
		  <div style="display: none" id="EditStatus1" >
			<select   name="AtciveStatus" id="AtciveStatus" onchange="StatuSup(this)" style='width:180px;' >
				<option value="Select">--Select One--</option>
			</select>
			<div>
	
		</td><td><span id='LastWorkingDate_t' style='display:none' >Action Date*</span></td> <td> <span id='LastWorkingDate' style='display:none'><input type='text' name='Lwdate' id='Lwdate' readonly> <span></td> 
		<td><span  id='Reason_f_up_t' style='display:none' >Reason*</span></td> 
		<td>
		<div id='Reason_f_up' style='display:none' >
		<select id='updatetype' name='updatetype' onchange='updateResion(this);' style='width:120px' >
		    <option value='Select' >--Select One-- </option>
		    <option value='5001' >PROMOTION </option>
			<option value='5002' >DEMOTION</option> 
			<option value='5003' title='ENTRY MISTAKE' >ENTRY MISTAKE</option>
			<option value='5004' title='EMPLOYMENT TYPE UPGRADE' >EMPLOYMENT TYPE UPGRADE</option>
			<option value='5005' title='EMPLOYMENT TYPE DEGRADE' >EMPLOYMENT TYPE DEGRADE</option>
			<option value='5006' title='EMPLOYEE STATUS UPDATE' >EMPLOYEE STATUS UPDATE</option>
			<option value='5008' >Re-Activation </option>
	         <option value='5010' > Resigned </option>
			<option value='5011' > DOJ Changes </option>
			<option value='5012' > STOP OR HOLD </option>
			<option value='5009' >CONFORMATION/PERMENENT</option> 
		    <option value='5007' title='Others (write reason in text box)' >Others</option>
		 </select> &nbsp;
		   <input type='text' value='' title='Update Reason' name='updatetype_reson' id='updatetype_reson'  max-length='200' style="width:220px;display:none;" >
		  <div style='font-size:9px;color:red;'>This reason only for histroy tracking not for report purpose</div>
		  <div style='font-size:9px;color:red;'>(Use proper links for promotion/designation & conformation changes)</div>
		  </div>
	</td>
		</tr>
		
		<!-- For Sales Office -->
		
		<tr>
		  <td colspan='6' width="40%" style="background-color:#7FFFD4"><b>Sales Office/group Mapping (Optional)</b></td>
		  
		<tr>
		
		
		<tr>
		  <td>Sales State/Distict</td>
		  
		  <td>
		   <select id='SalesDistict' name='SalesDistict' style='width: 120px'>
		       <option value='0'>--Select One--</option>
						<!-- <option value='0'>--Select One--</option>
						<option value='SZ001'>SOUTH ZONE</option>
						<option value='NZ001'>NORTH ZONE</option>
						<option value='EZ001'>EAST ZONE</option>
						<option value='WZ001'>WEAST ZONE</option> -->
		     </select>
		  
		  </td>
		   <td>Sale Office</td>
		  <td>
		    <select id='SalesOffice' name='SalesOffice' style='width: 120px' onchange="Salesoffice(this)">
		    <option value='0'>--Select One--</option>
						<!-- <option value='0'>--Select One--</option>
						<option value='SZ001'>SOUTH ZONE</option>
						<option value='NZ001'>NORTH ZONE</option>
						<option value='EZ001'>EAST ZONE</option>
						<option value='WZ001'>WEAST ZONE</option> -->
		     </select>
		     
		  </td>
		  
		  <td>Sale Group </td>
		  <td>
		   <select id='SalesGroup' name='SalesGroup' style='width: 120px'>
		    <option value='0'>--Select One--</option>
						<!-- <option value='0'>--Select One--</option>
						<option value='SZ001'>SOUTH ZONE</option>
						<option value='NZ001'>NORTH ZONE</option>
						<option value='EZ001'>EAST ZONE</option>
						<option value='WZ001'>WEAST ZONE</option> -->
		     </select>
		  </td>
		</tr>
		
		<tr>
		 <!--  <td>Sale Group </td>
		  <td>
		   <select id='SalesGroup' name='SalesGroup' style='width: 120px'>
						<option value='0'>--Select One--</option>
						<option value='SZ001'>SOUTH ZONE</option>
						<option value='NZ001'>NORTH ZONE</option>
						<option value='EZ001'>EAST ZONE</option>
						<option value='WZ001'>WEAST ZONE</option>
		     </select>
		  </td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
		<tr>
		
		
		<!-- For Sales Office -->
		
		
		<tr>
		 <td></td> <td></td> <td colspan='2' style='text-align:center;'>
		 <span >
		 <input type="button"   id="Reset" value='Reset' />
		<input type="button" id="reg" name="reg" onclick="MyFunction(this);" value="Save">
		 </span >&nbsp; <img id='Search_Scrolling1' src="progressdisc.gif" alt="Smiley face" height="24" width="24" style='display:none'>
		 
		 <div id="iconnect" style='font-size:10px;'><i>Please Press Reset for every New entry/update for best result</i></div>
		 <!-- <td></td>  -->
		 
		 <td colspan='2'>
		 
		 <span id="iconnect" style='font-size:10px;'><i>Iconnect Login:- UserID :(EmployeeID)/ password:(EmployeeID)@(Day from DOB)(Year from DOB)</i></span>
		 </td>
		</tr>
	</table>
	
	 <p id="Responce_Message" style="color: red;" align="center">  </p>
	<div class="form-group three-btn">
		<p id="System_Generate" style="color: #228B22;" align="center">
			<font size="2"><b></b></font>
		</p>
	</div>
	
</form>

<table width="100%">  <!------------------ For Search  -->

<tr >
<th  colspan='6' width="40%" style="background-color:#7FFFD4">
Search Criteria
</th>
 
<!-- <th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th> -->

</tr>

</table>
 <span style="color:red;margin-left:40%;" id="Search_error" ></span>
<!-- <br>
     -->                         
  <table   width="100%" >
  <tr>
  					 
											<td>Business Unit </td><td>
														 <select class="form-control " id="Division1" name="Division1" onchange="Change_Department()" style='width:180px;' >
															 
															 <option value="Select">--Select One--</option>
													</select>
													
													</td><td>
													 
													  Employee ID  </td><td>
													  <input type="text" class="form-control" id="EmployeeCode1" name="EmployeeCode1" style='width:180px;' >
													
													 </td><td>
													 
													 First/Last Name </td><td>
													  <input type="text" class="form-control" id="searchFristName" name="searchFristName" placeholder="Enter Employee Name" onblur="ChangeData(this);" style='width:180px;'>
													 
													 </td>
													 </tr><tr>
													 <td>
													  DOJ: </td><td>
													  <input type="text" class="form-control" id="doj" name="doj"  style='width:180px;' Onblur="Dat_Validate(this);">(YYYY-MM-DD)
													 </td>
													 
													 <td>
													 Employee Type: </td><td>
													 <select class="form-control " id="Status1" name="Status1" style='width:180px;'>
													 <option value="Select">--Select One--</option>
													  </select>
													 </td><td>
													   Department: </td><td>
													  <select class="form-control search-select" id="Department" name="Department" style='width:180px;'>
														<option value="Select">--Select One--</option>
													  </select>
													 </td>
													 
													 </tr><tr>
													 <td>
													 
													   Status: </td><td>
													  <select class="form-control " id="searchStatus" name="searchStatus" style='width:180px;' >
															 
															 <option value="Select">--Select One--</option>
													</select>
													
													</td>
													
													<td>
													 &nbsp;
												  
													 </td> <td>&nbsp;</td> <td>&nbsp;</td>
													 
													 <td> <button type="button" id="search" name="search" class="btn btn-primary department-it-btn " onclick="formvalidation2()">Search</button> 
													 
													 &nbsp; <img id='Search_Scrolling' src="progressdisc.gif" alt="Smiley face" height="24" width="24" style='display:none'>
													 </td></tr>
										</table>



<!-- <div> &nbsp;&nbsp;&nbsp; </div> -->


<table  width="100%" >

<tr>
<th  colspan='6' width="40%" style="background-color:#7FFFD4">
Employee List
</th>
</tr>
</table>

 <div class="table-responsive table-res" style="height:300px !important;
    overflow-y: scroll;"> 

<!-- <div  style="height:300px !important; overflow-y: scroll;"> -->
													<table   width='100%'>
													  <thead >
														<tr style='color:white'>
														  <th>S.No</th>
														  <th>Employee Id</th>
														  <th>Employee Name</th>
														  <th>Gender</th>
														  <th>Date Of Birth</th>
														  <th>Date Of Join</th>
														  <th>Employment Type</th>
														  <th>Department</th>
														  <th>Designation</th>
														  <th>Status</th>
														  
														  
														  
														  <th>Edit</th>
														</tr>
													  </thead>
												 
													  <tbody id="tableBody" width='100%' >
													  
													  </tbody>
													 
													</table>
  </div>



 <div style='hight:50px'>
 
 &nbsp;
 
 </div>

	



</body>

<script type="text/javascript">
$("#Date").datepicker({
	dateFormat : 'yy-mm-dd',
	changeMonth: true,
    changeYear: true,
    yearRange: '1950:2050'
});

$("#DATEOFBIRTH,#Lwdate").datepicker({
	dateFormat : 'yy-mm-dd',
	changeMonth: true,
    changeYear: true,
    yearRange: '1950:2050'
    
     

});

$("#doj").datepicker({
	dateFormat : 'yy-mm-dd',
	changeMonth: true,
    changeYear: true,
    yearRange: '2005:2050'

});




 var elmt = document.getElementById('FristName');

elmt.addEventListener('keypress', function (event) {
	//alert(event.which);
 
    if (elmt.value.length === 0 && event.which>=33 && event.which<=64||event.which==126||event.which==94||event.which==95) {
        event.preventDefault();
    }
});
var elmt = document.getElementById('MiddleName');

elmt.addEventListener('keypress', function (event) {
	//alert(event.which);
 
    if (elmt.value.length === 0 && event.which>=33 && event.which<=64||event.which==126||event.which==94||event.which==95) {
        event.preventDefault();
    }
});
var elmt = document.getElementById('LastName');

elmt.addEventListener('keypress', function (event) {
	//alert(event.which);
 
    if (elmt.value.length === 0 && event.which>=33 && event.which<=64||event.which==126||event.which==94||event.which==95) {
        event.preventDefault();
    }
});








</script>
<script  src="hq_reg.js"></script>
 <script src="HRM_JS/BasicScreen.js"></script>
</html>