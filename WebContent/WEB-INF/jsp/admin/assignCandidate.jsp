<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:admin>
<div class="head">Welcome</div>

	<spring:url value="/resources/js/assignCandidate.js" var="mainJs" />
	<script src="${mainJs}"></script>


	<div class="login-card">
		<h1>Assign Candidate</h1>
		<br> <font color="green">${msg}</font> <font color="red">${error}</font>
		<form:form method="POST" action="/EVS-01/assignCandidate"
			commandName="candidate">



			Select Election: <form:select path="electionID" type="select">
				<c:forEach var="list" items="${electionList}">
					<form:option value="${list.electionID }" label="${list.name }" />
				</c:forEach>
			</form:select>
			<br>
			<br>


			Select Party: <form:select path="partyID" type="select">
				<c:forEach var="list" items="${partyList}">
					<form:option value="${list.partyID }" label="${list.name }" />
				</c:forEach>
			</form:select>

<br><br>
			<form:input path="name" placeholder="Candidate Name" />
			<form:input path="district" placeholder="District" />
			<form:input path="constituency" placeholder="Constituency" />
			<label>Date Of Birth</label>
			<form:input path="dateOfBirth" type="date" />
			<form:input path="mobileNo" placeholder="Mobile Number" />
			<form:input path="address" placeholder="Address" />
			<form:input path="emailID" placeholder="Email" />

			<input type="submit" name="login" class="login login-submit"
				value="Assign Candidate">
		</form:form>


	</div>
</t:admin>