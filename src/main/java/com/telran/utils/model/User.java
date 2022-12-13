package com.telran.utils.model;

public class User {

    private String firtsname;
    private String lastname;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;
    private String firstLineAddress;
    private String city;


    public String getFirtsname() {
        return firtsname;
    }

    public User setFirtsname(String firtsname) {
        this.firtsname = firtsname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }


    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public User setFirstLineAddress(String firstLineAddress) {
        this.firstLineAddress = firstLineAddress;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }
}
