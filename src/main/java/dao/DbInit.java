package dao;

import models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import services.ContactService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PavelGrudina on 25.08.2017.
 */
public class DbInit {

    @Autowired
    private ContactService contactService;

    public void init() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("src/main/resources/db_init_data.txt")));

        String str;

        while ((str = reader.readLine()) != null) {
            Contact contact = new Contact();
            contact.setName(str);
            contactService.save(contact);
        }
        reader.close();
    }
}
