package com.example.test.tests;

import com.example.test.utilities.ScreenShotOnFailure;
import com.example.test.utilities.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShotOnFailure.class)
@DisplayName("Passing Tests")
public class TestOne extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("should pass")
    public void testPass(){
        google.goTo();
        assertEquals("https://www.google.com/", driver.getCurrentUrl());
    }
}
