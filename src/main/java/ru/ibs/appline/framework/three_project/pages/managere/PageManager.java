package ru.ibs.appline.framework.three_project.pages.managere;
import ru.ibs.appline.framework.three_project.pages.pages.CategoryPage;
import ru.ibs.appline.framework.three_project.pages.pages.HomePage;
import ru.ibs.appline.framework.three_project.pages.pages.SelectFilterCategoryPage;

public class PageManager {


    private static PageManager pageManager = null;

    private PageManager() {
    }
    public static PageManager getInstance() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    private HomePage homePage;
    private CategoryPage categoryPage;
    private SelectFilterCategoryPage selectFilterCategoryPage;



    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public CategoryPage getCategoryPage() {
        if (categoryPage == null) {
            categoryPage = new CategoryPage();
        }
        return categoryPage;
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
