

<?php

 
$databaseHost = 'localhost';
$databaseName = 'integrationfinal';
$databaseUsername = 'root';
$databasePassword = '';



  $conn = new PDO("mysql:host=$databaseHost;dbname=$databaseName",$databaseUsername, $databasePassword);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	
$sql = "select password from utilisateur";
echo mysql_result(mysql_query("select password from utilisateur"),0,$res); 


?>


<?php
/*
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "test";


// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	echo "pas de conn";
}
else echo "good";

$sql = "INSERT INTO login(username,password)
VALUES("+$_GET["test"]+","+$_GET["mdp"]+")";

if ($conn->query($sql)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();*/
?>

