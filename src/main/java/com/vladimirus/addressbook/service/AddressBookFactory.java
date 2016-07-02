package com.vladimirus.addressbook.service;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.service.data.DataProvider;

import java.util.Optional;

public class AddressBookFactory {

    public Optional<AddressBook> from(DataProvider dataProvider) {
        return dataProvider.addressBook();
    }
}
