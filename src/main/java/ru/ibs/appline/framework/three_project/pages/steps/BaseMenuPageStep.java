package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class BaseMenuPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Выбираем вкладку '(.+)'$")
    public void selectBaseMenuByText(String nameMenu) {

        pageManager.getBaseMenuPage().selectBaseMenuByText(nameMenu);
    }

    @И("^Выбираем меню '(.+)'$")
    public void  selectSubMenuByText(String nameMenu) {
        pageManager.getBaseMenuPage().selectSubMenuByText(nameMenu);
    }

    @И("^Нажимаем на кнопку '(.+)'$")
    public void  selectPulMenuByText(String namePulMenu) {
        pageManager.getBaseMenuPage().selectPulMenuByText(namePulMenu);
    }
}
