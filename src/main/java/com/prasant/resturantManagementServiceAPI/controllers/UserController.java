package com.prasant.resturantManagementServiceAPI.controllers;

import com.prasant.resturantManagementServiceAPI.dtos.FoodInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInOutput;
import com.prasant.resturantManagementServiceAPI.dtos.SignUpInputUser;
import com.prasant.resturantManagementServiceAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public String signupUser(@Valid @RequestBody SignUpInputUser inputUser){
        return userService.signupUser(inputUser);
    }

    @PostMapping("signin")
    public SignInOutput signinUser(@Valid @RequestBody SignInInput inputUser){
        return userService.signinUser(inputUser);
    }

    @DeleteMapping("signout/{token}")
    public String signoutUser(@PathVariable String token){
        return userService.signoutUser(token);
    }
}
