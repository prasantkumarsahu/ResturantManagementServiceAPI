package com.prasant.resturantManagementServiceAPI.controllers;

import com.prasant.resturantManagementServiceAPI.dtos.SignUpInput;
import com.prasant.resturantManagementServiceAPI.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("signup")
    public String signup(@RequestBody SignUpInput signUpInput){
        return adminService.
    }
}
