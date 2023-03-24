package ru.ibs.appline.framework.three_project.pages.managere;

import ru.ibs.appline.framework.three_project.pages.pages.BaseMenuPage;
import ru.ibs.appline.framework.three_project.pages.pages.LoadingOpenPage;
import ru.ibs.appline.framework.three_project.pages.pages.LogPage;
import ru.ibs.appline.framework.three_project.pages.pages.SelectCreateTravelPage;

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

    private LogPage logPage;
    /**
     * Страница загрузок страниц
     */
    private LoadingOpenPage loadingOpenPage;

    /**
     * Страничка-блок базовых меню и сабменю
     */
    private BaseMenuPage baseMenuPage;

    /**
     * Страничка создания командировки
     */
    private SelectCreateTravelPage selectCreateTravelPage;

    public LogPage getLogPage() {
        if (logPage == null) {
            logPage = new LogPage();
        }
        return logPage;
    }

    public LoadingOpenPage getLoadingOpenPage() {
        if (loadingOpenPage == null) {
            loadingOpenPage = new LoadingOpenPage();
        }
        return loadingOpenPage;
    }

    public SelectCreateTravelPage getSelectCreateTravelPage() {
        if (selectCreateTravelPage == null) {
            selectCreateTravelPage = new SelectCreateTravelPage();
        }
        return selectCreateTravelPage;
    }

    public BaseMenuPage getBaseMenuPage() {
        if (baseMenuPage == null) {
            baseMenuPage = new BaseMenuPage();
        }
        return baseMenuPage;
    }
    public static void quitPageManager() {
        if (pageManager != null) {
            pageManager = null;
        }
    }


}
