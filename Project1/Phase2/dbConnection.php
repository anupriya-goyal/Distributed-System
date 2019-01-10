<?php
//Provide your own values of localhost server in below fields
 $servername = " "; 
$username = " ";
 $password = " "; 
 $dbname = " ";
// Create connection 
$conn = mysqli_connect($servername, $username, $password,$dbname); 
// Check connection
 if (!$conn) {
 die("Connection failed: " . mysqli_connect_error()); }
 // sql to create table
$sql = "CREATE TABLE "Provide your own name of table" (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
StartLocation VARCHAR(30) NOT NULL,
EndLocation VARCHAR(30) NOT NULL,
TempStart FLOAT NOT NULL,
TempEnd FLOAT NOT NULL,
LatStart FLOAT NOT NULL,
LongStart FLOAT NOT NULL ,
LatEnd FLOAT NOT NULL,
LongEnd FLOAT NOT NULL

)";
 if ($conn->query($sql) === TRUE) { //echo "Table MyGuests created successfully";
 echo ""; } else { echo "Error creating table: " . $conn->error; } //mysqli_close($conn); ?> 
 
 

