package com.wagdynavas.wnmoviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wagdynavas.wnmoviecatalogservice.models.Rating;
import com.wagdynavas.wnmoviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
public class UserRatingService {

    @Qualifier("getWebBuilder")
    @Autowired
    private WebClient.Builder webBuilder;


    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
            commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "6"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public UserRating getUserRating(String userId) {
        return  webBuilder.build().get()
                .uri("http://wn.rating-data-service/rating/user/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();


    }



    public UserRating getFallbackUserRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating(Collections.singletonList(new Rating("0",0, userId)));
        return userRating;
    }

}
