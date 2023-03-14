package com.casetudy.repository;

import com.casetudy.entity.Episode;
import com.casetudy.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    @Query(nativeQuery = true,value = "select * from episodes where movie_id = :id")
    Episode findByReferenceId(@Param(value = "id")Integer id);
}
