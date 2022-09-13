package com.github.nutt1101;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Configuration {
    static boolean loaded;
     static JSONObject configuration;
     static String token;


    static void init() throws JSONException, IOException {
        configuration = load();
        token = configuration.getString("token");
        loaded = true;
    }

    private static JSONObject load() throws JSONException, IOException {
        InputStream inputStream = Configuration.class
                .getClassLoader()
                .getResource("data.json").openStream();

        if (inputStream == null) {
            return new JSONObject("{}");
        }

        String content = new String(inputStream.readAllBytes());

        return new JSONObject(content);
    }
}
