package com.vladimirus.addressbook.service.data;

import com.vladimirus.addressbook.model.AddressBook;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileReaderTest {

    @Test
    public void shouldNotGetAddressBook() {
        // given
        FileReader fileReader = new FileReader("AddressBook");

        // when
        Optional<AddressBook> addressBook = fileReader.addressBook();

        // then
        assertThat(addressBook.isPresent(), is(false));
    }
}