package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.dto.UserDto;
import com.wangchucheng.onlinebookstore.model.User;
import com.wangchucheng.onlinebookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/customer")
    public boolean customerSignUp(@RequestBody User user) {
        user.setRole("customer");
        return userService.saveUser(user);
    }

    @GetMapping(value = "/customer")
    public UserDto customerSignIn(@RequestBody User user) {
        return userService.selectUserByUsernameAndPassword(user.getUsername(), user.getPassword(), "customer");
    }

    @GetMapping(value = "/customer/{userId}")
    public UserDto getCustomerInfo(@PathVariable Long userId) {
        return userService.selectUserById(userId);
    }

    @PostMapping(value = "/seller")
    public boolean sellerSignUp(@RequestBody User user) {
        user.setRole("seller");
        return userService.saveUser(user);
    }

    @GetMapping(value = "/seller")
    public UserDto sellerSignIn(@RequestBody User user) {
        return userService.selectUserByUsernameAndPassword(user.getUsername(), user.getPassword(), "seller");
    }
}
