package com.testspringcloudeurekafeginclient.eurekafeginclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;
import com.testspringcloudeurekafeginclient.eurekafeginclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PutMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String saveUser(@RequestBody User user){
        user.setInsertTime(new Date());
        System.out.println("接收到的user为："+user.toString());
        int result = userService.insertUser(user);
        Map<String,String> resultMap = new HashMap<String,String>(4);
        resultMap.put("errorCode","1");
        resultMap.put("error","请求成功");
        resultMap.put("data",result==1?"插入成功":"插入失败");
        String jsonResult = JSONObject.toJSONString(resultMap);
        logger.info("fegin服务返回："+jsonResult);
        return jsonResult;
    }

    @GetMapping("")
    private String listUserAll(){
        //这里调用了service的方法//现在应该走熔断器了
        //List<User> userList = userService.listUserAll();
        String userList = userService.getPort("linbolun");
        Map<String,Object> resultMap = new HashMap<String,Object>(4);
        resultMap.put("errorCode","1");
        resultMap.put("error","请求成功");
        resultMap.put("data",userList);
        String jsonResult = JSONObject.toJSONString(resultMap);
        return jsonResult;
    }
}
