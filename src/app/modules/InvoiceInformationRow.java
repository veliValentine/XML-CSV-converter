package app.modules;

public class InvoiceInformationRow implements CSVRow, PaymentInformation, BuyerInformation {
    private String invoiceType;
    private String currency;
    private String slotC1;
    private String slotD1;
    private String buyerId;
    private String slotF1;
    private String buyerOrganizationName;
    private String slotH1;
    private String slotI1;
    private String slotJ1;
    private String slotK1;
    private String paymentOverDueFinePercent;
    private String date;
    private String slotN1;
    private String slotO1;
    private String slotP1;
    private String billingAddress;
    private String postalAddress;

    public String toCSVRow() {
        StringBuilder sb = new StringBuilder();
        sb.append(getInvoiceType()).append(";");
        sb.append(getCurrency()).append(";");
        sb.append(getSlotC1()).append(";");
        sb.append(getSlotD1()).append(";");
        sb.append(getBuyerId()).append(";");
        sb.append(getSlotF1()).append(";");
        sb.append(getBuyerOrganizationName()).append(";");
        sb.append(getSlotH1()).append(";");
        sb.append(getSlotI1()).append(";");
        sb.append(getSlotJ1()).append(";");
        sb.append(getSlotK1()).append(";");
        sb.append(getPaymentOverDueFinePercent()).append(";");
        sb.append(getDate()).append(";");
        sb.append(getSlotN1()).append(";");
        sb.append(getSlotO1()).append(";");
        sb.append(getSlotP1()).append(";");
        sb.append(getBillingAddress()).append(";");
        sb.append(getPostalAddress()).append(";");
        sb.append("\n");
        return sb.toString();
    }

    public String getInvoiceType() {
        if (invoiceType == null) {
            return "";
        }
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Override
    public String getCurrency() {
        if (currency == null) {
            return "";
        }
        return currency;
    }

    @Override
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSlotC1() {
        if (slotC1 == null) {
            return "";
        }
        return slotC1;
    }

    public void setSlotC1(String slotC1) {
        this.slotC1 = slotC1;
    }

    public String getSlotD1() {
        if (slotD1 == null) {
            return "";
        }
        return slotD1;
    }

    public void setSlotD1(String slotD1) {
        this.slotD1 = slotD1;
    }

    @Override
    public String getBuyerId() {
        if (buyerId == null) {
            return "";
        }
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSlotF1() {
        if (slotF1 == null) {
            return "";
        }
        return slotF1;
    }

    public void setSlotF1(String slotF1) {
        this.slotF1 = slotF1;
    }

    @Override
    public String getBuyerOrganizationName() {
        if (buyerOrganizationName == null) {
            return "";
        }
        return buyerOrganizationName;
    }

    @Override
    public void setBuyerOrganizationName(String buyerOrganizationName) {
        this.buyerOrganizationName = buyerOrganizationName;
    }

    public String getSlotH1() {
        if (slotH1 == null) {
            return "";
        }
        return slotH1;
    }

    public void setSlotH1(String slotH1) {
        this.slotH1 = slotH1;
    }

    public String getSlotI1() {
        if (slotI1 == null) {
            return "";
        }
        return slotI1;
    }

    public void setSlotI1(String slotI1) {
        this.slotI1 = slotI1;
    }

    public String getSlotJ1() {
        if (slotJ1 == null) {
            return "";
        }
        return slotJ1;
    }

    public void setSlotJ1(String slotJ1) {
        this.slotJ1 = slotJ1;
    }

    public String getSlotK1() {
        if (slotK1 == null) {
            return "";
        }
        return slotK1;
    }

    public void setSlotK1(String slotK1) {
        this.slotK1 = slotK1;
    }

    @Override
    public String getPaymentOverDueFinePercent() {
        if (paymentOverDueFinePercent == null) {
            return "";
        }
        return paymentOverDueFinePercent;
    }

    @Override
    public void setPaymentOverDueFinePercent(String paymentOverDueFinePercent) {
        this.paymentOverDueFinePercent = paymentOverDueFinePercent;
    }

    @Override
    public String getDate() {
        if (date == null) {
            return "";
        }
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    public String getSlotN1() {
        if (slotN1 == null) {
            return "";
        }
        return slotN1;
    }

    public void setSlotN1(String slotN1) {
        this.slotN1 = slotN1;
    }

    public String getSlotO1() {
        if (slotO1 == null) {
            return "";
        }
        return slotO1;
    }

    public void setSlotO1(String slotO1) {
        this.slotO1 = slotO1;
    }

    public String getSlotP1() {
        if (slotP1 == null) {
            return "";
        }
        return slotP1;
    }

    public void setSlotP1(String slotP1) {
        this.slotP1 = slotP1;
    }

    @Override
    public String getBillingAddress() {
        if (billingAddress == null) {
            return "";
        }
        return billingAddress;
    }

    @Override
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPostalAddress() {
        if (postalAddress == null) {
            return "";
        }
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
