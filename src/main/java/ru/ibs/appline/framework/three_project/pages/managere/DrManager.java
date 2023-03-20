package ru.ibs.appline.framework.three_project.pages.managere;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static java.lang.Thread.sleep;

public class DrManager {

    private WebDriver driver;


    private static DrManager INSTANCE = null;

    private DrManager() {
    }

    public static DrManager getDrManager() {
        if (INSTANCE == null) {
            INSTANCE = new DrManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }


    public void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    /**
     * Метод инициализирующий веб драйвер
     */
    private void initDriver() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_for_111_chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


}
