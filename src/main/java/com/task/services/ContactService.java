package com.task.services;

import com.task.dao.ContactDao;
import com.task.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.task.controllers.MainController.contactCache;
import static java.util.stream.Collectors.toList;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
@Service
public class ContactService {

    @Autowired
    ContactDao contactDao;

    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    public List<Contact> findAll() {

        return StreamSupport.stream(contactDao.findAll().spliterator(), false).collect(toList());
    }

    @PostConstruct
    public void initDb() {
        try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/db_init_data.txt"))) {
            stream.forEach(name -> save(new Contact(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
