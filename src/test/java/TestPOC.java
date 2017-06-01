import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static junit.framework.TestCase.assertFalse;

public class TestPOC{
    public static RemoteWebDriver testDriver;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        testDriver = new ChromeDriver();
        testDriver.get("https://www.readytalk.com");
    }

    @Before
    public void clean(){
        testDriver.manage().deleteAllCookies();
    }

    @Test
    public void testOne(){
        assertFalse("Nav Not Found", testDriver.findElementById("nav_container").isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        testDriver.quit();
    }

}