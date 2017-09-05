package com.carlomatulessy.issuetracker.data;

import java.util.HashMap;

/**
 * Created by Carlo on 5-9-2017.
 */

public class UserManager {

    private static UserManager instance = null;
    private HashMap<String, User> users;

    protected UserManager() {
        readDataFromCSVFile();
    }

    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public User getUserWithName(String name) {
        return users.get(name);
    }

    private void readDataFromCSVFile() {
        
    }
}
