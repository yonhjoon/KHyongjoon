<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Notice" %>
<%
    ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        background: black;
        color: white;
        width: 1000px;
        height: 500px;
        margin: auto;
        margin-top: 50px;
    }

    .list-area{
        border: 1px solid white;
        text-align: center;
    }
    .list-area>tbody>tr:hover{
        background: gray;
        cursor: pointer;
    }
</style>
</head>
<body>
    <%@ include file="../common/menubar.jsp" %>
    
    <div class="outer">
        <br>
        <h2 align="center">공지사항</h2>
        <br>

        <% if( loginUser != null && loginUser.getUserId().equals("admin")){%>
            <!-- 현재 로그인한 사용자가 관리자일 때-->
            <div align="right" style="width: 850px; margin-bottom: 4px;">
                <a href="<%=contextPath %>/enroll.no" class="btn btn-sm btn-secondary">글쓰기</a>
            </div>
        <%}%>    
        <table class="list-area" align="center">
            <thead>
                <th>글번호</th>
                <th width="400">글제목</th>
                <th width="100">작성자</th>
                <th>조회수</th>
                <th width="100">작성일</th>
            </thead>
            <tbody>
                <% if(list.isEmpty()) { %>
                    <!--공지사항이 없을 경우-->
                    <tr>
                        <td colspan="5">존재하는 공지사항이 없습니다.</td>
                    </tr>
                <% } else {%>
                    <!--공지사항이 있을 경우-->
                    <!-- tr에 온클릭하면 tr 자체가 가서 tr에 해도된다 밑 주석 -->
                    <% for(Notice n : list) { %>
                        <tr>
                            <td><%=n.getNoticeNo()%></td>
                            <td><%=n.getNoticeTitle()%></td>
                            <td><%=n.getNoticeWriter()%></td>
                            <td><%=n.getCount()%></td>
                            <td><%=n.getCreateDate()%></td>
                        </tr>
                    <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
    
    <script>
    	// const trList = document.querySelectorAll(".list-area > tbody > tr");
        // //[tr,tr,tr] 이렇게 오겠죠? 우리는 온클릭했을때 그 창으로 가는걸 하고싶으니
        		
        // for(const tr of trList){
        //     tr.onclick = function(ev){ tr.onclick이 되면  function(ev)를 실행해라
                 // 상세페이지에 url이없으니
                 // url / kh / detail..no
        //         const noticeNo = this.childNodes[0].innerText;
                 //childNodes : 자식들을 꺼낼수 있다 && 그리고 이러한코드가 많이 사용되고있다
                
        //         console.log(noticeNo);

        //         location.href = "<%=contextPath%>/detaill.no?num=" + nosticeNo;
                 // 물음표 왼쪽이 url 오른쪽에 데이터값 
                 // 디테일 정보를 볼려고 detaill.no로 보낸다 (자세한 정보를 볼려면 조건을 줘야해서 그래서 프라이머리키를 준다(nosticeNo))
        //     }
        // }
        // 스크립트가 훨씬 중요하므로 이해가 잘 안된다면 위 주석 스크립트를 먼저 외울것

        $(function(){
            $(".list-area > tbody > tr").click(function(){
                const noticeNo = $(this).children().eq(0).text();
                location.href = "<%=contextPath%>/detail.no?num=" + noticeNo;
            })
        })
    </script>
</body>
</html>