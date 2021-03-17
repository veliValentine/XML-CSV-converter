public class InvoiceRow {
    private String product;
    private String productCode;
    private String qty;
    private String unit;
    private String price;
    private String currency;
    private String unitPriceUnitCode;
    private String discount;
    private String tax;
    private String comment;
    private String account;
    private String vatDeduction;
    private String vatType;
    private String vatStatus;

    public String getProduct() {
        if (product == null) {
            return "";
        }
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductCode() {
        if (productCode == null) {
            return "";
        }
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getQty() {
        if (qty == null) {
            return "";
        }
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit() {
        if (unit == null) {
            return "";
        }
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        if (price == null) {
            return "";
        }
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        if (discount == null) {
            return "";
        }
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTax() {
        if (tax == null) {
            return "";
        }
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getComment() {
        if (comment == null) {
            return "";
        }
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAccount() {
        if (account == null) {
            return "";
        }
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getVatDeduction() {
        if (vatDeduction == null) {
            return "";
        }
        return vatDeduction;
    }

    public void setVatDeduction(String vatDeduction) {
        this.vatDeduction = vatDeduction;
    }

    public String getVatType() {
        if (vatType == null) {
            return "";
        }
        return vatType;
    }

    public void setVatType(String vatType) {
        this.vatType = vatType;
    }

    public String getVatStatus() {
        if (vatStatus == null) {
            return "";
        }
        return vatStatus;
    }

    public void setVatStatus(String vatStatus) {
        this.vatStatus = vatStatus;
    }

    public String toCSVRow() {
        StringBuilder sb = new StringBuilder(";");
        sb.append(getProduct()).append(";");
        sb.append(getProductCode()).append(";");
        sb.append(getQty()).append(";");
        sb.append(getUnit()).append(";");
        sb.append(getPrice()).append(";");
        sb.append(getDiscount()).append(";");
        sb.append(getTax()).append(";");
        sb.append(getComment()).append(";");
        sb.append(getAccount()).append(";");
        sb.append(getVatDeduction()).append(";");
        sb.append(getVatType()).append(";");
        sb.append(getVatStatus()).append(";");
        sb.append("\n");
        return sb.toString();
    }

    public String getCurrency() {
        if (currency == null) {
            return "";
        }
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUnitPriceUnitCode() {
        if (unitPriceUnitCode == null) {
            return "";
        }
        return unitPriceUnitCode;
    }

    public void setUnitPriceUnitCode(String unitPriceUnitCode) {
        this.unitPriceUnitCode = unitPriceUnitCode;
    }
}
