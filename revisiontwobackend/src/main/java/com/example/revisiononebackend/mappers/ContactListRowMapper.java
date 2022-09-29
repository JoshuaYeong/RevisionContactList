package com.example.revisiononebackend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.revisiononebackend.models.Contact;

public class ContactListRowMapper implements RowMapper<Contact> {

    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        Contact cont = new Contact();
        cont.setId(rs.getString("id"));
        cont.setName(rs.getString("name"));
        cont.setEmail(rs.getString("email"));
        cont.setMobile(rs.getString("mobile"));
        return cont;
    }
    
}
