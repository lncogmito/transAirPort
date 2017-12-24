package com.spring.henallux.transAirPort.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FormQuantity {
    @NotNull
    @Min(value = 1)
    private int quantity;

    public FormQuantity(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
