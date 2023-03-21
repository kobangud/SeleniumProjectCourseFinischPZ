package ru.ibs.appline.framework.three_project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadingOpenPage extends BasePage {
    @FindBy(xpath = "//div[@class='title-box']")
    private WebElement loginForm;
    @FindBy(xpath = "//a[@title='Создать командировку']")
    private WebElement createField;
    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement formField;
    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loading;

    public LoadingOpenPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    //Проверяет загружена ли форма авторизации
    public LogPage loadingLoginForm() {

        waitUtilElementToBeVisible(loginForm);
        return pageManager.getLogPage();
    }

    //Проверяем, что псоле авторизации произошел переход на первую страницу

    public BaseMenuPage checkOpenHomePage() {

        Assertions.assertEquals("Панель инструментов", drManager.getDriver().getTitle(),
                "Страница не загрузилась, заголовок не найден");
        return pageManager.getBaseMenuPage();
    }

    //Проверяет появилась ли кнопка Создать командировку
    public BaseMenuPage checkOpenTravelPage() {

        waitUtilElementToBeClickable(createField);
        return pageManager.getBaseMenuPage();
    }

    //Проверяет открытие формы содания командировки
    public SelectCreateTravelPage checkOpenTravelSubPage() {

        waitUtilElementToBeVisible(formField);
        return pageManager.getSelectCreateTravelPage();
    }

    public SelectCreateTravelPage loadingCreateField() {
        waitUtilElementToBeVisible(loading);
        return pageManager.getSelectCreateTravelPage();
    }
}
