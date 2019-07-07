package com.testspringcloudeurekafeginclient.eurekafeginclient.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.testspringcloudeurekafeginclient.eurekafeginclient.EurekaFeginClientApplication;
import com.testspringcloudeurekafeginclient.eurekafeginclient.manager.TestManager;
import com.testspringcloudeurekafeginclient.eurekafeginclient.mapper.UserMapper;
import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;
import com.testspringcloudeurekafeginclient.eurekafeginclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Resource
    TestManager testManager;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public int insertUser(User user) {
        int result = 1;
        rabbitTemplate.convertAndSend("hello", JSONObject.toJSONString(user));
        return result;
    }

    @Override
    public List<User> listUserAll() {
        List<User> resultList = userMapper.listUserAll();
        return resultList;
}


    @Override
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String getPort(String name) {
        //这个方法调用了eureka-client的服务，请求没有问题，关闭eueka-client服务 熔断器不走，后台直接报错
        String result = testManager.getPort("linbnolu");
        return result;
    }

    public String helloFallBack(String name){
        return "调用异常";
    }

}
