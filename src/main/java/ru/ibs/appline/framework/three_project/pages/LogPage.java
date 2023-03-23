package ru.ibs.appline.framework.three_project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.three_project.pages.managere.TestPropManager;
import ru.ibs.appline.framework.three_project.pages.utils.PropConst;

public class LogPage extends BasePage {


    protected WebDriverWait wait;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement logInput;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passInput;

    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement btnClick;

    public LogPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }
    TestPropManager propManager = TestPropManager.getInstance();
    @Step("Заполняем поля на форме регистрации")
    public LogPage loginForm() {

        //Вводим логин пароль
        logInput.sendKeys(propManager.getProperty(PropConst.LOGIN));
        passInput.sendKeys(propManager.getProperty(PropConst.PASSWORD));
        return pageManager.getLogPage();

    }

    //Жмем кнопку войти
    @Step ("Жмем войти")
    public LoadingOpenPage inputBtn() {
        btnClick.click();
        return pageManager.getLoadingOpenPage();
    }

}
