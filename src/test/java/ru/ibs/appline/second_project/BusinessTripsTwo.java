package ru.ibs.appline.second_project;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.appline.framework.properties.TestProperties;
import ru.ibs.appline.framework.steps.LoginSteps;
import ru.ibs.appline.second_project.extension.DriverExtension;

import java.util.Properties;

@ExtendWith(DriverExtension.class)

public class BusinessTripsTwo {


    private LoginSteps loginSteps = new LoginSteps();

    private final Properties properties = TestProperties.getInstance().getProperties();

    @Test
    public void test() {

        //1. Авторизация
        loginSteps
                .login(properties.getProperty("LOGIN"),
                        properties.getProperty("PASSWORD"))
                .filterByTriaps();


        //проверяет загрузилась ли следующая стараница(домашняя, стартовая)
//        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='row']")).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='row']"))));


//Шаг2. Расходы - командировки
// В выплывающем окне раздела Расходы нажать на Командировки
//        Нажать на  Создать командировку
//        Проверить наличие на странице заголовка "Создать командировку"

//добавляем вебэлемент "Расходы" для удобства
//        WebElement constList = driver.findElement(By.xpath(
//                "//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']"));
//
//        constList.click();
//
////видим всплывающее меню и проверяем, что оно появилось прежде чем идти дальше.
//        Assertions.assertTrue(driver.findElement(
//                By.xpath("//ul[contains(@class, 'main-menu')]/li/a/span[text()='Расходы']/" +
//                        "ancestor::li//ul[@class='dropdown-menu menu_level_1']")).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(constList.findElement(By.xpath(
//                "./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
//
//        driver.findElement(By.xpath("//span[text() = 'Командировки']")).click();
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
//                "//div[@class='loader-mask shown']"))));
//
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//a[@title='Создать командировку']"))));
//        Assertions.assertTrue(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).isDisplayed());
//
//// Проверяем наличие на странице заголовка "Создать командировку"
//
//        Assertions.assertTrue(driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']"))
//                .isDisplayed());
//        WebElement bussinesTripButton = driver.findElement(By.xpath(
//                "//a[@class='btn back icons-holder-text ']"));
//        Assertions.assertTrue(bussinesTripButton.isDisplayed() && bussinesTripButton.getText().
//                contains("Создать командировку"));
//        driver.findElement(By.xpath(
//                "//div[@data-layout='separate']/div/div/a[text()='Создать командировку']")).click();
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
//                "//div[@class='loader-mask shown']"))));
//
//
//        //Шаг 4. Создание командировки
////        На странице создания командировки заполнить или выбрать поля://
//
//
////— Подразделение - выбрать Отдел внутренней разработки//
//
//        driver.findElement(By.xpath("//select[@data-name='field__business-unit']")).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//option[text()='Отдел внутренней разработки']"))));
//        driver.findElement(By.xpath("//option[text()='Отдел внутренней разработки']")).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//span[text()='Отдел внутренней разработки']"))));
//
////— Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение//
//
//        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//div[contains(@id, 's2id_crm_business_trip')]"))));
//        driver.findElement(By.xpath("//span[@class='select2-chosen']")).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//li[@class='select2-searching'][contains(text(), 'Поиск')]"))));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
//                "//li/div[@class='select2-result-label'][contains(text(), 'Хром')]"))));
//        driver.findElement(By.xpath(
//                "//div[@class='select2-result-label'][contains(text(), 'Хром')]")).click();
//
//
////— В задачах поставить чекбокс на "Заказ билетов"//
//
//        driver.findElement(By.xpath("//input[@data-name='field__1']")).click();
//
//
////— Указать города выбытия и прибытия//
//
//        //Город убытия
//
//        driver.findElement(By.xpath("//input[@data-name='field__departure-city']")).clear();
//        driver.findElement(By.xpath("//input[@data-name='field__departure-city']"))
//                .sendKeys("Москва");
//
//        //Город прибытия
//
//        driver.findElement(By.xpath("//input[@data-name='field__arrival-city']")).clear();
//        driver.findElement(By.xpath("//input[@data-name='field__arrival-city']"))
//                .sendKeys("Тула");
//
//
////—Указать даты выезда и возвращения//
//
//        //дата убытия
//
//        driver.findElement(By.xpath("//input[contains(@name, 'trip_departureDatePlan')]")).clear();
//        driver.findElement(By.xpath("//input[contains(@name, 'trip_departureDatePlan')]"))
//                .sendKeys("10.05.2023");
//
//        // дата возвращения
//
//        driver.findElement(By.xpath("//input[contains(@name, 'trip_returnDatePlan')]"))
//                .clear();
//        driver.findElement(By.xpath("//input[contains(@name, 'trip_returnDatePlan')]"))
//                .sendKeys("20.05.2023", Keys.TAB);
//
//
////—  !! Раздел Командированные сотрудники не заполнять
////        Проверить, что все поля заполнены правильно
////        Нажать "Сохранить и закрыть"
//
//        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(
//                "//div[@class='loader-mask shown']"))));
//
////Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
//
//        Assertions.assertTrue(driver.findElement(By.xpath(
//                "//span[@class='validation-failed'][contains(text(), 'Список')]" +
//                        "/ancestor::div//label[text() = 'Командированные сотрудники']")).isDisplayed());
//        Assertions.assertEquals("Список командируемых сотрудников не может быть пустым",
//                driver.findElement(By.xpath(
//                        "//span[@class='validation-failed'][contains(text(), 'Список')]")).getText());

    }


}
