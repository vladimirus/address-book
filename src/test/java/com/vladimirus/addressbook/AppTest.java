package com.vladimirus.addressbook;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.model.Contact;
import com.vladimirus.addressbook.model.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import static com.vladimirus.addressbook.model.Gender.Male;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    private App app;
    @Mock
    private AddressBook addressBook;
    @Mock
    private Contact contact;

    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void shouldProduceStats() {
        // given
        given(addressBook.countByGender(Male)).willReturn(99L);
        given(addressBook.oldest()).willReturn(Optional.of(contact));
        given(contact.getName()).willReturn("Emma Morano");

        // when
        Collection<String> actual = app.stats(addressBook);

        // then
        Iterator<String> it = actual.iterator();
        assertThat(actual, hasSize(2));
        assertThat(it.next(), is("Number of males: 99"));
        assertThat(it.next(), is("Oldest person: Emma Morano"));
    }
}