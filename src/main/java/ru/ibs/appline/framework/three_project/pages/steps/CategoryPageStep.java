package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class CategoryPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверяем загрузку страницы Категории$")
    public void loadingPage() {

        pageManager.getCategoryPage().loadingPageCat();
    }

    //В меню Каталог - выбираем подменю
    @И("^В категории выбираем'(.+)'$")
    public void selectCatalogSubMenuByText(String nameMenu) {
        pageManager.getCategoryPage().selectCatalogSubMenuByText(nameMenu);
    }
}
