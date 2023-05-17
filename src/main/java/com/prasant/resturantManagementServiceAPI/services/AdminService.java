package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.dtos.SignUpInput;
import com.prasant.resturantManagementServiceAPI.repositories.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private IAdminRepository adminRepository;


}
