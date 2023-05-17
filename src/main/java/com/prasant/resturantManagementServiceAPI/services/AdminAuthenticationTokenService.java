package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.models.Admin;
import com.prasant.resturantManagementServiceAPI.models.AdminAuthenticationToken;
import com.prasant.resturantManagementServiceAPI.repositories.IAdminAuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationTokenService {

    @Autowired
    private IAdminAuthenticationTokenRepository authenticationTokenRepository;

    public void saveToken(AdminAuthenticationToken token) {
        authenticationTokenRepository.save(token);
    }

    public String deleteToken(String token) {
        AdminAuthenticationToken adminToken = authenticationTokenRepository.findByToken(token);
        if (adminToken == null){
            return "Invalid token!";
        }

        authenticationTokenRepository.delete(adminToken);
        return "Signed out";
    }

    public boolean authenticateToken(String token) {
        return authenticationTokenRepository.existsByToken(token);
    }

    public AdminAuthenticationToken getAuthToken(String token) {
        return authenticationTokenRepository.findByToken(token);
    }
}
