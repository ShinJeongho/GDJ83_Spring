<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
    <div>
        <c:import url="/WEB-INF/views/template/header_bar.jsp"></c:import>
    </div>
    <div class="container-fluid mt-5">
        <h1><span class="fw-bolder text-primary">My Page</span></h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${member.member_name}</h5>
                <p class="card-text">Email: ${member.email}</p>
                <p class="card-text">Phone: ${member.phone}</p>
                <c:if test="${not empty member.profile_image}">
                    <img src="${pageContext.request.contextPath}/resources/upload/members/${member.profile_image}" alt="Profile Image" class="img-thumbnail">
                </c:if>
                <c:if test="${empty member.profile_image}">
                    <img src="${pageContext.request.contextPath}/resources/upload/members/default.png" alt="Default Profile Image" class="img-thumbnail">
                </c:if>
                <form method="POST" action="${pageContext.request.contextPath}/members/update" enctype="multipart/form-data">
                    <div class="form-group mt-3">
                        <label for="profileImage">Update Profile Image</label>
                        <input type="file" class="form-control" id="profileImage" name="profileImage">
                    </div>
                    <button type="submit" class="btn btn-primary mt-3">Update</button>
                </form>
            </div>
        </div>
    </div>
    <div>
        <c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
    </div>
</body>
</html>

