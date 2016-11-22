<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:voter>
<div class="head">Profile</div>


<table cellpadding=10px cellspacing=5px>
<tr>
<td>UserID: </td>
<td>${profile.userID }</td>
</tr>


<tr>
<td>Name: </td>
<td>${profile.firstName } ${profile.lastName }</td>
</tr>

<tr>
<td>Date Of Birth: </td>
<td>${profile.dateOfBirth }</td>
</tr>


<tr>
<td>Gender: </td>
<td>${profile.gender }</td>
</tr>


<tr>
<td>Street: </td>
<td>${profile.street }</td>
</tr>



<tr>
<td>Street: </td>
<td>${profile.location }</td>
</tr>


<tr>
<td>City: </td>
<td>${profile.city }</td>
</tr>

<tr>
<td>State: </td>
<td>${profile.state }</td>
</tr>


<tr>
<td>PinCode: </td>
<td>${profile.pincode }</td>
</tr>

<tr>
<td>Mobile Number: </td>
<td>${profile.mobileNo }</td>
</tr>

<tr>
<td>Email ID: </td>
<td>${profile.emailID }</td>
</tr>


</table>

 
</t:voter> 