package com.api.test.utilities;


import com.example.test.utilities.TestBase;
import com.github.restdriver.serverdriver.http.response.Response;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.github.restdriver.serverdriver.RestServerDriver.get;
import static com.github.restdriver.serverdriver.RestServerDriver.url;

public class ApiBase {
    public static RemoteWebDriver driver;
    protected static Properties props = new Properties();
    protected static String testName = null;
    protected static ChromeDriverService service;
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static String baseUrl;

    protected Response response;

    @BeforeAll
    public static void shhh(){
        logger.info(System.getProperty("secret"));
    }

    @BeforeAll
    public static void setup(TestInfo testInfo) throws IOException {
        testName = "API Test " + testInfo.getDisplayName();
        props.load(new FileInputStream("src/test/resources/env.properties"));
        baseUrl = System.getProperty("baseUrl", props.getProperty("default.url"));
    }

    @BeforeEach
    public void start(TestInfo testInfo)
    {
        logger.info("Starting " + testName + " " + testInfo.getDisplayName());
    }

    @AfterEach
    public void shutdown(TestInfo testInfo){
        logger.info("Finished " + testName + " " + testInfo.getDisplayName());
    }

    public Response getResponse(String path){
        return get(url(baseUrl).withPath(path));
    }
}
