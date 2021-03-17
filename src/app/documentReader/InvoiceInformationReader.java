package app.documentReader;

import app.modules.InvoiceInformationRow;
import org.w3c.dom.Document;

public class InvoiceInformationReader extends DocumentReader {

    public InvoiceInformationReader(Document document) {
        super(document);
    }

    public InvoiceInformationRow getInvoiceInformation(String currency) {
        InvoiceInformationRow row = new InvoiceInformationRow();
        row.setInvoiceType(getTextContent("InvoiceTypeCode"));
        row.setCodeListAgencyIdentifier(getAttributeValue("InvoiceTypeCode", 0, "CodeListAgencyIdentifier"));
        row.setCurrency(currency);
        row.setBuyerId(getTextContent("BuyerPartyIdentifier"));
        row.setBuyerOrganizationName(getTextContent("BuyerOrganisationName"));
        row.setPaymentOverDueFinePercent(getTextContent("PaymentOverDueFinePercent"));
        row.setDate(getTextContent("InvoiceDate"));
        row.setBillingAddress(getBillingAddress());
        row.setPostalAddress(getDeliveryAddress());
        row.setFreeText(getTextContent("InvoiceFreeText"));
        return row;
    }
}
