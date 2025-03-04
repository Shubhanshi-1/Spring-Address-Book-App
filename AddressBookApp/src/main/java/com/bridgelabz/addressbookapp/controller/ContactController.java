package com.bridgelabz.addressbookapp.controller;


import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.ContactRepository;
import org.springframework.http.ResponseEntity;
import com.bridgelabz.addressbookapp.service.AddressBookAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private AddressBookAppService addressBookAppService;

    @PostMapping
    public Contact createContact(@RequestBody ContactDTO contactDTO) {
        return addressBookAppService.createContact(contactDTO);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return addressBookAppService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return addressBookAppService.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable int id, @RequestBody ContactDTO contactDTO) {
        return addressBookAppService.updateContact(id, contactDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        boolean deleted = addressBookAppService.deleteContact(id);
        return deleted ? "Deleted successfully" : "Contact not found";
    }
}
