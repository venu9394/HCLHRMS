/* var app=angular.module('myApp',[]);

app.controller('myCtrl',function($scope,$http){
	
$http({
	
	method:"POST",
	url:"DisplayDropdown",
	params:{
		condition:"Dropdown"
	},
	
}).then(function mySucces(response){
	
	var data=response.data;
	
	$scope.division=data[0];
	
	$scope.selectedItemvaluedivision = "Select";
}, function myError(response) {
    $scope.myWelcome = response.statusText;
    alert($scope.myWelcome);
});
});*/




function Load() {
	 
	$('#OLD_CTC_1,#NEW_CTC_1').hide();
	$('#RELIEVING_ID').hide();
	$('#DATE_1').hide();
	$('#ReGenerate').hide();
	$('#BU_ID').hide();
	$('#PROB_ID').hide();
	$('#ReGenerate').hide();
	
//	alert("In Script-1"+val.value);
	$('#probation').hide();
	
	$('#Division').hide();
	// alert(name);
	var formData = {condition :'Dropdown'};
	// alert("In Script-2"); 
	try {
		// alert("In Script-2.1");
//var kurl="http://10.30.0.45:8080/MaheshRFWS/Mahesh/Employee/Mahesh";
		$.ajax({
			type : "get",
			url : "DisplayDropdown",
		//url: kurl,
			data : formData,
			success : function(responseData, textStatus, jqXHR) {
				//alert(responseData);

				var dat = eval(responseData);
				// alert(dat[0]);
				//alert(dat[1]);

				/* var str = responseData;
				aler("1:"+str); */
				//document.getElementById("_Date").innerHTML=responseData;
				//	var comm_city=document.getElementById("comm_city");
				try {

					document.getElementById('Division').length = 0;
					var comm_city = document
							.getElementById('Division');

					for (var i = 0; i < dat.length; i++) {

						myOption = document.createElement("option");
						myOption.innerHTML = dat[i].split("#")[0];
						myOption.value = dat[i].split("#")[1];
						comm_city.appendChild(myOption);

					}

				} catch (err) {

					alert(err.message);

				}

			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(errorThrown);
				//   document.getElementById("Responce_Message").innerHTML=errorThrown;
				//  document.getElementById("Responce_Message_btn").style.display='';
				//alert("Error;" + textStatus);
				//alert("Error;" + errorThrown);

				//alert("jqXHR;" + jqXHR.status);

			}
		});
	} catch (err) {

		alert(err + ":at Last");
	}

	//document.getElementById("comm_state").value='112';
}