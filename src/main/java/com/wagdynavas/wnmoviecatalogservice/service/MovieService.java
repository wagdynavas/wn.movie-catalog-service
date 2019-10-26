package com.wagdynavas.wnmoviecatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wagdynavas.wnmoviecatalogservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieService {

    @Qualifier("getWebBuilder")
    @Autowired
    private WebClient.Builder webBuilder;


    @HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
    public Movie getMovieInfo(String movieId) {
        return  webBuilder.build().get()
                .uri("http://wn.movie-info-service/movies/info/" + movieId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
    }

    public Movie getFallbackMovieInfo(String movieId) {
        return new Movie(movieId, "Movie not found", "Movie not found");
    }
}
