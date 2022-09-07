package com.example.recyclerview;

public class User {
    private String username;
    private String email;
    private String postAddress;
    private int phoneNum;

    public User(String username, String email, String postAddress, int phoneNum) {
        this.username = username;
        this.email = email;
        this.postAddress = postAddress;
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
