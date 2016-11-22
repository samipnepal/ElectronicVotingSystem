<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<t:user>


	<script>
		function validatename() {

			var fname = document.forms.firstName.value;
			if (fname == null || fname == "") {
				alert("please enter the first name");
				document.getElementById("firstName").focus();
			}
		}
		function validatelname() {
			var lname = document.forms.lastName.value;
			if (lname == null || lname == "") {
				alert("please enter the last name");
				document.getElementById("lastName").focus();
			}
		}

		function validatedbirth() {
			var bdate = document.forms.dateOfBirth.value;
			var bdatee = new Date(bdate);
			var tdate = new Date();

			if (bdatee == "Invalid Date") {
				alert("please enter the date");
				document.getElementById("dateOfBirth").focus();
			} else if ((tdate.getFullYear() - bdatee.getFullYear()) < 18) {
				alert("please age should be greater than 18");
				document.getElementById("dateOfBirth").focus();
			}

		}
		function validateForm() {
			var bdate = document.forms.dateOfBirth.value;
			var bdatee = new Date(bdate);
			var tdate = new Date();
			if (bdatee == "Invalid Date") {
				alert("please enter the date");
				document.getElementById("dateOfBirth").focus();
				return false;
			} else if ((tdate.getFullYear() - bdatee.getFullYear()) < 18) {

				document.getElementById("dateOfBirth").focus();
				return false;
			}
			return true;

		}

		function validategender() {
			var gndr = document.forms.gender.value;

			if ((form.gender[0].checked == false)
					|| (form.gender[1].checked == false)) {
				alert("Please choose your Gender: Male or Female");
				document.getElementById("gender").focus();
			}

		}
		function validatestreet() {
			var strt = document.forms.street.value;
			if (strt == "" || strt == null) {
				alert("please enter the street name");
				document.getElementById("street").focus();
			}
		}
		function validatelocation() {
			var lctn = document.forms.location.value;
			if (lctn == "" || lctn == null) {
				alert("please enter the location");
				document.getElementById("location").focus();
			}
		}
		function validatecity() {
			var cty = document.forms.city.value;
			if (cty == "" || cty == null) {
				alert("please enter the city");
				document.getElementById("city").focus();
			}
		}

		function validatestate() {
			var st = document.forms.state.value;
			if (st == "" || st == null) {
				alert("please enter the state");
				document.getElementById("state").focus();
			}

		}
		function validatepincode() {
			var pin = document.forms.pincode.value;
			var pinpattern = /^[0-9]{6}$/;
			if (!pinpattern.test(pin)) {
				alert("please enter the valid pincode");
				document.getElementById("pincode").focus();
				document.getElementById("pincode").value = "";
			}
		}

		function validatemobile() {
			var mobile = document.forms.mobileNo.value;
			if (!mobile.match(/^[0-9]{10}$/)) {
				alert("please enter the valid mobile number");
				document.getElementById("mobileNo").focus();
				document.getElementById("mobileNo").value = "";
			}
		}

		function validateemail() {
			var email = document.forms.emailID.value;
			atpos = email.indexOf("@");
			dotpos = email.lastIndexOf(".");
			if (atpos < 1 || (dotpos - atpos < 2) || email == "") {

				alert("Please provide a valid email address");
				document.getElementById("emailID").focus();
				document.getElementById("elementId").value = "";
			}

		}

		function validatepassword() {
			var pwd = document.forms.password.value;
			if (pwd == "" || pwd == null || pwd.length < 6) {
				alert("please enter a password of atleast 6 characters");
				document.getElementById("password").focus();
			}

		}
	</script>

	<div class="head">User Registration</div>
	<div class="login-card">
		<h1>User Registration</h1>
		<br> <font color="red">${user}</font>

		<form:form method="POST" action="/EVS-01/registerUser"
			commandName="registerUser" name="forms"
			onsubmit="return validateForm()">
			<font color="green">${msg}</font>
			<table>
				<tr>
					<td><form:label path="firstName">First Name</form:label></td>
					<td><form:input path="firstName" onblur="validatename()" /></td>
					<td><font color="red"><form:errors path="firstName" /></font></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name</form:label></td>
					<td><form:input path="lastName" onblur="validatelname()" /></td>
					<td><font color="red"><form:errors path="lastName" /></font></td>
				</tr>
				<tr>
					<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
					<td><form:input type="date" path="dateOfBirth"
							onblur="validatedbirth()" /></td>
					<td><font color="red"><form:errors path="dateOfBirth" /></font></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label></td>
					<td><form:radiobutton path="gender" value="Male" />Male <form:radiobutton
							path="gender" value="Female" onblur="validategender()" />Female</td>
					<td><font color="red"><form:errors path="gender" /></font></td>
				</tr>
				<tr>
					<td><form:label path="street">Street</form:label></td>
					<td><form:input path="street" onblur="validatestreet()" /></td>
					<td><font color="red"><form:errors path="street" /></font></td>
				</tr>
				<tr>
					<td><form:label path="location">Location</form:label></td>
					<td><form:input path="location" onblur="validatelocation()" /></td>
					<td><font color="red"><form:errors path="location" /></font></td>
				</tr>
				<tr>
					<td><form:label path="city">City</form:label></td>
					<td><form:input path="city" onblur="validatecity()" /></td>
					<td><font color="red"><form:errors path="city" /></font></td>
				</tr>
				<tr>
					<td><form:label path="state">State</form:label></td>
					<td><form:input path="state" onblur="validatestate()" /></td>
					<td><font color="red"><form:errors path="state" /></font></td>
				</tr>
				<tr>
					<td><form:label path="pincode">Pincode</form:label></td>
					<td><form:input path="pincode" onblur="validatepincode()" /></td>
					<td><font color="red"><form:errors path="pincode" /></font></td>
				</tr>
				<tr>
					<td><form:label path="mobileNo">Mobile Number</form:label></td>
					<td><form:input path="mobileNo" onblur="validatemobile()" /></td>
					<td><font color="red"><form:errors path="mobileNo" /></font></td>
				</tr>
				<tr>
					<td><form:label path="emailID">Email ID</form:label></td>
					<td><form:input path="emailID" onblur="validateemail()" /></td>
					<td><font color="red"><form:errors path="emailID" /></font></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" onblur="validatepassword()" /></td>
					<td><font color="red"><form:errors path="password" /></font></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="register" class="login login-submit" value="Register">
					</td>
				</tr>

			</table>
		</form:form>
	</div>

</t:user>