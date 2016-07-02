package com.vladimirus.addressbook;

import com.vladimirus.addressbook.model.AddressBook;
import com.vladimirus.addressbook.model.Contact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Iterator;

import static com.vladimirus.addressbook.model.Gender.Male;
import static java.util.Optional.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

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
        given(addressBook.oldest()).willReturn(of(contact));
        given(contact.getName()).willReturn("Emma Morano");
        given(addressBook.ageDifference(anyString(), anyString())).willReturn(of(10L));

        // when
        Collection<String> actual = app.stats(addressBook);

        // then
        Iterator<String> it = actual.iterator();
        assertThat(actual, hasSize(3));
        assertThat(it.next(), is("Number of males: 99"));
        assertThat(it.next(), is("Oldest person: Emma Morano"));
        assertThat(it.next(), is("How many days older is Bill than Paul: 10"));
    }
}