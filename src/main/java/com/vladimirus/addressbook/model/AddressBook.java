package com.vladimirus.addressbook.model;

import java.util.Collection;
import java.util.Optional;

public class AddressBook {
    private Collection<Contact> contacts;

    public AddressBook(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public Long countByGender(Gender gender) {
        return contacts.stream()
                .filter(contact -> contact.getGender() == gender)
                .count();
    }

    public Optional<Contact> oldest() {
        return contacts
                .stream()
                .min((c1, c2) -> c1.getDateOfBirth().compareTo(c2.getDateOfBirth()));
    }
}
