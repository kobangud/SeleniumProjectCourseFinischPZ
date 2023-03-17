package ru.ibs.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.properties.BasePage;

public class LoginPage extends BasePage {



    @FindBy(xpath = "//div[@class='title-box']")
    private WebElement formLogin;
    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginRow;
    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passwordRow;
    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//div[@class='row']")
    private WebElement subtitle;

    public void logPassFormInput(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(formLogin));

        loginRow.sendKeys(login);
        passwordRow.sendKeys(password);

    }

    public void submitClickInput(){
        submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(subtitle));

    }


}
