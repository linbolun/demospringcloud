package com.testspringcloudeurekafeginclient.eurekafeginclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import java.util.concurrent.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@MapperScan("com.testspringcloudeurekafeginclient.eurekafeginclient.mapper")
public class EurekaFeginClientApplication {

    private static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"fegin-"+r.hashCode());
        }
    };

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 2,
            1000, TimeUnit.MILLISECONDS,
             new ArrayBlockingQueue<Runnable>(10),
             threadFactory,
             new ThreadPoolExecutor.AbortPolicy()
            );

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeginClientApplication.class, args);
    }

}
