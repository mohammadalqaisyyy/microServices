package com.services.authentication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private static final List<User> users=new ArrayList<>();

    static {
        users.add(new User("mhmd","mm"));
        users.add(new User("ahmad","aa"));
        users.add(new User("dana","dd"));
    }

    public static boolean checkUser(String userName, String password) {
        return users.contains(new User(userName, password));
    }

    public static void addUser(String userName, String password) {
        User newUser = new User(userName, password);
        for (User user : users)
            if (user.getUsername().equals(userName))
                throw new IllegalArgumentException("this username is used..");
        users.add(newUser);
    }

    @Override
    public String toString() {
        return "user size = " + users.size();
    }
}
