<!DOCTYPE html>
<html>
<body>
<h3>사용자 정보</h3>
<p><%= session.getAttribute("USER") %>
</p>
<p><a href="/mvc/article/articleList">게시글 목록</a> </p>
<p><a href="mvc/article/articleForm">게시글 등록</a> </p>
<p><a href="/mvc/article/articleUpdateForm">게시글 수정</a> </p>
<p><a href="/mvc/article/articleDeleteFormm">게시글 삭제`</a> </p>

</body>
</html>
