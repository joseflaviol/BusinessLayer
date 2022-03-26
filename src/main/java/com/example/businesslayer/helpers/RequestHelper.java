package com.example.businesslayer.helpers;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class RequestHelper {

    public boolean post(String url, String data) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        StringEntity stringEntity = new StringEntity(data); // configura o corpo da requisição

        httpPost.setEntity(stringEntity); // define o corpo da requisicao
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(httpPost); // executa requisicao
        httpClient.close();
        if (response.getStatusLine().getStatusCode() == 200) {
            return true;
        }
        return false;
    }

}
