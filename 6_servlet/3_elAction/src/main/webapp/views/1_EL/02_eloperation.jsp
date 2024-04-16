<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	EL방식 : <br>
	10 + 3 = ${big + small } <br>
	10 - 3 = ${big - small } <br>
	10 * 3 = ${big * small } <br>
	10 / 3 = ${big / small } 또는 ${big div small}<br>
	10 % 3 = ${big % small } 또는 ${big mod small } <br>
	
	<h3>2. 대소 비교</h3>
	10 &gt; 3 = ${big > small } 또는 ${big gt small } <br>
	10 &lt; 3 = ${big < small } 또는 ${big lt small } <br>
	10 &gt;= 3 = ${big >= small } 또는 ${big ge small } <br>
	10 &lt;= 3 = ${big <= small } 또는 ${big le small } <br>
	
	<h3>3. 동등비교</h3>
	<!-- el에서는 ==비교는 자바에서의 equals()와 같은 동작을 한다. -->
	sOne과 sTwo가 일치합니까? ${sOne == sTwo } 또는 ${sOne eq sTwo }<br>
	sOne과 sTwo가 일치하지 않습니까? ${sOne != sTwo } 또는 ${sOne ne sTwo }
	
	big에 담긴값이 10과 일치합니까? ${big == 10 } 또는 ${big eq 10}<br>
	
	sThree에 담긴값이 'HI'과 일치합니까? ${sTherr == 'HI' } <br><br>
	<!-- el구문안에서 문자열 리터럴값은 홀따음표 쌍따음표를 가리지않음 -->
	
	<h4>4. 객체가 null인지 아닌지 리스트가 비어있는지 비교</h4>
	pTwo가 null입니까? ${pTwo == null } 또는 ${pTwo eq null } 또는 ${empty pTwo }<br>
	pOne가 null입니까? ${pOne == null } 또는 ${pOne eq null } 또는 ${empty pOne }<br>
	pOne가 null이 아닙니까? ${pOne != null } 또는 ${pOne ne null } 또는 ${not empty pOne }<br>
	
	aOne이 텅비어있습니까? ${empty aOne }<br>
	aTwo이 텅비어있습니까? ${empty aTwo }<br>
	
	<h3>5.논리연산자</h3>
	true && true : ${true && true } 또는 ${true and true } <br>
	true && false : ${true && false } 또는 ${true and false } <br><br>
	
	true || false : ${true || false } 또는 ${true or false } <br>
	
	big이 small보다 크고 aOne이 텅 비어있냐? <br>
	${big > small && empty aOna } <br>
	${big gt small and empty aOna } <br>
</body>
</html>