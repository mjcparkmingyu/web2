<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<body>
<h3>게시글 삭제</h3>
<form action="deleteArticle" method="post">
    <p><input type="text" name="articleId" placeholder="articleId" required/></p>
    <p><input type="text" name="userId" placeholder="userId" required/></p>
    <p>
        <button type="submit">삭제</button>
    </p>
</form>
<p style="color:red;"><%= Optional.ofNullable(request.getParameter("msg"))
        .orElse("")%>
</p>
</body>
</html>