<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:voter>
<div class="head">Welcome</div>
 <div class="login-card">
    <h1>Generate Voter ID</h1><br>
    <font color="green">${msg}</font>
    <font color="red">${error}</font>
  <form:form method="POST" action="/EVS-01/requestVoterId" commandName="reqVoterId">
  Select Constituency:  <form:select path="constituency"> 
				<c:forEach var="list" items="${constituencyList }">
					<form:option value="${list.constituency }" >${list.constituency }</form:option>
				</c:forEach>
			</form:select>
			<br>
			<br>
    
    <input type="submit" name="login" class="login login-submit" value="Request VoterID">
  </form:form>
</div>
 
</t:voter> 