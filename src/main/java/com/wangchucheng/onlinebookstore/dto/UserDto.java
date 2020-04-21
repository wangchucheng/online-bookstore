package com.wangchucheng.onlinebookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long userId;
    private String username;
    private String profile;

    public UserDto() {
    }

    public UserDto(Long userId, String username, String profile) {
        this.userId = userId;
        this.username = username;
        this.profile = profile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
