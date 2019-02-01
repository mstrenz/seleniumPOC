
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestPOC{
    private static ChromeDriverService service;
    public static RemoteWebDriver testDriver;
    protected static Logger logger = LoggerFactory.getLogger(TestPOC.class);


    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
        //Configure Chromedriver
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("lib/chromedriver"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Get Driver
        ChromeOptions options = new ChromeOptions();
        testDriver = new RemoteWebDriver(service.getUrl(), options);
        testDriver.get("https://www.google.com");
    }


    @Test
    public void testOne(){
        logger.info("TESTING GOOGLE");
        assertEquals("https://www.google.com/", testDriver.getCurrentUrl());
    }

    @AfterAll
    public static void tearDown(){
        testDriver.quit();
    }

}
