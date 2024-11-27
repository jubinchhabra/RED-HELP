<?php
$SERVER="localhost";
$dbuserid="id21047459_bloodbank";
$dbpassword="Jubin@777";
$database="id21047459_bloodbank";

$con=mysqli_connect($SERVER,$dbuserid,$dbpassword,$database);
if($con){
	return true;
}
else{
	return false;
}
?>
