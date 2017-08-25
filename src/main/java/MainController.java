import config.PersistenceConfig;
import models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.ContactService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PavelGrudina on 24.08.2017.
 */

@Controller
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
    @ResponseBody
    String getNameFilter(@RequestParam(value = "nameFilter", required = false) String nameFilter) {
        return nameFilter;
    }


    public static void main(String[] args) throws Exception {

        SpringApplication.run(new Class<?>[]{MainController.class, PersistenceConfig.class}, args);


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

