package com.testspringcloudeurekafeginclient.eurekafeginclient.config.hystrixconfig;

import com.netflix.discovery.EurekaClientConfig;
import com.testspringcloudeurekafeginclient.eurekafeginclient.manager.TestManager;
import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class HihyStrix  implements TestManager {

    @Override
    public String getPort(@PathVariable("name") String name) {
        System.out.println("进入了请求一场的方法");
        return "获取信息异常！！！";
    }

    @Override
    public String saveUser(User user) {
        System.out.println("进入插入失败的方法");
        return "插入接口返回失败！！！";
    }
}
