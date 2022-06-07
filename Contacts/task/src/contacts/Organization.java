package contacts;

public class Organization extends Contact {

    private String organizationName;
    private String address;

    public Organization(Builder builder) {
        super(builder);
        this.organizationName = builder.organizationName;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return super.toString() + ", organizationName: " + this.organizationName+ ", address: " + this.address;
    }
    public String showName(){
        return this.organizationName;
    }

    public String showInfo() {
        return "Organization name: " + this.organizationName + "\nAddress: " + this.address  + "\nNumber: " + getNumber();
    }



    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Contact.Builder<Builder> {

        private String organizationName;
        private String address;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder organizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }

    }

}
