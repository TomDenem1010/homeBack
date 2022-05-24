package com.home.play.api.logout.helper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LogoutRequest.Builder.class)
public class LogoutRequest  {
    
    private final String name;
    private final String password;

    private LogoutRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
    public static class Builder {

        private String name;
        private String password;

        public static LogoutRequest.Builder newBuilder() {
            return new LogoutRequest.Builder();
        }

        public LogoutRequest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public LogoutRequest.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public LogoutRequest build() {
            return new LogoutRequest(
                name,
                password);
        }
    }
}
