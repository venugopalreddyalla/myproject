<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Request</title>
</head>
<body>
	<center>
		<h2>Enter Below Request Id To Update</h2>
	</center>

	<h3>This Is The Request Given Client</h3>
	<table border="1">
		<c:forEach var="req" items="${request}">

			<tr>
				<th>Request Id</th>
				<th>Request Info</th>
				<th>Data Of Request</th>
			</tr>
			<tr>
				<td>${req.requestId}</td>
				<td>${req.requestInfo}</td>
				<td>${req.date}</td>
			</tr>

		</c:forEach>
	</table>

	<h3>This Is The Task Done By us...</h3>

	<c:if test="${allRequestInfo=='null'}">
             You Have't Perform Any Task Up To Now...
    </c:if>
	<table border="1" >
		<tr>
			<th>Request Id</th>
			<th>Request Info</th>
			<th>Data Of Request</th>
		</tr>
	
		<c:forEach var="requestInfo" items="${allRequestInfo}">
			<c:if test="${requestInfo != 'null'}">
				<tr>
					<td>${requestInfo.requestId}</td>
					<td>${requestInfo.requestInfo}</td>
					<td>${requestInfo.dateInfo}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<center>
		<form:form modelAttribute="requestStatus" action="afterupdate">
			<table>
				<tr>
					<td><form:label path="requestId">Request Id:</form:label></td>
					<td><form:input path="requestId" /></td>
					<td><form:errors path="requestId"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="presntStatus">Present Status</form:label>
					</td>
					<td><form:select path="presntStatus">
							<option value="NONE">--- Select ---</option>
							<form:option value="Request Processing">Request Processing</form:option>
							<form:option value="Div Environment Processing">Div Environment Processing</form:option>
							<form:option value="SIT Environment Processing">SIT Environment Processing</form:option>
							<form:option value="CIT Is Processing">CIT Is Processing</form:option>
							<form:option value="UAT Is Processing">UAT Is Processing</form:option>
							<form:option value="PROD Is Processing">PROD Is Processing</form:option>

						</form:select></td>
					<td><form:errors path="presntStatus"></form:errors></td>
				</tr>

				<tr>
					<td><form:label path="completedStatus">Completed Status</form:label>
					</td>
					<td><form:select path="completedStatus">
							<option value="NONE">--- Select ---</option>
							<form:option value="Request Received">Request Received</form:option>
							<form:option value="Request processing Completed">Request processing Completed</form:option>
							<form:option value="DIV Environment Completed">Div Environment Completed</form:option>
							<form:option value="SIT Environment Completed">SIT Environment Completed</form:option>
							<form:option value="CIT Is Completed">CIT Is Completed</form:option>
							<form:option value="UAT Is Completed">UAT Is Completed</form:option>
							<form:option value="PROD Is Completed">PROD Is Completed</form:option>

						</form:select></td>
					<td><form:errors path="completedStatus"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button>update</form:button></td>
				</tr>

			</table>

		</form:form>
	</center>
</body>
</html>