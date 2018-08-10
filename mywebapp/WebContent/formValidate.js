function validate(){
	if(document.getElementById("Name").value){
		if(document.getElementById("Price").value && !isNaN(document.getElementById("Price").value)){
			if(document.getElementById("Qoh").value && !isNaN(document.getElementById("Qoh").value)){
				return true;
			}
			else{
				 document.getElementById("errQoh").innerHTML="Qoh needed!";
			        document.getElementById("errQoh").style.color="red";
			       // document.forms["f1"].submit();
			        return false;
			}
		}
		else{
			
		        document.getElementById("errPrice").innerHTML="Price needed!";
		        document.getElementById("errPrice").style.color="red";
		        return false;
		}
	}
	
	else{
		 document.getElementById("errName").innerHTML="User needed!";
	        document.getElementById("errName").style.color="red";
	        return false;
	       // document.forms["f1"].submit();
	       
	}
} 