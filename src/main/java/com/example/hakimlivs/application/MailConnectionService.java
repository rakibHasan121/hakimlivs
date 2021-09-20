package com.example.hakimlivs.application;


import org.springframework.stereotype.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class MailConnectionService {

    private final String newCustomerGreetingBody = "Du är nu med i klubben!";
    private final String newCustomerGreetingSubject = "Välkommen!";
    private final String newOrderSubject = "Tack för din beställning!";
    private final String newOrderBody = "Vi skickar din order så snart som möjligt! Ordernummer: ";

    private final String postURL = "https://hakim-mail.herokuapp.com/sendmail";

    public void sendMail(String mailTo, String subject, String body) throws IOException {

        System.out.println("posturl är currently: " + postURL);

        URL url = new URL(postURL);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{\"to\":\"" + mailTo + "\",\"subject\":\"" + subject + "\",\"body\":\"" + body + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

    }

    public void sendMailNewCustomer(String mailTo) throws IOException {
        sendMail(mailTo, newCustomerGreetingSubject, newCustomerGreetingBody);
    }

    public void sendMailNewOrder(String mailTo, Long orderNumber) throws IOException {
        sendMail(mailTo, newOrderSubject, newOrderBody + orderNumber);
    }

}
