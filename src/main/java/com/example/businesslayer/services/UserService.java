package com.example.businesslayer.services;

import com.example.businesslayer.helpers.RequestHelper;
import com.example.businesslayer.models.User;

import java.io.IOException;

public class UserService {

    private RequestHelper requestHelper = new RequestHelper();
    private String url = "https://sparklingwaterapi.herokuapp.com/api/user"; // url do DataLayer

    public boolean insertUser(User user) throws IOException {
        return this.requestHelper.post(url, user.toJson()); //+ "/insert", user.toJson());
    }

    public boolean login(User user) throws IOException {
        String json = "{\"username\": \"" + user.getUsername() + "\"," +
                        "\"password\": \"" + user.getPassword() + "\"}";
        return this.requestHelper.post(url + "/login", json); //+ "/login", json);
    }
}
