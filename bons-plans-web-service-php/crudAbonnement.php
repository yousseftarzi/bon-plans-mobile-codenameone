<?php
require_once('connect.php');

if (isset($_GET['idSource']))
$idSource=$_GET['idSource'];

$type=$_GET['type'];

if (isset($_GET['idAbonne']))
$idAbonne=$_GET['idAbonne'];

if ($type == 'ajout'){
$sql = "INSERT INTO abonnement (id_abonne,id_source) VALUES ( '$idAbonne','$idSource')";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}

if ($type == 'initEtat'){
$sql = "UPDATE `abonnement` SET `etat`=0 WHERE `id_abonne`='$idAbonne'";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}

if ($type == 'affichage')
{
	$sql="SELECT COUNT(*) as mawjoud FROM `abonnement` WHERE `id_abonne`= '$idAbonne' and `id_source`= '$idSource' ";

	$res = mysqli_query($conn,$sql);
$result = array();

while($row = mysqli_fetch_array($res)){
	array_push($result,
		array('mawjoud'=>$row[0]
			)
	);
}
echo json_encode(array("result"=>$result));

}


if ($type == 'supprimer')
{

$sql = "DELETE FROM abonnement WHERE id_abonne = '$idAbonne' and id_source = '$idSource' ";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}



}

if ($type == 'affichageUtilisateurByAbonne')
{
	$sql = "SELECT username,adresse,photo_de_profil from utilisateur INNER JOIN abonnement ON utilisateur.id = abonnement.id_source WHERE abonnement.id_abonne='$idAbonne' ";
$res = mysqli_query($conn,$sql);
$result = array();

while($row = mysqli_fetch_array($res)){
	array_push($result,
		array('username'=>$row['username'],
			'adresse'=>$row['adresse'],
			'photoDeProfil'=>$row['photo_de_profil']

			)
	);
}
echo json_encode(array("result"=>$result));
}

if ($type == 'affichageNotificatons')
{
	$sql = "SELECT utilisateur.id,utilisateur.username from abonnement JOIN utilisateur on abonnement.id_source=utilisateur.id WHERE `id_abonne`='$idAbonne' and `etat`=1 ";
$res = mysqli_query($conn,$sql);
$result = array();

while($row = mysqli_fetch_array($res)){
	array_push($result,
		array('id'=>$row['id'],
			'username'=>$row['username']

			)
	);
}
echo json_encode(array("result"=>$result));
}






mysqli_close($conn);
?>