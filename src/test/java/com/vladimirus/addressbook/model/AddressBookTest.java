package com.vladimirus.addressbook.model;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static com.vladimirus.addressbook.model.Gender.Female;
import static com.vladimirus.addressbook.model.Gender.Male;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddressBookTest {
    private AddressBook addressBook;
    private Collection<Contact> contacts;

    @Before
    public void setup() {
        contacts = Arrays.asList(
                Contact.builder().withName("Samantha Sheffield").withGender("Female").withDateOfBirth("18/04/71").build(),
                Contact.builder().withName("Michael Howard").withGender("Male").withDateOfBirth("07/07/41").build(),
                Contact.builder().withName("Tony Blair").withGender("Male").withDateOfBirth("06/05/53").build()
        );
        addressBook = new AddressBook(contacts);
    }

    @Test
    public void shouldCountByMales() {

        // when
        Long actual = addressBook.countByGender(Male);

        // then
        assertThat(actual, is(2L));
    }

    @Test
    public void shouldCountByFemales() {

        // when
        Long actual = addressBook.countByGender(Female);

        // then
        assertThat(actual, is(1L));
    }


    @Test
    public void shouldGetOldest() {

        // when
        Optional<Contact> actual = addressBook.oldest();

        // then
        assertThat(actual.isPresent(), is(true));
        assertThat(actual.get().getName(), is("Michael Howard"));
    }

    @Test
    public void shouldNotGetOldest() {
        // given
        AddressBook addressBook = new AddressBook(emptyList());

        // when
        Optional<Contact> actual = addressBook.oldest();

        // then
        assertThat(actual.isPresent(), is(false));
    }

    @Test
    public void shouldFindByFirstName() {
        // when
        Optional<Contact> actual = addressBook.findByFirstName("Tony");

        // then
        assertThat(actual.isPresent(), is(true));
        assertThat(actual.get().getName(), is("Tony Blair"));
    }

    @Test
    public void shouldNotFindByFirstName() {
        // when
        Optional<Contact> actual = addressBook.findByFirstName("Boris");

        // then
        assertThat(actual.isPresent(), is(false));
    }

    @Test
    public void shouldGetAgeDifference() {
        // when
        Optional<Long> actual = addressBook.ageDifference("Tony", "Samantha");

        // then
        assertThat(actual.isPresent(), is(true));
        assertThat(actual.get(), is(6556L));
    }

    @Test
    public void shouldGetAgeDifferenceInReverse() {
        // when
        Optional<Long> actual = addressBook.ageDifference("Samantha", "Tony");

        // then
        assertThat(actual.isPresent(), is(true));
        assertThat(actual.get(), is(-6556L));
    }

    @Test
    public void shouldNotGetAgeDifferenceInReverse() {
        // when
        Optional<Long> actual = addressBook.ageDifference("Tony", "Boris");

        // then
        assertThat(actual.isPresent(), is(false));
    }
}