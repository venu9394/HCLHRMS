<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<%

String EMP_LOPLIST=(String)request.getAttribute("PAYPERIOD");


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
    border-bottom: 1px dotted black; /* If you want dots under the hoverable text */
}

/* Tooltip text */
.tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: black;
    color: #fff;
    text-align: center;
    padding: 5px 0;
    border-radius: 6px;
 
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
</head>
<body>
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
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   <td>Department</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   <td>Bank Account Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   </tr>
   <tr>
   <td>Mobile Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   <td>Designation</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i>
   <span class="tooltiptext">
   
   Tooltip text
   
   </span>
   
   </div>
   
   </td>
   <td><i class="fa fa-download"></i></td>
   <td>PF No</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   </tr>
   <tr>
   <td>E-Mail Id's</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   <td>Work Location</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   <td>ESI Number</td>
   <td><div class="tooltip"><i class="fa fa-external-link-square"></i><span class="tooltiptext">Tooltip text</span></div></td>
   <td><i class="fa fa-download"></i></td>
   </tr>
    
  </table>
</div>
</body>
</html>