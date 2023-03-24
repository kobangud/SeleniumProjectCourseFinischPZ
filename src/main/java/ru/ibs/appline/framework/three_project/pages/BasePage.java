package ru.ibs.appline.framework.three_project.pages;

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

    /**
     * Явное ожидание состояния clickable элемента
     *
     * @param element - веб-элемент который требует проверки clickable
     * @return WebElement - возвращаем тот же веб элемент что был передан в функцию
     */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Явное ожидание того что элемент станет видемым
     *
     * @param element - веб элемент который мы ожидаем что будет  виден на странице
     */
    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Общий метод по заполнения полей ввода
     *
     * @param field - веб-элемент поле ввода
     * @param value - значение вводимое в поле
     */
    protected void fillInputField(WebElement field, String value) {

        waitUtilElementToBeClickable(field).click();
        field.clear();
        field.sendKeys(value);
    }

    /**
     * Общий метод по заполнению полей с датой
     *
     * @param field - веб-элемент поле с датой
     * @param value - значение вводимое в поле с датой
     */
    protected void fillDateField(WebElement field, String value) {

        field.sendKeys(value, Keys.TAB);
    }
}


