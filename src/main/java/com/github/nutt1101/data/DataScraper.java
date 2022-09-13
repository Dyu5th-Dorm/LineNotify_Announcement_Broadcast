package com.github.nutt1101.data;

import com.github.nutt1101.model.RequestionModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataScraper {

    private static String uri = "http://tis.dyu.edu.tw/app/app/news.php";
    private static String[] headers =  {
        "Content-Type", "application/json; charset=utf-8"
    };

    private static HttpRequest getRequestion(RequestionModel model) {
        return HttpRequest
                .newBuilder()
                .headers(DataScraper.headers)
                .uri(URI.create(DataScraper.uri))
                .POST(HttpRequest.BodyPublishers.ofString(
                        model.toString()
                ))
                .build();
    }


    static public JSONObject get(RequestionModel model) throws IOException, InterruptedException, JSONException {
        return new JSONObject(
                HttpClient
                .newHttpClient()
                .send(
                        getRequestion(model),
                        HttpResponse.BodyHandlers.ofString()
                ).body()
        );
    }
}
