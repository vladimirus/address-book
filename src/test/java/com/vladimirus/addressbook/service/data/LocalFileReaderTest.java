package com.vladimirus.addressbook.service.data;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.model.Contact;
import org.junit.Test;

import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class LocalFileReaderTest {

    @Test
    public void shouldNotGetAddressBook() {
        // given
        LocalFileReader localFileReader = new LocalFileReader("non-existent-file");

        // when
        Optional<AddressBook> actual = localFileReader.addressBook();

        // then
        assertThat(actual.isPresent(), is(false));
    }

    @Test
    public void shouldGetAddressBook() {
        // given
        LocalFileReader localFileReader = new LocalFileReader("src\\test\\resources\\AddressBook");

        // when
        Optional<AddressBook> actual = localFileReader.addressBook();

        // then
        assertThat(actual.isPresent(), is(true));
    }

    @Test
    public void shouldGetContacts() {
        // given
        LocalFileReader localFileReader = new LocalFileReader("src\\test\\resources\\AddressBook");

        // when
        Collection<Contact> actual = localFileReader.contacts();

        // then
        assertThat(actual, hasSize(5));
    }
}