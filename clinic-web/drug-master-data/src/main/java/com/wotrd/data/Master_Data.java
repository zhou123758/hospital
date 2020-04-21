package com.wotrd.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableOAuth2Sso
@EnableSwagger2
@ComponentScan("com.wotrd")
public class Master_Data {
    public static void main(String[] args) {
        SpringApplication.run(Master_Data.class,args);
    }
}
