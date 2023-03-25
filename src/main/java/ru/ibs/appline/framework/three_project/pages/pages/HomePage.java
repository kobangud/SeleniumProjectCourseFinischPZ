package ru.ibs.appline.framework.three_project.pages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.three_project.pages.managere.TestPropManager;

import java.util.List;

public class HomePage extends BasePage {


    protected WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class, 'Header_content')]")
    private WebElement loadingHomePage;

    @FindBy(xpath = "//button[contains(@class, 'burgerButton')]")
    private WebElement catalogMenus;

    @FindBy(xpath = "//ul[contains(@class,'Catalog_mainList')]/a")
    private List<WebElement> listMenu;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory')]")
    private List<WebElement> listSubMenu;


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
    public HomePage selectCatalogMenuByText(String nameMenu) {

        for (WebElement itemMenu : listMenu) {
            waitUtilElementToBeVisible(itemMenu);
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return this;
            }

        }
        Assertions.fail("меню с текстом " + nameMenu + " не найдено на странице");
        return this;
    }

    //В меню Каталог - выбираем подменю
    public SelectFilterCategoryPage selectCatalogSubMenuByText(String nameMenu) {
        for (WebElement itemMenu : listSubMenu) {
            waitUtilElementToBeVisible(itemMenu);
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getSelectFilter();
            }

        }
        Assertions.fail("меню с текстом " + nameMenu + " не найдено на странице");
        return pageManager.getSelectFilter();
    }




    /**откоыть страницу
     * проверить загрузку страницы
     * нажать на каталог
     * меню комплектующие
     * подменю видеокарты
     * 1. Открыть браузер и развернуть на весь экран
     * 2. Зайти на http://regard.ru .
     * 3. Открыть меню "Каталог"
     * 4. Выбрать раздел "Комплектующие для ПК"
     * 5. Выбрать раздел "Видеокарты"
     * 6. Задать параметр поиска по цене от 20000 рублей
     * 7. Выбрать производителя Gigabyte
     * 8. Дождаться выполнения поиска
     * 9. Проверить, что в поисковой выдаче не более 24 товаров (значение из выпадающего списка "Товаров на странице" внизу страницы)
     * 10. Сохранить наименование первого товара в списке
     * 11. В поисковую строку ввести запомненное значение, выполнить поиск
     * 12. Проверить, что в поисковой выдаче не более 1 товара
     * 13. Проверить, что наименование товара соответствует сохраненному значению
     */


}
