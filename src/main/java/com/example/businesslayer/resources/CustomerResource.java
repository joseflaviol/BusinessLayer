package com.example.businesslayer.resources;

import com.example.businesslayer.models.Customer;
import com.example.businesslayer.services.CustomerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("customer")
public class CustomerResource {

    CustomerService customerService = new CustomerService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) throws IOException {
        if (this.customerService.insertCustomer(customer)) {
            return Response.status(200).build(); // caso o customer tenha sido inserido, retorna uma reposta com status 200
        }
        return Response.status(400).build(); // caso o customer nao tenha sido inserido, retorna uma reposta com status 400
    }

}
