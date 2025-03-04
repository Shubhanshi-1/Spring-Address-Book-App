package com.bridgelabz.addressbookapp.service;


import com.bridgelabz.addressbookapp.controller.ContactController;
import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class AddressBookAppService {

    public Contact createContact(ContactDTO addressBookDTO) {
        return new Contact(addressBookDTO);
    }
}
