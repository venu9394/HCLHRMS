$("#Manual_Check").click(function() {
	 //alert('1');

	$("input").prop("disabled", false);

	$("Select").prop("disabled", false);

	 
	// document.getElementById("myform").reset();

	// $('#Show_Search').css("display", "none");
	$('#EmployeeCode').show();
	$('#EmployeeCodeDisplay').hide();

	$('#Digits').hide();

	$('#EmployeeCode').attr("disabled", false);

	$('#FristName').val('');
	$('#LastName').val('');

	$('#Gender').val('Select');

	$('#MiddleName').val('');
	$('#DATEOFBIRTH').val('');
	$('#Date').val('');
	$('#Status').val('Select');

	$('#EmployeeCode').val('');
	$('#state').val('Select');
	$('#Division').val('Select');
	$('#title1').val('Select');

	$('#Field').val('Select');

	$('#EditStatus').hide();
	
	$('#EditStatus1').hide();
	// $('#Lable_Name').html('Employee Code');

	$('#reg').val('Save');

	$('#System_Generate').html('');

	$('#errorMsg').html('');
	$('#employee_code_v1').html('');

	$('#Mobile_no').val('');
	$('#Email_id').val('');
	
	
	
	$('#LastWorkingDate_t').hide();
	
	$('#LastWorkingDate').hide();
	$('#Reason_f_up_t').hide();
	$('#Reason_f_up').hide();
	$('#updatetype_reson').hide();
	
	
	 
	
	

});

$("#System_Check").click(function() {

	$("input").prop("disabled", false);

	$("Select").prop("disabled", false);
	// document.getElementById("myform").reset();
	// alert('2');

	$('#System_Generate').html('');

	$('#EmployeeCode').attr("disabled", true);

	$('#EmployeeCode').show();
	$('#EmployeeCodeDisplay').hide();

	$('#Digits').show();
	// $('#Show_Search').css("display", "block");

	$('#FristName').val('');
	$('#LastName').val('');

	$('#Gender').val('Select');

	$('#MiddleName').val('');
	$('#DATEOFBIRTH').val('');
	$('#Date').val('');
	$('#Status').val('Select');

	$('#EmployeeCode').val('');
	$('#state').val('Select');
	$('#Division').val('Select');
	$('#title1').val('Select');

	$('#Field').val('Select');

	$('#EditStatus').hide();
	
	$('#EditStatus1').hide();

	$('#reg').val('Save');

	$('#errorMsg').html('');
	$('#employee_code_v1').html('');
	$('#Mobile_no').val('');
	$('#Email_id').val('');

	$('input[name=RadioButton]').removeAttr('checked');

});

$("#Reset").click(
		function() {
			
			$("#myform :input[type=text]").prop("disabled", true);

			//	$("Select").prop("disabled", true);

			$("#Gender,#title1,#Division,#Field,#Status,#state").prop(
					"disabled", true);

			$('#Digits').hide();

			document.getElementById("myform").reset();
			$("#System_Check").attr("disabled", false);
			$("#Manual_Check").attr("disabled", false);

			$('#CallNameDispaly').html('');
			$('#EmployeeCodeDisplay').hide();
			$('#EmployeeCode').show();

			$('#displayempid').html('');
			$('#displayname').html('');

			$('#EditStatus').hide();
			
			$('#EditStatus1').hide();

			$('#reg').val('Save');

			$('#System_Generate').html('');

			$('#errorMsg').html('');

			$('#employee_code_v1').html('');
			
			
			 location.reload();

		});

/*$("#FristName,#MiddleName,#LastName").keydown(
		function() {

			$('#CallNameDispaly').html(
					$('#FristName').val().concat(" ").concat(
							$('#MiddleName').val()).concat(" ").concat(
							$('#LastName').val()));

		});*/
$("#FristName,#MiddleName,#LastName,#CallNameDispaly,#mytblf").mouseover(
		function() {

			$('#CallNameDispaly').html(
					$('#FristName').val().concat(" ").concat(
							$('#MiddleName').val()).concat(" ").concat(
							$('#LastName').val()));

		});

$("#Mobile_no,#EmployeeCode,#EmployeeCode1").keypress(function(evt) {

	//	alert('');
	evt = (evt) ? evt : window.event;
	var charCode = (evt.which) ? evt.which : evt.keyCode;

	if (charCode >= 48 && charCode <= 57) {
		return true;
	}
	return false;
});

$("#Email_id").keyup(function() {

	var email = document.getElementById("Email_id").value;

	//alert(email);

	if (email == "" || email.length == 0) {

		//alert('11111');
		document.getElementById("reg").disabled = false;

		$('#errorMsg').html(' ');
	}

	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");

	if (email != "") {

		if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {

			$('#errorMsg').html('Please Enter Valid Email Id...');

			$('#Email_id').focus();

			document.getElementById("reg").disabled = true;

			// return false;
		} else {

			document.getElementById("reg").disabled = false;

			$('#errorMsg').html(' ');
			//alert('');
			//return true;
		}

		//return true;
	}

});

function MyFunction(val) {
	
	
	
	

	// alert(document.getElementById("System_Check").checked);
	//alert(($('#Mobile_no').val().length));
	//alert(val.value);
	var check = $("input[name='Manual_Check']").serializeArray();

	var Digits = $("input[name='RadioButton']").serializeArray();

	// alert(document.getElementById("Manual_Check").checked==true);

	var date1 = new Date($('#DATEOFBIRTH').val());
	
	var  DOB_DATE=$('#DATEOFBIRTH').val()
	var    JOIN_DOB=$('#Date').val();
	
	var  Dob_flg=Dat_Validate_call(DOB_DATE);
	var  join_flg=Dat_Validate_call(JOIN_DOB);
	
	
	//alert(Dob_flg + "~~" +join_flg);
	/*var doj = new Date($('#Date').val());
    var dojv=Dat_Validate_call(doj);
        if(!dojv){
        	$('#errorMsg').html('Invalid date formate..');
        }*/
	 
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; //January is 0!
	var yyyy = today.getFullYear();

	 //1988-08-28
	if (dd < 10) {
		dd = '0' + dd;
	}

	if (mm < 10) {
		mm = '0' + mm;
	}

	today = mm + '/' + dd + '/' + yyyy;
	//document.write(today);

	var date2 = new Date(today);
	var timeDiff = Math.abs(date2.getTime() - date1.getTime());
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));

	if (val.value == 'Save') {

		if (check.length === 0) {
			$('#errorMsg').html('Please Select Manual/System...');

		}

		if ((check.length != 0 && val.value == 'Save')
				|| document.getElementById("Manual_Check").checked === true
				|| document.getElementById("System_Check").checked === true)

		{

			if (document.getElementById("Manual_Check").checked === true
					&& val.value == 'Save') {

				// alert('2');

				if ($('#Gender').val() == "Select") {

					// alert('');
					$('#errorMsg').html('Please Select Gender..');

					$('#Gender').focus();
					return false;
				}

				else if ($('#title1').val() == "Select") {

					$('#errorMsg').html('Please Select Title...');

					$('#title1').focus();
					return false;
				}

				else if ($('#FristName').val() == "") {

					$('#errorMsg').html('Please Enter FirstName...');

					$('#FristName').focus();
					return false;
				}

				else if ($('#LastName').val() == "") {

					$('#errorMsg').html('Please Enter LastName...');

					$('#LastName').focus();
					return false;
				}

				else if ($('#Division').val() == 'Select') {

					$('#errorMsg').html('Please Select Division...');

					$('#Division').focus();
					return false;
				}

				else if ($('#Field').val() == 'Select') {

					// alert("Please Select Field...");

					$('#errorMsg').html('Please Select Cost Center...');

					$('#Field').focus();
					return false;
				}

				else if ($('#DATEOFBIRTH').val() == "") {

					// alert("Please Enter DATEOFBIRTH...");

					$('#errorMsg').html('Please Enter DateOfBirth...');

					$('#DATEOFBIRTH').focus();
					
					return false;
				}else if(!Dob_flg ){
					
					$('#errorMsg').html('Please Enter Valid DateOfBirth...');

					$('#DATEOFBIRTH').focus();
					return false;
					
				}

				else if (diffDays <= 6570) {

					$('#errorMsg').html(
							'Age must be above or equal to 18Yrs(DATEOFBIRTH)');

					$('#DATEOFBIRTH').focus();
					return false;

				}

				else if ($('#Date').val() == "") {

					// alert("Please Enter DATEOFBIRTH...");

					$('#errorMsg').html('Please Enter DateOfJoin...');

					$('#Date').focus();
					return false;
				}else if(!join_flg){
					
					$('#Date').html('Please Enter Valid Join Date...');

					$('#Date').focus();
					return false;
					
				}

				else if ($('#Status').val() == "Select") {

					// alert("Please Select Status...");

					$('#errorMsg').html('Please Select Employement Type...');

					$('#Status').focus();
					return false;
				}

				else if ($('#state').val() == "Select") {

					// alert("Please Select state...");

					$('#errorMsg').html('Please Select state...');

					$('#state').focus();
					return false;
				} else if ($('#Mobile_no').val() == "") {

					$('#errorMsg').html('Please Enter Mobile Number ...');

					$('#Mobile_no').focus();
					return false;

				} else if ($('#Mobile_no').val().length != 10) {

					$('#errorMsg').html("Mobile Number must be 10 digits.");
					$('#Mobile_no').focus();
					return false;

				} else if ($('#EmployeeCode').val() == "") {

					// alert("EmployeeCode length must be 5 to 6 digits.");

					$('#errorMsg').html('Please Enter EmployeeCode ...');

					$('#EmployeeCode').focus();
					return false;
				}

				else if ($('#EmployeeCode').val().length < 5
						|| $('#EmployeeCode').val().length > 6) {

					// alert("EmployeeCode length must be 5 to 6 digits.");

					$('#errorMsg').html(
							'EmployeeCode length must be 5 to 6 digits...');

					$('#EmployeeCode').focus();
					return false;
				}
				
				
				
				
				///---Sales-------
				
				
				else if( $('#SalesDistict').val()!='0'||$('#SalesOffice').val()!='0'||$('#SalesGroup').val()!='0')
				{
					   if($('#SalesDistict').val()!='0'||$('#SalesOffice').val()!='0'||$('#SalesGroup').val()!='0')
					   {
						 if($('#SalesDistict').val()=='0')
						{
							$('#errorMsg').html("Please Select Sales Distict..");
							
							 return false;
						}
						else if($('#SalesOffice').val()=='0')
							{
							  $('#errorMsg').html("Please Select Sales Office..");
							
							  return false;
							}
						else if($('#SalesGroup').val()=='0')
						{
							$('#errorMsg').html("Please Select Sales Group..");
						
							 return false;
						}
					   
					    //alert("no");
					}
					 
					  // alert("Yes");
					   
					//return true;
				} 
				
				

				// Gender
				// title1
				// FristName
				// MiddleName
				// LastName
				// Division
				// Field
				// DATEOFBIRTH
				// Date
				// Status
				// EmployeeCode
				// state

				else if ($('#EmployeeCode').val().length == 5
						|| $('#EmployeeCode').val().length == 6
						&& $('#title1').val() != 'Select'
						&& $('#Gender').val() != 'Select'
						&& $('#FristName').val() != ""
						&& $('#LastName').val() != ""
						&& $('#Field').val() != 'Select'
						&& $('#Date').val() != ""
						&& $('#DATEOFBIRTH').val() != ""
						&& $('#Division').val() != "Select"
						&& $('#Status').val() != 'Select'
						&& $('#state').val() != 'Select'
						&& $('#Mobile_no').val() != ""
						&& $('#Mobile_no').val().length == 10) {
					$('#errorMsg').html('');
					// alert($('#Division').val());

					//alert("Index: ");

					var x = document.getElementById("state").selectedIndex;
					var y = document.getElementById("state").options;
					// alert("Index: " + y[x].index + " is " + y[x].text);

					$( "#reg" ).prop( "disabled", true);			
					$('#Search_Scrolling1').css('display', '');
					responseData=null;
					$.ajax({
						type : "get",
						 cache: false,
						url : "Hhcl_BasicScreen",
						data : {
							type : "Manual",
							EmployeeCode : $('#EmployeeCode').val(),
							title : $('#title1').val(),
							Gender : $('#Gender').val(),
							FristName : $('#FristName').val(),
							MiddleName : $('#MiddleName').val(),
							LastName : $('#LastName').val(),
							Field : $('#Field').val(),
							Date : $('#Date').val(),
							DATEOFBIRTH : $('#DATEOFBIRTH').val(),
							COMPANYID : $('#Division').val(),
							Status : $('#Status').val(),
							STATE_CODE : $('#state').val(),
							state : y[x].text,
							mobileno : $('#Mobile_no').val(),
							emailid : $('#Email_id').val(),
							Sales_Zone : $('#Sales_Zone').val(),
							SalesDistict : $('#SalesDistict').val(),
							SalesOffice : $('#SalesOffice').val(),
							SalesGroup:$('#SalesGroup').val()
							
						},
						success : function(responseData, textStatus, jqXHR) {

							//var dat = eval(responseData);

							var dat = '' + eval(responseData) + '';

							//alert(dat);

							//alert(dat.split("#")[0]);

							if (dat.split("#")[0] == 'Insert_Success') {

								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");

								document.getElementById("myform").reset();
								
								$('#CallNameDispaly').html('');
								
								$( "#reg" ).prop( "disabled", false);			
								$('#Search_Scrolling1').css('display', 'none');
								

							} else if (dat.split("#")[0] == 'Invalid_Data') {
								//alert(eval(responseData));

								/*$('#EmployeeCode').val('');
								$('#title1').val('Select');
								$('#Gender').val('Select');
								$('#FristName').val('');
								$('#MiddleName').val('');
								$('#LastName').val('');
								$('#Field').val('Select');
								$('#Date').val('');
								$('#DATEOFBIRTH').val('');
								$('#Division').val('Select');
								$('#Status').val('Select');
								$('#state').val('Select');*/

								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");

								document.getElementById("myform").reset();

								document.getElementById("myform").reset();
								$("#System_Check").attr("disabled", false);
								$("#Manual_Check").attr("disabled", false);

								$('#CallNameDispaly').html('');
								$('#EmployeeCodeDisplay').hide();
								$('#EmployeeCode').show();

								$('#displayempid').html('');
								$('#displayname').html('');

								$('#EditStatus').hide();

								$('#EditStatus1').hide();
								
								$('#reg').val('Save');
								$('#employee_code_v1').html('');
								
								
							}
							else if (dat.split("#")[0] == 'Improper Data') {
								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");
							}

							else if (dat.split("#")[0] == 'Employee_Exist') {



								$('#Employee_Exist')
								.html(
										"<font color='red'>"
										+ dat.split("#")[1]
										+ "</font>");





							}

						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(errorThrown);

							alert("Unable to connect Server Please Try again..");
							/*alert("Error;" + textStatus);
							alert("Error;" + errorThrown);

							alert("jqXHR;" + jqXHR.status);*/
							
							$( "#reg" ).prop( "disabled", false);			
							$('#Search_Scrolling1').css('display', 'none');

						}
					});
					// }

				}

			}

			else if (document.getElementById("System_Check").checked == true
					&& val.value == 'Save') {

				//alert('System---------------');

				//	alert($("input[name='RadioButton']:checked").val());

				//alert($('[name="RadioButton"]').val());

				if ($('#Gender').val() == "Select") {

					// alert('');
					$('#errorMsg').html('Please Select Gender..');

					$('#Gender').focus();
					return false;
				}

				else if ($('#title1').val() == "Select") {

					$('#errorMsg').html('Please Select Title...');

					$('#title1').focus();
					return false;
				}

				else if ($('#FristName').val() == "") {

					$('#errorMsg').html('Please Enter FirstName...');

					$('#FristName').focus();
					return false;
				}

				else if ($('#LastName').val() == "") {

					$('#errorMsg').html('Please Enter LastName...');

					$('#LastName').focus();
					return false;
				}

				else if ($('#Division').val() == 'Select') {

					$('#errorMsg').html('Please Select Division...');

					$('#Division').focus();
					return false;
				}

				else if ($('#Field').val() == 'Select') {

					// alert("Please Select Field...");

					$('#errorMsg').html('Please Select Cost Center...');

					$('#Field').focus();
					return false;
				}

				else if (Digits.length === 0) {

					// alert("Please Select Field...");

					$('#errorMsg').html('Please Check Cost Center Digits...');

					$('#5_Digits').focus();
					return false;
				}

				else if ($('#DATEOFBIRTH').val() == "") {

					// alert("Please Enter DATEOFBIRTH...");

					$('#errorMsg').html('Please Enter DateOfBirth...');

					$('#DATEOFBIRTH').focus();
					return false;
				}else if(!Dob_flg ){
					
					$('#errorMsg').html('Please Enter Valid DateOfBirth...');

					$('#DATEOFBIRTH').focus();
					return false;
					
				}
				
				
				else if (diffDays <= 6570) {

					$('#errorMsg').html(
							'Age must be above or equal to 18Yrs(DATEOFBIRTH)');

					$('#DATEOFBIRTH').focus();
					return false;

				}

				else if ($('#Date').val() == "") {

					// alert("Please Enter DATEOFBIRTH...");

					$('#errorMsg').html('Please Enter DateOfJoin...');

					$('#Date').focus();
					return false;
				}else if(!join_flg){
					
					$('#errorMsg').html('Please Enter Valid join date...');

					$('#Date').focus();
					return false;
					
				}

				else if ($('#Status').val() == "Select") {

					// alert("Please Select Status...");

					$('#errorMsg').html('Please Select Employement Type...');

					$('#Status').focus();
					return false;
				}

				else if ($('#state').val() == "Select") {

					// alert("Please Select state...");

					$('#errorMsg').html('Please Select state...');

					$('#state').focus();
					return false;
				}

				else if ($('#Mobile_no').val() == "") {

					$('#errorMsg').html('Please Enter Mobile Number ...');

					$('#Mobile_no').focus();
					return false;

				} else if ($('#Mobile_no').val().length != 10) {

					$('#errorMsg').html("Mobile Number must be 10 digits.");
					$('#Mobile_no').focus();
					return false;

				}
				/*else if($('#SalesDistict').val()=='0'&&$('#SalesOffice').val()=='0'&&$('#SalesGroup').val()=='0')
				    {
					 return true;
					 }*/
				 else if( $('#SalesDistict').val()!='0'||$('#SalesOffice').val()!='0'||$('#SalesGroup').val()!='0')
				{
					   if($('#SalesDistict').val()!='0'||$('#SalesOffice').val()!='0'||$('#SalesGroup').val()!='0')
					   {
						 if($('#SalesDistict').val()=='0')
						{
							$('#errorMsg').html("Please Select Sales Distict..");
							
							 return false;
						}
						else if($('#SalesOffice').val()=='0')
							{
							  $('#errorMsg').html("Please Select Sales Office..");
							
							  return false;
							}
						else if($('#SalesGroup').val()=='0')
						{
							$('#errorMsg').html("Please Select Sales Group..");
						
							 return false;
						}
					   
					    //alert("no");
					}
					 
					  // alert("Yes");
					   
					//return true;
				} 
				
				//alert("33");
				
				 else if ($('#Gender').val() != 'Select'
						&& $('#title1').val() != 'Select'
						&& $('#FristName').val() != ""
						&& $('LastName').val() != ""
						&& $('#Division').val() != 'Select'
						&& $('#Field').val() != "Select"
						&& $('#DATEOFBIRTH').val() != ""
						&& $('#Date').val() != ""
						&& $('#Status').val() != 'Select'
						&& $('#state').val() != 'Select' && Digits.length != 0
						&& $('#Mobile_no').val() != ""
						&& $('#Mobile_no').val().length == 10) {

					$('#errorMsg').html('');
					// alert($('#Division').val());

					//alert("Index: ");

					var x = document.getElementById("state").selectedIndex;
					var y = document.getElementById("state").options;
					// alert("Index: " + y[x].index + " is " + y[x].text);

					$( "#reg" ).prop( "disabled", true);			
					$('#Search_Scrolling1').css('display', '');
					responseData=null;
					$.ajax({
						type : "get",
						 cache: false,
						url : "Hhcl_BasicScreen",
						data : {
							type : "System",
							title : $('#title1').val(),
							Gender : $('#Gender').val(),
							FristName : $('#FristName').val(),
							MiddleName : $('#MiddleName').val(),
							LastName : $('#LastName').val(),
							Field : $('#Field').val(),
							Date : $('#Date').val(),
							DATEOFBIRTH : $('#DATEOFBIRTH').val(),
							COMPANYID : $('#Division').val(),
							Status : $('#Status').val(),
							STATE_CODE : $('#state').val(),
							state : y[x].text,
							Digit : $("input[name='RadioButton']:checked")
									.val(),
							mobileno : $('#Mobile_no').val(),
							emailid : $('#Email_id').val(),
							Sales_Zone : $('#Sales_Zone').val(),
							SalesDistict : $('#SalesDistict').val(),
							SalesOffice : $('#SalesOffice').val(),
							SalesGroup:$('#SalesGroup').val()
						},
						success : function(responseData, textStatus, jqXHR) {

							var dat = '' + eval(responseData) + '';

							//alert(dat);

							//alert(dat.split("#")[0]);

							if (dat.split("#")[0] == 'System_Code') {

								//	alert(dat.split("#")[1]);
								// $('#employee_code_v1').html('<font color="red"
								// size="2">Employeecode Already Exist</font>');
								// alert('Employeecode Already Exist');

								$('#System_Generate')
										.html(
												"Generated Employee Code  : <font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");

								/*$('#title1').val('Select');
								$('#Gender').val('Select');
								$('#FristName').val('');
								$('#MiddleName').val('');
								$('#LastName').val('');
								$('#Field').val('Select');
								$('#Date').val('');
								$('#DATEOFBIRTH').val('');
								$('#Division').val('Select');
								$('#Status').val('Select');
								$('#state').val('Select');*/

								document.getElementById("myform").reset();

								document.getElementById("myform").reset();
								$("#System_Check").attr("disabled", false);
								$("#Manual_Check").attr("disabled", false);

								$('#CallNameDispaly').html('');
								$('#EmployeeCodeDisplay').hide();
								$('#EmployeeCode').show();

								$('#displayempid').html('');
								$('#displayname').html('');

								$('#EditStatus').hide();

								$('#EditStatus1').hide();
								
								$('#reg').val('Save');
								$('#employee_code_v1').html('');
								
								
								$( "#reg" ).prop( "disabled", false);			
								$('#Search_Scrolling1').css('display', 'none');
								

							}

							else if (dat.split("#")[0] == 'Invalid_Data') {
								//alert(eval(responseData));

								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");

							}

							else if (dat.split("#")[0] == 'Improper Data') {
								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");
							} else if (dat.split("#")[0] == 'Employee_Exist') {
								$('#System_Generate')
										.html(
												"<font color='red'>"
														+ dat.split("#")[1]
														+ "</font>");
							}

							$( "#reg" ).prop( "disabled", false);			
							$('#Search_Scrolling1').css('display', 'none');
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(errorThrown);

							alert("Unable to connect Server Please Try again..");
							/*alert("Error;" + textStatus);
							alert("Error;" + errorThrown);

							alert("jqXHR;" + jqXHR.status);*/
							
							$( "#reg" ).prop( "disabled", false);			
							$('#Search_Scrolling1').css('display', 'none');

						}
					});
					// }

				}

			}

		}

	}

	if (val.value == "Update") {

		
		
		responseData=null;
		// alert('UPDATE-----------------------');

		if ($('#Gender').val() == "Select") {

			// alert('');
			$('#errorMsg').html('Please Select Gender..');

			$('#Gender').focus();
			return false;
		}

		else if ($('#title1').val() == "Select") {

			$('#errorMsg').html('Please Select Title...');

			$('#title1').focus();
			return false;
		}

		else if ($('#FristName').val() == "") {

			$('#errorMsg').html('Please Enter FirstName...');

			$('#FristName').focus();
			return false;
		}

		else if ($('#LastName').val() == "") {

			$('#errorMsg').html('Please Enter LastName...');

			$('#LastName').focus();
			return false;
		}

		else if ($('#Division').val() == 'Select') {

			$('#errorMsg').html('Please Select Division...');

			$('#Division').focus();
			return false;
		}

		else if ($('#Field').val() == 'Select') {

			// alert("Please Select Field...");

			$('#errorMsg').html('Please Select Cost Center...');

			$('#Field').focus();
			return false;
		}

		else if ($('#DATEOFBIRTH').val() == "") {

			// alert("Please Enter DATEOFBIRTH...");

			$('#errorMsg').html('Please Enter DateOfBirth...');

			$('#DATEOFBIRTH').focus();
			return false;
		}else if(!Dob_flg ){
			
			$('#errorMsg').html('Please Enter valid DateOfBirth...');

			$('#DATEOFBIRTH').focus();
			return false;
			
		}

		else if ($('#Date').val() == "") {

			// alert("Please Enter DATEOFBIRTH...");

			$('#errorMsg').html('Please Enter DateOfJoin...');

			$('#Date').focus();
			return false;
		}else if(!join_flg){
			
			$('#errorMsg').html('Please Enter Valid join Date...');

			$('#Date').focus();
			return false;
			
		}

		else if ($('#Status').val() == "Select") {

			// alert("Please Select Status...");

			$('#errorMsg').html('Please Select Employement Type...');

			$('#Status').focus();
			return false;
		}
		 
		else if ($('#state').val() == "Select") {

			// alert("Please Select state...");

			$('#errorMsg').html('Please Select state...');

			$('#state').focus();
			return false;
		}

		else if ($('#Mobile_no').val() == "") {

			$('#errorMsg').html('Please Enter Mobile Number ...');

			$('#Mobile_no').focus();
			return false;

		} else if ($('#Mobile_no').val().length != 10) {

			$('#errorMsg').html("Mobile Number must be 10 digits.");
			$('#Mobile_no').focus();
			return false;

		}


		else if ($('#AtciveStatus').val() == "Select") {

			// alert("EmployeeCode length must be 5 to 6 digits.");

			$('#errorMsg').html('Please Select Active Status...');

			$('#AtciveStatus').focus();
			return false;
		}
		
		

		else if ($('#Lwdate').val()== "") {

			// alert("EmployeeCode length must be 5 to 6 digits.");
			 
				$('#errorMsg').html('Please Enter Action Date...');

				$('#Lwdate').focus();
			 
			return false;
		}
		
		else if ($('#updatetype').val()== "Select") {

			// alert("EmployeeCode length must be 5 to 6 digits.");
			 
				$('#errorMsg').html('Please Select Reason...');

				$('#updatetype').focus();
			 
			return false;
		}
		
		
		
		
		else if ($('#updatetype_reson').val()=="") {

			// alert("EmployeeCode length must be 5 to 6 digits.");
			 
				$('#errorMsg').html('Please Enter Others Reason ...');

				$('#updatetype_reson').focus();
			 
			return false;
		}
		
		
		/*else if( $('#SalesDistict').val()!='0'|| $('#SalesOffice').val()!='0'|| $('#SalesGroup').val()!='0')
		{
			
			alert("1");
			
			   if($('#SalesDistict').val()!='0'||$('#SalesOffice').val()!='0'||$('#SalesGroup').val()!='0')
			   {
				   
				   alert("2");
				   
				 if($('#SalesDistict').val()=='0')
				{
					$('#errorMsg').html("Please Select Sales Distict..");
					
					 return false;
				}
				else if($('#SalesOffice').val()=='0')
					{
					  $('#errorMsg').html("Please Select Sales Office..");
					
					  return false;
					}
				else if($('#SalesGroup').val()=='0')
				{
					$('#errorMsg').html("Please Select Sales Group..");
				
					 return false;
				}
			   
			    //alert("no");
			}
			 
			  // alert("Yes");
			   
			//return true;
		} */
		
		
		
			else if ($('#title1').val() != 'Select'
				&& $('#Gender').val() != 'Select'
				&& $('#FristName').val() != "" && $('#LastName').val() != ""
				&& $('#Field').val() != 'Select' && $('#Date').val() != ""
				&& $('#DATEOFBIRTH').val() != ""
				&& $('#Division').val() != "Select"
				&& $('#Status').val() != 'Select'
				&& $('#state').val() != 'Select'
				&& $('#AtciveStatus').val() != 'Select'
				&& $('#Mobile_no').val() != ""
				&& $('#Mobile_no').val().length == 10) {

			$('#errorMsg').html('');
			// alert($('#Division').val());

			

			var x = document.getElementById("state").selectedIndex;
			var y = document.getElementById("state").options;
			//alert("Index: " + y[x].index + " is " + y[x].text);

			$( "#reg" ).prop( "disabled", true);			
			$('#Search_Scrolling1').css('display', '');
			responseData=null;
			dat="NO_DATA";
			$.ajax({
				type : "post",
				url : "Hhcl_BasicScreen",
				/*dataType: "json",*/
                cache: false,
				data : {
					type : "UpDate",
					EmployeeCode : $('#EmployeeCode').val(),
					title : $('#title1').val(),
					Gender : $('#Gender').val(),
					FristName : $('#FristName').val(),
					MiddleName : $('#MiddleName').val(),
					LastName : $('#LastName').val(),
					Field : $('#Field').val(),
					Date : $('#Date').val(),
					DATEOFBIRTH : $('#DATEOFBIRTH').val(),
					COMPANYID : $('#Division').val(),
					Status : $('#Status').val(),
					STATE_CODE : $('#state').val(),
					state : y[x].text,
					AtciveStatus : $('#AtciveStatus').val(),
					Emp_Id : $('#Emp_Id').val(),
					mobileno : $('#Mobile_no').val(),
					emailid : $('#Email_id').val(),
					Lwdate:$('#Lwdate').val(),
					updatetype:$('#updatetype').val(),
					updatetype_reson:$('#updatetype_reson').val(),
					
					Sales_Zone : $('#Sales_Zone').val(),
					SalesDistict : $('#SalesDistict').val(),
					SalesOffice : $('#SalesOffice').val(),
					SalesGroup:$('#SalesGroup').val()
					 
				},
				success : function(responseData, textStatus, jqXHR) {

					//var dat = eval(responseData);

					 dat = '' + eval(responseData) + '';

					//alert(dat);

					//alert(dat.split("#")[0]);

					if (dat.split("#")[0] == 'Update_Success') {

						$('#System_Generate').html(
								"<font color='red'>" + dat.split("#")[1]
										+ "</font>");

						/*$('#EmployeeCode').val('');
						$('#title1').val('Select');
						$('#Gender').val('Select');
						$('#FristName').val('');
						$('#MiddleName').val('');
						$('#LastName').val('');
						$('#Field').val('Select');
						$('#Date').val('');
						$('#DATEOFBIRTH').val('');
						$('#Division').val('Select');
						$('#Status').val('Select');
						$('#state').val('Select');*/

						document.getElementById("myform").reset();

						document.getElementById("myform").reset();
						$("#System_Check").attr("disabled", false);
						$("#Manual_Check").attr("disabled", false);

						$('#CallNameDispaly').html('');
						$('#EmployeeCodeDisplay').hide();
						$('#EmployeeCode').show();

						$('#displayempid').html('');
						$('#displayname').html('');

						$('#EditStatus').hide();
						
						$('#EditStatus1').hide();
						

						$('#reg').val('Save');

						$('#employee_code_v1').html('');

						$('#tableBody').empty();
						
						
						$( "#reg" ).prop( "disabled", false);			
						$('#Search_Scrolling1').css('display', 'none');
						
						
						$('#LastWorkingDate_t').hide();
						
						$('#LastWorkingDate').hide();
						$('#Reason_f_up_t').hide();
						$('#Reason_f_up').hide();
						$('#updatetype_reson').hide();
						

					}

					else if (dat.split("#")[0] == 'Invalid_Data') {
						//alert(eval(responseData));

						$('#System_Generate').html(
								"<font color='red'>" + dat.split("#")[1]
										+ "</font>");

					}

					else if (dat.split("#")[0] == 'Improper Data') {
						$('#System_Generate').html(
								"<font color='red'>" + dat.split("#")[1]
										+ "</font>");
					}
					
					$( "#reg" ).prop( "disabled", false);			
					$('#Search_Scrolling1').css('display', 'none');

				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(errorThrown);

					alert("Unable to connect Server Please Try again..");
					/*alert("Error;" + textStatus);
					alert("Error;" + errorThrown);

					alert("jqXHR;" + jqXHR.status);*/
					
					$( "#reg" ).prop( "disabled", false);			
					$('#Search_Scrolling1').css('display', 'none');
					
				}
				
				
			});
			// }
			responseData=null;
		}

	}

}
 
    $('input').keyup(function() {
    	 if(this.id!="Email_id"){
        this.value = this.value.toUpperCase();
    	 }
    });
 //=====================Venu ADD For Date Manual Validation
    function Dat_Validate_call(dat) {
        var parts = dat.split('-');
        if (parts.length < 3)
            return false;
        else {
            
        	/*var day = parseInt(parts[2]);
            var month = parseInt(parts[1]);
            var year = parseInt(parts[0]);*/
            
            var day=eval(parts[2]);
            var month=eval(parts[1]);
            var year=eval(parts[0]);
            
            
            //alert(day +"~"+month+"~"+year);
            
            if (isNaN(day) || isNaN(month) || isNaN(year)) {
                return false;
            }
            if (day < 1 || year < 1)
                return false;
            if(month>12||month<1)
                return false;
            if ((month == 1 ||month == 01|| month =='01'|| month == 3||month =='03' || month ==03 || month == 5||month =='05' ||month ==05|| month == 7||month =='07'||month ==07 || month == 8||month =='08'||month == 08 || month == 10 || month == 12) && day > 31)
                return false;
            if ((month == 4||month == 04||month =='04' || month == 6||month =='06'||month == 06 || month == 9||month =='09'||month ==09 || month == 11 ) && day > 30)
                return false;
            if (month == 2 || month =='02' || month ==02) {
                if (((year % 4) == 0 && (year % 100) != 0) || ((year % 400) == 0 && (year % 100) == 0)) {
                    if (day > 29)
                        return false;
                } else {
                    if (day > 28)
                        return false;
                }      
            }
            return true;
        }
    }
