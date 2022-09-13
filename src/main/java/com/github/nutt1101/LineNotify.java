package com.github.nutt1101;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LineNotify {
    private static String apiURI = "https://notify-api.line.me/api/notify";

    private static String[] headers = {
            "Content-Type", "application/x-www-form-urlencoded; charset=utf-8",
            "Authorization", "Bearer " + Configuration.token,
    };

    private static HttpRequest getRequestion(String message) throws UnsupportedEncodingException {
        return HttpRequest
                .newBuilder()
                .headers(headers)
                .uri(URI.create(apiURI))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "message=" + URLEncoder.encode(message, "UTF-8")
                ))
                .build();
    }

    public static HttpResponse<String> sendMessage(String message) throws IOException, InterruptedException {
        return HttpClient.newHttpClient()
                .send(
                        getRequestion(message),
                        HttpResponse.BodyHandlers.ofString()
                );
    }

    public static HttpResponse<String> test() throws IOException, InterruptedException {
        return sendMessage("This is a test message");
    }
}
