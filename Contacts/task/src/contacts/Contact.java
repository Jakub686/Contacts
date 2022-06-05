package contacts;
//@Builder
public class Contact {
    private String name;
    private String surname;
    private String number;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    private Contact(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.number = builder.number;
    }

    public static class Builder{
        private String name;
        private String surname;
        private String number;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
