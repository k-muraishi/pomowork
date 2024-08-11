package com.murapp.pomowork.domain.entity;

import com.murapp.pomowork.domain.valueObject.Email;
import com.murapp.pomowork.domain.valueObject.Password;
import com.murapp.pomowork.domain.valueObject.UserName;

import java.util.UUID;

public class User {
    private String userId;
    private UserName userName;
    private Email email;
    private Password password;

    public User(String userName, String email, String password){
        this.userId = UUID.randomUUID().toString();
        this.userName = new UserName(userName);
        this.email = new Email(email);
        this.password = new Password(password);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName.getUserName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getPassword() {
        return password.getPassword();
    }

    public String changeUserName(String userName){
       UserName changedUserName =  new UserName(userName);
        return changedUserName.getUserName();
    }

    public String changeEmail(String email){
        Email changedEmail = new Email(email);
        return  changedEmail.getEmail();
    }

    public String changePassword(String password){
        Password changedPassword = new Password(password);
        return changedPassword.getPassword();
    }
}
