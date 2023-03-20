package ru.ibs.appline.framework.three_project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SelectCreateTravelPage extends BasePage {

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement title;

    //Выбираем выпадающий список Подразделения
    @FindBy(xpath = "//select[contains(@data-name, 'field')]")
    private List<WebElement> menuListSubdivision;

    //Выбираем из выпадающего списка Подразделение - Отдел внутренней разработки
    @FindBy(xpath = "//select[@data-name='field__business-unit']/option")
    private List<WebElement> listSubdivision;

    //принимающая организация
    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement openListOrganizations;
    //раскрываем список организаций
    @FindBy(xpath = "//span[@class='select2-chosen']")
    private WebElement fieldCompany;
    //Из раскрытого списка выбираем нужную
    @FindBy(xpath = "//ul[@class='select2-results']/li")
    private List<WebElement> selectFieldCompany;

    //Город выбытия
    @FindBy(xpath = "//input[@data-name='field__departure-city']")
    private WebElement departureCity;

    //Город прибытия
    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    private WebElement arrivalCity;

    //Планируемая дата выезда
    @FindBy(xpath = "//input[contains(@name, 'trip_departureDatePlan')]")
    private WebElement departureDatePlan;

    //Планируемая дата возвращения
    @FindBy(xpath = "//input[contains(@name, 'trip_returnDatePlan')]")
    private WebElement returnDatePlan;

    // Чек бокс - Заказ билетов
    @FindBy(xpath = "//div[@class='oro-clearfix']/label")
    private List<WebElement> orderingTickets;

    // Поле для ввода (город, дата)
    @FindBy(xpath = "//input[contains(@id,'crm_business') and (@type='text')]")
    private List<WebElement> inputTextSend;

    //Кнопка Сохранить и закрыть
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement btnSaveClose;

    //Проверка появления сообщения о незаполненом поле
    @FindBy(xpath = "//span[@class='validation-failed' ]")
    private WebElement errorMessageAlert;


    public SelectCreateTravelPage() {

        PageFactory.initElements(drManager.getDriver(), this);

    }

    /**
     * Метод "Находим на странице список с подразделениями"
     *
     * @param nameMenu - имя веб элемента, поля ввода
     */

    public void selectCreateTravelPage(String nameMenu) {
        for (WebElement itemMenu : menuListSubdivision) {
            if (itemMenu.getText().contains(nameMenu)) {
                itemMenu.click();
                return;
            }

        }
        Assertions.fail("меню с текстом" + nameMenu + "не найдено на странице");
    }

    /**
     * Метод "Выбор подразделения из списка"
     *
     * @param nameMenu - имя веб элемента, поля ввода
     */

    public void selectListSubdivisionByText(String nameMenu) {
        for (WebElement itemMenu : listSubdivision) {
            if (itemMenu.getText().contains(nameMenu)) {
                waitUtilElementToBeVisible(itemMenu).click();
                return;
            }

        }
        Assertions.fail("меню с текстом" + nameMenu + "не найдено на странице");
    }

    /**
     * Метод "Выбираем задачу и ставим чекбокс"
     *
     * @param nameSubMenu - имя веб элемента, поля ввода
     */

    public void selectCheckBoxTask(String nameSubMenu) {
        for (WebElement itemMenu : orderingTickets) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                waitUtilElementToBeVisible(itemMenu).click();
                return;
            }

        }
        Assertions.fail("Подменю с текстом" + nameSubMenu + "не найдено на странице");
    }

    /**
     * Метод "Открыть список оргазаций"
     */

    public SelectCreateTravelPage openListOrganization() {
        wait.until(ExpectedConditions.visibilityOf(openListOrganizations)).click();
        return this;
    }

    /**
     * Метод "Раскрыть список организаций"
     */

    public SelectCreateTravelPage openListSelectOrganization() {
        wait.until(ExpectedConditions.visibilityOf(fieldCompany)).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
                "//li[@class='select2-searching'][contains(text(), 'Поиск')]"))));
        return this;
    }

    /**
     * Метод "Раскрыть список организаций и выбрать заданое пользователем"
     *
     * @param nameSubMenu - имя веб элемента, поля ввода
     */

    public void selectOrganization(String nameSubMenu) {

        for (WebElement itemMenu : selectFieldCompany) {
            if (itemMenu.getText().contains(nameSubMenu)) {
                waitUtilElementToBeClickable(itemMenu).click();
                return;
            }

        }
        Assertions.fail("Подменю с текстом" + nameSubMenu + "не найдено на странице");
    }

    /**
     * Метод заполнения полей
     *
     * @param nameField - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public SelectCreateTravelPage fillField(String nameField, String value) {

        WebElement element = null;
        switch (nameField) {

            case "Город выбытия":
                departureCity.clear();
                fillInputField(departureCity, value);
                element = departureCity;
                break;
            case "Город прибытия":
                fillInputField(arrivalCity, value);
                element = arrivalCity;
                break;
            case "Планируемая дата выезда":
                fillDateField(departureDatePlan, value);
                element = departureDatePlan;
                break;
            case "Планируемая дата возвращения":
                fillDateField(returnDatePlan, value);
                element = returnDatePlan;
                break;
            default:

                Assertions.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "Командировки / Создать командировку");

        }
        Assertions.assertEquals(
                value, element.getAttribute("value"), "Поле '" + nameField + "' было заполнено некорректно");
        return this;
    }

    /**
     * Клик по кнопке "Сохранить и закрыть"
     *
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public SelectCreateTravelPage clickBtnSaveClose() {
        waitUtilElementToBeClickable(btnSaveClose).click();
        return this;
    }

    /**
     * Проверка общей ошибки
     *
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public SelectCreateTravelPage checkErrorMessageAlert(String errMessage) {

        waitUtilElementToBeVisible(errorMessageAlert);
        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",
                errorMessageAlert.getText(), "Сообщение 'Список командируемых сотрудников " +
                        "не может быть пустым' не было найдено");
        return this;
    }


}
