package services;

import dao.ContactDao;
import models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;

    public Contact save(Contact contact) {
        contactDao.save(contact);
        return contact;
    }

    public List<Contact> findAll() {
        return contactDao.findAll();
    }
}
