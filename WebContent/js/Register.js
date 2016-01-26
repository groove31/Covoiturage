
function getLatLng() {
	var addressNumber = document.getElementById("addressNumber").value;
	var addressWay = document.getElementById("addressWay").value;
	var addressCp = document.getElementById("addressCp").value;
	var addressCity = document.getElementById("addressCity").value;
	var theLatitude = "";
	var theLongitude = "";
	var form = document.forms['theForm'];

	var address = addressNumber + ", " + addressWay + ", " + addressCp + " " + addressCity + ", France";
	var url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + encodeURIComponent(address) + "&sensor=false";
	$.ajax({
		dataType : "json",
		url : url,
		async:false,
		success : function(data){
			theLatitude= (data.results[0].geometry.location.lat).toString();
			theLongitude= (data.results[0].geometry.location.lng).toString();
			var el = document.createElement("input");
			   el.type = "hidden";
			   el.name = "latitude";
			   el.value = theLatitude;
			   form.appendChild(el);
			var el = document.createElement("input");
			   el.type = "hidden";
			   el.name = "longitude";
			   el.value = theLongitude;
			   form.appendChild(el);   
		}
		
	});
	//$.getJSON(url)
	
		//.done(function(data) {
		//if (success) {
			
			//form.submit();
		//});
		//}
}

