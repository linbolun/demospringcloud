package com.demospringcloud.eurekadiscoveryclient.eurekadiscoveryclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{name}")
    private String getClient(@PathVariable("name") String name){
        return restTemplate.getForObject("http://eureka-client/hello/"+name,String.class);

    }
}
