package org.generation.bestoftheyear.model;

public class Song {
    private int id;
    private String title;

    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
