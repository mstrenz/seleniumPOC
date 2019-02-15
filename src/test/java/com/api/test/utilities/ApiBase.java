package com.api.test.utilities;


import com.example.test.utilities.TestBase;
import com.github.restdriver.serverdriver.http.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.github.restdriver.serverdriver.RestServerDriver.get;
import static com.github.restdriver.serverdriver.RestServerDriver.url;

public class ApiBase {
    protected static Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static Properties props = new Properties();
    protected static String baseUrl;
    protected Response response;

    @BeforeAll
    public static void setup(){
        try {
            props.load(new FileInputStream("src/test/resources/env.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseUrl = props.getProperty("default.url");
    }

    public Response getResponse(String path){
        return get(url(baseUrl).withPath(path));
    }

}
