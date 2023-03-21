package ru.ibs.appline.framework.three_project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public LogPage loginForm() {

        //Вводим логин пароль
        logInput.sendKeys("Irina Filippova");
        passInput.sendKeys("testing");
        return pageManager.getLogPage();

    }

    //Жмем кнопку войти
    public LoadingOpenPage inputBtn() {
        btnClick.click();
        return pageManager.getLoadingOpenPage();
    }

}
