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

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // GET all contacts
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactRepository.findAll());
    }

    // GET contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

 
    // PUT - Update an existing contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setName(updatedContact.getName());
                    contact.setEmail(updatedContact.getEmail());
                    contact.setPhone(updatedContact.getPhone());
                    return ResponseEntity.ok(contactRepository.save(contact));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Autowired
    private AddressBookAppService addressBookService; 

    @PostMapping("/create")
    public Contact createContact(@RequestBody ContactDTO addressBookDTO) {
        return addressBookService.createContact(addressBookDTO);
    }

    // DELETE - Delete a contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
