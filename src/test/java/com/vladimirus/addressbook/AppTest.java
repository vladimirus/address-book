package com.vladimirus.addressbook;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

public class AppTest {

    @Test
    public void shouldStart() {

        // when
        App app = new App();

        // then
        // starts without exceptions
    }

    @Test
    public void shouldProduceStats() {
        // given
        App app = new App();

        // when
        Collection<String> actual = app.stats();

        // then
        assertThat(actual, hasSize(1));
        assertThat(actual.iterator().next(), is("Number of males: 0"));
    }
}