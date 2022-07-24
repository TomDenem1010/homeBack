package com.home.play.api.menu.helper;

public class VideoFilter {

    public final String filterKey;
    public final String filterValue;

    public VideoFilter(String filterKey, String filterValue) {
        this.filterKey = filterKey;
        this.filterValue = filterValue;
    }

    public VideoFilter() {
        this.filterKey = null;
        this.filterValue = null;
    }

    public static class Builder {

        private String filterKey;
        private String filterValue;

        public static VideoFilter.Builder newBuilder() {
            return new VideoFilter.Builder();
        }

        public VideoFilter.Builder withFilterKey(String filterKey) {
            this.filterKey = filterKey;
            return this;
        }

        public VideoFilter.Builder withFilterValue(String filterValue) {
            this.filterValue = filterValue;
            return this;
        }

        public VideoFilter build() {
            return new VideoFilter(
                filterKey,
                filterValue);
        }
    }
}
