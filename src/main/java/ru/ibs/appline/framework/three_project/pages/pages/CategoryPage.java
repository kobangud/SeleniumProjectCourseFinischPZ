package ru.ibs.appline.framework.three_project.pages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.ibs.appline.framework.three_project.pages.managere.TestPropManager;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'PageTitle')]")
    private WebElement loadingCategoryPage;

    @FindBy(xpath = "//p[contains(@class, 'CardCategory')]")
    private List<WebElement> listSubMenu;

    public CategoryPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    TestPropManager propManager = TestPropManager.getInstance();

    //Проверка загрузки  страницы категории
    public CategoryPage loadingPageCat() {
        wait.until(ExpectedConditions.visibilityOf(loadingCategoryPage));
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

}
