package com.casetudy.dto;

import com.casetudy.entity.Movie;

public class EpisodeDto {
    private Integer id;
    private Movie movies;
    private String server;
    private String nameEpisode;
    private String slug;
    private String link;

    public EpisodeDto() {
    }

    public EpisodeDto(Movie movies, String server, String nameEpisode, String slug, String link) {
        this.movies = movies;
        this.server = server;
        this.nameEpisode = nameEpisode;
        this.slug = slug;
        this.link = link;
    }

    public EpisodeDto(Integer id, Movie movies, String server, String nameEpisode, String slug, String link) {
        this.id = id;
        this.movies = movies;
        this.server = server;
        this.nameEpisode = nameEpisode;
        this.slug = slug;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovies() {
        return movies;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getNameEpisode() {
        return nameEpisode;
    }

    public void setNameEpisode(String nameEpisode) {
        this.nameEpisode = nameEpisode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
