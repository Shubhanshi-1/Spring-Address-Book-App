package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.bridgelabz.addressbookapp.controller.ContactController;
@Service
public class AddressBookAppService {
    private List<Contact> contactList = new ArrayList<>();
    private int idCounter = 1;

    public Contact createContact(ContactDTO contactDTO) {
        Contact newContact = new Contact(idCounter++, contactDTO);
        contactList.add(newContact);
        return newContact;
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public Contact getContactById(int id) {
        return contactList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Contact updateContact(int id, ContactDTO contactDTO) {
        Contact contact = getContactById(id);
        if (contact != null) {
            contact.setName(contactDTO.getName());
            contact.setPhone(contactDTO.getPhone());
            contact.setEmail(contactDTO.getEmail());
        }
        return contact;
    }

    public boolean deleteContact(int id) {
        return contactList.removeIf(contact -> contact.getId() == id);
    }
}
