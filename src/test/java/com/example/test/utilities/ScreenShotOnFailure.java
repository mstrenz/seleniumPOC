package com.example.test.utilities;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.copy;

public class ScreenShotOnFailure implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if(context.getExecutionException().isPresent()){
            captureScreenShot(context.getDisplayName().replaceAll("[()]", ""));
        }
    }

    void captureScreenShot(String fileName) throws IOException {
        File directory = new File("screenshots");
        if(!directory.exists()){
            directory.mkdir();
        }
        File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File("screenshots/" + fileName + ".png");
        copy(scrFile, targetFile);
    }
}