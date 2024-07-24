<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%@include file="assets/html/head.jsp" %>

<body>
<%@include file="assets/html/header.jsp" %>

<div class="container my-5">
    <h2>Register</h2>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>
    <form action="register" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="mb-3">
            <label for="nick" class="form-label">Nick</label>
            <input type="text" class="form-control" id="nick" name="nick" required>
        </div>
        <div class="mb-3">
            <label for="weight" class="form-label">Weight</label>
            <input type="number" class="form-control" id="weight" name="weight" required>
        </div>
        <div class="mb-3">
            <label for="carId" class="form-label">Car ID</label>
            <input type="number" class="form-control" id="carId" name="carId" required>
        </div>
        <div class="mb-3">
            <label for="rolId" class="form-label">Role ID</label>
            <input type="number" class="form-control" id="rolId" name="rolId" required>
        </div>
        <div class="mb-3">
            <label for="addressId" class="form-label">Address ID</label>
            <input type="number" class="form-control" id="addressId" name="addressId" required>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</div>
<%@include file="assets/html/footer.jsp" %>
</body>
</html>
