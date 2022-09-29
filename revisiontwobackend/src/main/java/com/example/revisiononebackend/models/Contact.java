package com.example.revisiononebackend.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.Data;

@Data
public class Contact {

    private String id;
    private String name;
    private String email;
    private String mobile;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public static Contact create(SqlRowSet rs) {
        Contact cont = new Contact();
        cont.setName(rs.getString("name"));
        cont.setEmail(rs.getString("email"));
        cont.setMobile(rs.getString("mobile"));
        return cont;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("name", name)
            .add("email", email)
            .add("mobile", mobile)
            .build();
    }
}
