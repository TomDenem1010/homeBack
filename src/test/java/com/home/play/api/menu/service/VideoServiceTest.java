package com.home.play.api.menu.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.play.api.menu.helper.VideoFilter;
import com.home.play.api.menu.helper.VideoResponse;
import com.home.play.helper.video.VideoValidatorImpl;

public class VideoServiceTest {
    
    private VideoValidatorImpl validator;
    private VideoService videoService;

    @BeforeEach
    void setUp() {
        validator = mock(VideoValidatorImpl.class);
        videoService = new VideoService(validator);
    }

    @Test
    void getVideos_FileNamesFine_Ok() {
        doNothing().when(validator).validate(any());
        assertThat(videoService.getVideos())
            .isNotNull()
            .isInstanceOf(VideoResponse.class);
    }
}
