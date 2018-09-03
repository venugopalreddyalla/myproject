<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Page</title>
</head>
<body>

<center><h2>Request Login Page</h2></center>
	<center>
		<form:form modelAttribute="requestTbl" action="aftersubmit"
			method="POST">
			<table>
				<tr>

					<td><form:label path="name">Enter Your Name :</form:label> </td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name"></form:errors></td>

				</tr>

				<tr>

					<td><form:label path="mobileNum">Enter Your MobileNum :</form:label>
					</td>
					<td><form:input path="mobileNum" /></td>
					<td><form:errors path="mobileNum"></form:errors></td>

				</tr>

				<tr>

					<td><form:label path="requestInfo">Enter Your Request :</form:label>
					</td>
					<td><form:input path="requestInfo" /></td>
					<td><form:errors path="requestInfo"></form:errors></td>

				</tr>

				<tr>

					<td></td>
					<td><form:button> Submit Your Request</form:button></td>
					<td></td>

				</tr>

			</table>
		</form:form>
	</center>

<h2>The Below Link Is Used To Navigate to Your Status</h2>
<a href="statuslogin"> Click Hear To See Your Status...</a>

</body>
</html>