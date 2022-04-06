package com.example.businesslayer.services;

import com.example.businesslayer.helpers.RequestHelper;
import com.example.businesslayer.models.Customer;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CustomerService {

    private RequestHelper requestHelper = new RequestHelper();
    private String url = "http://localhost:3000/api/customer"; // url do DataLayer

    public String findAllCustomers() throws IOException {
        return this.requestHelper.get(this.url);
    }

    public String findCustomer(String id) throws IOException {
        return this.requestHelper.get(this.url + "/" + id);
    }

    public boolean insertCustomer(Customer customer) throws IOException {
        return this.requestHelper.post(this.url, customer.toJson()); // retorna true caso não tenha dado algum erro
    }

}
