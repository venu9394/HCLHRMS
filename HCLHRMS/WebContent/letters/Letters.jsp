<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.hclhrm.util.Util"%>
<%@ page import="java.util.*"%>
<%@page import="java.sql.*"%>


<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward 

	/*  if (session.getAttribute("username") != null) {
		String username = null;
		username = (String) session.getAttribute("username"); */
%>


<%-- <%
	Map mp = (Map) session.getAttribute("viewrights");
		if (mp.isEmpty()) {
			response.sendRedirect("error.html");
		}
%> --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Hetero Healthcare</title>

<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> 
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>  
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <script src="Script/HomePage.js"></script> -->
<script src="letters/Script/BuScript.js"></script>

<!-- 	<script type="text/javascript" >
 
$(document).ready(function() {
	$('#example').DataTable( {
		  	scrollY:        "300px",
	        scrollX:        true,
	        scrollCollapse: true,
	        paging:         false,
		dom: 'Bfrtip',
		buttons: [
			'csv', 'excel'
		]
	} );
} );
	</script> -->


<!-- <style type="text/css">
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

</style> -->

<style type="text/css">
body {
	font-family: calibri;
	font-size: 14px;
}

table {
	width: 60%;
	border-collapse: collapse;
}

table,th,td {
	border: 1px solid #cdcdcd;
	
}

th {
	background-color: #1161F5;
	color:white;
}

class1 {
	padding: 5px;
	text-align: center;
}

class2 {
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
table tr:nth-child(even) td {
	background-color: #e8eaf6;
	
}
</style>


<style>
input[type="text"] {
	width: 189px;
}

input[type="button"] {
	width: 50x;
}

select {
	width: 190px;
}
</style>
</head>


<!-- background="lily.jpg" -->

<body align="center" onload="Load()">

	<div id="dd" class="wrapper-dropdown-1" align="right">

		<%--  		<a role="menuitem" tabindex="-1" href="Logout"><span><font
														class="admin"><%=username %></font></span><br> <span
													class="logout">Logout</span></a>  --%>

	</div>
	<br>

	<form method="Post" action="LetterPrintReport" id="myform">

		<table align='center' border='1'>

			<tr style="color: white;">
				<th colspan='3' align='left'>Employee Letters Download</th>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<!--   <td> &nbsp; </td>   -->
			</tr>


			<tr>
				<td align='left'>Letter Type</td>
				<td align='left'><select id="lettertype" name="lettertype"
					style='width: 180px'>
						<option value="Select">--Select One--</option>
						<option value="AppointmentLetter">Appointment Letter</option>
						<option value="ConfirmationLetter">Confirmation Letter</option>
						<option value="PromotionLetter">Promotion Letter</option>
						<option value="TransferLetter">Transfer Letter</option>

				</select></td>

				<!-- <td></td>  -->
			</tr>
			<tr id="BU_ID">
				<td align='left'>Business Unit</td>
				<td align='left'><select class="form-control" name="Division"
					id="Division" style='width: 180px'>
						<option value="Select">--Select one --</option>
				</select></td>
				<!--   <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>   -->
			</tr>
			
			
			<tr id="E_ID">
				<td align='left'>Employee ID</td>
				<td align='left'><input type="text" id="employeeid"
					name="employeeid" onkeypress="return AdhadarisNumber(event)"
					onblur="DisplayName();" style='width: 176px' maxlength="6"> &nbsp; </span></td>
				<!--    <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
			</tr>

<tr id="OLD_CTC_1">
				<td align='left'>Previous CTC</td>
				<td align='left'><input type="text" id="old_ctc"
					name="old_ctc"  onkeypress="return CTCisNumber(event)"
					 style='width: 176px'> &nbsp; </span></td>
				<!--    <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
			</tr>

			<tr id="NEW_CTC_1">
				<td align='left'>Current CTC</td>
				<td align='left'><input type="text" id="new_ctc"
					name="new_ctc" onkeypress="return CTCisNumber(event)"
					 style='width: 176px'> &nbsp; </span></td>
				<!--    <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
			</tr>


	<tr id="PROB_ID">

				<td align='left'>Probation Period</td>
				<td align='left'><select id="probation" name="probation"
					style='width: 180px'>
						<option value="Select">--Select One--</option>
						<option value="one">one</option>
						<option value="two">two</option>
						<option value="three">three</option>
						<option value="four">four</option>
						<option value="five">five</option>
						<option value="six">six</option>
						<option value="seven">seven</option>
						<option value="eight">eight</option>
						<option value="nine">nine</option>
						<option value="ten">ten</option>
						<option value="eleven">eleven</option>
						<option value="twelve">twelve</option>
				</select></td>

			</tr>
			
			<tr id="RELIEVING_ID">

				<td align='left'>Notice Period</td>
				<td align='left'><select id="relieving" name="relieving"
					style='width: 180px'>
						<option value="Select">--Select One--</option>
						<option value="one">one</option>
						<option value="two">two</option>
						<option value="three">three</option>
						<option value="four">four</option>
						<option value="five">five</option>
						<option value="six">six</option>
						<!-- <option value="seven">seven</option>
						<option value="eight">eight</option>
						<option value="nine">nine</option>
						<option value="ten">ten</option>
						<option value="eleven">eleven</option>
						<option value="twelve">twelve</option> -->
				</select></td>

			</tr>
			
			<tr id="DATE_1">
				<td align='left'>Date(As per Offer Letter)</td>
				<td align='left'><input type="text" id="datepicker" name="datepicker" style='width: 176px'></td>
			</tr>
			
			
			<tr>
				<td align='left'>Employee Name</td>
				<td><span id="displayname" style="color: blue"></span></td>
				<!--   <td> &nbsp; </td>  -->
			</tr>

			<tr>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><span id="errormsg" style="color: red"></span></td>
				<!--   <td> &nbsp; </td>   -->
			</tr>
		</table>

		 <div align="left"  style="margin-left: 280px;" >
        
         
			<!-- 	<ul >
				 <li>
				 <b><em>Note for Button Usage:</em></b>
				 </li>
				 <li><b><em> Reset: </em></b> Clears the data in the form.</li>
				 <li><b><em> GetData: </em></b>If you click this button existing generated report is displayed in the below screen or it Generate new  </li>
				 <li><b><em> ReGenerate: </em></b> If any entry mistake regarding ProbationPeriod or etc,new file will be generated(only for AppointmentLetter)</li>
				 </ul> -->
		</div>

		<p align="center" style="margin-right: 100px;">
		
		
		 <input type="reset"  value="Reset"
				style="font-size: 10pt; color: white; background-color: #0088cc; border: 2px solid #336600; padding: 3px" onclick="Reset()">
		    
		
			<input type="button" onclick="GetData(this);" value="GetData"
				style="font-size: 10pt; color: white; background-color: #0088cc; border: 2px solid #336600; padding: 3px">

			<!-- <input type="button" onclick="GetData(this)" value="ReGenerate"
				id="ReGenerate"
				style="font-size: 10pt; color: white; background-color: #0088cc; border: 2px solid #336600; padding: 3px"> -->
		</p>

		<br> <span id="errormsg" style="color: red; margin-right: 220px;"></span>

		<br> <input type="hidden" id="PassEmployeeid"
			name="PassEmployeeid">
			
			<input type="hidden" id="CallGetfunction"
			name="CallGetfunction">

<div  align='center' style="display: none;" id="displaybutton">
			<input   type="button" value="Printall" onclick="PrintAll(this);"  style="font-size: 10pt; color: white; background-color: #0088cc; border: 2px solid #336600; padding: 3px">

		</div>	
			
		<div style="overflow: scroll; height: 300px;" align="center">

			<table id="dataTable"></table>
			<!--  <p align="center"><img id='Search_Scrolling' src="Process.gif" alt="Smiley face" height="50" width="80" style='display:none'></p>
													  -->



		</div>

		

		<!--  <div id="myModal" class="modal" style="display:none">

  Modal content
  <div class="modal-content">
    <div class="modal-header"></div>
    <div class="modal-body">Comment :	
    <div><textarea rows="4" cols="50" id="comment" name="comment" ></textarea></div>
    <div><input type="button" value="Submit"></div>	 
    </div>
    <div class="modal-footer"></div>
  </div>

</div>
	  -->



		<!-- 	<p align="center" id="download" style="display:none"><button  style="font-size:10pt;color:white;background-color:green;border:2px solid #336600;padding:3px"> Export</button></p>
  -->

	</form>
	<!--  <script src="Script/BuScript.js"></script> -->

<script>
$('#datepicker').datepicker({
	yearRange : "-90:+0",
	changeMonth : true,
	changeYear : true,
	maxDate:0,
	dateFormat : 'dd-mm-yy'

});

</script>

	<script>
			
	
	
function GetData(val)
{
	
	//alert("");
	$('input[name="employeeid"]').prop("disabled",false);
	var flag=false;
  //  alert($('#CallGetfunction').val());
	if($('#CallGetfunction').val()==101||$('#CallGetfunction').val()==100||$('#CallGetfunction').val()==""||$.trim($('#CallGetfunction').val()).length==0)
		{
		   
		
		  flag=true;
		    
		}
	
	
	else {
	//	alert("Not Call Ajax Fnction")
	    return false;
	
	}
	
	/* if(flag)
		{
		 alert("Oppppp");
		} */
	 
	
	
	
	
	$('#displaybutton').hide();
//	alert(val.value)
	var routingtype=val.value;	
	var AllDivisions="";
	$("#Division option").each(function(){
		if($(this).val()!='Select'){			
			AllDivisions=AllDivisions.concat($(this).val()).concat(",");
		}		 
			});
	$('#errormsg').html('');	
	var form=document.getElementById("myform");
	var Division=document.getElementById("Division").value;
	var lettertype=document.getElementById("lettertype").value;
	var employeeid=document.getElementById("employeeid").value;
	var probation=document.getElementById("probation").value;
	var date=document.getElementById("datepicker").value;
	var relieving=document.getElementById("relieving").value
	var oldctc=document.getElementById("old_ctc").value;
	var newctc=document.getElementById("new_ctc").value;
	
	/* if(Division=="Select"){	
		alert('Please Select BusinessUnit');
		 form.Division.focus();
		return false;
		
	} */
	
 if(lettertype=="Select"&&flag){
		//alert('Please Select LetterType');
		$('#errormsg').html("Please Select LetterType");
		$("#dataTable").empty();
		 form.lettertype.focus();
		return false;
	}/* else if(lettertype=="AppointmentLetter" && Division=="Select" && $.trim(employeeid)==0){
		
		$('#errormsg').html("Please Select Atleast One Businessunit");
		$("#dataTable").empty();
		
		//document.getElementById("Division").focus();
		$('#Division').focus();
		// form.Division.focus();
		return false;
	
	} */
	
	else if(lettertype=="AppointmentLetter" && $.trim(employeeid).length==0 &&flag){
		
		$('#errormsg').html("Please enter Employee ID");
		$("#dataTable").empty();
		 form.employeeid.focus();
		 return false;
	}
	
	else if(lettertype=="AppointmentLetter" &&(employeeid.length>6 || employeeid.length<5)&&flag){
			//alert();
			$('#errormsg').html("Please Enter EmployeeId 5 to 6 Digits");
			$("#dataTable").empty();
			form.employeeid.focus();
			return false;
		//return true;
	}
	
	//lettertype=="AppointmentLetter" && probation=="Select" && $.trim(employeeid)!=0 && Division=="Select"&&flag
	
	else if(lettertype=="AppointmentLetter" && probation=="Select"&&flag){
		
		$('#errormsg').html("Please Select Probation");
		$("#dataTable").empty();
		 form.probation.focus();
		 return false;
		 
		
	}
	 //lettertype=="AppointmentLetter" && probation!="Select" && $.trim(employeeid)!=0 && Division=="Select" && relieving=="Select"&&flag
	else if(lettertype=="AppointmentLetter"&& relieving=="Select"&&flag){
		
		$('#errormsg').html("Please Select Resignation Period");
		$("#dataTable").empty();
		 form.relieving.focus();
		 return false;
	}
	//lettertype=="AppointmentLetter" && probation!="Select" && $.trim(employeeid)!=0 && Division=="Select" && $.trim(date)==0&&flag
	else if(lettertype=="AppointmentLetter"&& $.trim(date).length==0&&flag){
		
		$('#errormsg').html("Please Select Date");
		$("#dataTable").empty();
		 form.datepicker.focus();
		 return false;
		
	} 
	 
	else if(lettertype=="PromotionLetter" && $.trim(employeeid).length==0&&flag){
		
		$('#errormsg').html("Please enter Employee ID");
		$("#dataTable").empty();
		 form.employeeid.focus();
		 return false;
		
	} else if(lettertype=="PromotionLetter" &&(employeeid.length>6 || employeeid.length<5)&&flag){
		//alert();
		$('#errormsg').html("Please Enter EmployeeId 5 to 6 Digits");
		$("#dataTable").empty();
		form.employeeid.focus();
		return false;
	//return true;
	}else if(lettertype=="PromotionLetter" && $.trim(oldctc).length==0&&flag){
		
		$('#errormsg').html("Please enter Previous CTC");
		$("#dataTable").empty();
		 form.old_ctc.focus();
		 return false;
		
	}else if(lettertype=="PromotionLetter" && $.trim(newctc)==0 &&flag){
		
		$('#errormsg').html("Please enter Current CTC");
		$("#dataTable").empty();
		 form.new_ctc.focus();
		 return false;
		
	}
	/* else if(lettertype=="AppointmentLetter" && probation=="Select"){		
		$('#errormsg').html("Please Select Probation");
		$("#dataTable").empty();
		 form.probation.focus();
		 return false;
	} */else if((employeeid!=""||$.trim(employeeid).length!=0)&&flag){
		if((employeeid.length>6 || employeeid.length<5)&&flag){
			//alert();
			$('#errormsg').html("Please Enter EmployeeId 5 to 6 Digits");
			$("#dataTable").empty();
			form.employeeid.focus();
			return false;
		}
		//return true;
	}
	
//alert("alert");
	//alert($('input[name="bu"]:checked').length);
	
/* 	Lettertype=document.getElementById('lettertype').value;
	Division=document.getElementById('Division').value */
	
	 
	
//	alert(document.getElementById('lettertype').value);
//	alert(Division);	
	 try {
			// alert("In Script-2.1");
			//EmployeeCode
			
			//alert($('#EmployeeCode1').val());
			//alert($('#Division1').val());
			$.ajax({
				type : "get",
				url : "EmployeeDetails",
				data:{lettertype:lettertype,Bussinessunit:Division,employeeid:employeeid,type:"ViewReport",AllDivisions:AllDivisions.replace(/.$/,""),
					probation:probation,routing:routingtype,date:date,relieving:relieving,oldctc:oldctc,newctc:newctc},
				success : function(responseData, textStatus, jqXHR) {
					 
			//		alert(responseData);
			//	alert($.trim(responseData));                // $.trim(responseData).replace('[]',"").length (Correct for jquery for length finding )
					if($.trim(responseData).replace('[]',"").length==0){						
						//alert("Employee");
						$('#errormsg').html("No Data Found");
						$("#dataTable").empty();						
					}
					else if(responseData==1)
						{
						//alert("Not Exist");
						$('#errormsg').html("EmployeeId Not Exist");
						$("#dataTable").empty();
						}
					else if(responseData==2)
						{
						  $('#errormsg').html("EmployeeId Not Eligible");
						  
											  
						  $("#dataTable").empty();
						}					
					else{						
						loadData(responseData);
						 $('#errormsg').html("");
					}
					//loadData(responseData);
			      //   alert(loadData(responseData));			        		 
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);
					alert("Error;" + textStatus);
					alert("Error;" + errorThrown);
					alert("jqXHR;" + jqXHR.status);
				}
			});
		} catch (err) {
			alert(err + ":at Last");
		}		
}  /* End Of GetData() function */


function loadData(datas){
	//alert(datas);
  var sb = '';
 var table = $('#dataTable'); 
 //.append('<tr><td> CheckAll </td><td> Employee ID </td><td>Name</td><td>Department</td><td>Designation</td><td>DOJ</td></tr>');
// $('#json').show();
 table.html('');
var newdata=eval(datas);
   sb += '<tr>';
 $.each(newdata, function(index,jsonObject){	 
	    $.each(jsonObject, function(key,val){		    	
		    sb += ' <td>' + val+ '</td>';
		    });		    
		    sb += '</tr>';
		});
 table.append('<tr><th><input type="checkbox" value="CheckAll" id="CheckAll" onclick="CheckAllData(this);"> # </th><th> Employee ID </th><th>Name</th><th>Department</th><th>Designation</th><th>DOJ</th><th>#</th></tr>');
 table.append(sb);  
}

function Print(val){
	$('#PassEmployeeid').val(val.id);
	// $('div input').attr('checked', true);
	if($('#PassEmployeeid').val()!=""){		
		document.getElementById("myform").submit();
	}	
}

function PrintAll(val){
	var Data1="";
	$("input[type=checkbox][name=check]:checked").each(function() {
	   // alert($(this).val());
	    Data1=Data1.concat($(this).val()).concat(",");
	    //Data=Data.append($(this).val());
	});	
	//alert(Data1.replace(/.$/,""));	 
$('#PassEmployeeid').val(Data1.replace(/.$/,""));	
//	$('#Search_Scrolling').show();		
	// $('div input').attr('checked', true);   	
		document.getElementById("myform").submit();	 
}

	/* $('#Division').on('change', function() {
		$('#errormsg').html("");
		}); */
	
function CheckAllData(val){
	//Print(val);
	//alert(val.value);
	if(val.value=="CheckAll")
	{
	if(document.getElementById("CheckAll").checked==true)
	{
	var group = "input:checkbox[name='check']";
	$(group).prop("checked", true);
	//jQuery("input[type='text']").attr("disabled", 'disabled');
	$('input[name="employeeid"]').prop("disabled",true);          // oncheck All print button gets disable
	$('#displaybutton').show();
	}
	else if(document.getElementById("CheckAll").checked==false)
	{
	var group = "input:checkbox[name='check']";
	$(group).prop("checked", false);
	$('input[name="employeeid"]').prop("disabled",false);    // uncheck print button gets enabled
	$('#displaybutton').hide();
	} 
	}
}

function Check(val)
{
	//alert($('[name="check"]:checked').length);
	if($('[name="check"]:checked').length>1)
		{
		
	//	var group = "input:checkbox[name='check']";
	//	$(group).prop("checked", true);
		$('input[name="employeeid"]').prop("disabled",true);
		/* var group = 'input[name="employeeid"]';
		$(group).attr("disabled", true);*/
	//	$('#CheckAll').hide();
		$('#displaybutton').show(); 
		}
	else{
	//	$('#CheckAll').disable(true);
	$('input[name="employeeid"]').prop("disabled",false);
	/* 	var group = 'input[name="employeeid"]';
		$(group).prop("disabled", false); */
		$('#displaybutton').hide();
	}	 
}
	

 function DisplayName(){

	 
	
			$('#errormsg').html('');
			$('#displayname').html('');
			
			
			var AllDivisions = "";

			$("#Division option").each(
					function() {
						if ($(this).val() != 'Select') {
							AllDivisions = AllDivisions.concat($(this).val()).concat(",");
							 
						}
					});
			
			
			
			
			 if($('#lettertype').val()=='Select')
					
				{
				  // alert(".....");
		//		   $('#displayname').html("Please Select LetterType....");
				   
				   return false;
				}
			
			  
	      else if ($('#employeeid').val().length==0) {
					//alert();
					$('#displayname').html('');
					$('#errormsg').html("Please enter Employee ID");
					$("#dataTable").empty();
					return false;
			}
			 
	      else if ($('#employeeid').val().length > 6 || $('#employeeid').val().length < 5) {
					//alert();
					$('#displayname').html('');
					$('#errormsg').html("Please Enter EmployeeId 5 to 6 Digits");
					$("#dataTable").empty();
					return false;
				}
			  

			//alert("bhanu"+$('#employeeid').val()+"<--------->"+AllDivisions);
			
			 

			else  {
				try {

					$.ajax({
						type : "get",
						url : "DisplayName",
						data : {
							employeeid : $('#employeeid').val(),
							AllDivisions : AllDivisions.replace(/.$/, ""),
							lettertype : $('#lettertype').val(),
							division : $('#Division').val()
						},
						success : function(responseData, textStatus, jqXHR) {
					
						//	alert(responseData);
							var displayname = responseData.split('~');

							var data1 = displayname[0];
							var data2 = displayname[1];
							var data3=displayname[2];
							var data4=displayname[3];
							var data5=displayname[4];
							var data6=displayname[5];
				//			alert(data1 + "<->" + data2 +":::"+data3+":::"+data4+":::"+data5);
							

							//alert($('#displayname').html(displayname[1]));
							
							
							
							if (data1 == 100) {
								if(data3=="AppointmentLetter"){
									
									
									$('#datepicker').val(data5);
									$('#probation').val(data4);
									$('#relieving').val(data6);
									$('#displayname').html(data2);
									$('#ReGenerate').show();
									$('#dataTable').empty();
									$('#CallGetfunction').val(data1);
								} else if(data3=="PromotionLetter"){
									
									$('#new_ctc').val(data5);
									$('#old_ctc').val(data4);
									$('#displayname').html(data2);
									$('#ReGenerate').hide();
									$('#CallGetfunction').val(data1);
								}
									
									else {
									$('#displayname').html(data2);
									$('#ReGenerate').hide();
								}
							} 
							
							else if (data1 == 101) {
								if (data3 == "AppointmentLetter") {
									$('#datepicker').val('');
									$('#probation').val('Select');
									$('#relieving').val('Select');
									$('#displayname').html(data2);
									$('#ReGenerate').hide();
									$('#dataTable').empty();
									
									$('#CallGetfunction').val(data1);
									
								}else if(data3=="PromotionLetter"){
									
									$('#new_ctc').val('');
									$('#old_ctc').val('');
									$('#displayname').html(data2);
									$('#ReGenerate').hide();
									
									$('#CallGetfunction').val(data1);
								} 
								else {
									$('#displayname').html(data2);
									$('#ReGenerate').hide();
									
									
								}
							}
							
						//Finall Else Code No:"2"	
                          else  {
								
								$('#datepicker').val('');
								$('#probation').val('Select');
								$('#relieving').val('Select');
								$('#displayname').html(data2);
								$('#ReGenerate').hide();
								
								$('#CallGetfunction').val(data1);
							}

							//loadData(responseData);
							//   alert(loadData(responseData));

						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(errorThrown);

							alert("Error;" + textStatus);
							alert("Error;" + errorThrown);

							alert("jqXHR;" + jqXHR.status);

						}
					});
				} catch (err) {

					alert(err + ":at Last");
				}
			}  /* else {
				$('#datepicker').val('');
				$('#probation').val('Select');
				$('#relieving').val('Select');
				$('#displayname').html("");
			}  */
		}
		/* try {
			// alert("In Script-2.1");
			//EmployeeCode
			
			//alert($('#EmployeeCode1').val());
			//alert($('#Division1').val());
			
			Lettertype=document.getElementById('lettertype').value;
			$.ajax({
				type : "get",
				url : "LetterPrintReport",
				data:{lettertype:Lettertype,employeeid:val.name},
				success : function(responseData, textStatus, jqXHR) {
					 
			       
					
				//	loadData(responseData);
			      //   alert(loadData(responseData));
			        		 
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);
				 
					alert("Error;" + textStatus);
					alert("Error;" + errorThrown);

					alert("jqXHR;" + jqXHR.status);

				}
			});
		} catch (err) {

			alert(err + ":at Last");
		}	 */

		/* function Popup(val){
			
			$('#PassEmployeeid').val(val.id);
			alert($('#PassEmployeeid').val());
		//		$('#myModal').show({ type: "html", htmlSelector: "#comment" });

			
			Lettertype=document.getElementById('lettertype').value;
				
			employeeid=$('#PassEmployeeid').val();

			  try {
					// alert("In Script-2.1");
					//EmployeeCode
					
					//alert($('#EmployeeCode1').val());
					//alert($('#Division1').val());
					$.ajax({
						type : "get",
						url : "EmployeeDownloadCheck",
						data:{lettertype:Lettertype,employeeid:employeeid},
						success : function(responseData, textStatus, jqXHR) {
							 
							alert(responseData);
							if(responseData==1)
								{
								//alert("Not Exist");
								$('#myModal').show();
								$('#errormsg').html("EmployeeId Not Exist");
								$("#dataTable").empty();
								}
							else if(responseData==2)
								{
								  $('#errormsg').html("EmployeeId Not Eligible");
								  $("#dataTable").empty();
								}
							
							else{
								
								loadData(responseData);
								 $('#errormsg').html("");
							}
							
							
							//loadData(responseData);
					      //   alert(loadData(responseData));
					        		 
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(errorThrown);
						 
							alert("Error;" + textStatus);
							alert("Error;" + errorThrown);

							alert("jqXHR;" + jqXHR.status);

						}
					});
				} catch (err) {

					alert(err + ":at Last");
				}	
				 	
			
		}
		 */
		function AdhadarisNumber(evt) {
			evt = (evt) ? evt : window.event;
			var charCode = (evt.which) ? evt.which : evt.keyCode;
			if (charCode >= 48 && charCode <= 57) {
				return true;
			}
			return false;
		}
		 
		 function CTCisNumber(evt) {
				evt = (evt) ? evt : window.event;
				var charCode = (evt.which) ? evt.which : evt.keyCode;
				if (charCode==46 || charCode >= 48 && charCode <= 57) {
					return true;
				}
				return false;
			}

		$('#Division,#employeeid,#probation,#datepicker').change(function() {

			//	$('#probation').val('Select');
			//	$('#displayname').html('');
			
			$('#displaybutton').hide();
			$('#dataTable').empty();
			$('#errormsg').html("");
		});

		$('#employeeid').keyup(function() {
			$('#errormsg').html("");
		});

		$('#lettertype').change(function() {
			//	alert('1');
			
			$('#OLD_CTC_1,#NEW_CTC_1').hide();
			$('#displaybutton').hide();
			$('input[name="employeeid"]').prop("disabled", false);
			$('#dataTable').empty();
			$('#errormsg').html('');
			$('#employeeid').val('');
			$('#displayname').html('');
			$('#ReGenerate').hide();
			$(this).find("option:selected").each(function() {
				if ($(this).attr("value") == "AppointmentLetter") {

					$('#RELIEVING_ID').show();
					$('#PROB_ID,#probation,#DATE_1').show();
					$('#probation').val('Select');
					
					$('#BU_ID').hide();
					$('#Division').hide();

				} else if($(this).attr("value")=="PromotionLetter"){
					$('#old_ctc').val('');
					$('#new_ctc').val('');
					$('#OLD_CTC_1,#NEW_CTC_1').show();
					$('#RELIEVING_ID').hide();
					$('#PROB_ID,#probation,#DATE_1').hide();
					$('#BU_ID').hide();
					$('#Division').show();
					$('#Division').val('Select');
					
					
				}else if($(this).attr("value")=="Select"){
					
					$('#OLD_CTC_1,#NEW_CTC_1').hide();
					$('#RELIEVING_ID').hide();
					$('#PROB_ID,#probation,#DATE_1').hide();
					$('#BU_ID').hide();
					/* $('#Division').show();
					$('#Division').val('Select'); */
					$('#ReGenerate').hide();
				}else {
					
					$('#OLD_CTC_1,#NEW_CTC_1').hide();
					$('#RELIEVING_ID').hide();
					$('#PROB_ID,#probation,#DATE_1').hide();
					$('#BU_ID').show();
					$('#Division').show();
					$('#Division').val('Select');
					$('#ReGenerate').hide();
				}
			});
		});

		function Reset()

		{
			$('#ReGenerate').hide();
			$('#errormsg').html('');
			$('input[name="employeeid"]').prop("disabled", false);
			$('#displaybutton').hide();
			$('#displayname').html('');
			$('#dataTable').empty();
		}
	</script>





	<!-- <script type="text/javascript">

$("button").click(function(){
	
	var d = new Date();
	var filename = d.getTime();
	 
	  $("#table2excel").table2excel({
	    // exclude CSS class
	    exclude: ".noExl",
	    name: "Worksheet Name",
	    filename: "Hetero".concat(''+filename+'') //do not include extension
	  }); 
	});
	
	
	
	
	

</script> -->
</body>
<!-- <style type="text/css">
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
</style> -->
</body>
</html>
<%
/* 	 } 
 else
{
	response.sendRedirect("login");
}  */
%>
