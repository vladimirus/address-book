package com.vladimirus.addressbook;

import com.vladimirus.addressbook.model.AddressBook;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {
    private App app;
    @Mock
    private AddressBook addressBook;

    @Before
    public void setup() {
        app = new App();
    }

    @Test
    public void shouldProduceStats() {
        // when
        Collection<String> actual = app.stats(addressBook);

        // then
        assertThat(actual, hasSize(1));
        assertThat(actual.iterator().next(), is("Number of males: 0"));
    }
}