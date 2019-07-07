package com.testspringcloudeurekafeginclient.eurekafeginclient.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.testspringcloudeurekafeginclient.eurekafeginclient.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/hi")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    TestService testService;

    @GetMapping("/{name}")

    private String getPort(@PathVariable("name") String name){
       String result = testService.getPort(name);
        Map<String,String> resultMap = new TreeMap<String,String>();
        resultMap.put("errorCode","1");
        resultMap.put("name",applicationName);
        resultMap.put("data",result);
        String resultJson = JSONObject.toJSONString(resultMap);
        logger.info("返回的json为："+resultJson);
        return resultJson;
    }
}
