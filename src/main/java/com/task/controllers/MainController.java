package com.task.controllers;

import com.task.models.Contact;
import com.task.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by PavelGrudina on 24.08.2017.
 */

@RestController
public class MainController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
    @ResponseBody
    String getNameFilter(@RequestParam(value = "nameFilter", required = false) String nameFilter) {
        return nameFilter;
    }

    @RequestMapping(value = "/hello/contacts/all", method = RequestMethod.GET)
    List<Contact> getAll() {
        contactService.initDb();
        return contactService.findAll();
    }

}

