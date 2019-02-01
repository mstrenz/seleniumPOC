package Tests;

import Utilities.ScreenShotOnFailure;
import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ScreenShotOnFailure.class)
public class TestOne extends TestBase {

    @Test
    public void testPass(){
        logger.info("Passing Test");
        google.goTo();
        assertEquals("https://www.google.com/", driver.getCurrentUrl());
    }
}
