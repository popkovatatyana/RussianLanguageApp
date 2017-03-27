package com.popkova.russianlanguageapp;

/**
 * Created by User on 16.03.2017.
 */

public class User {
    String name, username, surname, password;
    int age;
    int score = 0;

    public User(String name, String surname, String username, String password, int age, int score){
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.score = score;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
