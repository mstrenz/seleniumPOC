package com.example.test.tests;

import com.example.test.utilities.ScreenShotOnFailure;
import com.example.test.utilities.TestBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ScreenShotOnFailure.class)
@DisplayName("Failing Test")
public class TestTwo extends TestBase {

    @Test
    @Disabled
    @DisplayName("\uD83D\uDCA9 should fail")
    public void testFail(){
        google.goTo();
        assertTrue(driver.getCurrentUrl().contains("failure"), "Page Not As Expected");
    }
}
