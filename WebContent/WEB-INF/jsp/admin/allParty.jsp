<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:admin>
<div class="head">Party List</div>
<div class="table">
<table cellspacing="0">
<tr>
<th>Party ID</th>
<th>Party Name</th>
<th>Leader Name</th>
<th>Symbol</th>

</tr>

<c:forEach var="eb" items="${list}">

    <tr class="even">
    <td>${eb.partyID }</td>
    <td>${eb.name }</td>
    <td>${eb.leader}</td>
    <td>${eb.symbol }</td>
 
    </tr>
    </c:forEach>
    </table>
</div>
  
</t:admin>