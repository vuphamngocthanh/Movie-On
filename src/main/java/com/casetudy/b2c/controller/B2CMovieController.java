package com.casetudy.b2c.controller;

import com.casetudy.b2c.service.episode.IEpisodeB2CService;
import com.casetudy.b2c.service.movie.IMovieB2CService;
import com.casetudy.dto.Counter;
import com.casetudy.dto.EpisodeDto;
import com.casetudy.dto.MovieDto;
import com.casetudy.entity.Movie;
import com.casetudy.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("counter")
public class B2CMovieController {
    private final IEpisodeB2CService episodeB2CService;
    private final IMovieB2CService movieB2CService;
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }
    @Autowired
    private MovieRepository movieRepository;
    public B2CMovieController(IEpisodeB2CService episodeB2CService, IMovieB2CService movieB2CService) {
        this.episodeB2CService = episodeB2CService;
        this.movieB2CService = movieB2CService;
    }
//    @GetMapping("/")
//    public String index(){
//        return "client/index";
//    }
    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("client/index");
        modelAndView.addObject("listSingleNew",movieB2CService.listMovieSingleNewUpdate());
        modelAndView.addObject("listSeriesNew",movieB2CService.listMovieSerieNewUpdate());
        modelAndView.addObject("nominates",movieRepository.findMovieByNominate());
        modelAndView.addObject("listUpComing",movieB2CService.findAllUpcomingMovie());
        modelAndView.addObject("movieCinemaList",movieB2CService.listAllMovieCinemaByNumberOne());
        modelAndView.addObject("episodes",episodeB2CService .findAll());
        return modelAndView;
    }
    @GetMapping("/phim/{name}-{id}")
    public ModelAndView infoMovie(@PathVariable(value = "id") Integer id,
                                  @ModelAttribute("counter") Counter counter){
        ModelAndView modelAndView = new ModelAndView("client/info");
        modelAndView.addObject("listUpComing",movieB2CService.findAllUpcomingMovie());
        modelAndView.addObject("episode",episodeB2CService.findById(id));
        EpisodeDto episodeDto = episodeB2CService.findById(id);
        Movie movie = episodeDto.getMovies();
        movie.setView(counter.increment());
        movieRepository.save(movie);
        return modelAndView;
    }
    @GetMapping("/{name}-{slug}-{id}")
    public ModelAndView watchMovie(@PathVariable(value = "id") Integer id,
                                   @ModelAttribute("counter") Counter counter){
        ModelAndView modelAndView = new ModelAndView("client/watch");
        modelAndView.addObject("listUpComing",movieB2CService.findAllUpcomingMovie());
        modelAndView.addObject("episode",episodeB2CService.findById(id));
        EpisodeDto episodeDto = episodeB2CService.findById(id);
        Movie movie = episodeDto.getMovies();
        movie.setView(counter.increment());
        movieRepository.save(movie);
        return modelAndView;
    }
    @GetMapping("danh-sach/phim-moi")
    public ModelAndView showListNewMovie(){
        ModelAndView modelAndView = new ModelAndView("client/new-movie");
        modelAndView.addObject("listUpComing",movieB2CService.findAllUpcomingMovie());
        modelAndView.addObject("newMovies",movieB2CService.findListNewMovieUpdateByDate());
        return modelAndView;
    }

}
