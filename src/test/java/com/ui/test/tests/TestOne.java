package com.ui.test.tests;

import com.ui.test.utilities.ScreenShotOnFailure;
import com.ui.test.utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShotOnFailure.class)
@DisplayName("Passing Tests")
public class TestOne extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("should pass")
    public void testPass(){
        google.goTo();
        google.getSearchInput().sendKeys("Testing");
        assertEquals("Testing", google.getSearchInput().getAttribute("value"));
    }
}
