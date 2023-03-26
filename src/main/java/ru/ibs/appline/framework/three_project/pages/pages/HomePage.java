package ru.ibs.appline.framework.three_project.pages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.three_project.pages.managere.TestPropManager;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'Header_content')]")
    private WebElement loadingHomePage;

    @FindBy(xpath = "//button[contains(@class, 'burgerButton')]")
    private WebElement catalogMenus;

    @FindBy(xpath = "//ul[contains(@class,'Catalog_mainList')]/a")
    private List<WebElement> listMenu;



    @FindBy(xpath = "//button[@name='_submit']")
    private WebElement btnClick;

    public HomePage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    TestPropManager propManager = TestPropManager.getInstance();

    //Проверка загрузки домашней страницы
    public HomePage loadingPage() {
        wait.until(ExpectedConditions.visibilityOf(loadingHomePage));
               return this;
    }

    //Жмем меню каталог

    public HomePage catalogMenu() {
       wait.until(ExpectedConditions.elementToBeClickable(catalogMenus))
               .click();
        return this;
    }

    //В меню Каталог - выбираем Вкладку
    public CategoryPage selectCatalogMenuByText(String nameMenu) {

        for (WebElement itemMenu : listMenu) {
            waitUtilElementToBeVisible(itemMenu);
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getCategoryPage();
            }

        }
        Assertions.fail("меню с текстом " + nameMenu + " не найдено на странице");
        return pageManager.getCategoryPage();
    }


}
