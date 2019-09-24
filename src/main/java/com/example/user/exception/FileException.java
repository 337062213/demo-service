 package com.example.user.exception;

 public class FileException extends RuntimeException{
     /**
     *
     */
    private static final long serialVersionUID = -3869393841156967243L;

    public FileException(String message) {
       super(message);
    }
    
    public FileException(String message, Throwable cause) {
       super(message, cause);
    }
}
