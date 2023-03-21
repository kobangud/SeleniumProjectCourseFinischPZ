package ru.ibs.appline.three_project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.appline.framework.three_project.pages.managere.DrManager;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;
import ru.ibs.appline.framework.three_project.pages.managere.TestPropManager;
import ru.ibs.appline.framework.three_project.pages.utils.PropConst;

public class BaseTests {
    private DrManager drManager = DrManager.getDrManager();
    private TestPropManager testPropManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();


    @BeforeEach
    public void BaseTest() {

        drManager.getDriver().get(testPropManager.getProperty(PropConst.BASE_URL));

    }

    @AfterEach
    public void closeDriver() {

        drManager.getDriver().quit();
    }
}
