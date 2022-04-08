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
    private String url = "http://0226-170-254-198-77.ngrok.io/SparklingWater/api/customer"; // url do DataLayer

    public String findAllCustomers(int range) throws IOException {
        return this.requestHelper.get(this.url + "/select/paginated/" + range);
    }

    public String findCustomer(String id) throws IOException {
        return this.requestHelper.get(this.url + "/select/" + id);
    }

    public boolean insertCustomer(Customer customer) throws IOException {
        return this.requestHelper.post(this.url + "/insert", customer.toJson()); // retorna true caso não tenha dado algum erro
    }

}
