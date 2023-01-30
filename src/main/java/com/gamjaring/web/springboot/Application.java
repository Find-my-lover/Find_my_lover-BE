package com.gamjaring.web.springboot;

import com.gamjaring.web.springboot.filecontrol.MultipartUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Application {

    static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
    }
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }

}
