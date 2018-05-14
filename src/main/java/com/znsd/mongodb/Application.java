package com.znsd.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*Spring-boot已经集成了tomcat，main函数被执行时，SpringApplication引导应用启动spring
        进�?�启动tomcat启动应用*/
        SpringApplication.run(Application.class, args);
    }
}
