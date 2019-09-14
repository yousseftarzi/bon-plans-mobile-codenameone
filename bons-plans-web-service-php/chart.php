<?php

 

$databaseHost = 'localhost';
$databaseName = 'integrationfinal';
$databaseUsername = 'root';
$databasePassword = '';



  $conn = new PDO("mysql:host=$databaseHost;dbname=$databaseName",$databaseUsername, $databasePassword);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$sql = "select count(*) from reclamation where Idsource=1";

$stmt = $conn->prepare($sql);
$stmt->execute();

echo json_encode($stmt->fetchAll());

?>

