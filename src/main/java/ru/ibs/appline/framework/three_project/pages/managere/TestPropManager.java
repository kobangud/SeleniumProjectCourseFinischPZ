package ru.ibs.appline.framework.three_project.pages.managere;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {
    private final Properties properties = new Properties();
    private static TestPropManager INSTANCE = null;


    public static TestPropManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }


    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    /**
     * Метод подгружает содержимого файла application.properties в переменную {@link #properties}
     * Либо из файла переданного пользователем через настройку -DpropFile={nameFile}
     *
     * @see TestPropManager#TestPropManager()
     */
    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propFile", "environment") + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                            !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}


