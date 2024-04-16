<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. formatNumber </h3>
	<p>
		숫자데이터의 포맷(형식) 지정 <br>
		-표현하고자하는 숫자데이터의 형식을 통화기호, % 등 원하는 쓰임에 맞게 지정하는 태그 <br>
		
		(fmt:formatNumber value="출력할값" [groupingUsed="true|false" type="percent|currency" currencySymbol="문자"])<br>
		groupingUsed : 기본적으로 true 이다.
	</p>
	
	<c:set var="num1" value="123456789"/>
	<c:set var="num2" value="0.75"/>
	<c:set var="num3" value="50000"/>
	
	그냥 출력 : ${num1 } <br>
	세자리마다 구분하여 출력 : <fmt:formatNumber value="${num1 }"/> <br>
	숫자그대로 출력 : ${num1 } / <fmt:formatNumber value="${num1 }" groupingUsed="false"/> <br>
	
	percent : <fmt:formatNumber value="${num2}" type="percent" /> 퍼센트 나옴<br> 
	currency : <fmt:formatNumber value="${num3 }" type="currency" groupingUsed="false"/> 원화 표시됨 <br>
	currencySymbol : <fmt:formatNumber value="${num3 }" type="currency" groupingUsed="false" currencySymbol="$"/>  달러표시됨 <br>
	
	<h3>2. formatDate</h3>
	<p>날짜 및 시간 데이터의 포맷 지정(단, java.util.Date객체 사용)</p>
	(c:set var="current" value="&gl;%= new java.util.Date() %&gl;" /) <br>
	
	<c:set var="current" value="<%= new java.util.Date() %>" />
	출력 : ${current }
	(출력 : Tue Apr 09 11:26:24 KST 2024)
	
	<ul>
		<li>현재 날짜1 : <fmt:formatDate value="${current }"/> </li><!-- type생략시 type="date"이 디폴트 --> 
		<li>결과 : 2024. 4. 9</li><br>
		<li>현재 날짜2 : <fmt:formatDate value="${current }" type="time" /> </li>
		<li>결과 : 오전 11:32:58</li><br>
		<li>현재 날짜3 : <fmt:formatDate value="${current }" type="both" /> </li>
		<li>결과 : 2024. 4. 9 오전 11:32:58</li><br>
		<li>현재 날짜4 : <fmt:formatDate value="${current }" type="both" dateStyle="medium" timeStyle="medium" /> </li>
		<li>결과 : 2024. 4. 9 오전 11:32:58</li><br>
		<li>현재 날짜5 : <fmt:formatDate value="${current }" type="both" dateStyle="long" timeStyle="medium" /> </li>
		<li>결과 : 2024년 4월 9일 (화) 오전 11:32:58</li><br>
		<li>현재 날짜6 : <fmt:formatDate value="${current }" type="both" dateStyle="full" timeStyle="full"/> </li>
		<li>결과 : 2024년 4월 9일 화요일 오전 11시 32분 58초 KST</li>
		<li>현재 날짜7 : <fmt:formatDate value="${current }" type="both" dateStyle="short" timeStyle="short"/> </li>
		<li>결과 : 24. 4. 9 오전 11:32</li>
		<li>현재 날짜8 : <fmt:formatDate value="${current }" type="both" pattern="yyyy-MM-dd(E) HH:mm:ss(a)"/> </li>
		<li>결과 : 2024-04-09(화) 11:32:58(오전)</li>
	</ul>
	
</body>
</html>