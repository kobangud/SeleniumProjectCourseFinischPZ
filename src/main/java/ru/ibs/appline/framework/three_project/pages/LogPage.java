package ru.ibs.appline.framework.three_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogPage extends BasePage {


    protected WebDriverWait wait;
    @FindBy(xpath = "//div[@class='title-box']")
    private WebElement loginForma;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement logInput;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement passInput;

    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement btnClick;

    public LogPage() {

        PageFactory.initElements(drManager.getDriver(),this);

    }


    public void loginForm() {

        // Проверяет, загрузилась ли форма
//        Assertions.assertTrue((BooleanSupplier) loginForma);
//        wait.until(ExpectedConditions.visibilityOf(loginForma));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//div[@class='title-box']"))));

        //Вводим логин пароль

        logInput.sendKeys("Irina Filippova");
        passInput.sendKeys("testing");

        //Жмем кнопку войти
        btnClick.click();

    }

}
