package com.example.revisiononebackend.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Response {

    private String message = "";
    private Integer code = 0;
    private String data = "{}";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("message", message)
                .add("code", code)
                .add("data", data)
                .build();
    }

}
