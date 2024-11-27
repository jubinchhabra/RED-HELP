<?php
$con_status=include_once("connectionfile.php");

       $mydata=array();
if($con_status)
{
    //    $mydata[0]["Name"]="connection testing";
	
//	$uid=$_POST['user_district'];
//	$utype=$_POST['user_group'];
//	

	$sql="select * from donor";// where District='$uid' ";//and bloodgroup='$utype' ";
//	 $mydata[0]["Name"]=$sql;


	$result=mysqli_query($con, $sql);
    
if($result)
{   
    
    
    
    $num=mysqli_num_rows($result);

if($num>0)
{
 //     $mydata[0]["data"]="num=".$num;
      
      
      
          $i=0;
        while($row_data=mysqli_fetch_array($result)){
        $mydata[$i]['Name']=$row_data[1];
        $mydata[$i]['number']=$row_data[2];
         $mydata[$i]['bloodgroup']=$row_data[5];
          $mydata[$i]['District']=$row_data[6];
        
        //$mydata[$i] ['Mobile Number']=$row_data[2];
        //$mydata[$i] ['Blood Group']=$row_data[5];
         //  $mydata[$i] ['District']=$row_data[6];
        $i++;
        }
	
      
}
else
    $mydata[0]["data"]="not data found";

    
    
    
}
else
    $mydata[0]["data"]="query error";

	
	
}
else
    $mydata[0]["data"]="connection error";
	



    	echo json_encode($mydata);

?>