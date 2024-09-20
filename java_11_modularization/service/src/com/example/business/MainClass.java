package com.example.business;

import com.example.business.dto.User;
import com.example.business.dto.UserDTO;
import com.example.business.service.UserService;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        UserService service = new UserService();
        List<UserDTO> users = service.findAllUsers();
        List<User> usersList  = service.findAllUserList();
        System.out.println(usersList);
        System.out.println(users);
    }
}
