package com.bridgelabz.addressbookapp.model;

import jakarta.persistence.*; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.bridgelabz.addressbookapp.dto.ContactDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;
    
    
    public Contact(int id, ContactDTO contactDTO) {
        this.id = id;
        this.name = contactDTO.getName();
        this.phone = contactDTO.getPhone();
        this.email = contactDTO.getEmail();
    }

    }

