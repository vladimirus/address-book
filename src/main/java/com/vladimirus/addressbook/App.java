package com.vladimirus.addressbook;

import com.vladimirus.addressbook.service.AddressBookFactory;

import java.util.Collection;

import static java.lang.String.format;
import static java.util.Arrays.asList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        AddressBookFactory addressBookFactory = new AddressBookFactory();
        app.stats().stream().forEach(System.out::println);
    }

    public Collection<String> stats() {
        return asList(
                format("Number of males: %d", 0)
        );
    }
}
