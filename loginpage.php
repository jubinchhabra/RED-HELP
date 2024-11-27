<?php
$con_status=include_once("connectionfile.php");
if($con_status){
	
	$uemail=$_POST['user_email'];
	$upassword=$_POST['user_password'];
	
	// echo"hello=".$upassword;
	

	$sql="select* from login Where emailaddress='$uemail' ";
	$result=mysqli_query($con, $sql);
	$num=mysqli_num_rows($result);
	if($num>0){
		$row_data=mysqli_fetch_row($result);
		$user_db_password=$row_data[2];
		if($upassword==$user_db_password){
			echo"login";
		}
		else{
			echo"error";
		}

	}
	else{
		echo"user not found";
	}

}
else{
	echo"error";
}


?>