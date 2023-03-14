package com.casetudy.admin.service.Impl.movie;

import com.casetudy.dto.MovieDto;
import com.casetudy.entity.Movie;
import com.casetudy.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    public MovieService(MovieRepository movieRepository,
                        ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Page<Movie> pageAll(String keyword,Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum -1 , 2);
        if (keyword != null){
            return movieRepository.pageAll(keyword,pageable);
        }
        return movieRepository.findAll(pageable);
    }

    @Override
    public Iterable<MovieDto> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.parallelStream()
                .map(movie -> modelMapper.map(movie, MovieDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public MovieDto findById(Integer id) {
        Movie movie = movieRepository.findById(id).get();
        return modelMapper.map(movie,MovieDto.class);
    }
    @Override
    public void save(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto,Movie.class);
        movieRepository.save(movie);
    }
    @Override
    public void save(Movie movie) {
        movieRepository.saveAndFlush(movie);
    }

    @Override
    public void remove(Integer id) {
        movieRepository.deleteById(id);
    }

}
