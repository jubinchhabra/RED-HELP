<?php
$con_status=include_once("connectionfile.php");
if($con_status){
	
	$uid=$_POST['user_id'];
	$upassword=$_POST['user_password'];
	$uemail=$_POST['user_email'];
	$ugroup=$_POST['user_group'];
	$umobile=$_POST['user_mobile'];


	$sql="insert into login(userid,password,emailaddress,bloodgroup,mobile) values('$uid','$upassword','$uemail','$ugroup',      
'$umobile')";

if(mysqli_query($con,$sql))
{
    echo"inserted";

}

}