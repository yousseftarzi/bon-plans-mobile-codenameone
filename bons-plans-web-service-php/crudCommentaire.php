<?php
require_once('connect.php');
	require('FPDF/fpdf.php');



if ($_GET["type"] == 'ajout'){
$sql = "INSERT INTO `commentaire`(`id_bon_plan`, `id_auteur`, `contenu`, `date_creation`)

VALUES(".$_GET["idBonPlan"].",'".$_GET["idAuteur"]."','".$_GET["contenu"]."',NOW())";

if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}
}

else if($_GET["type"]=="supprimer"){

$sql= "DELETE FROM commentaire WHERE id=".$_GET["idCommentaire"]." ";
if (mysqli_query($conn, $sql)) {
    echo "success";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

}	

else if($_GET["type"]=="afficher"){
$sql="SELECT * FROM commentaire where id_bon_plan=".$_GET["idBonPlan"]."";
$res = mysqli_query($conn,$sql);
$result = array();

while($row = mysqli_fetch_array($res)){
    array_push($result,
        array('id'=>$row['id'],
            'idBonPlan'=>$row['id_bon_plan'],
            'idAuteur'=>$row['id_auteur'],
            'contenu'=>$row['contenu'],
            'date'=>$row['date_creation']
            )
    );
}
echo json_encode(array("root"=>$result));

}


else if($_GET["type"]=="getAuteur"){

$sql="SELECT * FROM Utilisateur where id=".$_GET["idAuteur"]."";
$res = mysqli_query($conn,$sql);
$result = array();

while($row = mysqli_fetch_array($res)){
    array_push($result,
        array('id'=>$row['id'],
            'username'=>$row['username'],
            'photoDeProfil'=>$row['photo_de_profil'],
            'nom'=>$row['nom'],
            'prenom'=>$row['prenom']
            )
    );
}
echo json_encode(array("root"=>$result));
}



else if($_GET["type"]=="reservationPdf"){
$pdf = new FPDF();
$pdf->AddPage();

//Nom Professionnel	
$pdf->SetFont('Arial','B',25);
$pdf->setTextColor(0,0,204);
$pdf->setX(75);
$pdf->Cell(40,10,$_GET["professionnel"]);
$pdf->Ln(30);
//Nom Bon Planeur
$pdf->setTextColor(0,0,0);
$pdf->SetFont('Arial','B',15);
$pdf->Cell(40,10,"Nom : "." ".$_GET["nom"]);
$pdf->Ln(15);
//Prenom Bon Planeur
$pdf->Cell(40,10,"Prenom : "." ".$_GET["prenom"]);
$pdf->Ln(15);
//Date Reservation
$pdf->Cell(40,10,"Date Reservation : "." ".$_GET["dateReservation"]);
$pdf->Ln(15);
//Nombre de Places
$pdf->Cell(40,10,"Nombre de places: "." ".$_GET["nbPlaces"]);	
$pdf->Output();

}

else if($_GET["type"]=="reservationAuthor")
{
	$sql="SELECT login_auteur FROM reservation JOIN bon_plan ON reservation.id_bon_plan=bon_plan.id WHERE reservation.id_bon_plan=".$_GET["idBonPlan"]."";    
    $res = mysqli_query($conn,$sql);
    $result = array();
	while($row = mysqli_fetch_array($res)){
	array_push($result,
		array('reservationAuthor'=>$row['login_auteur']
			)
	);

}
echo json_encode(array("root"=>$result));

}

else if($_GET["type"]=="getDateReservation")
{
    $sql="SELECT startdate FROM reservation WHERE id =".$_GET["idReservation"]."";    
    $res = mysqli_query($conn,$sql);
    $result = array();
    while($row = mysqli_fetch_array($res)){
    array_push($result,
        array('dateReservation'=>$row['startdate']
            )
    );

}
echo json_encode(array("root"=>$result));

}



else if($_GET["type"]=="test"){
$sql="SELECT * FROM Utilisateur where id=".$_GET["idAuteur"]."";
$db = Db::getInstance();
$stmt = $db->prepare($sql);
$stmt->execute();
 echo json_encode($stmt->fetchAll());
}





?>