package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface UserRepo extends JpaRepository <User, Long> {
    User findAllByUserId(Long userId);

    @Nullable
    User findByUsernameAndPasswordAndRole(String username, String password, String role);

    boolean existsByUsername(String username);
}
