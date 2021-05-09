package kr.mjc.parkmingyu.web.model2.article;


import kr.mjc.parkmingyu.web.dao.Article;
import kr.mjc.parkmingyu.web.dao.ArticleDao;
import kr.mjc.parkmingyu.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model2/article/articleList")
public class articleListServlet extends HttpServlet {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 100));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList1.jsp")
                .forward(request, response);
    }
}