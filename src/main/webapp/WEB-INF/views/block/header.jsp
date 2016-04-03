<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div id="header">
	<strong><a href="/">Share</a></strong>
	<ul class="nav">
		<li><a href="/post/">post all</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/post/add">post add</a></li>
		</sec:authorize>
		<li><a href="/category/">category all</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="/category/add">category add</a></li>
		</sec:authorize>
	</ul>
	<ul class="acount_box">
		<sec:authorize access="!isAuthenticated()">
			<li><a href="<c:url value="/login" />">Login</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li><a href="<c:url value="/logout" />">Logout</a></li>
		</sec:authorize>
	</ul>
</div>