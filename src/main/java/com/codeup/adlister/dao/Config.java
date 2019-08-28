package com.codeup.adlister.dao;

public class Config {

    private static String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private static String user = "root";
    private static String pass = "codeup";


    public static String getUsername() {
        return user;
    }

    public static String getPassword() {
        return pass;
    }

    public static String getUrl() {
        return url;
    }

}

