package com.home.play.api.login.helper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = LoginRequest.Builder.class)
public class LoginRequest {
    
    private final String name;
    private final String password;

    private LoginRequest(String name, String password) {
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

        public static LoginRequest.Builder newBuilder() {
            return new LoginRequest.Builder();
        }

        public LoginRequest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public LoginRequest.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(
                name,
                password);
        }
    }
}
