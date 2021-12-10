package com.example.funlearn.Models;

public class PriceDetail {
    private double amount;
    private String currency;
    private String price_string;

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrice_string() {
        return price_string;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice_string(String price_string) {
        this.price_string = price_string;
    }
}
