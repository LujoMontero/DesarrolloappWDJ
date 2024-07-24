<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="assets/html/head.jsp" %>

<body>
<%@include file="assets/html/header.jsp" %>
<div class="container my-5">
    <h2>Login</h2>
    <form action="login" method="post">
        Email: <input type="text" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
</div>
<%@include file="assets/html/footer.jsp" %>
</body>
</html>
