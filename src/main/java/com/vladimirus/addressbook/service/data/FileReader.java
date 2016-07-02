package com.vladimirus.addressbook.service.data;

import com.vladimirus.addressbook.model.AddressBook;

import java.util.Optional;

public class FileReader implements DataProvider {
    private String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public Optional<AddressBook> addressBook() {
        return Optional.empty();
    }
}
