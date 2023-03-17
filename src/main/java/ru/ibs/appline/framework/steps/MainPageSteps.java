package ru.ibs.appline.framework.steps;

import ru.ibs.appline.framework.pages.MainPage;

public class MainPageSteps extends MainPage {
    public void filterByTriaps() {
        MainPage mainPage = new MainPage();
    mainPage.costsClick();
    mainPage.triapsBtn();
    }

}
