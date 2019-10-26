package com.wagdynavas.wnmoviecatalogservice.resources;

import com.wagdynavas.wnmoviecatalogservice.models.CatalogItem;
import com.wagdynavas.wnmoviecatalogservice.models.Movie;
import com.wagdynavas.wnmoviecatalogservice.models.Rating;
import com.wagdynavas.wnmoviecatalogservice.models.UserRating;
import com.wagdynavas.wnmoviecatalogservice.service.MovieService;
import com.wagdynavas.wnmoviecatalogservice.service.UserRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRatingService userRatingService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingService.getUserRating(userId);
        List<Rating> ratings = userRating.getUserRating();

        return ratings.stream().map(rating -> {
            //Movie movie = restTemplate.getForObject("http://localhost:8081/movies/info/" + rating.getMovieId(), Movie.class);
            Movie movie = movieService.getMovieInfo(rating.getMovieId());
            return new CatalogItem(movie.getTitle(), movie.getOverview(), rating.getRate());

            }
        ).collect(Collectors.toList());
    }

}
