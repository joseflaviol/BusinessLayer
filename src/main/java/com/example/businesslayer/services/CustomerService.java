package com.example.businesslayer.services;

import com.example.businesslayer.helpers.RequestHelper;
import com.example.businesslayer.models.Customer;

import java.io.IOException;

public class CustomerService {

    private RequestHelper requestHelper = new RequestHelper();
    private String url = "http://a2ac-170-254-198-77.ngrok.io/SparklingWater/api/customer"; // url do DataLayer

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
