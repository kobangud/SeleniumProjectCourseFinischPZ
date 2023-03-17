package ru.ibs.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.properties.BasePage;

public class MainPage extends BasePage {
    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']")
    private WebElement costsBtn;
    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']" +
            "/ancestor::li//ul[@class='dropdown-menu menu_level_1']")
    private WebElement costsList;
    @FindBy(xpath = "//span[text() = 'Командировки']")
    private WebElement triaps;




    //    вебэлемент "Расходы"
    public void costsClick() {
        costsBtn.click();
    }

    //  проверяем, что меню раскрылось и кликаем командировки
    public void triapsBtn() {
        wait.until(ExpectedConditions.visibilityOf(costsList));
        triaps.click();
        loading();


    }


}


