package com.example.vaadin_crypto_diary.models;

public class BudgetChange {

    private Double amountChange;

    public BudgetChange(Double amountChange) {
        this.amountChange = amountChange;
    }

    public BudgetChange(){}

    public Double getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(Double amountChange) {
        this.amountChange = amountChange;
    }
}
