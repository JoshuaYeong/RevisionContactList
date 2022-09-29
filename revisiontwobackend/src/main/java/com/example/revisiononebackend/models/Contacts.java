package com.example.revisiononebackend.models;

import java.util.List;

import lombok.Data;

@Data
public class Contacts {

    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
}
