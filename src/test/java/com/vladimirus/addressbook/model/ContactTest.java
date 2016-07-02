package com.vladimirus.addressbook.model;

import org.junit.Test;

import java.time.LocalDate;

import static com.vladimirus.addressbook.model.Gender.Male;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContactTest {

    @Test(expected = NullPointerException.class)
    public void shouldNotBuild() {

        // when
        Contact actual = Contact.builder().build();

        // then
        // exception
    }

    @Test
    public void shouldBuild() {

        // when
        Contact actual = Contact.builder()
                .withName("David Cameron")
                .withGender("Male")
                .withDateOfBirth("09/10/66")
                .build();

        // then
        assertThat(actual.getFirstName(), is("David"));
        assertThat(actual.getSurname(), is("Cameron"));
        assertThat(actual.getName(), is("David Cameron"));
        assertThat(actual.getGender(), is(Male));
        assertThat(actual.getDateOfBirth(), is(LocalDate.of(1966, 10, 9)));
    }
}