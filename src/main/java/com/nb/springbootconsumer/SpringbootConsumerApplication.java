package com.nb.springbootconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumerApplication.class, args);
        System.out.println("rabbitMq消费者启动成功");
    }

}
