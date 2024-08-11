package com.murapp.pomowork.domain.valueObject;

public class Password {

    private final Integer passwordMinLength;
    private final Integer passwordMaxLength;
    private String password;

    public Password(String password) throws RuntimeException{
        this.passwordMinLength = 10;
        this.passwordMaxLength = 30;
        if (checkPassword(password)){
            this.password = hashPassword(password);
        }
    }

    private boolean checkPassword(String password){
        if (password.length() < passwordMinLength) {
            // TODO Exceptionクラスの実装
            throw new RuntimeException();
        }

        if (password.length() > passwordMaxLength){
            // TODO Exceptionクラスの実装
            throw new RuntimeException();
        }

        return true;
    }

    private String hashPassword(String password){
        String hashedPassword = "";

        // TODO パスワードをハッシュ科する
        hashedPassword = password;

        return hashedPassword;
    }

    public String getPassword() {
        return password;
    }
}
