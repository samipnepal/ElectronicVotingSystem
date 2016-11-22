<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:voter>

	<div class="head">Cast Vote</div>


	<div class="login-card">
		<h1>Cast Vote</h1>
		<br> <font size=24px color="green">${msg}</font> <font color="red">${error}</font>
		<form:form method="POST" action="/EVS-01/castVote"		commandName="castVote">
  
  Election Name:  <form:select path="electionID">
				<c:forEach var="list" items="${electionList }">
					<option value="${list.electionID }"  onfocus="/EVS-01/candidateList/${list.name }" >${list.name }</option>
				</c:forEach>
			</form:select>
			<br>
			<br>

			Select Candidate:   <form:select path="candidateID">
				<c:forEach var="list" items="${candidateList }">
					<option value="${list.candidateID }" >${list.name }<option>
				</c:forEach>
				</form:select>
			<br>
			<br> 

			<input type="submit" name="login" class="login login-submit"
				value="Cast Vote">
		</form:form>


	</div>
</t:voter>
