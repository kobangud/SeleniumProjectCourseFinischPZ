package ru.ibs.appline.framework.three_project.pages.utils;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.appline.framework.three_project.pages.managere.DrManager;


public class AllureListener extends AllureJunit5 implements AfterTestExecutionCallback {


    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] getScreenshot() {
        return ((TakesScreenshot) DrManager.getDrManager().getDriver()).getScreenshotAs(OutputType.BYTES);
    }

//      почему то не захотел этим методом добавлять скрин в отчет
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//
//        getScreenshot();
//    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) {

            getScreenshot();
        }
    }

}