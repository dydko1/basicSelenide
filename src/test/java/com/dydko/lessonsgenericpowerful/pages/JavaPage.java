package com.dydko.lessonsgenericpowerful.pages;

import static com.codeborne.selenide.Selenide.page;

public class JavaPage {

    public ArticleTabs tabs() {
        return page(ArticleTabs.class);
    }

    // DSL: “idź do artykułu”
    public ArticlePage goToArticle() {
        return tabs().selectTabTop("Article", ArticlePage.class, ArticlePage::shouldBeLoaded);
    }

    // DSL: “idź do historii”
    public HistoryPage goToHistory() {
        return tabs().selectTool("View history", HistoryPage.class, HistoryPage::shouldBeLoaded);
    }
}
