package com.casetudy.dto;

import com.casetudy.entity.Category;
import com.casetudy.entity.Episode;
import com.casetudy.entity.Region;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class MovieDto {
    private Integer id;
    private String name;
    private String originName;
    private String thumbUrl;
    private String content;
    private String notes;
    private String movieSchedule;
    private String movieTrailer;
    private String episodeDuration;
    private String currentEpisode;
    private String totalEpisode;
    private String movieLang;
    private String quality;
    private String publishYear;
    private Integer movie_nominate;
    private String movie_slug;
    private String movieCinema;
    private Integer view;
    private Set<Category> categories ;
    private Collection<Episode> episodes = new ArrayList<>();
    private Region region;

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }
    public MovieDto() {
    }

    public MovieDto(Integer view) {
        this.view = view;
    }

    public MovieDto(String name, String originName, String thumbUrl, String content, String notes, String movieSchedule, String movieTrailer,
                    String episodeDuration, String currentEpisode, String totalEpisode, String movieLang, String quality, String publishYear,
                    Integer movie_nominate, String movie_slug, String movieCinema, Integer view, Set<Category> categories, Collection<Episode> episodes, Region region) {
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
        this.movieCinema = movieCinema;
        this.view = view;
        this.categories = categories;
        this.episodes = episodes;
        this.region = region;
    }

    public MovieDto(Integer id, String name, String originName, String thumbUrl, String content, String notes, String movieSchedule, String movieTrailer,
                    String episodeDuration, String currentEpisode, String totalEpisode, String movieLang, String quality, String publishYear, Integer movie_nominate,
                    String movie_slug, String movieCinema, Integer view, Set<Category> categories, Collection<Episode> episodes, Region region) {
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
        this.movieCinema = movieCinema;
        this.view = view;
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

    public String getMovieCinema() {
        return movieCinema;
    }

    public void setMovieCinema(String movieCinema) {
        this.movieCinema = movieCinema;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }
    public Integer increment() {
        return view++;
    }
}
