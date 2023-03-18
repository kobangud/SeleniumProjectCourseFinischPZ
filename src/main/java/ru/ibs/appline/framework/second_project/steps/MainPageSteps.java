package ru.ibs.appline.framework.second_project.steps;

import ru.ibs.appline.framework.second_project.pages.MainPage;

public class MainPageSteps extends MainPage {
    public void filterByTriaps() {
        MainPage mainPage = new MainPage();
    mainPage.costsClick();
    mainPage.triapsBtn();
    }

}
