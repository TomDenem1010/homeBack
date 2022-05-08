package com.home.play.api.helper;

public class MenuDto {

    private final long id;
    private final String name;
    private final String path;
    private final int order;

    private MenuDto(long id, String name, String path, int order) {
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

        public static MenuDto.Builder newBuilder() {
            return new MenuDto.Builder();
        }

        public MenuDto.Builder withId(long id) {
            this.id = id;
            return this;
        }

        public MenuDto.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public MenuDto.Builder withPath(String path) {
            this.path = path;
            return this;
        }

        public MenuDto.Builder withOrder(int order) {
            this.order = order;
            return this;
        }

        public MenuDto build() {
            return new MenuDto(
                    id,
                    name,
                    path,
                    order);
        }
    }
}
