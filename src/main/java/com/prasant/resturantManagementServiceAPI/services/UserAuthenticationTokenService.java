package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.models.User;
import com.prasant.resturantManagementServiceAPI.models.UserAuthenticationToken;
import com.prasant.resturantManagementServiceAPI.repositories.IUserAuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationTokenService {

    @Autowired
    private IUserAuthenticationTokenRepository authenticationTokenRepository;

    public void saveToken(UserAuthenticationToken token) {
        authenticationTokenRepository.save(token);
    }

    public String deleteToken(String token) {
        UserAuthenticationToken userToken = authenticationTokenRepository.findByToken(token);
        if (userToken == null){
            return "Invalid token!";
        }

        authenticationTokenRepository.delete(userToken);
        return "Signed out";
    }

    public UserAuthenticationToken getAuthToken(String token) {
        return authenticationTokenRepository.findByToken(token);
    }
}
