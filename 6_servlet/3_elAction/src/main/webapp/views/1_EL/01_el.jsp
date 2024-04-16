<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.model.vo.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
    <h3>1. 기존방식대로 스크립틀릿과 표현식을 이용하여 각 scope에 담겨있는 값을 화면에 출력해보자</h3>
    <%
    	//request scope값 가져오기
    	String classRoom = (String)request.getAttribute("classRoom");
    	Person student = (Person)request.getAttribute("student");
    	
    	// session scope의 값 가져오기
    	String academy = (String)session.getAttribute("academy");
    	Person teacher = (Person)session.getAttribute("teacher");
    %>
    
    <p>
    	학원명 : <%=academy %>
    	강의장 : <%=classRoom %>
    	강사 : <%=teacher.getName() %>, <%=teacher.getAge() %>, <%=teacher.getGender() %><br><br>
    	
    	수강생정보
    	<ul>
    		<li>이름 : <%=student.getName() %></li>
    		<li>나이 : <%=student.getAge() %></li>
    		<li>성별 : <%=student.getGender() %></li>
    	</ul>
    </p>
     --%>

    <h3>2. EL을 이용하여 보다 쉽게 scope의 값을 출력하기</h3>
    <p>
        EL을 이용하여 get000을 통해 값을 가져올 필요없이 EL구문내의 키값만 제시하면 바로 접근이 가능하다 <br>
        기본적으로 EL은 JSP내장객체를 구분하지않고 자동으로 모든 내장객체의 키값을 검색하여 존재하는 경우 그 값을 가져온다.
    </p>
    <p>
    	강사정보
    	<ul>
    		<li>학원명 : ${academy}</li>
    		<li>강의장 : ${classRoom}</li>
    		<li>강사 : ${teacher.name}, ${teacher.age}, ${teacher.gender}</li>
    	</ul>
    	수강생정보
    	<ul>
    		<li>이름 : ${student.name}</li>
    		<li>나이 : ${student.age}</li>
    		<li>성별 : ${teacher.gender}</li>
    	</ul>
    </p>

    <h3>3. scope의 키값이 동일한 경우</h3>
    scope값 : ${scope} <br>
    <!--
        EL은 공유범위가 제일 작은 scope부터 해당 키값을 검색함
        page => request => session => application
    -->
    test값 : ${test}
    <!-- 없는값을 넣었을때는 빈값이 나온다 -->
    
    <h4>4. 직접 scope를 지정하여 접근하기</h4>
    <%
        //pagescope에 담기
        pageContext.setAttribute("scope", "page");
    %>
    
    pageScope값 : ${scope } 또는 ${pageScope.scope } <br>
    requestScope값 : ${requestScope.scope } <br>
    sessionScope값 : ${sessionScope.scope } <br>
    applicationScope 값 : ${applicationScope.scope } <br><br>
</body>
</html>