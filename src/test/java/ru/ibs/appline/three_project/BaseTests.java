package ru.ibs.appline.three_project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.three_project.pages.managere.DrManager;

public class BaseTests {
    private DrManager drManager = DrManager.getDrManager();
    protected WebDriverWait wait;


    @BeforeEach
    public void BaseTest() {

        drManager.getDriver().get("http://training.appline.ru/user/login");

    }

    @AfterEach
    public void closeDriver() {

        drManager.getDriver().quit();
    }
}
