<%@ page import="kr.mjc.parkmingyu.web.dao.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="kr.mjc.parkmingyu.web.dao.ArticleDao" %>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 상세보기</h3>
<p><a href="/mvc/article/articleUpdateForm">게시글 수정</a>  </p>
<p><a href="/mvc/article/articleList">게시글 목록</a>  </p>
<%
    Article article = (Article) request.getAttribute("articleView");
%>
<p><%= article %>
</p>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>