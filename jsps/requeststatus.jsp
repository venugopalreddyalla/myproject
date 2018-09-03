<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>The Below Data Is The Current Processing Data</h2>


	<c:if test="${processingStatus == null}">
 U Enter Wrong Request Id...
	</c:if>
	<c:if test="${processingStatus != null}">
		<table>
			<tr>
				<th>RequestId</th>
				<th>RequestInfo</th>
				<th>Data Info</th>
			</tr>
			<c:forEach var="processStatus" items="${processingStatus}">
				<c:if test="${processStatus != null}">
					<tr>
						<td>${processStatus.requestId}</td>
						<td>${processStatus.requestInfo}</td>
						<td>${processStatus.date}</td>
					</tr>

				</c:if>
			</c:forEach>
		</table>
	</c:if>


	<c:if test="${processingStatus != null}">
		<h2>The Below Data Is, The Completed Levels Of Request</h2>

		<c:if test="${completedStatus == null}">
 U R Request Is Not Submitted Still Yet...
 
		</c:if>

		<c:if test="${completedStatus != null}">
			<table>
				<tr>
					<th>RequestId</th>
					<th>RequestInfo</th>
					<th>Data Info</th>
				</tr>
				<c:forEach var="completedstatus" items="${completedStatus}">

					<c:if test="${completedstatus != null}">
						<tr>
							<td>${completedstatus.requestId}</td>
							<td>${completedstatus.requestInfo}</td>
							<td>${completedstatus.dateInfo}</td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
	<br>
	<h2>Use Below Link Used To Go Home Page</h2>
	<a href="/requestnavigator">Click Hear To Go Home Page...</a>
</body>
</html>