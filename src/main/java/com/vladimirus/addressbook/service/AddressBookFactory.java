package com.vladimirus.addressbook.service;

import com.vladimirus.addressbook.model.AddressBook;

import java.util.Optional;

import static java.util.Optional.empty;

public class AddressBookFactory {
    public Optional<AddressBook> fromFile(String addressBook) {
        return empty();
    }
}
