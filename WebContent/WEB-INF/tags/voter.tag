<%@tag description="Admin Page" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voter</title>
<spring:url value="/resources/css/style.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">
<div class="left"></div>
<div class="right">Electronic Voting System
<div class="user">Welcome , ${evsuser.userID}<a href="/EVS-01/logout"> Logout</a></div>
</div>
<div class="clear"></div>
</div>

<div id='cssmenu'>
<ul>
   <li><a href='/EVS-01/login'><span>Home</span></a></li>
   <li ><a href='#'><span>Products</span></a>
         </li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>
<div class="clear"></div>

<div class="content">
<div class="sidemenu">
<div class="sideheader">Voter Menu</div>
<ul>
<li><a href="/EVS-01/voterProfile">Profile</a></li>
<li><a href="/EVS-01/requestVoterId">Request VoterID</a></li>
<li><a href="/EVS-01/castVote">Cast Vote</a></li>
<li><a href="/EVS-01/upcomingVoterElection">Upcoming Election</a></li>
<li><a href="/EVS-01/viewVoterID">View VoterID</a></li>
<li><a href="/EVS-01/changePassword">Change Password</a></li>
</ul>

</div>
<div class="details">
<jsp:doBody/>
</div>
<div class="clear"></div>
</div>

<div class="footer">
Copyright &copy; 2013 Wipro Technologies. All rights reserved
</div>

</body>
</html>