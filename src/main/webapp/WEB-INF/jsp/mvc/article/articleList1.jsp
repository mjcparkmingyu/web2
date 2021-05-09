<%@ page import="kr.mjc.parkmingyu.web.dao.Article" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 목록</h3>
<h4>로그인 하셔야 글 편집이 가능합니다.</h4>
<p><a href="/mvc/user/loginForm">로그인</a></p>
<p><a href="/mvc/article/articleView">게시글 상세보기</a>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
    for (Article article : articleList) {%>
<p><%= "Article [ articleId=" + article.getArticleId() + " title=" + article.getTitle()
+ " userId=" + article.getUserId() + " name=" + article.getName() + " cdate=" + article.getCdate() +
" ]"%>
</p>
<%
    }
%>
</body>
</html>