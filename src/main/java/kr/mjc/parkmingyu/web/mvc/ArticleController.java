package kr.mjc.parkmingyu.web.mvc;

import kr.mjc.parkmingyu.web.dao.Article;
import kr.mjc.parkmingyu.web.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ArticleController {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * 게시글 목록 화면
     */
    public void articleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("articleList", articleDao.listArticles(0, 10));

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleList1.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 등록 화면
     */
    public void articleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleForm.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 등록 액션
     */
    public void articleAdd(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int userIdnum = Integer.parseInt(request.getParameter("userId"));
        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setUserId(userIdnum);
        article.setName(request.getParameter("name"));

        articleDao.addArticle(article);
        response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
    }

    /**
     * 게시글 상세보기 화면
     */
    public void articleView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("articleView", articleDao.getArticle(596));
        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleView.jsp")
                .forward(request, response);
    }


    /**
     * 게시글 삭제 액션
     */

    public void articleDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userIdnum = Integer.parseInt(request.getParameter("userId"));
        int articleIdnum = Integer.parseInt(request.getParameter("articleId"));

        int updateRows = articleDao.deleteArticle(articleIdnum, userIdnum);

        if(updateRows > 0) {
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleList");
        }
        else {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/articleDeleteForm?msg=wrong");
        }

    }


    /**
     * 게시글 삭제 화면
     */
    public void deleteForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleDelete.jsp")
                .forward(request, response);
    }

    /**
     * 게시글 수정 액션
     */
    public void articleUpdate(HttpServletRequest request, HttpServletResponse response)
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
            response.sendRedirect(request.getContextPath() + "/mvc/article/articleView");

        else {
            response.sendRedirect(request.getContextPath() +
                    "/mvc/article/updateForm?msg=wrong");
        }
    }

    /**
     * 게시글 수정 화면
     */
    public void updateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/jsp/mvc/article/articleEdit.jsp")
                .forward(request, response);
    }


}
