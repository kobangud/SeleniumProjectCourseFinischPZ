package ru.ibs.appline.framework.second_project.steps;

import ru.ibs.appline.framework.second_project.pages.LoginPage;

public class LoginSteps {
    public MainPageSteps login(String login, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.logPassFormInput(login,password);
        loginPage.submitClickInput();
        return  new MainPageSteps();
    }

}
