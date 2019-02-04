package com.api.test.utilities;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class ApiBase {
    public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();
    public static HttpRequestFactory requestFactory = null;

    /** URL for Custom API. */
    public static class CustomUrl extends GenericUrl {

        public CustomUrl(String encodedUrl) {
            super(encodedUrl);
        }

        @Key
        public String fields;
    }

    /** Represents a endpoint. */
    public static class CustomEndpoint {
        @Key
        public List<CustomObject> list;

        @Key("has_more")
        public boolean hasMore;
    }

    /** Represents a object. */
    public static class CustomObject {
        @Key
        public String id;

        @Key
        public List<String> tags;

        @Key
        public String title;

        @Key
        public String url;
    }

    @BeforeAll
    public static void setup(){
         requestFactory = HTTP_TRANSPORT.createRequestFactory(request -> request.setParser(new JsonObjectParser(JSON_FACTORY)));
    }

}
