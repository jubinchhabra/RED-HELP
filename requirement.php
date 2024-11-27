<?php
$con_status=include_once("connectionfile.php");
if($con_status){
	
	$ptname=$_POST['userptname'];
	$cpname=$_POST['usercpname'];
	$group=$_POST['usergroup'];
	$udistrict=$_POST['userdistrict'];
	 $ucity=$_POST['usercity'];
	 $hospital=$_POST['userhospital'];
	  $units=$_POST['userunits'];
	   $phone=$_POST['userphone'];
	    $date=$_POST['userdate'];
	   


	$sql="insert into requirement(ptname,contactPname,blood,district,city,hospital,units,phone,date) values('$ptname','$cpname','$group','$udistrict','$ucity','$hospital','$units','$phone','$date')";

if(mysqli_query($con,$sql))
{
    echo"inserted";

}
else{
    echo"error";
}

}
else
{
    echo "connection error";
}



?>