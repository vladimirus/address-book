package com.vladimirus.addressbook.model;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.requireNonNull;

public class Contact {
    private final String firstName;
    private final String surname;
    private final Gender gender;
    private final LocalDate dateOfBirth;

    public Contact(String firstName, String surname, Gender gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return firstName + " " + surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static class Builder {
        private String firstName;
        private String surname;
        private Gender gender;
        private LocalDate dateOfBirth;

        public Builder withName(String name) {
            this.firstName = name.split(" ")[0];
            this.surname = name.split(" ")[1];
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = Gender.valueOf(gender);
            return this;
        }

        public Builder withDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = LocalDate.parse(dateOfBirth, ofPattern("dd/MM/yy")).minusYears(100);
            return this;
        }

        public Contact build() {
            requireNonNull(firstName, "First name cannot be null");
            requireNonNull(surname, "Surname cannot be null");
            requireNonNull(gender, "Gender cannot be null");
            requireNonNull(dateOfBirth, "Date of birth cannot be null");
            return new Contact(firstName, surname, gender, dateOfBirth);
        }
    }
}
