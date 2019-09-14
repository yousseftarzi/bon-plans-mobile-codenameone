

<?php

 if($_GET["type"]=="ajout"){
$databaseHost = 'localhost';
$databaseName = 'integrationfinal';
$databaseUsername = 'root';
$databasePassword = '';


  $conn = new PDO("mysql:host=$databaseHost;dbname=$databaseName",$databaseUsername, $databasePassword);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$sql = "INSERT INTO reclamation(message,Idsource)
VALUES('".$_GET["message"]."',".$_GET["Idsource"].")";


if ($conn->exec($sql)) {
echo "New record created successfully";}
else echo "problem"; 
 }


?>


