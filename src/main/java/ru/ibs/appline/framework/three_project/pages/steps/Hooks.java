package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.appline.framework.three_project.pages.managere.DrManager;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class Hooks {

    @Before
    public void before() {
        DrManager.getDrManager().getDriver();

    }

    @After

    public void after(Scenario scenario) {
        String screenshotName = scenario.getName().replace(" ", "_");
        try {
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) DrManager.getDrManager().getDriver();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageManager.quitPageManager();
        DrManager.getDrManager().quitDriver();
    }
}

