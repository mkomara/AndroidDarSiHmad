<?php

function Connexion(){
 	$login = "PhilippeB";
 	$motDePasse = "Passw0rd";
 	$BaseDeDonne = "darsihmadbd";
 	$serveur = "localhost";

 	$con = new mysqli($serveur,$login,$motDePasse,$BaseDeDonne);
 	if ($con->connect_error) {
 		print("failed");
		die('connection failed: '.$con->connect_error);
	}
	return $con;
}



function InsertData(){

}

function RequestUser($email'$connection){
	$Query = "SELECT id_user,role_id FROM users where email='$email'";
	$result = $connection->query($Query);
	if($result->num_rows > 0){
 		while ( $row = $result->fetch_assoc()) {
 			print(" User%{id_user:".$row["id_user"].",role_id:".$row["role_id"]."}");
 		}
 	}
	else{
		print("failed to get user");
	}
}

?>