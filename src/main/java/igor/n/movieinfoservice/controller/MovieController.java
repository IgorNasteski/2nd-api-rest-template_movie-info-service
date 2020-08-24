package igor.n.movieinfoservice.controller;

import igor.n.movieinfoservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId")String movieId){
        Movie movie = new Movie(movieId, "nekiFilmIzMovie-info-service");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieId().equalsIgnoreCase(movieId)){
                return movies.get(i);
            }
        }

        return null;
    }

    Movie movie1 = new Movie("1", "Lord Of The Rings");
    Movie movie2 = new Movie("2", "Harry Potter 1");
    Movie movie3 = new Movie("3", "Harry Potter 2");
    Movie movie4 = new Movie("4", "Harry Potter 3");
    Movie movie5 = new Movie("5", "Harry Potter 4");

    List<Movie> movies = new ArrayList<>();

}
