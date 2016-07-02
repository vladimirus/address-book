package com.vladimirus.addressbook.service.data;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.model.Contact;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import static org.apache.commons.csv.CSVFormat.DEFAULT;
import static org.apache.commons.io.FileUtils.getFile;
import static org.apache.commons.io.IOUtils.closeQuietly;

public class LocalFileReader implements DataProvider {
    private String filename;

    public LocalFileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public Optional<AddressBook> addressBook() {
        return ofNullable(createAddressBookWithContacts(contacts()));
    }

    public Collection<Contact> contacts() {
        Reader in = null;
        try {
            in = new FileReader(getFile(filename));
            return stream(DEFAULT.parse(in).spliterator(), false)
                    .map(record -> new Contact())
                    .collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
            return emptyList();
        } finally {
            closeQuietly(in);
        }
    }

    private AddressBook createAddressBookWithContacts(Collection<Contact> contacts) {
        if (!contacts.isEmpty()) {
            return new AddressBook(contacts);
        }
        return null;
    }
}
