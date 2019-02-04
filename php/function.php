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
	else{
		print("connection réeussi!");
	}



function InsertData(){

}

function RequestUser($userName){

}

?>