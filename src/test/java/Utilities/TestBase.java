package Utilities;

import Pages.GooglePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class TestBase {
    private static ChromeDriverService service;
    public static RemoteWebDriver driver;
    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected static GooglePage google;


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
        driver = new RemoteWebDriver(service.getUrl(), options);

        //Initialize Pages
        google = new GooglePage(driver);
    }

    @AfterAll
    //Teardown driver after each test
    public static void tearDown() {
        driver.quit();
        service.stop();
    }
}
