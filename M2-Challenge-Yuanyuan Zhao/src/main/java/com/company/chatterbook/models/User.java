package com.company.chatterbook.models;

import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = chatterPosts;
    }

    public String getName() {
        return name;
    }

    public List<ChatterPost> getChatterPosts() {
        return chatterPosts;
    }
}
