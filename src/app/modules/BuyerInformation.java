package app.modules;

public interface BuyerInformation {
    String getBuyerId();

    String getBuyerOrganizationName();

    String getBillingAddress();

    void setCurrency(String currency);

    void setBuyerOrganizationName(String buyerOrganizationName);

    void setBillingAddress(String billingAddress);
}
