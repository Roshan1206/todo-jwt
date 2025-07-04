package com.example.todos.service;

import com.example.todos.request.PasswordUpdateRequest;
import com.example.todos.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo();
    void deleteUser();
    void updatePassword(PasswordUpdateRequest passwordUpdateRequest);
}
