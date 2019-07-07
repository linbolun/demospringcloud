package com.testspringcloudeurekafeginclient.eurekafeginclient.manager;


import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client")
public interface TestManager {

    @GetMapping("/hello/{name}")
    String getPort(@PathVariable("name") String name);


    @PutMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String saveUser(@RequestBody User user);

}
