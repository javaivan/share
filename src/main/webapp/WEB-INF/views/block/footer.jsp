<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


Greeting : ${greeting}
This is a welcome page.
<sec:authorize access="hasRole('ROLE_USER')">
	ROLE_USER
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	ROLE_ADMIN
</sec:authorize>
<sec:authorize access="hasRole('ROLE_DBA')">
	ROLE_DBA
</sec:authorize>


<br>
<hr>

<sec:authentication property="principal" />
<br>
<hr>

<sec:authorize access="isAuthenticated()">
	1111
	<sec:authentication property="principal.username" var="username" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	222
	<sec:authentication property="principal" var="username" />
</sec:authorize>

<sec:authentication property="principal" var="authorities" />
