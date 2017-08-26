package com.task.services;

import com.task.dao.ContactDao;
import com.task.models.Contact;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
@Service
public class ContactService {

    private final ContactDao contactDao;

    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }


    public Contact save(Contact contact) {
        contactDao.save(contact);
        return contact;
    }

    public List<Contact> findAll() {

        List<Contact> allContacts = new ArrayList<>();
        allContacts.addAll((Collection<? extends Contact>) contactDao.findAll());

        return allContacts;
    }

    public void initDb() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("src/main/resources/db_init_data.txt")));

            String str;

            while ((str = reader.readLine()) != null) {
                Contact contact = new Contact();
                contact.setName(str);
                save(contact);
            }
            reader.close();
        } catch (IOException ex) {
              ex.getMessage();
        }
    }
}
