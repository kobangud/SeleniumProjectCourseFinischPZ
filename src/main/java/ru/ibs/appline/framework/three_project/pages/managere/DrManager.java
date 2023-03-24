package ru.ibs.appline.framework.three_project.pages.managere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.three_project.pages.utils.PropConst;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class DrManager {

    private WebDriver driver;
    private TestPropManager testPropManager = TestPropManager.getInstance();

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
        setProperty(testPropManager.getProperty(PropConst.TYPE_BROWSER), testPropManager.getProperty(PropConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(testPropManager.getProperty(PropConst.BASE_URL));

    }


}
