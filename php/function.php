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
	$Query = "SELECT id_user,role_id,email FROM users where email='$email'";
	$result = $connection->query($Query);
	if($result->num_rows > 0){
 		while ( $row = $result->fetch_assoc()) {
 			print(" User%{id_user:".$row["id_user"].",role_id:".$row["role_id"].",email:".$row["email"]."}");
 		}
 	}
	else{
		print("failed to get user");
	}
}

function RequestSite($connection){
	$query = "SELECT id_site,site FROM sites";
	$result = $connection->query($query);
	if($result->num_rows > 0){
		print("site%")
		while($row = $result->fetch_assoc()){
			print("{id_site:".$row["id_site"].",site:".$row["site"]."}%");
		}
	}
	else{
		print("failed to get Sites");
	}
}

?>