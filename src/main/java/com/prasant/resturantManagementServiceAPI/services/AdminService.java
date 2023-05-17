package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.dtos.FoodInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInOutput;
import com.prasant.resturantManagementServiceAPI.dtos.SignUpInput;
import com.prasant.resturantManagementServiceAPI.models.Admin;
import com.prasant.resturantManagementServiceAPI.models.AdminAuthenticationToken;
import com.prasant.resturantManagementServiceAPI.repositories.IAdminRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminService {

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private AdminAuthenticationTokenService authenticationTokenService;

    public String saveAdmin(SignUpInput signUpInput) {
        boolean isPresent = adminRepository.existsByEmail(signUpInput.getEmail());
        if (isPresent){
            return "Admin already signed up! Sign in instead!";
        }

        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signUpInput.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Admin admin = new Admin(signUpInput.getName(), signUpInput.getEmail(), encryptedPassword, signUpInput.getAddress());
        adminRepository.save(admin);
        return "Admin sign up successfully!";
    }

    public SignInOutput signinAdmin(SignInInput signInInput) {
        Admin admin = adminRepository.findByEmail(signInInput.getEmail());
        if (admin == null){
            return new SignInOutput("Admin is not signed up! Sign up instead", null);
        }

        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInInput.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (!encryptedPassword.equals(admin.getPassword())){
            return new SignInOutput("Wrong admin details! Sign up instead", null);
        }

        AdminAuthenticationToken token = new AdminAuthenticationToken(admin);
        authenticationTokenService.saveToken(token);
        return new SignInOutput("Admin signed in successful!", token.getToken());
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();
        return DatatypeConverter.printHexBinary(digested);
    }

    public String signoutAdmin(String token) {
        return authenticationTokenService.deleteToken(token);
    }

    public boolean authenticateToken(String token) {
        return authenticationTokenService.authenticateToken(token);
    }

    public Admin getAdminByToken(String token) {
        AdminAuthenticationToken authToken = authenticationTokenService.getAuthToken(token);
        if (authToken == null){
            return null;
        }

        return authToken.getAdmin();
    }
}
