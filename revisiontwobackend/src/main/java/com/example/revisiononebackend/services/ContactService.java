package com.example.revisiononebackend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revisiononebackend.models.Contact;
import com.example.revisiononebackend.repositories.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepo;

    public Optional<Contact> getContactById(String id) {
        return contactRepo.getContactById(id);
    }

    public boolean insertContact(Contact cont) {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        cont.setId(uuid);

        if (contactRepo.insertContact(cont)) {
            System.out.println(":::::PASS: Inserted Contact: " + cont);
            return true;
        }
        System.out.println(":::::FAIL: Did Not Insert Contact: " + cont);
        return false;
    }

    public boolean deleteContact(String id) {

        boolean contactDeleted = contactRepo.deleteContact(id);
        System.out.println(":::::PASS: Deleted Contact: " + id);

        return contactDeleted;
    }

    public List<Contact> getAllContacts() {
        return contactRepo.getAllContacts();
    }
}
