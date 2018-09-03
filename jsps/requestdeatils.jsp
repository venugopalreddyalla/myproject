<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Request Update Page</h1>
		<h3>Select Below Clint Request Id To Update</h3>
		<form:form modelAttribute="requestId" action="updaterequest"
			method="POST">
			<table>
				<tr>
					<td><form:label path="reqId">Enter Request Id:</form:label></td>
					<td><form:input path="reqId" /></td>
					<td><form:errors path="reqId"></form:errors></td>

					<td></td>
				</tr>

				<tr>
					<td></td>
					<td><form:button>Click Hear</form:button></td>
					<td></td>

				</tr>
			</table>
		</form:form>
	</center>
	<h3>Below All Are Requests Given By Clint</h3>

	<table border="1">
		<tr>
			<th>Request Id</th>
			<th>Name</th>
			<th>Mobile Num</th>
			<th>Request Info</th>
			<th>Request Date</th>
		</tr>
		<c:forEach var="requestInfo" items="${allRequests}">
			<tr>
				<td>${requestInfo.requestId}</td>
				<td>${requestInfo.name}</td>
				<td>${requestInfo.mobileNum}</td>
				<td>${requestInfo.requestInfo}</td>
				<td>${requestInfo.date}</td>
			</tr>


		</c:forEach>
	</table>
</body>
</html>