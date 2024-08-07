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
	<div>
	 <!-- Header profile picture-->
            <div class="d-flex justify-content-center mt-5 mt-xxl-0">
                <div class="">
                    <!-- TIP: For best results, use a photo with a transparent background like the demo example below-->
                    <!-- Watch a tutorial on how to do this on YouTube (link)-->
                    <img class="profile-img" src="/resources/assets/1.jpg" alt="..." />
                    </div>
                </div>
            </div>
	</div>
	<div>
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
	</div>
</body>
</html>