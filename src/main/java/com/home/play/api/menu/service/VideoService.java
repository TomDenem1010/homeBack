package com.home.play.api.menu.service;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.play.api.menu.helper.VideoFilter;
import com.home.play.api.menu.helper.VideoFilters;
import com.home.play.api.menu.helper.VideoResponse;
import com.home.play.helper.video.Video;
import com.home.play.helper.video.VideoValidatorImpl;

@Service
public class VideoService {

    private String path = "C:\\Users\\User\\Videos\\Funny\\Family";
    private ObjectMapper objectMapper = new ObjectMapper();
    private VideoValidatorImpl validator;

    public VideoService(
        VideoValidatorImpl validator
    ) {
        this.validator = validator;
    }

    public VideoResponse getVideos() {     
        return new VideoResponse(path,getNamesFromFolder(new VideoFilters()));
    }

    public VideoResponse getVideosFiltered(VideoFilters filters) {     
        return new VideoResponse(path,getNamesFromFolder(filters));
    }
    
    private List<Video> getNamesFromFolder(VideoFilters filters) {
        List<Video> videos = new ArrayList<>();
        File[] files = new File(path).listFiles();

        for(File file : files) {
            if(file.isFile()) {
                Video video = new Video(file.getName(), validator);

                if(filters.videoFilters.isEmpty() || isFilterable(filters, video)) {
                    videos.add(new Video(file.getName(), validator));
                }
            }
        }

        return videos;
    }

    private Boolean isFilterable(VideoFilters filters, Video video) {
        Boolean isFilterableVideo = true;

        for(VideoFilter filter : filters.videoFilters) {
            try {
                Field field = video.getClass().getField(filter.filterKey);
                String stringifiedField = objectMapper.writeValueAsString(field.get(video));

                if(!stringifiedField.contains(filter.filterValue)) {
                    isFilterableVideo = false;
                    break;
                }
            } catch (Exception exception) {
                isFilterableVideo = false;
            }
        }

        return isFilterableVideo;
    }
}
