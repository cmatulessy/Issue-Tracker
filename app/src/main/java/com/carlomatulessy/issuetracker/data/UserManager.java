package com.carlomatulessy.issuetracker.data;

import com.carlomatulessy.issuetracker.R;
import java.util.HashMap;

/**
 * Created by Carlo on 5-9-2017.
 * This class is responsible for managing the data during usage of the app.
 * If we add a new issue, we add here a new count.
 */
public class UserManager {

    private static UserManager instance = null;
    private HashMap<String, User> users;
    private boolean refreshUserList = false;

    private UserManager() {
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

    public boolean getRefreshUserList() {
        return refreshUserList;
    }

    public void setRefreshUserList(boolean refreshUserList) {
        this.refreshUserList = refreshUserList;
    }

    public HashMap<String, User> getAllUsers() {
        return users;
    }

    public void setUsersAvatars() {
        for(User user : users.values()) {
            switch (user.getUserFullName().toLowerCase()) {
                case "fiona de vries" :
                    user.setProfilePictureResourceId(R.drawable.fiona);
                    break;
                case "petra boersma" :
                    user.setProfilePictureResourceId(R.drawable.petra);
                    break;
                case "theo jansen" :
                    user.setProfilePictureResourceId(R.drawable.theo);
                    break;
                default :
                    break;
            }
        }
    }
}
