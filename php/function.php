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

function RequestUser($userName'$connection){
	$Query = "SELECT name,password,role_id FROM users where name='$userName'";
	$result = $connection->query($Query);
	if($result->num_rows > 0){
 		while ( $row = $result->fetch_assoc()) {
 			print(" User% name:".$row["name"]."password:".$row["password"]."role_id:".$row["role_id"]);
 		}
 	}
	else{
		print("failed to get user");
	}
}

?>