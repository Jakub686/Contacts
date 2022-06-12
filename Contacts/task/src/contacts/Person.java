package contacts;

import java.time.LocalDateTime;

//@Builder
public class Person extends Contact {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;


    public Person(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
    }

    @Override
    public String toString() {
        return super.toString() + ", name: " + this.name + ", surname: " + this.surname + ", birthDate: " + this.birthDate + ", gender: " + this.gender;
    }


    public String showName() {
        return this.name;
    }
    public String showSurname() {
        return this.surname;
    }
    public String showBirthDate() {
        return this.birthDate;
    }
    public String showGender() {
        return this.gender;
    }
    public LocalDateTime showCreated() {
        return getCreated();
    }
    public String showNumber() {
        return getNumber();
    }

    public String showInfo() {
        return "Name: " + this.name + "\nSurname: " + this.surname + "\nBirth date: " + this.birthDate + "\nGender: " + this.gender + "\nNumber: " + getNumber()+ "\nTime created: " + getCreated()+ "\nTime last edit: " + getLastEdit();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Contact.Builder<Builder> {

        private String name;
        private String surname;
        private String birthDate;
        private String gender;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder birthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
}
