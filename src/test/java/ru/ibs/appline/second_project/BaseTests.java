package ru.ibs.appline.second_project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.appline.framework.managers.DriverManager;
import ru.ibs.appline.framework.properties.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class BaseTests {
    protected WebDriver driver= DriverManager.getWebDriver();
    protected WebDriverWait wait;
    private final Properties properties = TestProperties.getInstance().getProperties();

    @BeforeEach
    public void before()  {
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        String baseUrl = properties.getProperty("HOSTNAME");
        driver.get(baseUrl);
    }
    @AfterEach
    public void after(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
