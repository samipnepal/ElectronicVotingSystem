
function validatename(){
	alert();
	var fname=document.forms.firstName.value;
	if(fname==null || fname=="")
	{
		alert("please enter the first name");
		document.getElementById("firstName").focus();
	}
}
function validatelname(){
	var lname=document.forms.lastName.value;
	if(lname==null || lname=="")
	{
		alert("please enter the last name");
		document.getElementById("lastName").focus();
	}
}

function validatedbirth(){
	var bdate=document.forms.dateOfBirth.value;
	var bdatee=new Date(bdate);
	var tdate=new Date();

		if(bdatee=="Invalid Date" )
		{
			alert("please enter the date");
			document.getElementById("dateOfBirth").focus();
			}
			else if((tdate.getFullYear()-bdatee.getFullYear())<18)
			{
				alert("please age should be greater than 18");
		document.getElementById("dateOfBirth").focus();
			}
			
}

function validategender(){
	var  gndr=document.forms.gender.value;
	
if ( (form.gender[0].checked == false ) || ( form.gender[1].checked == false ) )
{
	alert ( "Please choose your Gender: Male or Female" );
document.getElementById("gender").focus();
}

}
function validatestreet(){
	var strt=document.forms.street.value;
	 if(strt==""  || strt==null)
		{
		alert("please enter the street name");
		document.getElementById("street").focus();
		}
}
function validatelocation(){
	var  lctn=document.forms.location.value;
	if(lctn==""  || lctn==null)
	{
		alert("please enter the location");
		document.getElementById("location").focus();
		}
}
function validatecity(){
	var cty=document.forms.city.value;
	if(cty==""  || cty==null)
	 {
			alert("please enter the city");
			document.getElementById("city").focus();
	 }
}

function validatestate(){
	var st=document.forms.state.value;
	if(st==""  ||st==null)
	{
	alert("please enter the state");
	document.getElementById("state").focus();
	}
	
}
function validatepincode(){
	var pin=document.forms.pincode.value;
	var pinpattern=/^[0-9]{6}$/;
	if(!pinpattern.test(pin)){
		alert("please enter the valid pincode");
		document.getElementById("pincode").focus();
	document.getElementById("pincode").value="";
	}
}

function validatemobile(){
	var mobile=document.forms.mobileNo.value;
	if(!mobile.match(/^[0-9]{10}$/))
		{
		alert("please enter the valid mobile number");
		document.getElementById("mobileNo").focus();
	document.getElementById("mobileNo").value="";
		}
}


function validateemail(){
	var email=document.forms.emailID.value;
		  atpos = email.indexOf("@");
	    dotpos = email.lastIndexOf(".");
	    if (atpos < 1 || ( dotpos - atpos < 2 )|| email=="")
	    {
	       
	        alert("Please provide a valid email address");
	        document.getElementById("emailID").focus();
	        document.getElementById("elementId").value="";
	    }

}


function validatepassword(){
	var pwd=document.forms.password.value;
	if(pwd==""  ||pwd==null||pwd.length<6)
		{
	alert("please enter a password of atleast 6 characters");
	document.getElementById("password").focus();
		}
	
}