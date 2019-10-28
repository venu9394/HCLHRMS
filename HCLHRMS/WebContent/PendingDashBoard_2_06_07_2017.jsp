<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	String DashBoard=(String)request.getAttribute("DASHBOARD");
	String LOGINBY=(String)request.getAttribute("LOGINBY");
%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
/* Tooltip container */
.tooltip {
    position: relative;
    display: inline-block;
    cursor: pointer;
   /*  border-bottom: 1px dotted black; */ /* If you want dots under the hoverable text */
   text-decoration:none;
   text-color:red;
}
/* Tooltip text */
.tooltip .tooltiptext {
    visibility: hidden;
    width: auto;
    background-color: #ddd;
    color: #;
    text-align: center;
    padding: 5px 0;
    border-radius: 6px;
    
    font-size:10px;
    /* Position the tooltip text - see examples below! */
    position: absolute;
    z-index: 1;
}

/* Show the tooltip text when you mouse over the tooltip container */
.tooltip:hover .tooltiptext {
    visibility: visible;
}
#th{
background-color:#ddd;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
function load(){
	
	var Data=eval(<%=DashBoard%>);
	try{
	 var j=0;
	 var Count=0;
	 var Data_load;
		for(var i=0;i<Data.length;i++){
 		  Data_load="<table width='100%'>";
 		$.each(Data[i], function(k, v) {
            Count=Data[i].FinalCount;
            if(k=="FinalCount"){
            	Count=v; 	
            }
           if(k!="FinalCount"){
        	   $("#"+k).html(Count);
           $.each(v, function(M, N) {
        	   Data_load=Data_load+"<tr><td>"+M+"</td><td>"+N+"</td></tr>";
           });
           Data_load=Data_load+"</table>"
           $("#"+k+"_T").html(Data_load);
           }
       });
 		
		}
	}catch(err){
		
		alert(err.message);
	}
}
</script>
</head>
<body Onload="load();">
<div class="w3-container">
   <table class="w3-table-all">
  	<tr>
  	<th colspan="9" style="text-align:center;">Employee Pending Details</th>
  	</tr>
  	 <tr>
      <th colspan="3" id="th" style="text-align:center;">Personal Details</th>
      <th colspan="3" id="th" style="text-align:center;">Professional Details</th>
      <th colspan="3" id="th" style="text-align:center;">Other Details</th>
    </tr>
   <tr>
   <td>Address</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"> <span id='ADD' > </span>  </i> <span class="tooltiptext" id='ADD_T'></span></div></td>
   <td> <a href="ExcelDownload?type=query1&&name=a.permanentaddress&&LOGINBY=<%=LOGINBY%>"  style='text-decoration:none;'" ><i class="fa fa-download"></i> </a></td>
   <td>Department </td>
   <td><div class="tooltip"> <i class="fa fa-external-link-square"> <span id='DEPART'> </span> </i>
   <span class="tooltiptext" id='DEPART_T'> 
   </span>
   </div></td>
   <td><a href="ExcelDownload?type=query3&&name=a.departmentid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' > <i class="fa fa-download"></i> </a> </td>
   <td>Bank Account Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"> <span id='BANK'></span></i> </i><span class="tooltiptext" id='BANK_T'> </span></div></td>
   <td> <a href="ExcelDownload?type=query2&&name=a.accountno&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'> <i class="fa fa-download"></i> </a> </td>
   </tr>
   <tr>
   <td>Mobile Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"> <span id='MOB'></span> </i><span class="tooltiptext" id='MOB_T' > </span></div></td>
   <td> <a href="ExcelDownload?type=query1&&name=a.mobile&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' > <i class="fa fa-download"> </i> </a></td>
   <td>Designation</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square">  <span id='DES'> </span> </i>
   <span class="tooltiptext" id='DES_T' >
   </span>
   </div>
   </td>
   <td> <a href="ExcelDownload?type=query3&&name=a.designationid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' > <i class="fa fa-download"></i> </a></td>
   <td>PF No</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"><span id='PF'></span></i><span class="tooltiptext" id='PF_T'> </span></div></td>
   <td> <a href="ExcelDownload?type=query2&&name=a.pfno&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'> <i class="fa fa-download"></i> </a></td>
   </tr>
   <tr>
   <td>E-Mail Id's</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"><span id='EMAIL'></span></i><span class="tooltiptext" id='EMAIL_T'></span></div></td>
   <td><a href="ExcelDownload?type=query1&&name=a.email&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'> <i class="fa fa-download"></i> </a></td>
   <td>Work Location</td>
   <td><div class="tooltip">
   <i class="fa fa-external-link-square"> <span id='WLC' > </span> </i>
    <span class="tooltiptext" id='WLC_T'> </span>
   </div></td>
   <td> <a href="ExcelDownload?type=query3&&name=a.worklocationid&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;'  > <i class="fa fa-download"></i> </a> </td>
   <td>ESI Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"> <span id='ESI'></span> </i><span class="tooltiptext" id='ESI_T'></span></div></td>
   <td><a href="ExcelDownload?type=query2&&name=a.esino&&LOGINBY=<%=LOGINBY%>" style='text-decoration:none;' > <i class="fa fa-download"></i></a></td>
   </tr>
  </table>
</div>
</body>
</html>