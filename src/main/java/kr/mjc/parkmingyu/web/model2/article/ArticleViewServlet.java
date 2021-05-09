package kr.mjc.parkmingyu.web.model2.article;

import kr.mjc.parkmingyu.web.dao.ArticleDao;
import kr.mjc.parkmingyu.web.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/model2/article/articleView")
public class ArticleViewServlet extends HttpServlet {
    @Autowired
    private ArticleDao articleDao;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("articleView", articleDao.getArticle(591));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleView.jsp")
                .forward(request, response);
    }

}

