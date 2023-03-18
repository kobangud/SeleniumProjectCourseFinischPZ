package ru.ibs.appline.framework.second_project.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.second_project.managers.DriverManager;


public class BasePage {

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loadingIcon;
    protected static WebDriver driver = DriverManager.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,(20));
    public BasePage(){
        PageFactory.initElements(driver,this);
    }
    public void loading(){
        wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }


}
