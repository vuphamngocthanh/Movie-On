package com.casetudy.b2c.service.movie;

import com.casetudy.dto.MovieDto;
import com.casetudy.entity.Movie;
import com.casetudy.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieB2CService implements IMovieB2CService{
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    public MovieB2CService(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<MovieDto> findAll() {
        return null;
    }

    @Override
    public MovieDto findById(Integer id) {
        return null;
    }

    @Override
    public void save(MovieDto movieDto) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public List<MovieDto> findByNominate() {
        List<Movie> movies = movieRepository.findMovieByNominate();
        return movies.parallelStream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<MovieDto> listMovieSingleNewUpdate() {
        List<Movie> movieListSingle = movieRepository.getAllSingleByCreatedAt();
                return movieListSingle.parallelStream()
                        .map(movie -> modelMapper.map(movie,MovieDto.class))
                        .collect(Collectors.toList());
    }
    @Override
    public List<MovieDto> listMovieSerieNewUpdate() {
        List<Movie> movieListSeries = movieRepository.getAllSeriesByCreatedAt();
        return movieListSeries.parallelStream()
                .map(movie -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<MovieDto> listAllMovieCinemaByNumberOne() {
        List<Movie> movieCinemaList = movieRepository.getAllByMovieCinemaByNumberOne();
        return movieCinemaList.parallelStream()
                .map(movie -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findAllUpcomingMovie() {
        List<Movie> movieListUpComingMovie = movieRepository.findAllUpcomingMovie();
        return movieListUpComingMovie.parallelStream()
                .map(movie -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findListNewMovieUpdateByDate() {
        List<Movie> movieList = movieRepository.findListNewMovieByDateUpdate();
        return movieList.parallelStream()
                .map(movie -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }
}
