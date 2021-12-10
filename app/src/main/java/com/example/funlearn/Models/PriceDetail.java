package com.example.funlearn.Models;

import com.google.gson.annotations.SerializedName;

public class PriceDetail {

    @SerializedName("amount")
    private double amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("price_string")
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
