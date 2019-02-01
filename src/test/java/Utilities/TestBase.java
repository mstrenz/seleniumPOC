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
        if(System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverMac");
        }else{
            System.setProperty("webdriver.chrome.driver", "lib/chromedriverLinux");
        }

        //Configure Chromedriver
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
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
