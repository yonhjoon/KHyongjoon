<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판-글목록</title>
<style>
     #boardList {text-align:center;}
     #boardList>tbody>tr:hover {cursor:pointer;}

     #pagingArea {width:fit-content; margin:auto;}
     
     #searchForm {
         width:80%;
         margin:auto;
     }
     #searchForm>* {
         float:left;
         margin:5px;
     }
     .select {width:20%;}
     .text {width:53%;}
     .searchBtn {width:20%;}
</style>
</head>
<body>

<jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter" style="padding:5% 10%;">
            <h2>게시판</h2>
            <br>
            <!-- 로그인 후 상태일 경우만 보여지는 글쓰기 버튼 -->
           
            	<a class="btn btn-secondary" style="float:right;" href="">글쓰기</a>
	            <br>
            
            <br>
            <table id="boardList" class="table table-hover" align="center">
                <thead>
                    <tr>
                        <th>글번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일</th>
                        <th>첨부파일</th>
                    </tr>
                </thead>
                <tbody>
                	<tr>
               			<td>123</td>
               			<td>게시글입니다</td>
               			<td>admin</td>
               			<td>105</td>
               			<td>2023-10-11</td>
               			<td>
               				★
               			</td>
               		</tr>
                </tbody>
            </table>
            
            <br>

            <div id="pagingArea">
                <ul class="pagination">
                
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>

                   <li class="page-item"><a class="page-link" href="">1</a></li>
                   <li class="page-item"><a class="page-link" href="">2</a></li>
                   <li class="page-item"><a class="page-link" href="">3</a></li>
                   <li class="page-item"><a class="page-link" href="">4</a></li>
                   <li class="page-item"><a class="page-link" href="">5</a></li>
                    
                  	<li class="page-item"><a class="page-link" href="#">Next</a></li>
                
                </ul>
            </div>

            <br clear="both"><br>

            <form id="searchForm" action="" method="get" align="center">
                <div class="select">
                    <select class="custom-select" name="condition">
                        <option value="writer">작성자</option>
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                </div>
                <div class="text">
                    <input type="text" class="form-control" name="keyword">
                </div>
                <button type="submit" class="searchBtn btn btn-secondary">검색</button>
            </form>
            <br><br>
        </div>
        <br><br>

    </div>

    <jsp:include page="../common/footer.jsp" />

</body>
</html>