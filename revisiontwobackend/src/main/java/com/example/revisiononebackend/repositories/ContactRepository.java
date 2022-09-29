package com.example.revisiononebackend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.revisiononebackend.mappers.ContactListRowMapper;
import com.example.revisiononebackend.models.Contact;

@Repository
public class ContactRepository {

    private static final String SQL_GET_CONTACT_BY_ID = "SELECT * FROM contacts WHERE id = ?";
    private static final String SQL_GET_ALL_CONTACTS = "SELECT * from contacts";
    private static final String SQL_INSERT_INTO_CONTACTS = "INSERT into contacts(id, name, email, mobile) values (?, ?, ?, ?)";
    private static final String SQL_DELETE_CONTACT_BY_ID = "DELETE from contacts where id = ?";

    @Autowired
    private JdbcTemplate template;

    public Optional<Contact> getContactById(String id) {
        SqlRowSet rs = template.queryForRowSet(SQL_GET_CONTACT_BY_ID, id);
        if (rs.next()) {
            return Optional.of(Contact.create(rs));
        }
        return Optional.empty();
    }

    public boolean insertContact(Contact cont) {
        int added = template.update(SQL_INSERT_INTO_CONTACTS,
                cont.getId(),
                cont.getName(),
                cont.getEmail(),
                cont.getMobile());
        return 1 == added;
    }

    public boolean deleteContact(String id) {

        int deleted = template.update(SQL_DELETE_CONTACT_BY_ID, id);

        return 1 == deleted;
    }

    public List<Contact> getAllContacts() {
        return template.query(SQL_GET_ALL_CONTACTS, new ContactListRowMapper());
    }
}
