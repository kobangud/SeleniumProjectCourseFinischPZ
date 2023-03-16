package ru.ibs.appline.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.ibs.appline.framework.properties.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;


/**
 * Класс для управления веб драйвером
 */
public class DriverManager {

    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getWebDriver() {
        if (driver == null) {
            iniDriver();
        }
        return driver;
    }

    public static void iniDriver() {
        driver = new ChromeDriver();
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        String baseUrl = properties.getProperty("HOSTNAME");
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    /**
     * Метод для закрытия сессии драйвера и браузера
     *
     * @see WebDriver#quit()
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
