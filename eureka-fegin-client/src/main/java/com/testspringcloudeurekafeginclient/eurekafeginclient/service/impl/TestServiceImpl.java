package com.testspringcloudeurekafeginclient.eurekafeginclient.service.impl;

import com.testspringcloudeurekafeginclient.eurekafeginclient.manager.TestManager;
import com.testspringcloudeurekafeginclient.eurekafeginclient.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TestService")
public class TestServiceImpl implements TestService {

    @Autowired
    TestManager testManager;

    @Override
    public String getPort(String name) {

        return testManager.getPort(name);
    }
}
