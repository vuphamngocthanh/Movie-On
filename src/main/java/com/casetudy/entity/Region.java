package com.casetudy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(targetEntity = Movie.class)
    private List<Movie> movies;
    private String name;
    private String slug;

    public Region() {
    }

    public Region(List<Movie> movies, String name, String slug) {
        this.movies = movies;
        this.name = name;
        this.slug = slug;
    }

    public Region(Integer id, List<Movie> movies, String name, String slug) {
        this.id = id;
        this.movies = movies;
        this.name = name;
        this.slug = slug;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
