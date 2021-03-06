package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.dto.UserDto;
import com.wangchucheng.onlinebookstore.model.User;
import com.wangchucheng.onlinebookstore.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CartService cartService;

    public boolean checkUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public boolean saveUser(User user) {
        User savedUser = userRepo.save(user);
        if(savedUser.getRole().equals("customer")) {
            cartService.initCart(savedUser.getUserId());
        }
        return true;
    }

    public UserDto selectUserByUsernameAndPassword(String username, String password, String role) {
        ModelMapper modelMapper = new ModelMapper();
        User user = userRepo.findByUsernameAndPasswordAndRole(username, password, role);
        if (user != null) {
            return modelMapper.map(user, UserDto.class);
        } else {
            return null;
        }
    }

    public UserDto selectUserById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        User user = userRepo.findAllByUserId(id);
        return modelMapper.map(user, UserDto.class);
    }
}
