package com.vladimirus.addressbook.model;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public Optional<Long> ageDifference(String firstName1, String firstName2) {
        return findByFirstName(firstName1)
                .flatMap(c1 -> findByFirstName(firstName2)
                        .map(c2 -> DAYS.between(c1.getDateOfBirth(), c2.getDateOfBirth())));
    }

    public Optional<Contact> findByFirstName(String firstname) {
        return contacts.stream()
                .filter(c -> Objects.equals(c.getFirstName(), firstname))
                .findAny();
    }
}
