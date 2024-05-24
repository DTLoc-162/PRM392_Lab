package com.example.lab5;

public class User {
    private String username;
    private String fullname;
    private String email;

    private int img;

    public User (String username, String fullname, String email, int img){
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.img = img;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getFullname(){
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
