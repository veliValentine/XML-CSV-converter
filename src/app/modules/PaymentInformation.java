package app.modules;

public interface PaymentInformation {
    String getCurrency();

    String getPaymentOverDueFinePercent();

    String getDate();

    void setCurrency(String currency);

    void setPaymentOverDueFinePercent(String percent);

    void setDate(String date);
}
