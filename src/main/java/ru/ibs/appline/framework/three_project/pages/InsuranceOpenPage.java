package ru.ibs.appline.framework.three_project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsuranceOpenPage extends BasePage{

    public void checkOpenHomePage (){
        Assertions.assertEquals("Панель инструментов", drManager.getDriver().getTitle(), "Страница не загрузилась, заголовок не найден");
        Assertions.assertTrue(drManager.getDriver().findElement(By.xpath("//div[@class='row']")).isDisplayed());
    }
    public void checkOpenTravelPage (){

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                "//a[@title='Создать командировку']"))));
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).isDisplayed());
    }

    public void checkOpenTravelSubPage (){

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                "//h1[@class='user-name']"))));
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[@class='user-name']")).isDisplayed());
    }
    public void loding(){
        wait.until(ExpectedConditions.invisibilityOf(drManager.getDriver().findElement(By.xpath(
                "//div[@class='loader-mask shown']"))));
    }
}
