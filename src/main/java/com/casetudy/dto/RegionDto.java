package com.casetudy.dto;

public class RegionDto {
    private Integer id;
    private String name;
    private String slug;

    public RegionDto() {
    }
    public RegionDto(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public RegionDto(Integer id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
