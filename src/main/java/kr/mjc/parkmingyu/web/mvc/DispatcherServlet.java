package kr.mjc.parkmingyu.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/*")
public class DispatcherServlet extends HttpServlet {

  @Autowired
  UserController userController;

  @Autowired
  ArticleController articleController;

  @Override
  protected void service(HttpServletRequest request,
                         HttpServletResponse response)
      throws ServletException, IOException {
    String uri = request.getRequestURI();

    switch (uri) {
      case "/mvc/user/userList" -> userController.userList(request, response);
      case "/mvc/user/userForm" -> userController.userForm(request, response);
      case "/mvc/user/loginForm" -> userController.loginForm(request, response);
      case "/mvc/user/userInfo" -> userController.userInfo(request, response);
      case "/mvc/user/addUser" -> userController.addUser(request, response);
      case "/mvc/user/login" -> userController.login(request, response);

      case "/mvc/article/articleList" -> articleController.articleList(request, response); //게시글 목록 화면

      case "/mvc/article/addArticle" -> articleController.articleAdd(request, response);
      case "/mvc/article/articleForm" -> articleController.articleForm(request, response); //게시글 생성

      case "/mvc/article/articleView" -> articleController.articleView(request, response); //게시글 상세보기

      case "/mvc/article/updateArticle" -> articleController.articleUpdate(request, response);
      case "/mvc/article/articleUpdateForm" -> articleController.updateForm(request, response); //게시글 수정

      case "/mvc/article/deleteArticle" -> articleController.articleDelete(request, response);
      case "/mvc/article/articleDeleteForm" -> articleController.deleteForm(request, response); //게시글 삭제
      default -> response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
  }
}
