<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>After Submit</title>
</head>
<body>
 Hello ${requestTbl.name} You Are Request Is SubMitted ...  <br>
 
 This Is Your Request Id [ ${requestTbl.requestId} ]  Please Note This Request Id To See Your Request Status... <br>
 
 Thank You
 
 <h2>The Below Link Used TO Add New Request</h2>
<a href="/requestnavigator">click hear to add another request</a>


<h2>The Below Link Is Used To Navigate to Your Status</h2>
<a href="statuslogin"> Click Hear To See Your Status...</a>


</body>
</html>