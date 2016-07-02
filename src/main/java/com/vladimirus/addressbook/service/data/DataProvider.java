package com.vladimirus.addressbook.service.data;

import com.vladimirus.addressbook.model.AddressBook;

import java.util.Optional;

public interface DataProvider {
    Optional<AddressBook> addressBook();
}
