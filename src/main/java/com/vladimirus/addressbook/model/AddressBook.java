package com.vladimirus.addressbook.model;

import java.util.Collection;

public class AddressBook {
    private Collection<Contact> contacts;

    public AddressBook(Collection<Contact> contacts) {
        this.contacts = contacts;
    }
}
