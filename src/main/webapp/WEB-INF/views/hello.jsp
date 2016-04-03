<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Maven + Spring MVC</title>
</head>
<ul>
	<li><a href="/">Home</a></li>
	<li><a href="/post-all">post all</a></li>
	<li><a href="/post-add">post add</a></li>
	<li><a href="/category-all">category all</a></li>
	<li><a href="/category-add">category add</a></li>
	<li><a href="/user-all">user all</a></li>
</ul>
<div class="jumbotron">
	<div class="container">
		<h1>${messege}</h1>
	</div>
</div>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<sec:authorize access="hasRole('ROLE_USER')">
	<!-- For login user -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			User : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>


</sec:authorize>


</body>
</html>