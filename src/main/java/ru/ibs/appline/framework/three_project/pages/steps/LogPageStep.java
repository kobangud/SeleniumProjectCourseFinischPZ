package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class LogPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^Заполняем поля на форме регистрации$")
    public void loginForm() {
        pageManager.getLogPage().loginForm();
    }

    @И("^Жмем войти$")
    public void inputBtn() {
        pageManager.getLogPage().inputBtn();
    }
}
