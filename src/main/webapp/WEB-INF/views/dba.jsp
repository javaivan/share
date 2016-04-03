<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>DBA page</title>
</head>
<body>
	<div class="wraper">
		<jsp:include page="block/header.jsp" />
		Dear <strong>${user}</strong>, Welcome to DBA Page.
		<a href="<c:url value="/logout" />">Logout</a>
		<jsp:include page="block/footer.jsp" />
	</div>
</body>
</html>