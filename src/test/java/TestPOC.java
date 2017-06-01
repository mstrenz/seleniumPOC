import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertEquals;

public class TestPOC{
    public static RemoteWebDriver testDriver;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        testDriver = new ChromeDriver();
        testDriver.get("https://www.google.com");
    }

    @Before
    public void clean(){
        testDriver.manage().deleteAllCookies();
    }

    @Test
    public void testOne(){
        assertEquals("https://www.google.com/", testDriver.getCurrentUrl());
    }

    @AfterClass
    public static void tearDown(){
        testDriver.quit();
    }

}
