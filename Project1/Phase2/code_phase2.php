<?php
//This includes the database connection to this file
//Provide your own api key for weather as well as google maps api key
include 'dBconnection.php';
if(isset($_POST['submit'])){
	$startloc=$_POST['start'];
	$endloc=$_POST['end'];
	//echo $startloc;
}


// url encode the address
    $address1 = urlencode($startloc);
	 $address2 = urlencode($endloc);
	
     
    // google map geocode api url
    $url1 = "https://maps.googleapis.com/maps/api/geocode/json?address={$address1}&key=YOUR API KEY";
 $url2 = "https://maps.googleapis.com/maps/api/geocode/json?address={$address2}&key=YOUR API KEY";
    // get the json response
    $resp_json1 = file_get_contents($url1);
     $resp_json2 = file_get_contents($url2);
     
    // decode the json
    $resp1 = json_decode($resp_json1, true);
  $resp2 = json_decode($resp_json2, true);
    // response status will be 'OK', if able to geocode given address 
    if($resp1['status']=='OK' && $resp2['status']=='OK'){
 
        // get the important data
        $lati1 = isset($resp1['results'][0]['geometry']['location']['lat']) ? $resp1['results'][0]['geometry']['location']['lat'] : "";
        $longi1 = isset($resp1['results'][0]['geometry']['location']['lng']) ? $resp1['results'][0]['geometry']['location']['lng'] : "";
		  $lati2 = isset($resp2['results'][0]['geometry']['location']['lat']) ? $resp2['results'][0]['geometry']['location']['lat'] : "";
        $longi2 = isset($resp2['results'][0]['geometry']['location']['lng']) ? $resp2['results'][0]['geometry']['location']['lng'] : "";
	//	echo 'Latitude: '.$lati1;
	//echo 'Longitude: '.$longi1;
	//	echo 'Latitude: '.$lati2;
	//	echo 'Longitude: '.$longi2;
	//	lat="+latitude+"&lon="+longitude+"
	
	//get JSON
 $json1 = file_get_contents('http://api.openweathermap.org/data/2.5/weather?lat='.$lati1.'&lon='.$longi1.'&APPID=YOUR WEATHER API KEY');

 //decode JSON to array
 $data1 = json_decode($json1,true);

 //show data
 //var_dump($data1);
 
$temp_start=$data1['main']['temp'];

 //description
 $desc_start=$data1['weather'][0]['description'];
 //temperature
 $json2 = file_get_contents('http://api.openweathermap.org/data/2.5/weather?lat='.$lati2.'&lon='.$longi2.'&APPID=YOUR WEATHER API KEY');

 //decode JSON to array
 $data2 = json_decode($json2,true);

 //show data
 //var_dump($data2);
 
$temp_end=$data2['main']['temp'];

 //description
$desc_end= $data2['weather'][0]['description'];
 //temperature
 
	}
else
{
	echo $resp->status;
}
?>
<!DOCTYPE html>

<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
	
    <title>MyWayPoints </title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
	  
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #floating-panel {
        position: absolute;
        top: 10px;
        left: 25%;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
        text-align: center;
        font-family: 'Roboto','sans-serif';
        line-height: 30px;
        padding-left: 10px;
      }
      #warnings-panel {
        width: 100%;
        height:10%;
        text-align: center;
      }
    </style>
  </head>
  <body>
    <div id="floating-panel">
     
   
	
	Temperature start: <input id="temp_start" type="textbox" value=" ">
	Description start: <input id="desc_start" type="textbox" value=" ">
	Temperature end:  <input id="temp_end" type="textbox" value=" ">
	Description end:  <input id="desc_end" type="textbox" value=" ">
	
     
    </div>
     <div id="map"></div>
    &nbsp;
    <div id="warnings-panel"></div>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script>
	document.getElementById('temp_start').value = '<?php echo json_encode($temp_start); ?>',
	 document.getElementById('temp_end').value = '<?php echo json_encode($temp_end); ?>'
	 document.getElementById('desc_start').value = '<?php echo json_encode($desc_start); ?>',
	 document.getElementById('desc_end').value = '<?php echo json_encode($desc_end); ?>'
      var temps =[];
	  function initMap() {
        var markerArray = [];
        
        // Instantiate a directions service.
        var directionsService = new google.maps.DirectionsService;

        // Create a map and center it on University at Buffalo.
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: {lat: 43.0008, lng: -78.7890}
        });

        // Create a renderer for directions and bind it to the map.
        var directionsDisplay = new google.maps.DirectionsRenderer({map: map});

        // Instantiate an info window to hold step text.
        var stepDisplay = new google.maps.InfoWindow;

        // Display the route between the initial start and end selections.
        calculateAndDisplayRoute(
            directionsDisplay, directionsService, markerArray, stepDisplay, map);
        // Listen to change events from the start and end lists.
        var onChangeHandler = function() {
          calculateAndDisplayRoute(
              directionsDisplay, directionsService, markerArray, stepDisplay, map);
        };

        document.getElementById('start').addEventListener('change', onChangeHandler);
        document.getElementById('end').addEventListener('change', onChangeHandler);
      }

      function calculateAndDisplayRoute(directionsDisplay, directionsService,
          markerArray, stepDisplay, map) {
        // First, remove any existing markers from the map.
        for (var i = 0; i < markerArray.length; i=i+5) {
          markerArray[i].setMap(null);
        }

        // Retrieve the start and end locations and create a DirectionsRequest using
        // DRIVING directions.
        directionsService.route({

         origin: '<?php echo json_encode($startloc); ?>',
          destination: '<?php  echo json_encode($endloc); ?>',
          travelMode: 'DRIVING'
        }, function(response, status) {
          // Route the directions and pass the response to a function to create
          // markers for each step.
          if (status === 'OK') {
            document.getElementById('warnings-panel').innerHTML =
                '<b>' + response.routes[0].warnings + '</b>';

            directionsDisplay.setDirections(response);
            showSteps(response, markerArray, stepDisplay, map);
          }
        });
      }

      function showSteps(directionResult, markerArray, stepDisplay, map) {
        // For each step, place a marker, and add the text to the marker's infowindow.
        // Also attach the marker to an array so we can keep track of it and remove it
        // when calculating new routes.
        var myRoute = directionResult.routes[0].legs[0];
        for (var i = 0; i < myRoute.steps.length; i=i+5) {
          var marker = markerArray[i] = markerArray[i] || new google.maps.Marker;
          marker.setMap(map);
          marker.setPosition(myRoute.steps[i].start_location);

          var Latitude = marker.getPosition().lat();
          var Longitude = marker.getPosition().lng();

          attachInstructionText(
          stepDisplay, marker,"<br> Temperature: " + getWeather(Latitude, Longitude), map);
        }
      }

      
	 

        function getWeather(Latitude, Longitude){
            var temperature = [];
			//var desc= [];
              $.ajax({
                url: 'http://api.openweathermap.org/data/2.5/weather?lat='+Latitude+'&lon='+Longitude+'&appid=YOUR WEATHER API KEY',
                async: false,
                dataType: 'json',
                success: function(json){
                temperature = json.main.temp;
			//	desc=json.weather[0].description;
                }
              });
              return(temperature);
			  //return(desc);
        }
		

      function attachInstructionText(stepDisplay, marker, text, map) {
        google.maps.event.addListener(marker, 'click', function() {
           //Open an info window when the marker is clicked on, containing the text
           //of the step.
          
          stepDisplay.setContent(text);
          stepDisplay.open(map, marker);
        });
      }

    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
    </script>
