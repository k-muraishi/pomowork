package com.murapp.pomowork.domain.valueObject;

public class UserName {
    private final int userNameMinlength;
    private final int userNameMaxlength;
    private String userName;

    public UserName(String userName){
        this.userNameMinlength = 1;
        this.userNameMaxlength = 10;
        this.userName = userName;
    }

    private boolean checkUserName(String userName){
        if (userName.length() < userNameMinlength) {
            // TODO Exceptionクラスの実装
            throw new RuntimeException();
        }

        if (userName.length() > userNameMaxlength){
            // TODO Exceptionクラスの実装
            throw new RuntimeException();
        }

        return true;
    }

    public String getUserName() {
        return userName;
    }
}
