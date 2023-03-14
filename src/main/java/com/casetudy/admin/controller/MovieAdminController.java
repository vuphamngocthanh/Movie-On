package com.casetudy.admin.controller;

import com.casetudy.admin.service.Impl.category.ICategoryService;
import com.casetudy.admin.service.Impl.episode.IEpisodeService;
import com.casetudy.admin.service.Impl.movie.IMovieService;
import com.casetudy.admin.service.Impl.region.IRegionService;
import com.casetudy.dto.CategoryDto;
import com.casetudy.dto.EpisodeDto;
import com.casetudy.dto.MovieDto;
import com.casetudy.dto.RegionDto;
import com.casetudy.entity.Episode;
import com.casetudy.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin-movie")
public class MovieAdminController {
    private final ModelMapper modelMapper;
    private final IEpisodeService episodeService;
    private final IMovieService movieService;
    private final ICategoryService categoryService;
    private final IRegionService regionService;

    public MovieAdminController(IEpisodeService episodeService, IMovieService movieService
            , ICategoryService categoryService, IRegionService regionService, ModelMapper modelMapper) {
        this.episodeService = episodeService;
        this.movieService = movieService;
        this.categoryService = categoryService;
        this.regionService = regionService;
        this.modelMapper = modelMapper;
    }
    @ModelAttribute("categories")
    public Iterable<CategoryDto> categories(){
        return categoryService.findAll();
    }
    @ModelAttribute("episodes")
    public Iterable<EpisodeDto> episodes(){
        return episodeService.findAll();
    }
    @ModelAttribute("regions")
    public Iterable<RegionDto> regions(){
        return regionService.findAll();
    }

    @GetMapping("/dashboard")
    public ModelAndView dashBoard(){
        return new ModelAndView("admin/home/index");
    }
    @GetMapping("/list-movie")
    public ModelAndView movieMain(){
        String keyword = null;
        return showListMovie(1 ,keyword);
    }
    @GetMapping("/list-movie-page-{pageNum}")
    public ModelAndView showListMovie(@PathVariable(value = "pageNum")Integer pageNum,
                                      @Param(value = "keyword") String keyword){
        ModelAndView modelAndView = new ModelAndView("admin/movie/list");
        Page<Movie> page = movieService.pageAll(keyword,pageNum);
        List<Movie> movieList = page.getContent();
        modelAndView.addObject("movies",movieList);
        modelAndView.addObject("currentPage",pageNum);
        modelAndView.addObject("keyword",keyword);
        modelAndView.addObject("totalPages",page.getTotalPages());
        modelAndView.addObject("totalItems",page.getTotalElements());
        return modelAndView;
    }
    @GetMapping("/list-movie/create")
    public String createMovie(Model model){
        MovieDto movieDto = new MovieDto();
        for(int i = 0;i < 4; i++){
            movieDto.addEpisode(new Episode());
        }
        model.addAttribute("movie",movieDto);
        return "admin/movie/create";
    }
    @PostMapping("/list-movie/save")
    public ModelAndView saveMovie(MovieDto movieDto){
        Movie movie = modelMapper.map(movieDto, Movie.class);
        for(Episode e:movie.getEpisodes()){
            e.setMovies(movie);
        }
        movie.setEpisodes(movie.getEpisodes());
        movieService.save(movie);
        return new ModelAndView("redirect:/admin-movie/list-movie");
    }
//    @PostMapping("/list-movie/save")
//    public ModelAndView saveMovie(MovieDto movieDto,EpisodeDto episodeDto){
//        Episode episode = modelMapper.map(episodeDto,Episode.class);
//        Movie movie = modelMapper.map(movieDto, Movie.class);
//        episode.setMovies(movie);
//        movie.setEpisodes(Collections.singleton(episode));
//        movieService.save(movie);
//        return new ModelAndView("redirect:/admin-movie/list-movie");
//    }
    @GetMapping("/list-movie/edit-{id}")
    public ModelAndView editMovie(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/movie/edit");
        modelAndView.addObject("movie", movieService.findById(id));
        return modelAndView;
    }
    @PostMapping("/list-movie/edit")
    public ModelAndView saveEditMovie(MovieDto movieDto){
        movieService.save(movieDto);
        return new ModelAndView("redirect:/admin-movie/list-movie");
    }
    @GetMapping("/list-movie/delete-{id}")
    public ModelAndView delete(@PathVariable(value = "id") Integer id){
        movieService.remove(id);
        return new ModelAndView("admin/movie/list");
    }
    @GetMapping("/list-movie/info-{id}")
    public ModelAndView showInfo(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/movie/info");
        modelAndView.addObject("movie",movieService.findById(id));
        return modelAndView;
    }
}
