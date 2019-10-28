var request=null;
function myFunction() {
	document.getElementById('error').innerHTML = "";
	var Obj = document.getElementById('employeeid');
	var employeeid=Obj.value;

	if (employeeid.length >= 5) {
		var url = "EmployeeCTC?employeeid="+employeeid+"&type=viewctc";
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo1;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	} else {
		document.getElementById('components').innerHTML = "";
		document.getElementById('DataTable_Div').innerHTML = "";
		document.getElementById("componentsave_Div").style.display='none'; 
	}
}

function getInfo1() {
	if (request.readyState == 4) {
		if(request.responseText==102)
		{
			document.getElementById('components_Div').innerHTML = "";
			document.getElementById('DataTable_Div').innerHTML = "";
			document.getElementById("componentsave").style.display='none'; 
			document.getElementById('error').innerHTML = "Employee Not Exists/CTC not Updated";
		}
		else if(request.responseText==2){
			document.getElementById('components_Div').innerHTML = "";
			document.getElementById('DataTable_Div').innerHTML = "";
			document.getElementById("componentsave").style.display='none';
			document.getElementById('error').innerHTML = "Connection Problem. Please Contact Admin...."; 
		}
		else{
			try{
				document.getElementById('DataTable_Div').innerHTML="<table id='DataTable' align='center' style='width:50%;1px solid black'>"+request.responseText+"</table>";
			}catch(err){
				alert(err.message);
			}
			DisplayComponents();
		}
		/*if (request.responseText.length == 2) {

				document.getElementById('DataTable').style.border = "";
				document.getElementById('viewheaders').innerHTML = "";
				document.getElementById('viewtable').innerHTML = "";
				document.getElementById('error').innerHTML = "Invalid Employee-ID...";
				//alert("");
			} else if (request.responseText.length == 5) {

				document.getElementById('viewheaders').innerHTML = "";
				 document.getElementById("actiondate").disabled = true;
				document.getElementById("fuelmaintenance").disabled = true;
				document.getElementById("Submit").disabled = true; 
				document.getElementById('error').innerHTML = "Employee Not Eligible";

			} else {

				document.getElementById('DataTable').style.border = "1px solid black";
				document.getElementById('viewheaders').innerHTML = '<th>EmployeeID</th><th>Gross</th><th>Fuel&Maintenance</th><th>Effective Date</th>';
				//alert(request.responseText.split(",")[2]);
				document.getElementById('viewtable').innerHTML = '<td>'
						+ request.responseText.split(",")[0] + '</td><td>'
						+ request.responseText.split(",")[1] + '</td><td>'
						+ request.responseText.split(",")[2] + '</td><td>'
						+ request.responseText.split(",")[3] + '</td>';
				 document.getElementById('actiondate').value = request.responseText
						.split(",")[3];
				document.getElementById('fuelmaintenance').value = request.responseText
						.split(",")[2]; 

						 window.onload = function(){
							alert('compo');
							DisplayComponents();
						} 
				DisplayComponents();

			}*/

		/* alert(request.responseText.split(",")[0])
			alert(request.responseText.split(",")[1])
			alert(request.responseText.split(",")[2])
			alert(request.responseText.split(",")[3]) */
	}
}
function FormReset(){
	window.location.href="BasicComponent.jsp";
}
function TableReset(){
	document.getElementById('error').innerHTML = " ";
	DisplayComponents();
}
function DisplayComponents(){
	var url = "EmployeeCTC?type=DisplayComponents";
	if (window.XMLHttpRequest) {
		request1 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request1 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request1.onreadystatechange = getInfo3;
		request1.open("GET", url, true);
		request1.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function getInfo3(data) {

	if (request1.readyState == 4) {
		var ObjButton=document.getElementById('componentsave');
		ObjButton.style.display='block';
		document.getElementById('components_Div').innerHTML="<table id='components' border='1' > "+request1.responseText+"</table>";
	}
}
function ComponentCheck(val)
{

	//alert(val.id.concat("_B"));	


	var checked= document.getElementById(val.id).checked;
	if(checked){
		document.getElementById('error').innerHTML = "";
		document.getElementById(val.id.concat("_B")).disabled=false;
	}

	else{
		document.getElementById('error').innerHTML = " ";
		document.getElementById(val.id.concat("_B")).disabled=true;
		document.getElementById(val.id.concat("_B")).value="";
	}


}









//*****
function printChecked(){

	//	 alert('1');
	var items=document.getElementsByName('FM');

	var fmvalue=document.getElementsByName('FMVALUE');

	/* var imageTag="";

			    imageTag = document.createElement("IMG"); //Creates image tag
			    imageTag.setAttribute("src", "popo.jpg"); //sets the image tags source
			    count++; //as the start function keeps getting called, count will increase by 1 and the parameter for each function in each individual image tag will increase by one
			    imageTag.setAttribute("onclick", "disappear("+count+")"); //this will add the onclick attribute with the function disappear() and the parameter inside which will be a number that will increase as the start function is called again and the image tag is called again *ERROR*
			    document.body.appendChild(imageTag); */

	// onkeypress='return RateisNumber(event,this)'


	//alert( fmvalue[2].alt);


	//	 var checkbox = document.getElementsByName('FM');
	var ln = 0;
	var j=0;
	var checkedlength=[];

	for(j=0; j< items.length; j++) {
		if(items[j].checked)

		{
			//  	 alert('2');
			checkedlength.push(j);
			ln++;
		}

	}
	// alert(checkedlength);

	if(ln==0){

		document.getElementById('error').innerHTML = "Please Check Atleast One Row..";
		return false;
	}
	for(var j=0; j< checkedlength.length; j++) {
		if(fmvalue[checkedlength[j]].value=="")
		{
			document.getElementById('error').innerHTML = "Please Enter "+fmvalue[checkedlength[j]].alt+"  Value..."; 
			return false;
		}
	}
	var employeeid=document.getElementById('employeeid').value;
	var componentid="";
	var componentvalue="";
	var allvalues=[];
	for(var i=0; i<items.length; i++){
		if(items[i].checked==true)
		{
			componentid=items[i].value;
			componentvalue=fmvalue[i].value;
			allvalues.push(componentid.concat("~").concat(componentvalue));
		} 
	}
	var url = "EmployeeCTC?employeeid=" +employeeid+"&type=insert_fuel&fmvalues="+allvalues+"";
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}
	try {
		request.onreadystatechange = getInfo4;
		request.open("GET", url, true);
		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}
function getInfo4(data) {
	if (request.readyState == 4) {
		if(request.responseText==1)
		{
			myFunction();
			document.getElementById('error').innerHTML = "Record Saved Successfully..."; 
		}else if(request.responseText==2){

			document.getElementById('error').innerHTML = "Connection Problem. Please Contact Admin...."; 
		}
	}
}