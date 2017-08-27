package com.task.controllers;

import com.task.models.Contact;
import com.task.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    public static final List<Contact> contactCache = new ArrayList<>();

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/hello/contacts", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<Contact>> getNameFilter(@RequestParam(value = "nameFilter", required = false) String nameFilter) throws IOException, IllegalArgumentException {

        contactService.initDb();
        contactCache.addAll(contactService.findAll());

//        regEx validator
        if (!(nameFilter.startsWith("^") && nameFilter.endsWith("$"))){
            throw new  IllegalArgumentException();
        }

        List<Contact> filteredNames = MainController.contactCache.parallelStream()
                .filter(contact -> contact.getName() != null && MainController.doNameFilter(contact.getName(), nameFilter))
                .collect(Collectors.toList());

//        so slow, need faster
        List<Contact> nameList = new ArrayList<>();
        nameList.addAll(contactCache);
        nameList.removeAll(filteredNames);

        return new ResponseEntity<>(nameList, HttpStatus.OK);
    }


    @RequestMapping(value = "/hello/contacts/all", method = RequestMethod.GET)
    ResponseEntity<List<Contact>> getAll() {
        return new ResponseEntity<>(contactCache, HttpStatus.OK);
    }


    public static boolean doNameFilter(String name, String nameFilter) {
        Pattern p = Pattern.compile(nameFilter);
        Matcher m = p.matcher(name);
        return m.matches();
    }

}



