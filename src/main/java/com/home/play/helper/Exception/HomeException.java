package com.home.play.helper.Exception;

public class HomeException extends RuntimeException {
    
    public HomeException() {
        super();
    }

    public HomeException(String message) {
        super(message);
    }

    public HomeException(Throwable cause) {
        super(cause);
    }

    public HomeException(String message, Throwable cause) {
        super(message, cause);
    }
}
