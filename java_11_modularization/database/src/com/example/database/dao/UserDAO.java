package com.example.database.dao;

import com.example.database.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<UserEntity> findAll(){
        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1L, "Mark"));
        users.add(new UserEntity(2L, "Bill"));
        users.add(new UserEntity(3L, "Son"));
        return users;
    }
}
