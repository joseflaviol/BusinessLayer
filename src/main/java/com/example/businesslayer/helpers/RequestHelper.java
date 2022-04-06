package com.example.businesslayer.helpers;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class RequestHelper {

    private CloseableHttpClient httpClient;

    public boolean post(String url, String data) throws IOException {
        httpClient = HttpClients.createDefault();
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

    public String get(String url) throws IOException {
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return result;
    }

}
