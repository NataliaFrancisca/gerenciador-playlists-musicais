package service;

import models.user.User;

public class UserService {
    public static User create(String name, String username){
        try{
            return new User(name, username);
        }catch (Exception e){
            System.out.println("Error creating user: " + e.getMessage());
            return null;
        }
    }
}
