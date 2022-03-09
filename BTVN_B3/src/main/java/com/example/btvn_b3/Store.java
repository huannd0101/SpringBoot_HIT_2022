package com.example.btvn_b3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<User> users = new ArrayList<>();

    static {
        //Cách 1
//        users.add(new User(1L, "user1", "123", "Nguyễn Đình Huân 1"));
//        users.add(new User(2L, "user2", "123", "Nguyễn Đình Huân 2"));
//        users.add(new User(3L, "user3", "123", "Nguyễn Đình Huân 3"));
//        users.add(new User(4L, "user4", "123", "Nguyễn Đình Huân 4"));
//        users.add(new User(5L, "user5", "123", "Nguyễn Đình Huân 5"));

        //Cách 2
        for(int i=1; i<6; i++) {
            users.add(
                    new User(
                            Long.parseLong(String.valueOf(i)),
                            "user" + i,
                            "123",
                            "Nguyễn Đình Huân " + i
                    )
            );
        }
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Store.users = users;
    }
}
