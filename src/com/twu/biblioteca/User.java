package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isLoggedIn;

    public User(String username, String name, String email, String phoneNumber){
        this.username = username;
        this.password = null;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isLoggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(){
        isLoggedIn = true;
    }

    public void setLoggedOut(){
        isLoggedIn = false;
    }


    public void logIn(String passwordAttempt){
        if (passwordAttempt.equals(password) && !isLoggedIn){
            isLoggedIn = true;
        }
    }

    public void showUserDetails(){
        if (isLoggedIn){
            System.out.println("Username: " + username);
            System.out.println("Your name: " + name);
            System.out.println("Your email: " + email);
            System.out.println("Your phone number: " + phoneNumber);
        }
    }
}
