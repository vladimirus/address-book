package com.vladimirus.addressbook.service;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.service.data.DataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookFactoryTest {
    private AddressBookFactory addressBookFactory;
    @Mock
    private DataProvider dataProvider;
    @Mock
    private AddressBook addressBook;

    @Before
    public void setup() {
        addressBookFactory = new AddressBookFactory();
    }

    @Test
    public void shouldNotGetAddressBook() {
        // given
        given(dataProvider.addressBook()).willReturn(empty());

        // when
        Optional<AddressBook> addressBook = addressBookFactory.from(dataProvider);

        // then
        assertThat(addressBook.isPresent(), is(false));
    }

    @Test
    public void shouldGetAddressBook() {
        // given
        given(dataProvider.addressBook()).willReturn(of(addressBook));

        // when
        Optional<AddressBook> addressBook = addressBookFactory.from(dataProvider);

        // then
        assertThat(addressBook.isPresent(), is(true));
    }
}