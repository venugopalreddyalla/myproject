<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>statuslogin</title>
</head>
<body>

	<center>
		<h2>Enter Your Request Id To Get Current Status Of Your
			Request...</h2>
		<form:form modelAttribute="requestId" action="requeststatus">
			<table>
				<tr>
					<td><form:label path="reqId">Enter Request Id:</form:label></td>
					<td><form:input path="reqId" /></td>
					<td><form:errors path="reqId"></form:errors></td>
					
				</tr>
				<tr>
					<td></td>
					<td><form:button>Get Status</form:button></td>
					<td></td>
					
				</tr>
			</table>
		</form:form>
	</center>

</body>
</html>