package com.example.test.tests;

import com.example.test.utilities.ScreenShotOnFailure;
import com.example.test.utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShotOnFailure.class)
public class TestOne extends TestBase {

    @Test
    @Tag("pass")
    @DisplayName("This is an example of a passing test")
    public void testPass(){
        logger.info("Passing Test");
        google.goTo();
        assertEquals("https://www.google.com/", driver.getCurrentUrl());
    }
}
