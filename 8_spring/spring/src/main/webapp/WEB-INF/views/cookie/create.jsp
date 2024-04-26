<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	쿠키생성완료
	
	<c:if test="${not empty cookie.test}"> <!-- cookie.test가 아니라면 -->
		 ${cookie.test.value } <!-- cookie.test의  value값을 보여줘-->
	</c:if>
</body>
</html>