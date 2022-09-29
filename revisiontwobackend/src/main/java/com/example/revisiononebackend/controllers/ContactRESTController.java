package com.example.revisiononebackend.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revisiononebackend.models.Contact;
import com.example.revisiononebackend.models.Contacts;
import com.example.revisiononebackend.services.ContactService;
import com.google.gson.Gson;

@RestController
@RequestMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactRESTController {

    @Autowired
    private ContactService contactSvc;

    private Logger logger = Logger.getLogger(ContactRESTController.class.getName());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addNewContact(@RequestBody String payload) {

        logger.info(":::PAYLOAD: " + payload);
        // System.out.println(":::::PAYLOAD: " + payload);

        Gson gson = new Gson();
        Contacts contactList = gson.fromJson(payload, Contacts.class);
        System.out.println(":::::CONTACTLIST: " + contactList.toString());

        contactList.getContacts().stream().forEach(v -> {
            contactSvc.insertContact(v);
        });

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(":::::PASS: New Contact Added");
    }

    @GetMapping(path = "/retrieve")
    public ResponseEntity<List<Contact>> getAllContacts() {

        List<Contact> cList = contactSvc.getAllContacts();

        return ResponseEntity.status(HttpStatus.OK).body(cList);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable String id) {

        boolean contactDeleted = contactSvc.deleteContact(id);

        if (contactDeleted == false) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(":::::FAIL: Contact was not deleted");
        }
        return ResponseEntity.status(HttpStatus.OK).body(":::::PASS: Contact has been deleted");
    }

}
