package com.casetudy.repository;

import com.casetudy.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query(value = "SELECT e FROM Movie e WHERE e.movie_nominate= 1")
    List<Movie> findMovieByNominate();
    @Query(nativeQuery = true,
            value = "select * from movies where total_episode = 'Full' order by created_at desc limit 8")
    List<Movie> getAllSingleByCreatedAt();
    @Query(nativeQuery = true,
            value = "select * from movies where total_episode != 'Full' order by created_at desc limit 8")
    List<Movie> getAllSeriesByCreatedAt();
    @Query(nativeQuery = true,
            value = "select * from movies where movie_cinema = 1 order by created_at desc limit 8")
    List<Movie> getAllByMovieCinemaByNumberOne();
    @Query(nativeQuery = true,
            value ="select * from movies order by created_at desc limit 32")
    List<Movie> findListNewMovieByDateUpdate();
    @Query(nativeQuery = true,
            value = "select * from movies where total_episode = 'null' ")
    List<Movie> findAllUpcomingMovie();
    @Query("select m from Movie m where concat(m.name,m.movie_slug) LIKE %?1%")
    Page<Movie> pageAll(String keyword, Pageable pageable);
}
