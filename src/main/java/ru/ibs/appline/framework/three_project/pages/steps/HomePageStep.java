package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class HomePageStep {

    PageManager pageManager = PageManager.getInstance();


    @И("^Проверяем загрузку домашней страницы$")
    public void loadingPage() {
        pageManager.getHomePage().loadingPage();
    }


    //Жмем меню каталог
    @И("^Жмем меню каталог$")
    public void catalogMenu() {
        pageManager.getHomePage().catalogMenu();
    }

    //В меню Каталог - выбираем Вкладку
    @И("^В меню Каталог - выбираем Вкладку '(.+)'$")
    public void selectCatalogMenuByText(String nameMenu) {
        pageManager.getHomePage().selectCatalogMenuByText(nameMenu);
    }




}