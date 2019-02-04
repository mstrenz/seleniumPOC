package com.api.test.tests;

import com.api.test.utilities.ApiBase;
import com.google.api.client.http.HttpRequest;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestApi extends ApiBase {

    @Test
    public void apiTest() throws IOException {
        CustomUrl url = new CustomUrl("https://example-rest-api");
        url.fields = "id,tags,title,url";

        HttpRequest request = requestFactory.buildGetRequest(url);
        CustomEndpoint customFeed = request.execute().parseAs(CustomEndpoint.class);
        if (customFeed.list.isEmpty()) {
            System.out.println("No objects found.");
        } else {
            if (customFeed.hasMore) {
                System.out.print("First ");
            }
            System.out.println(customFeed.list.size() + " objects found:");
            for (CustomObject object : customFeed.list) {
                System.out.println();
                System.out.println("-----------------------------------------------");
                System.out.println("ID: " + object.id);
                System.out.println("Title: " + object.title);
                System.out.println("Tags: " + object.tags);
                System.out.println("URL: " + object.url);
            }
        }
    }
}
