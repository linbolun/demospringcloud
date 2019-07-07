package com.demospringcloud.eurekaclient.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Value("${server.port}")
    private int port;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/{name}")
    private String getPort(@PathVariable("name") String name){
        return "my:"+name+",applicationName:"+applicationName+",port="+port;
    }
}
