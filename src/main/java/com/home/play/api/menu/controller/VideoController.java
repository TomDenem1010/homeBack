package com.home.play.api.menu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.play.api.menu.helper.VideoFilters;
import com.home.play.api.menu.helper.VideoResponse;
import com.home.play.api.menu.service.VideoService;

@RestController
public class VideoController {

    private VideoService videoService;
    
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/api/videos")
    public VideoResponse getVideos() {
        return videoService.getVideos();
    }

    @PostMapping("/api/videos/filtered")
    public VideoResponse getVideosFiltered(@RequestBody VideoFilters filter) {
        return videoService.getVideosFiltered(filter);
    }
}
