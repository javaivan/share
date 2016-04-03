<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>HelloWorld page</title>
	<jsp:include page="block/head.jsp" />
</head>
<body>
	<div class="wraper">
		<jsp:include page="block/header.jsp" />
		Greeting : ${greeting}
		This is a welcome page.
		<jsp:include page="block/footer.jsp" />
	</div>
</body>
</html>