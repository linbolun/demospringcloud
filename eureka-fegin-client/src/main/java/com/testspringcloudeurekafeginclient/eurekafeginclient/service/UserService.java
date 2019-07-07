package com.testspringcloudeurekafeginclient.eurekafeginclient.service;

import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);

    List<User> listUserAll();

    String getPort(String name);
}
