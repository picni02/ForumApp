package com.example.web_250.services;

import java.util.List;

import com.example.web_250.models.entities.User;
import com.example.web_250.models.in.UserIn;
import com.example.web_250.models.out.UserOut;

public interface UserService {
    public List<UserOut> getAllUsers();
    public User getUserByEmail(String username);
    public UserOut registerUser(UserIn userIn);
    public void banUser(String userEmail);
}
