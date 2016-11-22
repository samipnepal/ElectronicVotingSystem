<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:admin>
<div class="head">Welcome</div>

    <div class="login-card">
    <h1>Add Election</h1><br>
    <font color="green">${msg}</font>
    <font color="red">${error}</font>
  <form:form method="POST" action="/EVS-01/addParty" commandName="addParty" enctype="multipart/form-data">
  
    <form:input path="name" placeholder="Party Name" />
    <form:input path="leader" placeholder="Leader Name" />
     <input type="file" name="file" />
    
    
    <input type="submit" name="login" class="login login-submit" value="Add Election">
  </form:form>
    
 
</div>
</t:admin>