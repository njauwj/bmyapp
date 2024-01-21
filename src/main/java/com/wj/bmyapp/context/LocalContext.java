package com.wj.bmyapp.context;

import com.wj.bmyapp.domain.User;

/**
 * @author wj
 * @create_time 2024/1/21
 * @description
 */
public class LocalContext {

    private final static ThreadLocal<User> threadLocal = new ThreadLocal<>();


    public static void setUser(User user) {
        threadLocal.set(user);
    }

    public static User getUser() {
        return threadLocal.get();
    }
}
