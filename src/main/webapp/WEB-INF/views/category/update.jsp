<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="wraper">
        <jsp:include page="../block/header.jsp" />
        <div class="panel-body">
            <c:if test="${not empty category}">
            <form action="/category/update" method="post" id="category" commandName="category">
                <input type="hidden" name="id" value="<c:out value="${category.id}"/>">
                Title <input type="text" name="title" value="<c:out value="${category.title}"/>"><br>
                <input type="submit" value="submit"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </c:if>
        </div>
        <jsp:include page="../block/footer.jsp" />
    </div>
</body>
</html>