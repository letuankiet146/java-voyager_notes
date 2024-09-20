package com.example.business.service;

import com.example.business.dto.User;
import com.example.business.dto.UserDTO;
import com.example.database.dao.UserDAO;
import com.example.database.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    public List<UserDTO> findAllUsers() {
        List<UserEntity> userEntities = userDAO.findAll();
        return userEntities.stream().map(this::toUserDTO).collect(Collectors.toList());
    }

    public List<User> findAllUserList() {
        List<UserEntity> userEntities = userDAO.findAll();
        return userEntities.stream().map(this::toUser).collect(Collectors.toList());
    }

    private UserDTO toUserDTO(UserEntity entity) {
        UserDTO user = new UserDTO();
        user.setId(entity.getId());
        user.setUserName(entity.getUserName());
        return user;
    }
    private User toUser(UserEntity entity) {
        return new User(entity.getId(), entity.getUserName());
    }
}
