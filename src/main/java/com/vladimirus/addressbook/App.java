package com.vladimirus.addressbook;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.model.Contact;
import com.vladimirus.addressbook.model.Gender;
import com.vladimirus.addressbook.service.AddressBookFactory;
import com.vladimirus.addressbook.service.data.LocalFileReader;

import java.util.Collection;

import static com.vladimirus.addressbook.model.Gender.Male;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class App {
    public static void main(String[] args) {
        new AddressBookFactory().from(new LocalFileReader("src\\main\\resources\\AddressBook"))
                .map(addressBook -> new App().stats(addressBook))
                .orElseGet(() -> singletonList("Address book is not found"))
                .forEach(System.out::println);
    }

    public Collection<String> stats(AddressBook addressBook) {
        return asList(
                format("Number of males: %d", addressBook.countByGender(Male)),
                format("Oldest person: %s", addressBook.oldest().map(Contact::getName).orElse("<no data>"))
        );
    }
}
