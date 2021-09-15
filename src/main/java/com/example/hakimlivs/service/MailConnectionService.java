package com.example.hakimlivs.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Service
public class MailConnectionService {

    @Value("${sendmail.url.post}")
    private String postURL;

    public void sendMail() throws IOException {

        System.out.println("posturl är currently: " + postURL);

        URL url = new URL(postURL);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{\"to\":\"noreply.hakimlivs@gmail.com\",\"subject\":\"Välkommen!\",\"body\":\"Du är nu med i klubben!\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

    }

}
