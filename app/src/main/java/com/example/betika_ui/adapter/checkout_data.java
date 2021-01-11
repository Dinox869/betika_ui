package com.example.betika_ui.adapter;

public class checkout_data {
    private String first,second,third, rates;

    public checkout_data(String first, String second, String third, String rates)
    {
        this.first = first;
        this.rates = rates;
        this.second = second;
        this.third = third;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }
}
