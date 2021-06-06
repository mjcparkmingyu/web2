package kr.mjc.parkmingyu.web.dao;

import org.owasp.encoder.Encode;
import lombok.Data;

@Data
public class Article {
  int articleId;
  String title;
  String content;
  int userId;
  String name;
  String cdate;
  String udate;

  public String getTitleHtml() {
    return Encode.forHtml(title);
  }

  public String getContentHtml() {
    return Encode.forHtml(content).replaceAll("\n", "<br>");
  }
}
