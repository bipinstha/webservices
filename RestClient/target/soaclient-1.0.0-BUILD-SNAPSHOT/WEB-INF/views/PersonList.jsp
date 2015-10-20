<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>:: Rest Client ::</title>
</head>
<body>
	<h1>Rest Client</h1>
        <div>${error}</div>
	<table>
		<caption>Person List</caption>
		<thead>
			<tr>
				<th>Full Name</th>
				<th>Address</th>
				<th>Email</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${persons}" var="person">
		<tr>
		<td>${person.name}</td>
		<td>${person.address}</td>
		<td>${person.email}</td>
		<td><a href='<c:url value = "/person/${person.id}"/>'>Edit</a> | <a href="#">Delete</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
