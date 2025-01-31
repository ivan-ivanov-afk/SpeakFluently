package com.SpeakFluently.api.SpeakFluently.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppResponse {

    private static HashMap<String, Object> response;

    // Success response
    public static AppResponse success() {
        response = new HashMap<>();
        response.put("status", "success");
        response.put("code", HttpStatus.OK.value());
        return new AppResponse();
    }

    // Error response
    public static AppResponse error() {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.BAD_REQUEST.value());
        return new AppResponse();
    }


    public static AppResponse notFound(String resourceName) {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.NOT_FOUND.value());
        response.put("message", resourceName + " not found.");
        return new AppResponse();
    }


    public static AppResponse unauthorized() {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.UNAUTHORIZED.value());
        response.put("message", "Unauthorized access.");
        return new AppResponse();
    }


    public AppResponse withCode(HttpStatus code) {
        response.put("code", code.value());
        return this;
    }


    public AppResponse withMessage(String message) {
        response.put("message", message);
        return this;
    }


    public AppResponse withData(Object data) {
        response.put("data", data);
        return this;
    }


    public AppResponse withDataAsArray(List<?> data) {
        response.put("data", data);
        return this;
    }


    public ResponseEntity<Object> build() {
        int code = (int) response.get("code");
        return new ResponseEntity<>(response, HttpStatus.valueOf(code));
    }


    public static AppResponse duplicateEntry(String entryName) {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.CONFLICT.value());
        response.put("message", entryName + " already exists.");
        return new AppResponse();
    }

    public static AppResponse invalidInput(String fieldName) {
        response = new HashMap<>();
        response.put("status", "error");
        response.put("code", HttpStatus.UNPROCESSABLE_ENTITY.value());
        response.put("message", "Invalid input for field: " + fieldName);
        return new AppResponse();
    }
}
