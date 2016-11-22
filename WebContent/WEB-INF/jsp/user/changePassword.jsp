<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:user>
<div class="head">Welcome</div>

<div class="login-card"> 
    <h1>Change Password</h1><br>
    <font color="red">${user}</font>
 
<form method="post" action="">
<input type="password" name="oldpass" placeholder="Old Password">
<input type="password" name="newpass" placeholder="New Password">
<input type="password" name="cfgpass" placeholder="Confirm Password">


 <input type="submit" name="change" class="login login-submit" value="Change Password">
</form>

</div>


 </t:user>