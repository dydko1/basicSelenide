package com.dydko.lessons011x.tests;

import com.dydko.lessons011x.pages.ArticlePage;
import com.dydko.lessons011x.pages.HistoryPage;
import com.dydko.lessons011x.pages.WikipediaJavaPage;
import com.dydko.tests.BaseTest;
import org.junit.jupiter.api.Test;

public class WikipediaTabsTest extends BaseTest {

  @Test
  void should_open_article_and_history_using_generic_tabs() {
    WikipediaJavaPage page = new WikipediaJavaPage();

    ArticlePage article = page.tabs().selectTabTop("Article", ArticlePage.class);
    article.assertLoaded();

    HistoryPage history = page.tabs().selectTool("View history", HistoryPage.class);
    history.assertLoaded();
  }

  @Test
  void should_open_article_and_history_using_generic_tabs2() {
    WikipediaJavaPage page = new WikipediaJavaPage();

    ArticlePage article = page.tabs().selectTabTop("Article", ArticlePage.class);
    article.assertLoaded();

    HistoryPage history = page.tabs().selectTool("View history", HistoryPage.class);
    history.assertLoaded();
  }
}