package com.vishav.usercrud.user.exception;

public class CustomException {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String username) {
            super("User not found with username " + username);
        }
    }

    public static class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String email) {
            super("User already exists with email " + email);
        }
    }
}
