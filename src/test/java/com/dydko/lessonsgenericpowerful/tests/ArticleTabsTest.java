package com.dydko.lessonsgenericpowerful.tests;

import com.dydko.lessonsgenericpowerful.pages.ArticlePage;
import com.dydko.lessonsgenericpowerful.pages.HistoryPage;
import com.dydko.lessonsgenericpowerful.pages.JavaPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class WikipediaTabsTest extends BaseTest {

  @Test
  void should_open_article_and_history_using_generic_tabs() {
    JavaPage page = page(JavaPage.class);

    ArticlePage article = page.tabs().selectTabTop("Article", ArticlePage.class);
    article.assertLoaded();

    HistoryPage history = page.tabs().selectTool("View history", HistoryPage.class);
    history.assertLoaded();
  }

//  @Test
//  void should_open_article_and_history_using_generic_tabs2() {
//    WikipediaJavaPage wiki = new WikipediaJavaPage();
//
//    ArticlePage article = wiki.tabs().selectTabTop("Article", ArticlePage.class);
//    article.assertLoaded();
//
//    HistoryPage history = wiki.tabs().selectTool("View history", HistoryPage.class);
//    history.assertLoaded();
//  }
}