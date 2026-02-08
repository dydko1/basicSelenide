package com.dydko.lessonsgenericpowerful.tests;

import com.dydko.lessonsgenericpowerful.pages.ArticlePage;
import com.dydko.lessonsgenericpowerful.pages.HistoryPage;
import com.dydko.lessonsgenericpowerful.pages.JavaPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class ArticleTabsTest extends BaseTest {

  @Test
  void should_open_article_and_history_using_generic_tabs() {
    JavaPage javaPage = page(JavaPage.class);

    javaPage.tabs().selectTabTop("Article", ArticlePage.class, ArticlePage::shouldBeLoaded);
    javaPage.tabs().selectTool("View history", HistoryPage.class, HistoryPage::shouldBeLoaded);
  }

  @Test
  void should_open_article_and_history_using_dsl() {
    JavaPage javaPage = page(JavaPage.class);

    javaPage.goToArticle();
    javaPage.goToHistory();
  }
}