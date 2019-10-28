<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.table2excel.js"></script>
<%
String EMP_LOPLIST=(String)request.getAttribute("PAYPERIOD");

String RoutingPage=(String)request.getAttribute("Routing");
String BU=(String)request.getAttribute("BU");
String ProcessedBy=(String)request.getAttribute("Pby");
String LOGINBY=(String)request.getAttribute("LOGINBY");
String GlobalMsg=(String)request.getAttribute("GlobalMsg");
String Mode="";

  if(GlobalMsg==null){
	  GlobalMsg="N";
  }else{
	  Mode="disabled";
  }
request.setAttribute("Routing", RoutingPage);
request.setAttribute("BU", BU);
request.setAttribute("Pby", ProcessedBy);
request.setAttribute("LOGINBY", LOGINBY);



%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=7,8,10,11"> 
<style type="text/css">
  body{
  
  font-family:calibri;
  font-size:12px;
  }
    table{
        /* width: 80%; */
        margin: 20px 0;
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
   
     background-color: #11F5A9;
    }

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

function Change_Field(val)
{
	
	alert(val);
	
	$("table tbody#dd1").empty();
	 $("table thead#thd1").empty();
	 
	if(val!="CallReport" && val=="select"){
		
		alert("select Payperiod..!");
		 $("table tbody#dd").empty();
		 $("table thead#thd").empty();
		return false;
		
	}
	$('#Search_Scrolling1').css('display', '');
	 var markup= markup ="";
	// $("table tbody#dd").empty();
	 
	// Search_Scrolling1
	var Type="Reports_PF";
	if(val!="CallReport"){
		Type="Reports";
	 }
	try {
		
		$.ajax({
			type : "get",
			url : "Fectch_Data",
			
			data:{ type:""+Type+"", PayPeriod:$('#payperiod').val() },
		
			success : function(responseData, textStatus, jqXHR) {
				
				 alert(responseData);
			
				var Data =eval(responseData);
				
				
				
				try {
					
				
					if(val!="CallReport"){
						
				    var theader={'SNO':'SNO','BUUNITID':'Business Unit'};
				    var Data_load="";
				    $.each(theader, function(k, v) {
				    	   Data_load=Data_load+"<th style='color:white;' align='center' >"+v+"</th>";
			       });
				    
				    $("table thead#thd").append(Data_load);
				    
						
					markup="";
					
					 var j=0;
					for(var i=0;i<Data.length;i++){
			    		 tempjason=Data[i];
			    	     j++;
			             markup = "<tr><td> "+j+" </td> <td><input type='checkbox' value="+tempjason.BUID+" name='chxbox' id='chxbox'> &nbsp; " + tempjason.BUNAME + " </td> </tr>";
			            <%-- var markup = "<tr><td><input type='checkbox' checked name='" + tempjason.SEQNO + "' disabled > </td><td>" + tempjason.SEQNO + "</td><td>" + tempjason.CALLNAME + "</td><td>" + tempjason.DATEOFJOIN + "</td><td> <input type='text' value='"+tempjason.LOP+"' name='"+tempjason.EMPID+"' id='" + tempjason.EMPID + "'  <%=Mode%> onkeypress='return isNumber(event)' style='width:50px' /> </td> <td></td> <td></td> <td></td> </tr>"; --%>
			            $("table tbody#dd").append(markup); 
			        }
					
					$('#Search_Scrolling1').css('display', 'none');
				}else{
					
					
					 /// var Data_rep1=Data_rep.split("##");
					
					   
					  
					 var theader={'ID':'ID','PFUAN':'PFUAN','MEMBER NAME':'MEMBER NAME','GROSS WAGES':'GROSS WAGES','EPF WAGES':'EPF WAGES','EPS WAGES':'EPS WAGES','EDLI Wages':'EDLI Wages','EPF Contribution_EE_Share_due':'EPF Contribution_EE_Share_due','EPS_Contribution_due':'EPS_Contribution_due','Diff EPF and EPS Contrbution_ER_Share_due':'Diff EPF and EPS Contrbution_ER_Share_due'};
					 /* var Data=Data_rep1[1];
					 
					 alert(theader);
					 
					 alert(Data); */
					 
					 //var theader={'SNO':'SNO','BUUNITID':'Business Unit'};
					 
					   var Data_load1="";
					    $.each(theader, function(l, v) {
					    	   Data_load1=Data_load1+"<th style='color:white;' align='center' >"+v+"</th>";
				       });
					    
					    $("table thead#thd1").append(Data_load1);
				
					   var Data_load="";
					
					for(var i=0;i<Data.length;i++){
				 		  Data_load="<tr>";
				 		$.each(Data[i], function(k, v) {
				           
				        	   Data_load=Data_load+"<td>"+v+"</td>";
				           
				           
				           $("#"+k+"_T").html(Data_load);
				          
				       });
				 		
				 		$("table tbody#dd1").append(Data_load+"</tr>");
				 		
						}
					
					$('#Search_Scrolling1').css('display', 'none');
					
					
				}
					/* document.getElementById('Field').length = 0;
					var comm_city = document.getElementById('Field');
					for (var i = 0; i < dat.length; i++) {
						myOption = document.createElement("option");
						myOption.text = dat[i].split("#")[1];
						myOption.value = dat[i].split("#")[0];
						comm_city.options.add(myOption);
					} */
					
				} catch (err) {
					$('#Search_Scrolling1').css('display', 'none');
					alert(err.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
				alert("Unable to connect Server Please Try again..");
				$('#Search_Scrolling1').css('display', 'none');
			}
		});
	} catch (err) {
		alert(err + ":at Last");
		$('#Search_Scrolling1').css('display', 'none');
	}
}

$(document).ready(function(){
    	
    	 var Data=eval('<%=EMP_LOPLIST%>');
    	// alert(Data.length);
       // $(".add-row").click(function(){
     <%-- var Data=JSON.parse('<%=EMP_LOPLIST%>'); --%>
    	 //alert("Data::"+Data.length);
    	 var tempjason="";
    	 var CALLNAME="";
    	 var j=0
    	 document.getElementById('payperiod').length=0;
    	 var selobj=document.getElementById('payperiod');
    	 myOption = document.createElement("option");
    	 myOption.text='--select--';
    	 myOption.value='select';
    	 selobj.options.add(myOption);
    	
    	 for(var i=0;i<Data.length;i++){
    		 tempjason=Data[i];
    		 
    		 myOption = document.createElement("option");
    		 myOption.text=""+tempjason.PAYPERIOD+"";
        	 myOption.value=""+tempjason.PAYPERIOD_KEY+"";
        	 
        	 selobj.options.add(myOption);
    		 
    		 
    	 }
    		// alert(tempjason);
    		// alert(tempjason.CALLNAME);
           /*  var name = $("#name").val();
            var email = $("#email").val(); */
            
         <%--    j++;
            var markup = "<tr><td> "+j+" </td> <td><input type='checkbox' value="+tempjason.PAYPERIOD_KEY+" name='chxbox'> &nbsp; " + tempjason.PAYPERIOD + " </td> </tr>";
            var markup = "<tr><td><input type='checkbox' checked name='" + tempjason.SEQNO + "' disabled > </td><td>" + tempjason.SEQNO + "</td><td>" + tempjason.CALLNAME + "</td><td>" + tempjason.DATEOFJOIN + "</td><td> <input type='text' value='"+tempjason.LOP+"' name='"+tempjason.EMPID+"' id='" + tempjason.EMPID + "'  <%=Mode%> onkeypress='return isNumber(event)' style='width:50px' /> </td> <td></td> <td></td> <td></td> </tr>";
            $("table tbody#dd").append(markup); --%>
    	  //}
        //});
        // Find and remove selected table rows
        $(".delete-row").click(function(){
            $("table tbody").find('input[name="record"]').each(function(){
                if($(this).is(":checked")){
                    $(this).parents("tr").remove();
                }
            });
        });
        
        
    });
    
    function isNumber(evt) {
    	evt = (evt) ? evt : window.event;
    	var charCode = (evt.which) ? evt.which : evt.keyCode;
    	//alert(charCode);
    	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	return false;
    	}
    	return true;
    	}

    
 function SetGlobalMsg(){ //Message
	 
	if('<%=GlobalMsg%>'=='N'){
	   document.getElementById("SubMBut").style.display='';
	   document.getElementById("Message").inerHTML='';
	}else{
		document.getElementById("SubMBut").style.display='none';
		document.getElementById("ClMBut").style.display='';
		document.getElementById("Message").innerHTML='<%=GlobalMsg%>';
	}
	 
 }
 function Clswindow(){
	 
	 window.close();
 }
 </script>
 <script>
 function myFunction() {
   var input, filter, table, tr, td, i;
   input = document.getElementById("myInput");
   filter = input.value.toUpperCase();
   table = document.getElementById("myTable");
   tr = table.getElementsByTagName("tr");
   for (i = 0; i < tr.length; i++) {
     td = tr[i].getElementsByTagName("td")[2];
     if (td) {
       if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
         tr[i].style.display = "";
       } else {
         tr[i].style.display = "none";
       }
     }       
   }
 }
 
 
 function CheckView(){
	 
	 //var chboxLength=document.getElementById("checkbox").length();
       // alert("1");
	 var checkedValue ="0"; 
	 var inputElements = document.getElementsByName('chxbox');
	 alert("Length::"+inputElements.length);
	 for(var i=0; i<=inputElements.length; i++){
		 
		 try{
			 
		   if(inputElements[i].checked==true){
	            checkedValue =checkedValue+","+inputElements[i].value;
	           // break;
	       } 
			// alert(inputElements[i].checked+"::HI");
			 
		 }catch(err){
			// alert(err.message);
		 }
		 
	       /* if(inputElements[i].checked){
	            checkedValue =checkedValue+","+inputElements[i].value;
	           // break;
	       } */
	 }
	 alert("checkedValue"+checkedValue);
	 
	 Change_Field("CallReport");

	 
 }
 
 $("#SubMBut11").click(function(){
	 	  $("#myTable1").table2excel({
	 	    // exclude CSS class
	 	    exclude: "myTable1",
	 	    name: "Worksheet Name",
	 	    filename: "SomeFile" //do not include extension
	 	  });
	 	});
 </script>
 



</head>
<body onload='SetGlobalMsg();'>

 <form action="Reports_Db_call" method='post' autocomplete='off' >
       <!--  <input type="text" id="name" placeholder="Name">
        <input type="text" id="email" placeholder="Email Address">
        <input type="button" class="add-row" value="Add Row"> -->
<!--     </form> -->


<input type='hidden' value='REPORTS' name='Routing' >

<table style='margin-left:300px' align='center' width='40%' class='class1'>
   <tr><td colspan='8' align='center'>PayPeriod : &nbsp;&nbsp;
   
   <select id='payperiod' name='payperiod' Onchange="Change_Field(this.value)">
  <!--  <option value='201704'>201704</option>
   <option value='201703'>201703</option>
   <option value='201702'>201702</option> -->
   
   </select> &nbsp; <img id='Search_Scrolling1' src="progressdisc.gif" alt="Smiley face" height="24" width="24" style='display:none'>
   
   &nbsp;
   Report Type:: <select id='ReportType' name='ReportType' >
   <option value='ESI'>ESI Report</option>
   <option value='PF'>PF Report</option>
   
   </select>
   </td></tr>
   </table>
 <div style='widht:200px;height:200px;overflow:scroll;'  > 
 <!-- <div style='widht:400px;height:480px;'  > -->
 <div id='Message' style='color:red;font-size:14px;'> </div>
 <!-- <div align='right'>
   Search By name <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
 </div> -->
   
   
    <table style='margin-left:300px' class='class2' id="myTable" align='center' width='40%'>
        <thead id="thd">
            <tr>
              
               <!-- <th>NAME</th>
                <th>DateOfJoin</th>
                <th>LOP</th>
                <th>A <span style='font-size:10px'>(Leaves)</span></th>
                <th>R <span style='font-size:10px'>(Leaves)</span> </th>
                <th>P <span style='font-size:10px'>(Leaves)</span> </th> -->
            </tr>
        </thead>
        <tbody id='dd'>
           
        </tbody>
    </table>
    </div>
    <br/>
 
 <div align='center' widht='20%'>
    <input align='center' type="button" id='SubMBut' class="delete-row" Onclick="CheckView();" value="View" style='display:' />
    <input align='center' type="button" id='SubMBut11' class="delete-row"  value="Download" style='display:' />
    <!-- <input align='center' type="button" id='ClMBut' class="delete-row" onclick="Clswindow();" value="Home" style='display:none' /> -->
 <div>   
   <div style='widht:100%;height:300px;overflow:scroll;'  > 
       
       <table style='margin-left:50px' class='class2' id="myTable1" align='center' width='100%'>
        <thead id="thd1">
            <tr>
              
               <!-- <th>NAME</th>
                <th>DateOfJoin</th>
                <th>LOP</th>
                <th>A <span style='font-size:10px'>(Leaves)</span></th>
                <th>R <span style='font-size:10px'>(Leaves)</span> </th>
                <th>P <span style='font-size:10px'>(Leaves)</span> </th> -->
            </tr>
        </thead>
        <tbody id='dd1'>
           
        </tbody>
    </table>
   
   </div>
    </form>
</body>
</html>