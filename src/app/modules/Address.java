package app.modules;

public class Address {
    private String organizationName;
    private String street;
    private String town;
    private String postalCode;
    private String country;

    @Override
    public String toString() {
        return getOrganizationName() +
                "\\" + getStreet() +
                "\\" + getPostalCode() +
                "\\" + getTown() +
                "\\" + getCountry();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
