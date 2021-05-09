package kr.mjc.parkmingyu.web.model2.article;

import kr.mjc.parkmingyu.web.dao.Article;
import kr.mjc.parkmingyu.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/article/updateArticle")
public class UpdateArticleServlet  extends HttpServlet {
    @Autowired
    private ArticleDao articleDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userIdnum = Integer.parseInt(request.getParameter("userId"));
        int articleIdnum = Integer.parseInt(request.getParameter("articleId"));
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(userIdnum);
        article.setArticleId(articleIdnum);


        int updateRows = articleDao.updateArticle(article);
        if(updateRows > 0)
        response.sendRedirect(request.getContextPath() + "/model2/article/articleList");

        else {
            response.sendRedirect(request.getContextPath() +
                    "/model2/article/updateArticleForm?msg=wrong");
        }
    }
}
