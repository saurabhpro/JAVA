package com.saurabh.moustachedemo.models;

import lombok.Data;

@Data
public class Article {
    private String title;
    private String body;
    private String author;
    private String publishDate;
}