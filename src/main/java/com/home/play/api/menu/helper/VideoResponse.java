package com.home.play.api.menu.helper;

import java.util.List;

import com.home.play.helper.video.Video;

public class VideoResponse {

    public final String pathPrefix;    
    public final List<Video> videos;

    public VideoResponse(String pathPrefix, List<Video> videos) {
        this.pathPrefix = pathPrefix;
        this.videos = videos;
    }
}
