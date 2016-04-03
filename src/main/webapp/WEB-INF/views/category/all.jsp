<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category List</title>
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
            <c:if test="${empty listCategories}">
                There are no Employees
            </c:if>
            <c:if test="${not empty listCategories}">

                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listCategories}" var="category">
                        <tr>
                            <th><c:out value="${category.id}"/></th>
                            <th>
                                <a href="/category/<c:out value="${category.id}"/>"><c:out value="${category.title}"/></a>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <br>
                                    <a href="/category/update/<c:out value="${category.id}"/>">Update</a>
                                </sec:authorize>
                            </th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
        <jsp:include page="../block/footer.jsp" />
    </div>
</body>
</html>