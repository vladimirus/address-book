package com.vladimirus.addressbook;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.service.AddressBookFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class App {
    public static void main(String[] args) {
        new AddressBookFactory().fromFile("AddressBook")
                .map(addressBook -> new App().stats(addressBook))
                .orElseGet(() -> singletonList("Address book is not found"))
        .forEach(System.out::println);
    }

    public Collection<String> stats(AddressBook addressBook) {
        return asList(
                format("Number of males: %d", 0)
        );
    }
}
