package kr.mjc.parkmingyu.web.model2.article;

import kr.mjc.parkmingyu.web.servlets.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/model2/article/deleteArticleForm")
public class DeleteFormArticleServlet extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleDelete.jsp")
                    .forward(request, response);
    }

}
