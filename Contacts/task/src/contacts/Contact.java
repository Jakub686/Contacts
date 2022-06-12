package contacts;

import java.time.LocalDateTime;

public class Contact {

    private String number;
    private LocalDateTime created;
    private LocalDateTime lastEdit;

    protected Contact(Builder<?> builder) {
        this.number = builder.number;
        this.created = builder.created;
        this.lastEdit = builder.lastEdit;
    }


    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", created=" + created +
                ", lastEdit=" + lastEdit +
                '}';
    }

    public abstract static class Builder<T extends Builder<T>> {


        private String number;
        private LocalDateTime created;
        private LocalDateTime lastEdit;


        public abstract T getThis();

        public T number(String number) {
            this.number = number;

            return this.getThis();
        }

        public T created(LocalDateTime created) {
            this.created = created;
            return this.getThis();
        }

        public T lastEdit(LocalDateTime lastEdit) {
            this.lastEdit = lastEdit;
            return this.getThis();
        }
        public Contact build() {
            return new Contact(this);
        }


    }

}