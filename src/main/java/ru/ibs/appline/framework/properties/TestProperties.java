package ru.ibs.appline.framework.properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static java.nio.file.Files.newInputStream;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {

            properties.load(newInputStream(new File("./" + System.getProperty("environment") + ".properties").toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}


