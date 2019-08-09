package com.example.c0753560_mad3125_midterm.JavaClasses;

public class User
{
    private String email;
    private String password;
    private int id;

    public User() {
    }

    public User(int i, String s, String naina) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
