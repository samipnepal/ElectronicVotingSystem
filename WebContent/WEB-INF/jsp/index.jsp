<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronic Voting System</title>
</head>

<spring:url value="/resources/css/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" type="text/css" />
<body>

<div class="header">
<div class="left"></div>
<div class="right">Electronic Voting System</div>
<div class="clear"></div>
</div>

<div id='cssmenu'>
<ul>
   <li><a href='#'><span>Home</span></a></li>
   <li><a href='#'><span>Products</span></a>
    
   </li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>
<div class="clear"></div>

<div class="content">
<div class="left">Welcome to Electronic Voting System</div>




<div class="right">
  <div class="login-card">
    <h1>Log-in</h1><br>
    <font color="red">${user}</font>
    <font color="green">${msg}</font>
  <form:form method="POST" action="/EVS-01/login" commandName="loginuser" >
    <form:input path="userID" placeholder="Username" />
    <form:password path="password" placeholder="Password" />
    <input type="submit" name="login" class="login login-submit" value="login">
  </form:form>
    
  <div class="login-help">
    <a href="/EVS-01/registerUser">Register</a> 
  </div>
</div>

</div>
<div class="clear"></div>
</div>

<div class="footer">
Copyright &copy; 2013 Wipro Technologies. All rights reserved
</div>


</body>
</html>