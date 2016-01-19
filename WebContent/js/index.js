var geocoder = new google.maps.Geocoder();
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;
var circle;


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
	$("#direction").submit(function(e)
			{
		var postData = $(this).serializeArray();
		var formURL = $(this).attr("action");
		$.ajax(
				{
					url : formURL,
					type: "POST",
					data : postData,
					success:function(data, textStatus, jqXHR) 
					{
						for (var i = 0; i < data.length; i++) {
							addMarker(Number(data[i].latitude), Number(data[i].longitude), data[i].lastName + " " + data[i].firstName);
						}
					},
					error: function(jqXHR, textStatus, errorThrown) 
					{
					}
				});
		e.preventDefault();	//STOP default action
			});	
	
	
	var form = document.forms['direction'];
	
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
//			form.submit();
			$("#direction").submit(); //SUBMIT FORM
			
			var lat1 = Number(theLatitude);
			var lng1 = Number(theLongitude);
			var rayon = Number(document.getElementById("area").selectedIndex) * 1000;
			
			delCircle();
			//Add the circle for this city to the map.
			newCircle = new google.maps.Circle({
			  strokeColor: '#FF0000',
			  strokeOpacity: 0.5,
			  strokeWeight: 1,
			  fillColor: '#FF0000',
			  fillOpacity: 0.2,
			  map: map,
//			  center: new google.maps.LatLng(43.4618736, 1.2407275000000482),
			  //radius: Math.sqrt(citymap[city].population) * 100
			  center: {lat: lat1, lng: lng1},
			  radius: rayon
			});
			addCircle(newCircle);
		});
}


//function initialize() {	
//	var geocoder = new google.maps.Geocoder();
//	var directionsDisplay;
//	var directionsService = new google.maps.DirectionsService();
//	var map;
//
//	geocoder.geocode( { 'address': ADDRESSE_BL}, function(results, status) {
//		if (status == google.maps.GeocoderStatus.OK) {
//			map = new google.maps.Map(document.getElementById('map_canvas'), 
//					{
//				zoom: 10,
//				center: results[0].geometry.location
//					}
//			);
//			var marker = new google.maps.Marker({
//				map: map,
//				position: results[0].geometry.location,
//				title: "Berger-Levrault",
//				//icon : "http://www.berger-levrault.com/public/css/page/logo.png"
//				icon : "http://maps.gstatic.com/mapfiles/markers2/boost-marker-mapview.png",
//				title :  "Berger-Levrault"
//			});
//		}
//	});
//
//
//	for (var i = 0; i < addressesString.length; i++) {
//		geocoder.geocode( { 'address': addressesString[i]}, function(results, status) {
//			if (status == google.maps.GeocoderStatus.OK) {
//				var marker = new google.maps.Marker({
//					map: map,
//					position: results[0].geometry.location,
//					title: addressesString[i]
//				});
//			}
//		});
//
//	}
//}

function addMarker(latitude, longitude, nom) {
	var marker = new google.maps.Marker({
		map: map,
		position: {lat: latitude, lng: longitude},
		title: nom
	});
}

function addCircle(circleToAdd) {
	circle = circleToAdd;
}

function delCircle() {
	if(circle != null) {
		circle.setMap(null);
		circle = null;
	}
}


