package com.api.test.tests;

import com.api.test.utilities.ApiBase;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.restdriver.serverdriver.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing api endpoint")
@Tag("integ")
public class TestApi extends ApiBase {

    @BeforeEach
    public void start(){
        response = getResponse("");
    }

    @Test
    @DisplayName("returns 200 on valid GET request")
    public void successTest(){
        assertThat(response, hasStatusCode(200));
    }

    @Test
    @DisplayName("returns the correct response")
    public void inspectTest(){
        for(JsonNode result : response.asJson()){
            assertTrue(result.has("id"), "Id missing from result " + result.toString());
            assertTrue(result.has("field"), "Field missing from result " + result.toString());
        }
    }

    @Test
    @DisplayName("returns the correct header")
    public void headerTest(){
        assertThat(response, hasHeaderWithValue("Content-Type", equalTo("application/json")));
    }

}
