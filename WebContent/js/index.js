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