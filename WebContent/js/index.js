var geocoder = new google.maps.Geocoder();
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;



function afficherBL() {
	var ADDRESSE_BL = document.getElementById("ADDRESSE_BL").value;
	var conducteurs = document.getElementById("conducteurs").value;
	geocoder.geocode( { 'address': ADDRESSE_BL}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map = new google.maps.Map(document.getElementById('map_canvas'), 
					{
				zoom: 10,
				center: results[0].geometry.location
					}
			);
			var marker = new google.maps.Marker({
				map: map,
				position: results[0].geometry.location,
				//icon : "http://www.berger-levrault.com/public/css/page/logo.png"
				icon : "http://maps.gstatic.com/mapfiles/markers2/boost-marker-mapview.png",
				title :  "Berger-Levrault"
			});
		}
	});
}

function sendToServer() {
	var form = document.forms['direction'];
	var rayon = document.getElementById("area").selectedIndex;
	var address = document.getElementById("origin").value;
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


function initialize() {	
	var geocoder = new google.maps.Geocoder();
	var directionsDisplay;
	var directionsService = new google.maps.DirectionsService();
	var map;

	geocoder.geocode( { 'address': ADDRESSE_BL}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map = new google.maps.Map(document.getElementById('map_canvas'), 
					{
				zoom: 10,
				center: results[0].geometry.location
					}
			);
			var marker = new google.maps.Marker({
				map: map,
				position: results[0].geometry.location,
				title: "Berger-Levrault",
				//icon : "http://www.berger-levrault.com/public/css/page/logo.png"
				icon : "http://maps.gstatic.com/mapfiles/markers2/boost-marker-mapview.png",
				title :  "Berger-Levrault"
			});
		}
	});


	for (var i = 0; i < addressesString.length; i++) {
		geocoder.geocode( { 'address': addressesString[i]}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				var marker = new google.maps.Marker({
					map: map,
					position: results[0].geometry.location,
					title: addressesString[i]
				});
			}
		});

	}
}

function calculate() {

}