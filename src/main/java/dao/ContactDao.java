package dao;

import models.Contact;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
@Repository
public class ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

        public Contact save (Contact contact) {
            entityManager.persist(contact);
            return contact;
        }

        public List<Contact> findAll() {
            List<Contact> resultList = entityManager.createQuery("from Contact", Contact.class).getResultList();
            return resultList;
        }
    }

