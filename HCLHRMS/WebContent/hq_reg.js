
function Fetch_Data1(){
	
$("#myform :input[type=text]").prop("disabled", true);
	
//	$("Select").prop("disabled", true);

$("#Gender,#title1,#Division,#Field,#Status,#state").prop("disabled", true);

}

function Fetch_Data()
{
	
	//alert("Hai");
	
$("#myform :input[type=text]").prop("disabled", true);
	
//	$("Select").prop("disabled", true);

$("#Gender,#title1,#Division,#Field,#Status,#state").prop("disabled", true);
  
	
	 // $('input[type=radio]').prop('checked', false); 
	  
	
	DropDownLoad("Division","HQLIST",responseData);
	//DropDownLoad("Division1","HQLIST");
	DropDownLoad("state","STATES");
	DropDownLoad("Gender","Gender");
	DropDownLoad("title","title");
	DropDownLoad("Status","Status");
	DropDownLoad("Status1","Status");
	
	
	DropDownLoad("searchStatus","StatusCodes");
	DropDownLoad("AtciveStatus","StatusCodes");
	 	 
}

function DropDownLoad(val,type,responseData11){
	
	 //alert(responseData11);
	
	var dat = eval(""+responseData11+"");
	
	//alert(dat );
	//var dat = responseData;
	 
	try {

		document.getElementById(val).length = 0;
		var comm_city = document.getElementById(val);

		// alert(comm_city+"::HAI::"+dat.length);
		for (var i = 0; i < dat.length; i++) {
			
			
			// alert(dat[i].split("#")[1] +"~~~~"+dat[i].split("#")[0]);

			var myOption = document.createElement("option");
			myOption.text = dat[i].split("#")[1];
			myOption.value = dat[i].split("#")[0];
			//myOption.id = dat[i].split("#")[0];
			
			
			comm_city.options.add(myOption);
			
			//document.getElementById('bandwidth').options.add(opt);
			//comm_city.appendChild(myOption,i);

		}

	} catch (err) {

		alert(err.message);

	}
	
	 
	
}
 
function DropDownLoad111(val,type)
{
	
	
	responseData=null;
	try {
		// alert("In Script-2.1");

		$.ajax({
			type : "get",
			url : "Fectch_Data",
			data:{type:type},
			success : function(responseData, textStatus, jqXHR) {
				///alert(responseData);

				var dat = eval(""+responseData+"");
				
				//var dat = responseData;
				 
				try {

					document.getElementById(val).length = 0;
					var comm_city = document.getElementById(val);

					// alert(comm_city+"::HAI::"+dat.length);
					for (var i = 0; i < dat.length; i++) {
						
						
						// alert(dat[i].split("#")[1] +"~~~~"+dat[i].split("#")[0]);

						var myOption = document.createElement("option");
						myOption.text = dat[i].split("#")[1];
						myOption.value = dat[i].split("#")[0];
						//myOption.id = dat[i].split("#")[0];
						
						
						comm_city.options.add(myOption);
						
						//document.getElementById('bandwidth').options.add(opt);
						//comm_city.appendChild(myOption,i);

					}

				} catch (err) {

					alert(err.message);

				}
				
				 

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
				alert("Unable to connect Server Please Try again..");
				//alert("Error;" + textStatus);
				//alert("Error;" + errorThrown);

				//alert("jqXHR;" + jqXHR.status);

			}
		});
	} catch (err) {

		//alert(err + ":at Last");
	}


}
function Change_Field(val)
{
	
	
	try {
	//alert("In Script-2.1"+$('#Division').val());

		$.ajax({
			type : "get",
			url : "Fectch_Data",
			data:{type:"Filed",BUSINESSUNITID:$('#Division').val()},
			success : function(responseData, textStatus, jqXHR) {
				//alert(responseData);

				var dat = eval(responseData);
				 
				try {

					document.getElementById('Field').length = 0;
					var comm_city = document.getElementById('Field');

					for (var i = 0; i < dat.length; i++) {

						myOption = document.createElement("option");
						myOption.text = dat[i].split("#")[1];
						myOption.value = dat[i].split("#")[0];
						//myOption.id = dat[i].split("#")[0];
						
						
						comm_city.options.add(myOption);
						//comm_city.appendChild(myOption);

					}

				} catch (err) {

					alert(err.message);

				}
				
				 

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
			 
				alert("Unable to connect Server Please Try again..");
				/*alert("Error;" + textStatus);
				alert("Error;" + errorThrown);

				alert("jqXHR;" + jqXHR.status);*/

			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}
	
	
}


//----------SALES

function Salesoffice(val)
{
	
	
	try {
	//alert("In Script-2.1"+$('#Division').val());

		$.ajax({
			type : "get",
			url : "Fectch_Data",
			data:{type:"SalesOffice",SalesOffice:$('#SalesOffice').val()},
			success : function(responseData, textStatus, jqXHR) {
				//alert(responseData);
				var dat = eval(responseData);
				try {
					document.getElementById('SalesGroup').length = 0;
					var comm_city = document.getElementById('SalesGroup');
					for (var i = 0; i < dat.length; i++) {
						myOption = document.createElement("option");
						myOption.text = dat[i].split("#")[1];
						myOption.value = dat[i].split("#")[0];
						//myOption.id = dat[i].split("#")[0];
						comm_city.options.add(myOption);
						//comm_city.appendChild(myOption);
					}
					
					 

				} catch (err) {

					alert(err.message);

				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
			 
				alert("Unable to connect Server Please Try again..");
				/*alert("Error;" + textStatus);
				alert("Error;" + errorThrown);

				alert("jqXHR;" + jqXHR.status);*/
			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}
}



///


function Change_EditCostCenter(val,val1)
{
	// alert('--Cost'+val+'----------DIVISIOn-'+val1);
	
	try {
		//alert("In Script-2.1"+$('#Division').val());

			$.ajax({
				type : "get",
				url : "Fectch_Data",
				data:{type:"Filed",BUSINESSUNITID:val1},
				success : function(responseData, textStatus, jqXHR) {
					//alert(responseData);

					var dat = eval(responseData);
					 
					try {

						document.getElementById('Field').length = 0;
						var comm_city = document.getElementById('Field');

						for (var i = 0; i < dat.length; i++) {

							myOption = document.createElement("option");
							myOption.text = dat[i].split("#")[1];
							myOption.value = dat[i].split("#")[0];
							//myOption.id = dat[i].split("#")[0];
							
							comm_city.options.add(myOption);
							//comm_city.appendChild(myOption);

						}
						
						SelectLoad('Field',val);

					} catch (err) {

						alert(err.message);

					}
					
					 

				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);
				 
					alert("Unable to connect Server Please Try again..");
					/*alert("Error;" + textStatus);
					alert("Error;" + errorThrown);

					alert("jqXHR;" + jqXHR.status);*/

				}
			});
		} catch (err) {

			alert(err + ":Unable to process your request..!");
		}
	
	
	
}

//-------



function Sales_Edit(val,val1)
{
	// alert('--Cost'+val+'----------DIVISIOn-'+val1);
	
	try {
		//alert("In Script-2.1"+$('#Division').val());

			$.ajax({
				type : "get",
				url : "Fectch_Data",
				data:{type:"SalesOffice",SalesOffice:val1},
				success : function(responseData, textStatus, jqXHR) {
					//alert(responseData);

					var dat = eval(responseData);
					 
					try {

						document.getElementById('SalesGroup').length = 0;
						var comm_city = document.getElementById('SalesGroup');

						for (var i = 0; i < dat.length; i++) {

							myOption = document.createElement("option");
							myOption.text = dat[i].split("#")[1];
							myOption.value = dat[i].split("#")[0];
							//myOption.id = dat[i].split("#")[0];
							
							comm_city.options.add(myOption);
							//comm_city.appendChild(myOption);

						}
						
						SelectLoad('SalesGroup',val);

					} catch (err) {

						alert(err.message);

					}
					
					 

				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);
				 
					alert("Unable to connect Server Please Try again..");
					/*alert("Error;" + textStatus);
					alert("Error;" + errorThrown);

					alert("jqXHR;" + jqXHR.status);*/

				}
			});
		} catch (err) {

			alert(err + ":Unable to process your request..!");
		}
	
	
	
}






//-------
 

function Employee_Code()
{
	try {
		// alert("In Script-2.1");
		//EmployeeCode
		
		//alert($('#EmployeeCode').val());
		$.ajax({
			type : "get",
			url : "Fectch_Data",
			data:{type:"EMPOLYEECODE",EmployeeCode:$('#EmployeeCode').val()},
			success : function(responseData, textStatus, jqXHR) {
				//alert(eval(responseData));

				var dat = eval(responseData);
				
				if(dat==1)
					{
					$('#employee_code_v1').html('<font color="red" size="2">Employeecode Already Exist..</font>');
					
					
					//$('#reg').prop('disabled', false);
					
					document.getElementById("reg").disabled = true;
					
					$('#errorMsg').html('');
					
					
					
					 
					}
				 
				 

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
			 
				alert("Unable to connect Server Please Try again..");
				/*alert("Error;" + textStatus);
				alert("Error;" + errorThrown);

				alert("jqXHR;" + jqXHR.status);*/

			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}	
}
 
 

function Change_Title(val){
	
	
	//alert(val.value);
	
	document.getElementById('title1').length=0;
	//$('#title').val();
	
	var length = $('#title > option').length;
	
	var selobj=document.getElementById('title');
	
	//alert(length);
	
	if(val.value=="1")
		{
		
		
		 
		var comm_city = document.getElementById('title1');

		for (var i = 0; i < length; i++) {

			
			
			if(i==1 || i==4||i==0){
				
				
			myOption = document.createElement("option");
			
			
			myOption.text = selobj.options[i].text;
			myOption.value =selobj.options[i].value;
			//myOption.id = dat[i].split("#")[0];
			
			comm_city.options.add(myOption);
			//comm_city.appendChild(myOption);
           // alert(selobj.options[i].value+"--------------"+selobj.options[i].text);
				}
			
			
		}
		
		}
	
	else if(val.value=="2")
		{
		
		 
		var comm_city = document.getElementById('title1');

		for (var i = 0; i < length; i++) {

			
			
			if(i==2 || i==4||i==3||i==0){
				
				
			myOption = document.createElement("option");
			
			
			myOption.text = selobj.options[i].text;
			myOption.value =selobj.options[i].value;
			//myOption.id = dat[i].split("#")[0];
			
			
			comm_city.options.add(myOption);
			//comm_city.appendChild(myOption);
            //alert(selobj.options[i].value+"--------------"+selobj.options[i].text);
				}
			
			
		}
		
		 
		}
   
	
}




function Change_EditTitle(val,val1){
	
	//alert(val);
	 //alert(val.value);
	
	document.getElementById('title1').length=0;
	//$('#title').val();
	
	var length = $('#title > option').length;
	
	var selobj=document.getElementById('title');
	
	//alert(length);
	
	if(val=="1")
		{
		
		
		 
		var comm_city = document.getElementById('title1');

		for (var i = 0; i < length; i++) {

			
			
			if(i==1 || i==4||i==0){
				
				
			myOption = document.createElement("option");
			
			
			myOption.text = selobj.options[i].text;
			myOption.value =selobj.options[i].value;
			//myOption.id = dat[i].split("#")[0];
			
			
			comm_city.options.add(myOption);
			
			//comm_city.appendChild(myOption);
           // alert(selobj.options[i].value+"--------------"+selobj.options[i].text);
				}
			
			
		}
		
		//SelectLoad('title1',val1);
		
		}
	
	else if(val=="2")
		{
		
		 
		var comm_city = document.getElementById('title1');

		for (var i = 0; i < length; i++) {

			
			
			if(i==2 || i==4||i==3||i==0){
				
				
			myOption = document.createElement("option");
			
			
			myOption.text = selobj.options[i].text;
			myOption.value =selobj.options[i].value;
			//myOption.id = dat[i].split("#")[0];
			
			comm_city.options.add(myOption);
			//comm_city.appendChild(myOption);
            //alert(selobj.options[i].value+"--------------"+selobj.options[i].text);
				}
			
		  
		}
		
		
		}
	
	 SelectLoad('title1',val1); 
}


function SelectLoad(val1,val){
	
	var $Seleted=document.getElementById(val1);
	for(var i, j = 0; i = $Seleted.options[j]; j++) {
		    if(i.value == val) {
		    	$Seleted.selectedIndex = j;
		        break;
		    }
	   }
		
	
	
}


function Change_Department()
{
	
	 
	$('#Search_error').html('');
	
	
	try {
		// alert("In Script-2.1");

		$.ajax({
			type : "get",
			url : "Fectch_Data",
			data:{type:"Fetch",BUSINESSUNITID:$('#Division1').val()},
			success : function(responseData, textStatus, jqXHR) {
				//alert(responseData);

				var dat = eval(responseData);
				 
				try {

					document.getElementById('Department').length = 0;
					var comm_city = document.getElementById('Department');

					for (var i = 0; i < dat.length; i++) {

						myOption = document.createElement("option");
						myOption.text = dat[i].split("#")[1];
						myOption.value = dat[i].split("#")[0];
						//myOption.id = dat[i].split("#")[0];
						
						comm_city.options.add(myOption);
						//comm_city.appendChild(myOption);

					}

				} catch (err) {

					alert(err.message);

				}

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
			 
				alert("Unable to connect Server Please Try again..");
				/*alert("Error;" + textStatus);
				alert("Error;" + errorThrown);

				alert("jqXHR;" + jqXHR.status);*/

			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}
}

$('#EmployeeCode').keyup(function()
{
	//alert("55");
	$('#employee_code_v1').html("");
	document.getElementById("reg").disabled = false;
	
	//$("#employee_code_v1").css("display", "none");
	

});




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
function NoEntry(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
   // var regexp=/^[a-zA-Z,\/,0-9]+$/;
         
    
    
 //alert(charCode);
    /*if (( !charCode==64 &&  charCode > 49 && charCode < 123)|| charCode==16 ||charCode==47  &&   96 <= charCode && charCode <= 105) {*/
    	if (charCode>=97 && charCode<=122 ) {
    	return true;
    }
    return false;
}


 
var jsondata="";

function formvalidation2(){
	
	jsondata="";
	
	
	
	//$( "#search" ).prop( "disabled", true);
	//$('#Search_Scrolling').css('display', '');
	
	//alert($('#FristName').val());
	var Search=null;
	if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
			$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
		{
	//$('#tableBody').show();
		Search={type:'search1',Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
}
		
		
	
	if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
			$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
			{
		 
		    Search={type:"search2",searchFristName:$('#searchFristName').val(),Division:$('#Division1').val()};
			 
			}
	
	if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
			$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		
		
		
		 Search={type:"search3",employementtype:$('#Status1').val(),Division:$('#Division1').val()};
	 
	}
	
	
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 
		 
		 
		 Search={type:"search4",ActiveStatus:$('#searchStatus').val(),Division:$('#Division1').val()};
 
	}
	
	
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search5",doj:$('#doj').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	
	}	 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 
		 Search={type:"search6",Department:$('#Department').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	} 
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 
		 Search={type:"search7",searchFristName:$('#searchFristName').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	
	}
	
	
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 
		 Search={type:"search8",doj:$('#doj').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	}
	
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 
		 Search={type:"search9",employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	
	}
	
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search10",Department:$('#Department').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};
	
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 
		 Search={type:"search11",ActiveStatus:$('#searchStatus').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val()};

	}
	
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search12",searchFristName:$('#searchFristName').val(),doj:$('#doj').val(),Division:$('#Division1').val()};
	}
	 
	 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search13",searchFristName:$('#searchFristName').val(),employementtype:$('#Status1').val(),Division:$('#Division1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search14",searchFristName:$('#searchFristName').val(),Department:$('#Department').val(),Division:$('#Division1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search15",searchFristName:$('#searchFristName').val(),ActiveStatus:$('#searchStatus').val(),Division:$('#Division1').val()};
	
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search16",doj:$('#doj').val(),employementtype:$('#Status1').val(),Division:$('#Division1').val()};
	} 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search17",doj:$('#doj').val(),Department:$('#Department').val(),Division:$('#Division1').val()};
	}  
	 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search18",doj:$('#doj').val(),ActiveStatus:$('#searchStatus').val(),Division:$('#Division1').val()};
	} 
	 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search19",employementtype:$('#Status1').val(),Department:$('#Department').val(),Division:$('#Division1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search20",employementtype:$('#Status1').val(),ActiveStatus:$('#searchStatus').val(),Division:$('#Division1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search21",Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val(),Division:$('#Division1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search22",searchFristName:$('#searchFristName').val(),Employeecode:$('#EmployeeCode1').val(),Division:$('#Division1').val(),doj:$('#doj').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search23",searchFristName:$('#searchFristName').val(),Employeecode:$('#EmployeeCode1').val(),
				Division:$('#Division1').val(),doj:$('#doj').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search24",searchFristName:$('#searchFristName').val(),Employeecode:$('#EmployeeCode1').val(),
				Division:$('#Division1').val(),doj:$('#doj').val(),employementtype:$('#Status1').val(),Department:$('#Department').val()};
	}
	 
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search25",searchFristName:$('#searchFristName').val(),Employeecode:$('#EmployeeCode1').val(),
				Division:$('#Division1').val(),doj:$('#doj').val(),employementtype:$('#Status1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search26",searchFristName:$('#searchFristName').val(),doj:$('#doj').val(),Division:$('#Division1').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search27",searchFristName:$('#searchFristName').val(),doj:$('#doj').val(),
				Division:$('#Division1').val(),employementtype:$('#Status1').val(),Department:$('#Department').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search28",searchFristName:$('#searchFristName').val(),doj:$('#doj').val(),
				Division:$('#Division1').val(),employementtype:$('#Status1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search29",searchFristName:$('#searchFristName').val(),Division:$('#Division1').val(),employementtype:$('#Status1').val(),Department:$('#Department').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search30",searchFristName:$('#searchFristName').val(),Division:$('#Division1').val(),
				employementtype:$('#Status1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search31",searchFristName:$('#searchFristName').val(),Division:$('#Division1').val(),
				Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search32",Division:$('#Division1').val(),
				Department:$('#Department').val(),doj:$('#doj').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search33",Division:$('#Division1').val(),
				Department:$('#Department').val(),doj:$('#doj').val(),employementtype:$('#Status1').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search34",Division:$('#Division1').val(),
				Department:$('#Department').val(),doj:$('#doj').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search35",Division:$('#Division1').val(),
				Department:$('#Department').val(),employementtype:$('#Status1').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search36",Division:$('#Division1').val(),doj:$('#doj').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search37",Division:$('#Division1').val(),doj:$('#doj').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val()};
	}
	
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search38",Division:$('#Division1').val(),doj:$('#doj').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search39",Division:$('#Division1').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search40",Division:$('#Division1').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val()};
	}
	 
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search41",Division:$('#Division1').val(),searchFristName:$('#searchFristName').val(),
				employementtype:$('#Status1').val(),Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search42",Division:$('#Division1').val(),doj:$('#doj').val(),
				Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search43",Division:$('#Division1').val(),doj:$('#doj').val(),
				Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search44",Division:$('#Division1').val(),
				Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search45",Division:$('#Division1').val(),
				Employeecode:$('#EmployeeCode1').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search46",Division:$('#Division1').val(),
				Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search47",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val(),
				searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search48",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val(),doj:$('#doj').val(),
				searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search49",Division:$('#Division1').val(),Department:$('#Department').val(),doj:$('#doj').val(),
				searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search50",Division:$('#Division1').val(),Department:$('#Department').val(),doj:$('#doj').val(),ActiveStatus:$('#searchStatus').val(),
				searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search51",Division:$('#Division1').val(),doj:$('#doj').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search52",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val(),
				 Employeecode:$('#EmployeeCode1').val(),Department:$('#Department').val(),searchFristName:$('#searchFristName').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search53",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),employementtype:$('#Status1').val(),
				 Employeecode:$('#EmployeeCode1').val(),searchFristName:$('#searchFristName').val(),doj:$('#doj').val()};
	}
	 
	 if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search54",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),
				 searchFristName:$('#searchFristName').val(),doj:$('#doj').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
				$('#doj').val()!=""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search55",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),Employeecode:$('#EmployeeCode1').val(),
				 employementtype:$('#Status1').val(),doj:$('#doj').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search56",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),Employeecode:$('#EmployeeCode1').val(),
				 searchFristName:$('#searchFristName').val(),doj:$('#doj').val()};
	}
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()!=""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search57",Division:$('#Division1').val(),ActiveStatus:$('#searchStatus').val(),Employeecode:$('#EmployeeCode1').val(),
				 Department:$('#Department').val(),searchFristName:$('#searchFristName').val(),doj:$('#doj').val()};
	}
 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		 Search={type:"search58",Division:$('#Division1').val(),Employeecode:$('#EmployeeCode1').val(),
				searchFristName:$('#searchFristName').val(),employementtype:$('#Status1').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()!="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search59",Division:$('#Division1').val(),Employeecode:$('#EmployeeCode1').val(),
				searchFristName:$('#searchFristName').val(),Department:$('#Department').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 if($('#EmployeeCode1').val()!=""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()!=""&&
				$('#doj').val()==""&&$('#Status1').val()!="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()!="Select")
	{
		 Search={type:"search60",Division:$('#Division1').val(),Employeecode:$('#EmployeeCode1').val(),
				searchFristName:$('#searchFristName').val(),employementtype:$('#Status1').val(),ActiveStatus:$('#searchStatus').val()};
	}
	 
	 
	 
	if($('#Division1').val()=='Select')
		{
		//alert('');
		$('#Search_error').html('Please Select BusinessUnit...');
		$( "#Division1" ).focus();
		return false;
	}
	
	else if($('#EmployeeCode1').val()==""&&$('#Division1').val()!="Select"&&$('#searchFristName').val()==""&&
			$('#doj').val()==""&&$('#Status1').val()=="Select"&&$('#Department').val()=="Select"&&$('#searchStatus').val()=="Select")
	{
		
		$('#Search_error').html('Please Select One Field....');
		
		return false;
	}
	 
	 
	 else 
		 {
		 
		 $('#Search_error').html('');
	 try {
		 
		 
		    $( "#search" ).prop( "disabled", true);
			
			$('#Search_Scrolling').css('display', '');
		 
		 responseData=null;
			// alert("In Script-2.1");
			//EmployeeCode
			
			//alert($('#EmployeeCode1').val());
			//alert($('#Division1').val());
			$.ajax({
				type : "post",
				url : "SearchServlet",
				data:Search,
				success : function(responseData, textStatus, jqXHR) {
					//alert(eval(responseData));

					//var dat = eval(responseData);
					
					 jsondata = eval(responseData);
					
					//alert("JasonData:::"+jsondata);
			         loadData(jsondata);
					
				 
				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);
				 
					alert("Unable to connect Server Please Try again..");
					/*alert("Error;" + textStatus);
					alert("Error;" + errorThrown);

					alert("jqXHR;" + jqXHR.status);*/

				}
			});
		} catch (err) {

			alert(err + ":at Last");
			 $( "#search" ).prop( "disabled", false);
				
				$('#Search_Scrolling').css('display', '');
		}	
		 } 
	 
   

}
var sb = '';
function loadData(datas){
	 
	// alert("Datas::"+datas);
    sb = '';
    var table = $('#tableBody');
   // $('#json').show();
    
    table.html('');
  
    $.each(datas, function(index, value){
        sb += '<tr>';
        
        
        
        sb += '    <td>' + value.SNO + '</td>';
        sb += '    <td>' + value.EMPLOYEESEQUENCENO + '</td>';
        sb += '    <td>' + value.CALLNAME + '</td>';
    /*    sb += '    <td>' + value.LASTNAME+' </td>';*/
        sb += '    <td>' + value.GENDER + '</td>';
        sb += '    <td>' + value.DATEOFBIRTH + '</td>';
        sb += '    <td>' + value.DATEOFJOIN+' </td>';
        sb += '    <td>' + value.EMPLOYMENTTYPEID + '</td>';
        sb += '    <td>' + value.DEPARTMENT + '</td>';
        sb += '    <td>' + value.DESINGNATION+' </td>';
        sb += '    <td>' + value.STATUS+' </td>';
        sb += '    <td>' + value.EDIT + '</td>';
        sb += '</tr>';
    });

    table.append(sb);
    
   $( "#search" ).prop( "disabled", false);
	
	$('#Search_Scrolling').css('display', 'none');
	
}
	
function Edit(val){
	
	
	$("input").prop("disabled", false);
	
	$("Select").prop("disabled", false);
	
     $('#Digits').hide();
	 
	 $('#EditStatus').show();
	 $('#EditStatus1').show();
	 $('#LastWorkingDate_t').show();
	 $('#LastWorkingDate').show();
	 
	 
	 
	 
	 $('#Reason_f_up').show();
	 $('#Reason_f_up_t').show();
	 
	//alert(val.id.split("#")[14]);
	
//	$('#EmployeeCode1').val(val.id.split("#")[0]);
	$('#FristName').val(val.id.split("#")[1]);
	$('#LastName').val(val.id.split("#")[2]);
	
	
	$('#CallNameDispaly').html(val.id.split("#")[14]);
	
	var MiddleName2='';
	
	try{
	var MiddleName=val.id.split("#")[14].toString().replace(val.id.split("#")[1],'');
	 MiddleName2=MiddleName.replace(val.id.split("#")[2],'');
	}catch(err){
		alert("Middle Name::"+err.message);
	}
	
	$('#MiddleName').val(MiddleName2);
	
	
	$('#Gender').val(val.id.split("#")[3]);
	
	
	 
	
	$('#DATEOFBIRTH').val(val.id.split("#")[4]);
	$('#Date').val(val.id.split("#")[5]);
	$('#Status').val(val.id.split("#")[6]);
	
	$('#AtciveStatus').val(val.id.split("#")[9]);
	$('#Division').val(val.id.split("#")[10]);
	
	$('#Field').val(val.id.split("#")[11]);
	
	 
	
	//FIELD_Function();
	
	//SelectLoad('Field',val.id.split("#")[11]);
	$('#title').val(val.id.split("#")[12]);
	$('#state').val(val.id.split("#")[13]);
	$('#displayname').html(val.id.split("#")[14]);
	$('#AtciveStatus').val(val.id.split("#")[15]);
	$('#displayempid').html(val.id.split("#")[0]);
	
	$('#EmployeeCode').val(val.id.split("#")[0]);
	$('#EmployeeCode').hide();
	
	$('#EmployeeCodeDisplay').html(val.id.split("#")[0]);
	$('#EmployeeCodeDisplay').show();
	
	
	/*$('#tableBody').empty();*/
	 
	
	$('#reg').val('Update');
	//$("input[name=Manual_Check]").attr('disabled', true);
	$("input[name=Manual_Check]").attr('disabled', true);
	
	
	
	$("input[name=Manual_Check]").prop('checked', false);
	//$("input[id=System_Check]").prop('checked', false);
	
	Change_EditTitle(val.id.split("#")[3],val.id.split("#")[12]);
	
	Change_EditCostCenter(val.id.split("#")[11],val.id.split("#")[10]);
	
	
	$('#System_Generate').html('');	
	
	$('#Emp_Id').val(val.id.split("#")[16]);
	
	
	$('#Email_id').val(val.id.split("#")[17]);
	$('#Mobile_no').val(val.id.split("#")[18]);
	
	
	
	
	/*$('#Sales_Zone').val(val.id.split("#")[19]);*/
	$('#SalesDistict').val(val.id.split("#")[19]);
	$('#SalesOffice').val(val.id.split("#")[20]);
	 
	
	
	Sales_Edit(val.id.split("#")[21],val.id.split("#")[20]);
	 /*Salesoffice(val.id.split("#")[20]);*/
	 
	 
	 
	
	 
	 
	 /*alert(val.id.split("#")[21]);
	 $('#SalesGroup option[value="O92"]').attr("selected",true);*/
	
	/*$('#SalesGroup').val(val.id.split("#")[21]);*/
	
	
	
	//alert(val.id.split("#")[16]);
	//$('#').attr("disabled", false);
	//$('#Manual_Check').attr("disabled", false);

	 $('#errorMsg').html('');	
 
	
}

 
 
