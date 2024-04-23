package com.example.pppr.Firebase;

import java.util.List;

public class ContentData {
    private List<Content> contents;
    private String name;

    public ContentData(List<Content> contents, String name) {
        this.contents = contents;
        this.name = name;
    }


    public List<Content> getContents() {
        return contents;
    }

    public String getName() {
        return name;
    }
}

