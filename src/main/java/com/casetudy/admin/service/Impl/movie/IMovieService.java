package com.casetudy.admin.service.Impl.movie;

import com.casetudy.admin.service.IGeneralService;
import com.casetudy.dto.EpisodeDto;
import com.casetudy.dto.MovieDto;
import com.casetudy.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IMovieService extends IGeneralService<MovieDto> {
    void save(Movie movie);
    Page<Movie> pageAll(String keyword, Integer pageNum);

}
