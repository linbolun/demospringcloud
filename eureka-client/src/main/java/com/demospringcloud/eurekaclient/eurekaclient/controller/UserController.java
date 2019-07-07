package com.demospringcloud.eurekaclient.eurekaclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.demospringcloud.eurekaclient.eurekaclient.pojo.User;
import com.demospringcloud.eurekaclient.eurekaclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PutMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private String saveUser(@RequestBody User user) throws InterruptedException {
        logger.info("传过来的对象为：{}",user.toString());
        int result = userService.saveUser(user);
        Map<String, String> resultMap = new HashMap<String,String>();
        if(result==0){
            resultMap.put("error","error");
            resultMap.put("errorcode","0");
            resultMap.put("data","插入失败");
        }else{
            resultMap.put("error","success");
            resultMap.put("errorcode","1");
            resultMap.put("data","插入成功");
        }
        String jsonResult = JSONObject.toJSONString(resultMap);
        return jsonResult;
    }
}
