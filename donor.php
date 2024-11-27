<?php
$con_status=include_once("connectionfile.php");
if($con_status){
	
	$uid=$_POST['user_id'];
	$unumber=$_POST['user_mobile'];
	$uemail=$_POST['user_email'];
	$ugroup=$_POST['user_group'];
	 $ugender=$_POST['user_gender'];
	 $udistrict=$_POST['user_district'];


	$sql="insert into donor(name,number,email,gender,bloodgroup,District) values('$uid','$unumber','$uemail','$ugender','$ugroup','$udistrict')";

if(mysqli_query($con,$sql))
{
    echo"inserted";

}
else
echo "query error-".$sql;


}

else
{
    echo "server connection error";
}

?>