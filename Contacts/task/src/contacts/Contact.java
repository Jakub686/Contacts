package contacts;

public class Contact {

    private String number;

    public String getNumber() {
        return number;
    }

    protected Contact(Builder<?> builder) {
        this.number = builder.number;
    }

    @Override
    public String toString() {
        return "number: " + this.number;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    public abstract static class Builder<T extends Builder<T>> {

        private String number;


        public abstract T getThis();

        public T number(String number) {
            this.number = number;
            return this.getThis();
        }


        public Contact build() {
            return new Contact(this);
        }
    }

}