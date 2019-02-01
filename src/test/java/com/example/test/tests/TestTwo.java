package com.example.test.tests;

import com.example.test.utilities.ScreenShotOnFailure;
import com.example.test.utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ScreenShotOnFailure.class)
public class TestTwo extends TestBase {

    @Test
    @Tag("fail")
    @DisplayName("\uD83D\uDE31 This is an example of a failing test")
    public void testFail(){
        logger.info("Failing Test");
        google.goTo();
        assertTrue(driver.getCurrentUrl().contains("failure"), "Page Not As Expected");
    }
}
