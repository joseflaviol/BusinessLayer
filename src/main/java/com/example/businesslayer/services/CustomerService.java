package com.example.businesslayer.services;

import com.example.businesslayer.helpers.RequestHelper;
import com.example.businesslayer.models.Customer;

import java.io.IOException;

public class CustomerService {

    private RequestHelper requestHelper = new RequestHelper();
    private String url = "https://sparklingwaterapi.herokuapp.com/api/customer"; // url do DataLayer

    public String findAllCustomers(/*int range*/) throws IOException {
        return this.requestHelper.get(this.url);
                //return this.requestHelper.get(this.url + "/select/paginated/" + range);
    }

    public String findCustomer(String id) throws IOException {
        return this.requestHelper.get(this.url + "/" + id);// + "/select/" + id);
    }

    public boolean insertCustomer(Customer customer) throws IOException {
        return this.requestHelper.post(this.url, customer.toJson());// "/insert", customer.toJson()); // retorna true caso não tenha dado algum erro
    }

}
