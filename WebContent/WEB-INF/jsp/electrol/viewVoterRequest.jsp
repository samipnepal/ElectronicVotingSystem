<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:electrol>
<div class="head">Welcome</div>

<div class="table">
<table cellspacing="0">
<tr>
<th>User ID</th>
<th>Constituency</th>
<th>Passed Status</th>
<th>Approved Status</th>
<th>Voter ID</th>
<th>Approve</th>
<th>Reject</th>

</tr>
<c:forEach var="eb" items="${list}">
    <tr class="even">
    <td>${eb.userID }</td>
    <td>${eb.constituency }</td>
    <td>${eb.passedStatus}</td>
    <td>${eb.approvedStatus }</td>
    <td>${eb.voterID }</td>
    <td><a href="/EVS-01/approveVoterIDAdmin/${eb.userID }/1">Approve</a></td>
    <td><a href="/EVS-01/approveVoterIDAdmin/${eb.userID }/0">Reject</a></td>
    </tr>
    </c:forEach>
    </table>
</div>
</t:electrol>