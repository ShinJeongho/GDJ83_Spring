<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="/WEB-INF/views/template/header_css.jsp"></c:import> <!-- 헤더 CSS 가져오기 -->
</head>
<body class="d-flex flex-column h-100">
    <div>
        <c:import url="/WEB-INF/views/template/header_bar.jsp"></c:import> <!-- 헤더 바 가져오기 -->
    </div>
    <div class="container-fluid mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="<c:url value='/members/join'/>" method="post" id="frm" enctype="multipart/form-data"> <!-- action 추가 -->
                    <div class="mb-3">
                        <label for="userName" class="form-label">ID</label>
                        <input type="text" class="form-control" id="userName" name="member_id">
                        <div id="userNameError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">PASSWORD</label>
                        <input type="password" class="form-control" id="password" name="member_pwd">
                        <div id="passwordError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3">
                        <label for="confirmPassword" class="form-label">PASSWORD 확인</label>
                        <input type="password" class="form-control" id="confirmPassword">
                        <div id="confirmPasswordError" class="text-danger"></div>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">NAME</label>
                        <input type="text" class="form-control" id="name" name="member_name">
                        <div id="nameError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3">
                        <label for="memberNumber" class="form-label">MEMBER NUMBER</label>
                        <input type="text" class="form-control" id="memberNumber" name="member_number">
                        <div id="memberNumberError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">PHONE</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                        <div id="phoneError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">EMAIL</label>
                        <input type="email" class="form-control" id="email" name="email">
                        <div id="emailError" class="text-danger"></div> <!-- 오류 메시지 표시 -->
                    </div>
                    <div class="mb-3" id="photoContainer"> <!-- 사진 입력 필드 컨테이너 -->
                        <button type="button" id="add" class="btn btn-secondary">사진추가</button> <!-- 사진 추가 버튼 -->
                        <div id="photoFields"></div> <!-- 동적으로 추가될 파일 입력 필드를 위한 div -->
                    </div>
                    <div class="d-grid gap-2">
                        <button type="button" id="btn" class="btn btn-primary">Join</button> <!-- 제출 버튼 -->
                    </div>
                </form> <!-- 폼 끝 -->
            </div>
        </div>
    </div>
    <div>
        <c:import url="/WEB-INF/views/template/footer.jsp"></c:import> <!-- 푸터 가져오기 -->
        <script type="text/javascript" src="../resources/js/commons/files.js"></script> <!-- 파일 추가 스크립트 -->
        <script type="text/javascript" src="../resources/js/member/memberjoinCheck.js"></script> <!-- 회원가입 체크 스크립트 -->
    </div>
</body>
</html>
