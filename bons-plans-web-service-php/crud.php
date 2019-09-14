

<?php

 if($_GET["type"]=="ajout"){
$databaseHost = 'localhost';
$databaseName = 'integrationfinal';
$databaseUsername = 'root';
$databasePassword = '';

$allowedExts = array("gif", "jpeg", "jpg", "png");
$temp = explode(".", $_FILES["file"]["name"]);
$extension = end($temp);

if ((($_FILES["file"]["type"] == "image/gif") || ($_FILES["file"]["type"] == "image/jpeg") || ($_FILES["file"]["type"] == "image/jpg") || ($_FILES["file"]["type"] == "image/pjpeg") || ($_FILES["file"]["type"] == "image/x-png") || ($_FILES["file"]["type"] == "image/png")) && ($_FILES["file"]["size"] < 5000000) && in_array($extension, $allowedExts)) {
    if ($_FILES["file"]["error"] > 0) {
        $named_array = array("Response" => array(array("Status" => "error")));
        echo json_encode($named_array);
    } else {
        move_uploaded_file($_FILES["file"]["tmp_name"], "uploads/" . $_FILES["file"]["name"]);

        $Path = $_FILES["file"]["name"];
        $named_array = array("Response" => array(array("Status" => "ok")));
        echo $Path;
    }
} else {
    $named_array = array("Response" => array(array("Status" => "invalid")));
    echo json_encode($named_array);
}


  $conn = new PDO("mysql:host=$databaseHost;dbname=$databaseName",$databaseUsername, $databasePassword);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$sql = "INSERT INTO bon_plan(login_auteur,titre,adresse,etat_coupon)
VALUES(".$_GET["auteur"].",'".$_GET["nom"]."','".$_GET["adress"]."',".$_GET["nbre"].")";

$sql2 = "UPDATE `abonnement` SET `etat` = '1' WHERE `abonnement`.`id_source` = ".$_GET["auteur"]." ";

if ($conn->exec($sql)) {
echo "New record created successfully";}
else echo "problem"; 

if ($conn->exec($sql2)) {
echo "New record abonnement successfully";}
else echo "problem abonnement"; 



 }


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

