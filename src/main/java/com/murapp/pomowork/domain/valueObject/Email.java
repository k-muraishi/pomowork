package com.murapp.pomowork.domain.valueObject;

import java.util.regex.Pattern;

public class Email {
    private final String emailPattern;
    private String email;

    public Email (String email){
        this.emailPattern = "^([a-zA-Z0-9])+([a-zA-Z0-9¥._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9¥._-]+)+$";
        if (isEmail(email)){
            this.email = email;
        }
    }

    private boolean isEmail(String email){
        Pattern p = Pattern.compile(emailPattern);

        if(!p.matcher(email).find()) {
            throw new RuntimeException();
        }
        return true;
    }

    public String getEmail(){
        return email;
    }
}
