<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
String EMP_LOPLIST=(String)request.getAttribute("LOPLIST");

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
        width: 80%;
        margin: 20px 0;
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
   
     background-color: #f5f5f0;
    }

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	
    	 var Data=eval('<%=EMP_LOPLIST%>');
    	// alert(Data.length);
       // $(".add-row").click(function(){
     <%-- var Data=JSON.parse('<%=EMP_LOPLIST%>'); --%>
    	 //alert("Data::"+Data.length);
    	 var tempjason="";
    	 var CALLNAME="";
    	 var j=0
    	 for(var i=0;i<Data.length;i++){
    		 tempjason=Data[i];
    		// alert(tempjason);
    		// alert(tempjason.CALLNAME);
            var name = $("#name").val();
            var email = $("#email").val();
            j++;
            var markup = "<tr><td> "+j+" </td><td>" + tempjason.SEQNO + "</td><td>" + tempjason.CALLNAME + "</td><td>" + tempjason.DATEOFJOIN + "</td><td> <input type='text' value='"+tempjason.LOP+"' name='"+tempjason.EMPID+"' id='" + tempjason.EMPID + "'  <%=Mode%> onkeypress='return isNumber(event)' style='width:50px' /> </td> <td></td> <td></td> <td></td> </tr>";
          <%--   var markup = "<tr><td><input type='checkbox' checked name='" + tempjason.SEQNO + "' disabled > </td><td>" + tempjason.SEQNO + "</td><td>" + tempjason.CALLNAME + "</td><td>" + tempjason.DATEOFJOIN + "</td><td> <input type='text' value='"+tempjason.LOP+"' name='"+tempjason.EMPID+"' id='" + tempjason.EMPID + "'  <%=Mode%> onkeypress='return isNumber(event)' style='width:50px' /> </td> <td></td> <td></td> <td></td> </tr>"; --%>
            $("table tbody").append(markup);
    	 }
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
	   document.getElementById("SubMBut1").style.display='';
	   document.getElementById("Message").inerHTML='';
	}else{
		document.getElementById("SubMBut").style.display='none';
		document.getElementById("SubMBut1").style.display='none';
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

function LoadSub(){
	
	    document.forms[0].action="Lop_file_upload";
	    
 }
 </script>
 
</head>
<body onload='SetGlobalMsg();'>

 <form action="LOP_Db_insertion" method='post' autocomplete='off' >
       <!--  <input type="text" id="name" placeholder="Name">
        <input type="text" id="email" placeholder="Email Address">
        <input type="button" class="add-row" value="Add Row"> -->
<!--     </form> -->


<input type='hidden' value='LOPINSERT' name='Routing' >

<div style='widht:400px;height:480px;overflow:scroll;'  >
 <div id='Message' style='color:red;font-size:14px;'> </div>
 <div align='right'>
   Search By name <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
 </div>
    <table id="myTable" align='center'>
        <thead>
            <tr style='color:white'>
                <th>##</th>
                <th>ID</th>
                <th>NAME</th>
                <th>DateOfJoin</th>
                <th>LOP</th>
                <th>A <span style='font-size:10px'>(Leaves)</span></th>
                <th>R <span style='font-size:10px'>(Leaves)</span> </th>
                <th>P <span style='font-size:10px'>(Leaves)</span> </th>
            </tr>
        </thead>
        <tbody>
           
        </tbody>
    </table>
    </div>
    <br/>
 
 <div align='center' widht='100px'>
 
    <!--<input align='center' type="submit" id='SubMBut1' class="delete-row"   Onclick="LoadSub();" value="Upload" style='display:' /> -->
    <input align='center' type="submit" id='SubMBut' class="delete-row"  value="Save & Edit" style='display:' />
    
    <input align='center' type="button" id='ClMBut' class="delete-row" onclick="Clswindow();" value="Home" style='display:none' />
 <div>   
   
    </form>
</body>
</html>