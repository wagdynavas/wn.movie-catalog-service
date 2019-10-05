package com.wagdynavas.wnmoviecatalogservice.resources;

import com.wagdynavas.wnmoviecatalogservice.models.CatalogItem;
import com.wagdynavas.wnmoviecatalogservice.models.Movie;
import com.wagdynavas.wnmoviecatalogservice.models.Rating;
import com.wagdynavas.wnmoviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("getWebBuilder")
    @Autowired
    private WebClient.Builder webBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {
        UserRating userRating = getUserRating(userId);
        List<Rating> ratings = userRating.getUserRating();

        return ratings.stream().map(rating -> {
            //Movie movie = restTemplate.getForObject("http://localhost:8081/movies/info/" + rating.getMovieId(), Movie.class);
            Movie movie = webBuilder.build().get()
                    .uri("http://wn.movie-info-service/movies/info/" + rating.getMovieId())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRate());

            }
        ).collect(Collectors.toList());
    }

    public UserRating getUserRating(String userId) {
        return  webBuilder.build().get()
                .uri("http://wn.rating-data-service/rating/user/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();


    }
}
