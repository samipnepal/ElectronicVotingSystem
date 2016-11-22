<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:admin>
<div class="head">Welcome</div>

<div class="table">
<table cellspacing="0">
<tr>
<th>Election ID</th>
<th>Election Name</th>
<th>Election Date</th>
<th>District</th>
<th>Constituency</th>
<th>Counting Date</th>


</tr>

<c:forEach var="eb" items="${list}">

    <tr class="even">
    <td>${eb.electionID }</td>
    <td>${eb.name }</td>
    <td>${eb.electionDate}</td>
    <td>${eb.district }</td>
    <td>${eb.constituency }</td>
    <td>${eb.countingDate}</td>

    </tr>
    </c:forEach>
    </table>
</div>
</t:admin>