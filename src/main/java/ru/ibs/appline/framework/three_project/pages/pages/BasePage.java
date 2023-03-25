package ru.ibs.appline.framework.three_project.pages.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.three_project.pages.managere.DrManager;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class BasePage {
    DrManager drManager = DrManager.getDrManager();
    WebDriver driver = drManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(drManager.getDriver(), 20, 1000);
    PageManager pageManager = PageManager.getInstance();

    public BasePage() {
        this.driver = drManager.getDriver();

    }

    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void fillInputField(WebElement field, String value) {

        waitUtilElementToBeClickable(field).click();
        field.clear();
        field.sendKeys(value);
    }

}


