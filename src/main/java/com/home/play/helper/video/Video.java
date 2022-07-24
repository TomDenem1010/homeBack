package com.home.play.helper.video;

import java.util.List;

public class Video {
    
    public final List<String> category;
    public final List<String> actor;
    public final String title;
    public final String format;
    public final String path;

    /*
     * Path needs to be like this:
     * "CATEGORY & CATEGORY - ACTOR & ACTOR - NAME.mp4"
     */
    public Video(String path, VideoValidator validator) {
        String content = getContent(path);
        List<String> parts = getPartsByDelimiter(content, "-", validator);

        this.category = getPartsByDelimiter(parts.get(0), "&");
        this.actor = getPartsByDelimiter(parts.get(1), "&");
        this.title = parts.get(2).trim();
        this.format = getFormat(path);
        this.path = path;
    }

    private String getFormat(String path) {
        return path.split("\\.")[1];
    }

    private String getContent(String path) {
        return path.split("\\.")[0];
    }

    private List<String> getPartsByDelimiter(String path, String delimiter) {
        List<String> parts = List.of(path.split(delimiter));

        return parts;
    }

    private List<String> getPartsByDelimiter(String path, String delimiter, VideoValidator validator) {
        List<String> parts = List.of(path.split(delimiter));
        validator.validate(parts);

        return parts;
    }
}
