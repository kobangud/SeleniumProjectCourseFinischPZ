package ru.ibs.appline.framework.three_project.pages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BaseMenuPage extends BasePage {
    @FindBy(xpath = "//ul[contains(@class, 'multilevel')]/li[contains(@class, 'dropdown')]")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//span[@class='title']")
    private List<WebElement> listSubMenu;
    @FindBy(xpath = "//div[@class='row']/div[contains(@class, 'pull')]")
    private List<WebElement> listPulMenu;

    public BaseMenuPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    /**
     * Клик по базовому меню - меню выбирается по тексту переданному на вход функции
     *
     * @param nameMenu - параметр (текст), который будет передан пользователем (наименование меню)
     */
    //Вкладка расходы
    public BaseMenuPage selectBaseMenuByText(String nameMenu) {
        for (WebElement itemMenu : listBaseMenu) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return pageManager.getBaseMenuPage();
            }

        }
        Assertions.fail("меню с текстом " + nameMenu + " не найдено на странице");
        return pageManager.getBaseMenuPage();
    }

    //Вкладка расходы - командировки

    public LoadingOpenPage selectSubMenuByText(String nameSubMenu) {
        for (WebElement itemMenu : listSubMenu) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                itemMenu.click();
                return pageManager.getLoadingOpenPage();
            }

        }
        Assertions.fail("Подменю с текстом " + nameSubMenu + " не найдено на странице");
        return pageManager.getLoadingOpenPage();
    }


    //Находим на 2ой панели Кнопку "Создать командировку"

    public LoadingOpenPage selectPulMenuByText(String namePulMenu) {
        for (WebElement itemMenu : listPulMenu) {
            if (itemMenu.getText().contains(namePulMenu)) {
                itemMenu.click();
                return pageManager.getLoadingOpenPage();
            }

        }
        Assertions.fail("Подменю с текстом " + namePulMenu + " не найдено на странице");
        return pageManager.getLoadingOpenPage();
    }
}

    