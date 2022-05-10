package com.home.play.api.menu.helper;

public class MenuResponseDto {

    private final long id;
    private final String name;
    private final String path;
    private final int order;

    private MenuResponseDto(long id, String name, String path, int order) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public int getOrder() {
        return order;
    }

    public static class Builder {

        private long id;
        private String name;
        private String path;
        private int order;

        public static MenuResponseDto.Builder newBuilder() {
            return new MenuResponseDto.Builder();
        }

        public MenuResponseDto.Builder withId(long id) {
            this.id = id;
            return this;
        }

        public MenuResponseDto.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public MenuResponseDto.Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public MenuResponseDto.Builder withOrder(int order) {
            this.order = order;
            return this;
        }

        public MenuResponseDto build() {
            return new MenuResponseDto(
                    id,
                    name,
                    path,
                    order);
        }
    }
}
