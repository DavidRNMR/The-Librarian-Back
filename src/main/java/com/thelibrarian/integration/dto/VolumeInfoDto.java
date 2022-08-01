package com.thelibrarian.integration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfoDto {
    private String title;
    private String[] authors;
    private String publishedDate;
    private String description;
    private Map<String, String> imageLinks;
    private int pageCount;
    private String[] categories;
    private String language;
    private Map<String, String>[] industryIdentifiers;
}
