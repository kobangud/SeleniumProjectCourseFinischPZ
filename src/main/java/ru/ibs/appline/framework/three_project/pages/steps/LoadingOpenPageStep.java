package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class LoadingOpenPageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Проверяем загрузку страницы формы авторизации$")
    public void loadingLoginForm() {
        pageManager.getLoadingOpenPage().loadingLoginForm();
    }

    @И("Проверяем открытие главной страницы после успешной авторизации$")
    public void checkOpenHomePage() {
        pageManager.getLoadingOpenPage().checkOpenHomePage();
    }

    @И("^Ожидаем переход на страницу - Командировки")
    public void checkOpenTravelPage() {
        pageManager.getLoadingOpenPage().checkOpenTravelPage();
    }

    @И("^Ожидаем переход на страницу - Создания Командировки$")
    public void checkOpenTravelSubPage() {
        pageManager.getLoadingOpenPage().checkOpenTravelSubPage();
    }

    @И("^Ожидание Сохраниния формы создания командировки$")
    public void loading() {
        pageManager.getLoadingOpenPage().loadingCreateField();
    }
}
