package com.wagdynavas.wnmoviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WnMovieCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WnMovieCatalogServiceApplication.class, args);
    }

}
