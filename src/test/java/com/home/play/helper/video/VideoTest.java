package com.home.play.helper.video;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.play.helper.Exception.HomeException;

public class VideoTest {
    
    private static final String CATEGORY = "ACTION";
    private static final String ACTOR = "DANIEL CRAIG";
    private static final String TITLE = "NO TIME TO DIE";
    private static final String FORMAT = "mp4";

    VideoValidator validator;

    @BeforeEach
    void setUp() {
        validator = new VideoValidatorImpl();
    }

    @Test
    void create_validPath_Ok() {
        Video video = assertDoesNotThrow(() -> {
            return new Video(getValidPath(), validator);
        });
        assertThat(video.category.get(0)).isEqualTo(CATEGORY);
        assertThat(video.actor.get(0)).isEqualTo(ACTOR);
        assertThat(video.title).isEqualTo(TITLE);
        assertThat(video.format).isEqualTo(FORMAT);
    }

    @Test
    void create_invalidPath_HomeException() {
        assertThrows(HomeException.class, () -> {
            new Video(getInvalidPath(), validator);
        });
    }

    private String getValidPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CATEGORY);
        stringBuilder.append("-");
        stringBuilder.append(ACTOR);
        stringBuilder.append("-");
        stringBuilder.append(TITLE);
        stringBuilder.append(".");
        stringBuilder.append(FORMAT);
        return stringBuilder.toString();
    }

    private String getInvalidPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CATEGORY);
        stringBuilder.append(ACTOR);
        stringBuilder.append(TITLE);
        stringBuilder.append(".");
        stringBuilder.append(FORMAT);
        return stringBuilder.toString();
    }
}
