package com.carlomatulessy.issuetracker.data;

import java.util.HashMap;

/**
 * Created by Carlo on 5-9-2017.
 */

public class UserManager {

    private static UserManager instance = null;
    private HashMap<String, User> users;

    protected UserManager() {
    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public User getUserWithName(String name) {
        return users.get(name);
    }

    public HashMap<String, User> getAllUsers() {
        return users;
    }
}
