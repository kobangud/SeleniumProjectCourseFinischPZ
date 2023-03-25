package ru.ibs.appline.framework.three_project.pages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class SelectFilterCategoryPage extends BasePage {

    String resultFind;

    @FindBy(xpath = "//h1")
    private WebElement title;

    //Выставляем минимальную цену
    @FindBy(xpath = "//input[@placeholder and @name='min']")
    private WebElement sendInputMinPrise;
    //Выставляем максимальную цену
    @FindBy(xpath = "//input[@placeholder and @name='max']")
    private WebElement sendInputMaxPrise;

    // Чек бокс - производитель
    @FindBy(xpath = "//label[contains(@class, 'Checkbox_text')]")
    private List<WebElement> orderingCheckBox;

    // загрузка параметров фильтра
    @FindBy(xpath = "//span[contains(@class, 'Skeleton')]")
    private WebElement loadingSelectAfter;

    // в поисковой выдаче не более 24 товаров
    @FindBy(xpath = "//span[contains(@class,'Pagination')]")
    private WebElement quantityElements;

    //наименование первого товара в списке

    @FindBy(xpath = "//h6[@title]")
    private List<WebElement> nameElement;

    //Поле поиска

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement fieldFind;

    public SelectFilterCategoryPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    //Проверяем,что категория каталога открылась
    public SelectFilterCategoryPage loadingTitle() {

        waitUtilElementToBeVisible(title);
        return pageManager.getSelectFilter();
    }

    // заполнение полей фильтра(цена)

    public SelectFilterCategoryPage fillField(String nameField, String value) {

        WebElement element = null;
        switch (nameField) {

            case "Минимальная цена":
                sendInputMinPrise.clear();
                fillInputField(sendInputMinPrise, value);
                element = sendInputMinPrise;
                break;
            case "Максимальная цена":
                sendInputMaxPrise.clear();
                fillInputField(sendInputMaxPrise, value);
                element = sendInputMaxPrise;
                break;

            default:

                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице ");

        }
        Assertions.assertEquals(
                value, element.getAttribute("value"), "Поле '" + nameField + "' было заполнено некорректно");
        return this;
    }


        // Выбираем производителя

    public SelectFilterCategoryPage selectCheckBox(String nameSubMenu) {
        for (WebElement itemMenu : orderingCheckBox) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                waitUtilElementToBeVisible(itemMenu).click();
                return pageManager.getSelectFilter();
            }

        }
        Assertions.fail("Подменю с текстом '" + nameSubMenu + "' не найдено на странице");
        return this;
    }

    //Прогрузка экрана результатов поиска

    public SelectFilterCategoryPage loadingAfterSelect() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                    By.xpath("//span[contains(@class, 'Skeleton')]"))));
        } catch (NoSuchElementException e) {

        }return this;
    }


    // Проверяем найденное колличество записей внизу страницы не более 24
    public SelectFilterCategoryPage findElementQuantity(String count) {
        try {

            Assertions.assertTrue(quantityElements.getText().contains(count));
        }
        catch (NoSuchElementException e){

        }
        return this;
    }


    // Сохраняем результат поиска первой строки в переменную
    public SelectFilterCategoryPage findElement(int num) {

        resultFind = nameElement.get(num-1).getText().trim();

        return this;
    }

    // Делаем поиск сохраненного результата через поле поиск
    public SelectFilterCategoryPage fieldFindElement() {

        waitUtilElementToBeVisible(fieldFind).sendKeys(resultFind, Keys.ENTER);

        return this;
    }



    // Сравниваем найденнное и сохраненное значение
    public SelectFilterCategoryPage doubleFindElement() {

        wait.until(ExpectedConditions.visibilityOf((WebElement) nameElement)).getText().equals(resultFind);

        return this;
    }


}
