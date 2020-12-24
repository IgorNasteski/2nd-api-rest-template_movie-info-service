package igor.n.movieinfoservice.controller;

import igor.n.movieinfoservice.model.Movie;
import igor.n.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/{movieId}")
    public Movie getMovies(@PathVariable("movieId")String movieId){

        //zovem spoljni free api: na sajtu "https://api.themoviedb.org" sam se registrovao i onda dobio "api_key" bez kog ne daju da
        //se posalje restTemplate request ka njima(smestio sam ga u application.properties fajl  i ovde ga pozivam)
        //takodje, morao sam da napravim novu klasu "MovieSummary", da bih u njoj smestio one podatke koji mi trebaju(id,title,overview)
        //pa onda te podatke iskoristim da setujem objekat "Movie" i da ga onda vratim na api "movie-catalog-service" jer odatle gadjam ovaj endpoint
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +
                                                                            "?api_key=" + apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }

}
