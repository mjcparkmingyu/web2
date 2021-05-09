<%@ page import="kr.mjc.parkmingyu.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 목록</h3>
<h4>로그인 하셔야 글 편집이 가능합니다.</h4>
<p><a href="/mvc/user/loginForm">로그인</a></p>
<p><a href="./articleForm">게시글 등록</a></p>
<p><a href="./articleDeleteForm">게시글 삭제</a></p>
<p><a href="./articleView">게시글 상세보기</a>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= article %>
</p>
<%
    }
%>
</body>
</html>