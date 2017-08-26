package com.task.dao;

import com.task.models.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
@Repository
public interface ContactDao extends CrudRepository<Contact, Long> {
}

