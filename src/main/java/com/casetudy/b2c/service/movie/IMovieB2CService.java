package com.casetudy.b2c.service.movie;

import com.casetudy.admin.service.IGeneralService;
import com.casetudy.dto.MovieDto;

import java.util.List;

public interface IMovieB2CService extends IGeneralService<MovieDto> {
    List<MovieDto> findByNominate();
    List<MovieDto> findListNewMovieUpdateByDate();
    List<MovieDto> listMovieSingleNewUpdate();
    List<MovieDto> listMovieSerieNewUpdate();
    List<MovieDto> listAllMovieCinemaByNumberOne();
    List<MovieDto> findAllUpcomingMovie();
}
