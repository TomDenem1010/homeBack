package com.home.play.api.menu.helper;

import java.util.List;

public class VideoFilters {
    
    public final List<VideoFilter> videoFilters;

    public VideoFilters(List<VideoFilter> videoFilters) {
        this.videoFilters = videoFilters;
    }

    public VideoFilters() {
        this.videoFilters = List.of();
    }
}
