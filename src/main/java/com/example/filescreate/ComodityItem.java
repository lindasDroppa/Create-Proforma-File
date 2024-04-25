package com.example.filescreate;


public class ComodityItem
{
    private String item;
    private String price;
    private  String qty;
    private String hs_code;
    private String tax_duties;

    public ComodityItem(String item, String price, String qty, String hs_code, String tax_duties) {
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.hs_code = hs_code;
        this.tax_duties = tax_duties;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getHs_code() {
        return hs_code;
    }

    public void setHs_code(String hs_code) {
        this.hs_code = hs_code;
    }

    public String getTax_duties() {
        return tax_duties;
    }

    public void setTax_duties(String tax_duties) {
        this.tax_duties = tax_duties;
    }
}
