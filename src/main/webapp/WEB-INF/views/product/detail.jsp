<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<div>
		<c:import url="/WEB-INF/views/template/header_bar.jsp"></c:import>
		
	</div>
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
        <a href="/product/list" class="btn btn-primary">Back to List</a>
        <a href="/product/update?product_id=${product.product_id}" class="btn btn-warning">Update</a>
        <form action="/product/delete" method="POST" style="display:inline;">
            <input type="hidden" name="product_id" value="${product.product_id}" />
            <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this product?');">Delete</button>
        </form>
        <a href="/account/add?product_id=${product.product_id}" class="btn btn-success">Create Account</a>
    </div>
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
	
</body>
</html>