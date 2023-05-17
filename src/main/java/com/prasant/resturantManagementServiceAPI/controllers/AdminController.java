package com.prasant.resturantManagementServiceAPI.controllers;

import com.prasant.resturantManagementServiceAPI.dtos.FoodInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInOutput;
import com.prasant.resturantManagementServiceAPI.dtos.SignUpInput;
import com.prasant.resturantManagementServiceAPI.models.Food;
import com.prasant.resturantManagementServiceAPI.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("signup")
    public String signup(@Valid @RequestBody SignUpInput signUpInput){
        return adminService.saveAdmin(signUpInput);
    }

    @PostMapping("signin")
    public SignInOutput signinAdmin(@RequestBody SignInInput signInInput){
        return adminService.signinAdmin(signInInput);
    }

    @DeleteMapping("signout/{token}")
    public String signoutAdmin(@PathVariable String token){
        return adminService.signoutAdmin(token);
    }
}
