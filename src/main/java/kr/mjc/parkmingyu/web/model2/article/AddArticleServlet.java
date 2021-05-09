package kr.mjc.parkmingyu.web.model2.article;

import kr.mjc.parkmingyu.web.dao.Article;
import kr.mjc.parkmingyu.web.dao.ArticleDao;
import kr.mjc.parkmingyu.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/article/addArticle")
public class AddArticleServlet extends HttpServlet {
    @Autowired
    private ArticleDao articleDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userIdnum = Integer.parseInt(request.getParameter("userId"));
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(userIdnum);
        article.setName(request.getParameter("name"));

        articleDao.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/model2/article/articleList");

    }

}
