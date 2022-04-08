package com.example.businesslayer.resources;

import com.example.businesslayer.models.User;
import com.example.businesslayer.services.UserService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

@Path("user")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) throws IOException {
        if (user.getUsername() == null || user.getPassword() == null || user.getGroup() == null) {
            return Response.status(400).build();
        }
        if (this.userService.insertUser(user)) {
            return Response.status(200).build();
        }
        return Response.status(400).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(User user) throws IOException {
        if (user.getUsername() == null || user.getPassword() == null) {
            return Response.status(400).build();
        }
        if (this.userService.login(user)) {
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

}
