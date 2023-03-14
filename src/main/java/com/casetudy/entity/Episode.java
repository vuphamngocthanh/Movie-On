package com.casetudy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movies;
    private String server;
    private String nameEpisode;
    private String slug;
    private String link;

    public Episode() {
    }

    public Episode(Movie movies, String server, String nameEpisode, String slug, String link) {
        this.movies = movies;
        this.server = server;
        this.nameEpisode = nameEpisode;
        this.slug = slug;
        this.link = link;
    }

    public Episode(Integer id, Movie movies, String server, String nameEpisode, String slug, String link) {
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
