package com.example.todos.controller;

import com.example.todos.request.PasswordUpdateRequest;
import com.example.todos.response.UserResponse;
import com.example.todos.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User REST API Endpoint", description = "Operation related to info about user")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "User information", description = "Get current user info")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info")
    public UserResponse getUserInfo(){
        return userService.getUserInfo();
    }

    @Operation(summary = "Deleter user", description = "Delete current user account")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping
    public void deleteUser(){
        userService.deleteUser();
    }

    @Operation(summary = "Password update", description = "Change user password after verification")
    @PutMapping("/password")
    public void passwordUpdate(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest) throws Exception {
        userService.updatePassword(passwordUpdateRequest);
    }
}
