package com.example.dev.lottepos.conn;

/**
 * Created by DEV on 2017-12-06.
 */
public class BasicValue {
    private static BasicValue ourInstance = new BasicValue();
    private String urlHead = "http://115.68.14.27:80/mh/";

    public static BasicValue getInstance() {
        return ourInstance;
    }

    public String getUrlHead() {
        return urlHead;
    }

}