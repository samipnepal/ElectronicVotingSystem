<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:voter>
 <div class="head">Voter ID Status</div>
 <table cellspacing="5px" cellpadding="5px">
 
 <tr>
 <td>UserID: </td>
 <td>${aBean.userID }</td>
 </tr>
 
 <tr>
 <td>Constituency: </td>
 <td>${aBean.constituency }</td>
 </tr>
 
 <tr>
 <td>PassedStatus: </td>
 <td>${aBean.passedStatus }</td>
 </tr>
 
 <tr>
 <td>Approved Status </td>
 <td>${aBean.approvedStatus }</td>
 </tr>
 
 <tr>
 <td>VoterID </td>
 <td>${aBean.voterID }</td>
 </tr>
 
 
 
 </table>
</t:voter> 