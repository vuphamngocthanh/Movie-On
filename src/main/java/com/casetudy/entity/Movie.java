package com.casetudy.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "movies")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "origin_name")
    private String originName;
    @Column(name = "thumb_url")
    private String thumbUrl;
    @Column(name = "content")
    private String content;
    @Column(name = "notes")
    private String notes;
    @Column(name = "movie_Schedule")
    private String movieSchedule;
    @Column(name = "movie_Trailer")
    private String movieTrailer;
    @Column(name = "episode_Duration")
    private String episodeDuration;
    @Column(name = "current_Episode")
    private String currentEpisode;
    @Column(name = "total_Episode")
    private String totalEpisode;
    @Column(name = "movie_Lang")
    private String movieLang;
    @Column(name = "quality")
    private String quality;
    @Column(name = "publish_Year")
    private String publishYear;
    @Column(name = "movie_nominate")
    private Integer movie_nominate;
    @Column(name = "movie_slug")
    private String movie_slug;
    @Column(name = "view")
    private Integer view;
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "movie_cinema")
    private String movieCinema;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movies_categories",
            joinColumns = @JoinColumn(name = "movies_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Category> categories;
    @OneToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private Collection<Episode> episodes;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public Movie() {
    }

    public Movie(String name, String originName, String thumbUrl, String content, String notes, String movieSchedule, String movieTrailer,
                 String episodeDuration, String currentEpisode, String totalEpisode, String movieLang, String quality, String publishYear,
                 Integer movie_nominate, String movie_slug, Integer view, Timestamp createdAt, String movieCinema, Set<Category> categories,
                 Collection<Episode> episodes, Region region) {
        this.name = name;
        this.originName = originName;
        this.thumbUrl = thumbUrl;
        this.content = content;
        this.notes = notes;
        this.movieSchedule = movieSchedule;
        this.movieTrailer = movieTrailer;
        this.episodeDuration = episodeDuration;
        this.currentEpisode = currentEpisode;
        this.totalEpisode = totalEpisode;
        this.movieLang = movieLang;
        this.quality = quality;
        this.publishYear = publishYear;
        this.movie_nominate = movie_nominate;
        this.movie_slug = movie_slug;
        this.view = view;
        this.createdAt = createdAt;
        this.movieCinema = movieCinema;
        this.categories = categories;
        this.episodes = episodes;
        this.region = region;
    }

    public Movie(Integer id, String name, String originName, String thumbUrl, String content, String notes, String movieSchedule
            , String movieTrailer, String episodeDuration, String currentEpisode, String totalEpisode, String movieLang, String quality
            , String publishYear, Integer movie_nominate, String movie_slug, Integer view, Timestamp createdAt, String movieCinema
            , Set<Category> categories, Collection<Episode> episodes, Region region) {
        this.id = id;
        this.name = name;
        this.originName = originName;
        this.thumbUrl = thumbUrl;
        this.content = content;
        this.notes = notes;
        this.movieSchedule = movieSchedule;
        this.movieTrailer = movieTrailer;
        this.episodeDuration = episodeDuration;
        this.currentEpisode = currentEpisode;
        this.totalEpisode = totalEpisode;
        this.movieLang = movieLang;
        this.quality = quality;
        this.publishYear = publishYear;
        this.movie_nominate = movie_nominate;
        this.movie_slug = movie_slug;
        this.view = view;
        this.createdAt = createdAt;
        this.movieCinema = movieCinema;
        this.categories = categories;
        this.episodes = episodes;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMovieSchedule() {
        return movieSchedule;
    }

    public void setMovieSchedule(String movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(String episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    public String getCurrentEpisode() {
        return currentEpisode;
    }

    public void setCurrentEpisode(String currentEpisode) {
        this.currentEpisode = currentEpisode;
    }

    public String getTotalEpisode() {
        return totalEpisode;
    }

    public void setTotalEpisode(String totalEpisode) {
        this.totalEpisode = totalEpisode;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getMovie_nominate() {
        return movie_nominate;
    }

    public void setMovie_nominate(Integer movie_nominate) {
        this.movie_nominate = movie_nominate;
    }

    public String getMovie_slug() {
        return movie_slug;
    }

    public void setMovie_slug(String movie_slug) {
        this.movie_slug = movie_slug;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getMovieCinema() {
        return movieCinema;
    }

    public void setMovieCinema(String movieCinema) {
        this.movieCinema = movieCinema;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Collection<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Collection<Episode> episodes) {
        this.episodes = episodes;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

}
