<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<t:admin>
<div class="head">Welcome</div>

    <div class="login-card">
    <h1>Add Election</h1><br>
    <font color="green">${msg}</font>
    <font color="red">${error}</font>
  <form:form method="POST" action="/EVS-01/addElection" commandName="election" >
    <form:input path="name" placeholder="Election Name" />
    <label>Election Date</label>
    <form:input path="electionDate" type="date" placeholder="Election Date" />
    <form:input path="district" placeholder="district" />
     <form:input path="constituency" placeholder="constituency" />
     <label>Counting Date</label>
      <form:input path="countingDate" type="date" placeholder="Counting Date" />
    
    <input type="submit" name="login" class="login login-submit" value="Add Election">
  </form:form>
    
 
</div>
</t:admin>