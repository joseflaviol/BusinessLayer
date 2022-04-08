package com.example.businesslayer.resources;

import com.example.businesslayer.helpers.ErrorHelper;
import com.example.businesslayer.models.Customer;
import com.example.businesslayer.services.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

@Path("/customer")
public class CustomerResource {

    CustomerService customerService = new CustomerService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/paginated/{range}")
    public String getAllCustomers(/*@PathParam("range") int range*/) throws IOException {
       return this.customerService.findAllCustomers(/*range*/);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getCustomer(@PathParam("id") Long id) throws IOException {
        return this.customerService.findCustomer(id.toString());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) throws IOException {
        if (customer.getFirstName() == null || customer.getLastName() == null || customer.getEmailAddress() == null ||
            customer.getPhoneNumber() == null || customer.getAddress() == null || customer.getCountry() == null ||
            customer.getState() == null) {
            return Response.status(400).entity(new ErrorHelper("campo em branco")).build();
        }
        if (this.customerService.insertCustomer(customer)) {
            return Response.status(200).entity(customer).build(); // caso o customer tenha sido inserido, retorna uma reposta com status 200
        }
        return Response.status(400).entity(new ErrorHelper("cadastro nao efetuado")).build(); // caso o customer nao tenha sido inserido, retorna uma reposta com status 400
    }

}
