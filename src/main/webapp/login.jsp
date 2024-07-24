<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="assets/html/head.jsp" %>

<body>
<%@include file="assets/html/header.jsp" %>
<div class="container my-5">
    <h2>Login</h2>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>
    <form action="login" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>
<%@include file="assets/html/footer.jsp" %>
</body>
</html>
