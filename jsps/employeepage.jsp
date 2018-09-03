<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Employee Login Page For Request Update</h1>

		<form:form modelAttribute="employeeInfoTbl" action="requestdeatils">

			<table>
				<tr>
					<td><form:label path="userId">Employee User Id:</form:label></td>
					<td><form:input path="userId" /></td>
					<td><form:errors path="userId"></form:errors></td>
				</tr>

				<tr>
					<td></td>
					<td><form:button>Submit</form:button></td>
					<td></td>
				</tr>
			</table>

		</form:form>
	</center>

</body>
</html>