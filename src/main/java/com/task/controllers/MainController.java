package com.task.controllers;

import com.task.models.Contact;
import com.task.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by PavelGrudina on 24.08.2017.
 */

@RestController
public class MainController extends BaseController {

    public static List<Contact> contactCache = new ArrayList<>();

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
    ResponseEntity<List<Contact>> getNameFilter(@RequestParam(value = "nameFilter", required = false) String nameFilter) throws IllegalArgumentException {

//        regEx validator
        if (!(nameFilter.startsWith("^") && nameFilter.endsWith("$"))) {
            throw new IllegalArgumentException("Wrong nameFilter format!");
        }

        List<Contact> filteredNames = MainController.contactCache.parallelStream()
                .filter(contact -> contact.getName() != null && !doNameFilter(contact.getName(), nameFilter))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filteredNames, HttpStatus.OK);
    }


    @RequestMapping(value = "/hello/contacts/all", method = RequestMethod.GET)
    ResponseEntity<List<Contact>> getAll() {
        return new ResponseEntity<>(contactCache, HttpStatus.OK);
    }


    public boolean doNameFilter(String name, String nameFilter) {
        Pattern p = Pattern.compile(nameFilter);
        Matcher m = p.matcher(name);
        return m.matches();
    }

}



