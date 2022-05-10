package com.home.play.api.login.helper;

import java.sql.Timestamp;

public class LoginResponse {
    
    private final String name;
    private final String password;
    private final Timestamp start;
    private final Timestamp end;
    private final String message;

    private LoginResponse(String name, String password, Timestamp start, Timestamp end, String message) {
        this.name = name;
        this.password = password;
        this.start = start;
        this.end = end;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getStart() {
        return start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public String getMessage() {
        return message;
    }

    public static class Builder {

        private String name;
        private String password;
        private Timestamp start;
        private Timestamp end;
        private String message;

        public static LoginResponse.Builder newBuilder() {
            return new LoginResponse.Builder();
        }

        public LoginResponse.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public LoginResponse.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginResponse.Builder withStart(Timestamp start) {
            this.start = start;
            return this;
        }

        public LoginResponse.Builder withEnd(Timestamp end) {
            this.end = end;
            return this;
        }

        public LoginResponse.Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public LoginResponse build() {
            return new LoginResponse(
                name,
                password,
                start,
                end,
                message);
        }
    }
}
