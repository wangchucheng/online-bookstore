package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
    User findAllByUserId(Long userId);
    User findByUsernameAndPasswordAndRole(String username, String password, String role);
}
