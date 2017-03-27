package com.popkova.russianlanguageapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 16.03.2017.
 */

public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("surname", user.surname);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.putInt("age", user.age);
        spEditor.putInt("score", user.score);
        spEditor.commit();
    }

    public User getLoggedInUser(){
        String name = userLocalDatabase.getString("name","");
        String surname = userLocalDatabase.getString("surname","");
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        int score = userLocalDatabase.getInt("score", 0);
        int age = userLocalDatabase.getInt("age",0);

        User storedUser = new User(name, surname, username, password, age, score);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", loggedIn);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }

    public boolean getUserLoggedIn() {
        if (userLocalDatabase.getBoolean("LoggedIn", false) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void setScoreForAGame(int scoreForAGame){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putInt("Score for a game", scoreForAGame);
        spEditor.commit();
    }

    public void setTotalScore(int scoreForAGame){
        int score = userLocalDatabase.getInt("score", 0);
        int scoreTotal = score + scoreForAGame;
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putInt("score", scoreTotal);
        spEditor.commit();
    }

    public int getTotalScore(){
        return userLocalDatabase.getInt("score", 0);
    }

    public void clearScoreForAGame(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putInt("Score for a game", 0);
        spEditor.commit();
    }

    public String getUserUsername(){
        return userLocalDatabase.getString("username","");
    }

    public String getUserName(){
        return userLocalDatabase.getString("name","");
    }

}
