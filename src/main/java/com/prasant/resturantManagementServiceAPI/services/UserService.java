package com.prasant.resturantManagementServiceAPI.services;

import com.prasant.resturantManagementServiceAPI.dtos.SignInInput;
import com.prasant.resturantManagementServiceAPI.dtos.SignInOutput;
import com.prasant.resturantManagementServiceAPI.dtos.SignUpInputUser;
import com.prasant.resturantManagementServiceAPI.models.User;
import com.prasant.resturantManagementServiceAPI.models.UserAuthenticationToken;
import com.prasant.resturantManagementServiceAPI.repositories.IUserRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserAuthenticationTokenService authenticationTokenService;

    public String signupUser(SignUpInputUser inputUser) {
        boolean isPresent = userRepository.existsByEmail(inputUser.getEmail());
        if (isPresent){
            return "User already signed up! Sign in instead!";
        }

        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(inputUser.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        User user = new User(inputUser.getName(), inputUser.getEmail(), encryptedPassword, inputUser.getAddress());
        userRepository.save(user);
        return "User sign up successfully!";
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();
        return DatatypeConverter.printHexBinary(digested);
    }

    public SignInOutput signinUser(SignInInput inputUser) {
        User user = userRepository.findByEmail(inputUser.getEmail());
        if (user == null){
            return new SignInOutput("User is not signed up! Sign up instead", null);
        }

        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(inputUser.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (!encryptedPassword.equals(user.getPassword())){
            return new SignInOutput("Wrong user details! Sign up instead", null);
        }

        UserAuthenticationToken token = new UserAuthenticationToken(user);
        authenticationTokenService.saveToken(token);
        return new SignInOutput("User signed in successful!", token.getToken());
    }

    public String signoutUser(String token) {
        return authenticationTokenService.deleteToken(token);
    }

    public User getUserByToken(String token) {
        UserAuthenticationToken authToken = authenticationTokenService.getAuthToken(token);
        if (authToken == null){
            return null;
        }

        return authToken.getUser();
    }
}
