
function getLatLng() {
	var adressNumber = document.getElementById("adressNumber").value;
	var adressWay = document.getElementById("adressWay").value;
	var adressCp = document.getElementById("adressCp").value;
	var adressCity = document.getElementById("adressCity").value;
	var theLatitude = "";
	var theLongitude = "";
	var form = document.forms['theForm'];

	var address = adressNumber + ", " + adressWay + ", " + adressCp + " " + adressCity + ", France";
	var url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + encodeURIComponent(address) + "&sensor=false";
	$.getJSON(url)
		.done(function(data) {
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
			form.submit();
		});
}

