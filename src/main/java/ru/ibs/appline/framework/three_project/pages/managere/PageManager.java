package ru.ibs.appline.framework.three_project.pages.managere;

import ru.ibs.appline.framework.three_project.pages.pages.HomePage;
import ru.ibs.appline.framework.three_project.pages.pages.SelectFilterCategoryPage;

public class PageManager {
    private static PageManager pageManager;

    private static PageManager INSTANCE = null;

    private PageManager() {
    }
    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    private HomePage homePage;
    private SelectFilterCategoryPage selectFilterCategoryPage;



    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }


    public SelectFilterCategoryPage getSelectFilter() {
        if (selectFilterCategoryPage == null) {
            selectFilterCategoryPage = new SelectFilterCategoryPage();
        }
        return selectFilterCategoryPage;
    }



    public static void quitPageManager() {
        if (pageManager != null) {
            pageManager = null;
        }
    }


}
