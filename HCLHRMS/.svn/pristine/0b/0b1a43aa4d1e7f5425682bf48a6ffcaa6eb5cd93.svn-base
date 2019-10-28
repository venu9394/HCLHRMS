<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@page import="java.sql.*"%>



<%
    System.out.println("Hi Iam in Letters.jsp");
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
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

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
  body{
  
  font-family:calibri;
  font-size:14px;
  }
    table{
         width: 60%; 
        
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


<style>

input[type="text"]
 {
    width:189px;        
 }
 input[type="button"]{
 
	width:50x;    
 }
 select{
  width:190px; 
 }
</style>
</head>


 <!-- background="lily.jpg" -->

<body   align="center" onload="Load()">   
								
									 <div id="dd" class="wrapper-dropdown-1" align="right">
										
									<%--  		<a role="menuitem" tabindex="-1" href="Logout"><span><font
														class="admin"><%=username %></font></span><br> <span
													class="logout">Logout</span></a>  --%>
										
								 </div> <br>
	
  <form method="Post" action="LetterPrintReport" id="myform">				




<table align='center' border='1'>
  
  <tr style="color:white;"><th colspan='3' align='left'>Employee Letters Download </th></tr>
  
  <tr>
	  <td>&nbsp;</td> 
	  <td>&nbsp; </td> 
	 <!--  <td> &nbsp; </td>  -->
  </tr>
  
  <tr> 
    <td align='left'>Business Unit </td> 
   <td align='left'> <select class="form-control" name="Division" id="Division" style='width:180px'>
    <option value="Select">--Select one --</option>
    </select>
   </td>
 <!--  <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
 </tr>
 <tr> 
        <td align='left'>Letter Type  </td> 
		<td align='left'>
		<select id="lettertype" name="lettertype"  style='width:180px'>
		<option value="Select">--Select One--</option> 
		<option value="AppointmentLetter">Appointment Letter</option> 
		<option value="ConfirmationLetter">Confirmation Letter</option>
		<option value="PromotionLetter">Promotion Letter</option>
		<option value="TransferLetter">Transfer Letter</option>
		
       </select>

		</td> 
		
		<!-- <td> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>  -->
</tr>
 <tr>
	  <td align='left'>Employee ID</td> 
	  <td align='left'><input type="text" id="employeeid" name="employeeid" onkeypress="return AdhadarisNumber(event)" onblur="DisplayName();" style='width:176px'>
	  &nbsp; </span>
	  </td> 
	 <!--  <td> <span id="displayname"></span> &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
  </tr>
 
 <tr>
	  <td align='left' >Employee Name</td> 
	  <td><span id="displayname"></span></td> 
	 <!--  <td> &nbsp; </td>  -->
  </tr>
  
  <tr>
	  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td> 
	  <td> <span id="errormsg" style="color:red"></span></td> 
	 <!--  <td> &nbsp; </td>  -->
  </tr>
</table>


<p align="center" style="margin-right:220px;">
<input type="button" onclick="GetData();" value="Search" style="font-size:10pt;color:white;background-color:#0088cc;border:2px solid #336600;padding:3px"></p>
 <br>
 

 
 <br>
<input type="hidden" id="PassEmployeeid" name="PassEmployeeid">

					<div style="overflow: scroll; height:300px;" align="center">								  
													
													  <table  id="dataTable" style="width:80%;" border='1'>
													  
													  </table>
													 <!--  <p align="center"><img id='Search_Scrolling' src="Process.gif" alt="Smiley face" height="50" width="80" style='display:none'></p>
													  -->
													  
													  
													  
													  </div>
													 
													 <div style="display: none;" align='center' id="displaybutton">
													 <input type="button" value="Download" onclick="PrintAll(this);" style="background-color:blue;color:white;">
													 
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
 <!-- <script src="Script/BuScript.js"></script> -->

<script>
function GetData()

{
	
	
	
	var AllDivisions="";
	
	$("#Division option").each(function()
			{
		if($(this).val()!='Select'){
			
			AllDivisions=AllDivisions.concat($(this).val()).concat(",");
		}
		 
		
		 
			});
	
	
	
	$('#errormsg').html('');
	
	var form=document.getElementById("myform");

	var Division=document.getElementById("Division").value;

	var lettertype=document.getElementById("lettertype").value;

	 var employeeid=document.getElementById("employeeid").value;


	/* if(Division=="Select"){	
		alert('Please Select BusinessUnit');
		 form.Division.focus();
		return false;
		
	} */
	if(lettertype=="Select"){
		//alert('Please Select LetterType');
		$('#errormsg').html("Please Select LetterType");
		$("#dataTable").empty();
		 form.lettertype.focus();
		return false;
	}else if(Division=="Select" && $.trim(employeeid)==0){
		
		$('#errormsg').html("Please Select Atleast One Businessunit");
		$("#dataTable").empty();
		
		//document.getElementById("Division").focus();
		$('#Division').focus();
		// form.Division.focus();
		return false;
	
	}else if(employeeid!=""||$.trim(employeeid)!=0){
		//$.trim(employeeid)
		//alert("tyt");
		if(employeeid.length>6 || employeeid.length<5 ){
			
			//alert();
			$('#errormsg').html("EmployeeId should be 5/6 Digits");
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
				data:{lettertype:lettertype,Bussinessunit:Division,employeeid:employeeid,type:"ViewReport",AllDivisions:AllDivisions.replace(/.$/,"")},
				success : function(responseData, textStatus, jqXHR) {
					 
				//	alert(responseData);
			//	alert($.trim(responseData).length);
		//	alert(eval(responseData.trim()).length);
	//	alert($.trim(responseData).replace('[]',"").length);
			
			
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
				 
					//alert("Error;" + textStatus);
					alert("Error:" + errorThrown);

					//alert("jqXHR;" + jqXHR.status);

				}
			});
		} catch (err) {

			alert(err + ":at Last");
		}	
		 	 

		
}


function loadData(datas){
	 
	//alert(datas);
  var sb = '';
 var table = $('#dataTable');
 
 //.append('<tr><td> CheckAll </td><td> Employee ID </td><td>Name</td><td>Department</td><td>Designation</td><td>DOJ</td></tr>');
// $('#json').show();
 
 table.html('');
 
 

var newdata=eval(datas);


 
 
   sb += '<tr>';
 
   	//sb +='<th><input type='checkbox'>''</th>'	;
 
 $.each(newdata, function(index,jsonObject){
	 
	         //  alert(index);
	         
	         
	        
		    $.each(jsonObject, function(key,val){
		    	
		    	// alert("key : "+key+" ; value : "+val);
		         
		   
		          sb += ' <td>' + val+ '</td>';
		        
				     
				    
				  
		    });
		    
		    sb += '</tr>';
		});
 table.append('<tr style="color:white;" ><th><input type="checkbox" value="CheckAll" id="CheckAll" onclick="CheckAllData(this);"> # </th><th> Employee ID </th><th>Name</th><th>Department</th><th>Designation</th><th>Dateofjoin</th><th>#</th></tr>');

 table.append(sb);  
 
  
	
}




function Print(val){
	
	//alert(val.id);
	$('#PassEmployeeid').val(val.id);
	
//	$('#Search_Scrolling').show();
	
	
	// $('div input').attr('checked', true);
	if($('#PassEmployeeid').val()!="")
		{
		
		document.getElementById("myform").submit();
		
		
		}
	
}


function PrintAll(val)
{
	
	
	
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

		
		
		
 $('#Division,#lettertype').change(function(){
		
		$('#errormsg').html("");
		
	 
		
	});
	
	$('#employeeid').keyup(function(){
		$('#errormsg').html("");
	});

	
	
	 
	
function CheckAllData(val){
	
	//Print(val);
	//alert(val.value);
	
	
	if(val.value=="CheckAll")
	{
	if(document.getElementById("CheckAll").checked==true)
	{
	var group = "input:checkbox[name='check']";
	$(group).prop("checked", true);
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
	if($('[name="check"]:checked').length>0)
		{
		var group = 'input[name="employeeid"]';
		$(group).prop("disabled", true);
		$('#displaybutton').show();
		}
	else{
		
		var group = 'input[name="employeeid"]';
		$(group).prop("disabled", false);
		$('#displaybutton').hide();
	}
		 
	
}
	

 function DisplayName(){
	 
$('#employeeid').val();
 //alert("bhanu"+$('#employeeid').val());
 
 
 if($('#employeeid').val()!=""){
 try {
	
		$.ajax({
			type : "get",
			url : "DisplayName",
			data:{employeeid:$('#employeeid').val()},
			success : function(responseData, textStatus, jqXHR) {
				 
			//	alert(responseData);
			
				$('#displayname').html(responseData);
				
				//loadData(responseData);
		      //   alert(loadData(responseData));
		        		 
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
			 
				//alert("Error;" + textStatus);
				alert("Error:" + errorThrown);

				//alert("jqXHR;" + jqXHR.status);

			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}	
 }	 	 
else{
	
	$('#displayname').html("");
}
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
	   // var regexp=/^[a-zA-Z,\/,0-9]+$/;
	         
	    
	    
	 // alert(charCode);
	    /*if (( !charCode==64 &&  charCode > 49 && charCode < 123)|| charCode==16 ||charCode==47  &&   96 <= charCode && charCode <= 105) {*/
	    	if ( charCode>=48 && charCode<=57 ) {
	    	return true;
	    }
	    return false;
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

