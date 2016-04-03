<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:48 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Category Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="wraper">
        <jsp:include page="../block/header.jsp" />
        <div class="panel-body">
            <form:form method="post" action="/category/add" commandName="category">
                <table>
                    <tr>
                        <td>title</td>
                        <td><form:input path="title" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="submit" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
        <jsp:include page="../block/footer.jsp" />
    </div>
</body>
</html>