package Tests;

import Utilities.ScreenShotOnFailure;
import Utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ScreenShotOnFailure.class)
public class TestTwo extends TestBase {

    @Test
    public void testFail(){
        logger.info("Failing Test");
        google.goTo();
        assertTrue(driver.getCurrentUrl().contains("failure"), "Page Not As Expected");
    }
}
