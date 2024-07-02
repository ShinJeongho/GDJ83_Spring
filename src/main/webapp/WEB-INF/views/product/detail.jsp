<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Detail</title>
    <c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
    <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

    <div class="container-fluid mt-5">
        <h1>Product Detail</h1>
        <table class="table table-striped">
            <tr>
                <th>Product ID</th>
                <td>${product.product_id}</td>
            </tr>
            <tr>
                <th>Product Type</th>
                <td>${product.product_type}</td>
            </tr>
            <tr>
                <th>Product Rate</th>
                <td>${product.product_rate}</td>
            </tr>
            <tr>
                <th>Product Detail</th>
                <td>${product.product_detail}</td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/product/list" class="btn btn-primary">Back to List</a>
    </div>

    <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
