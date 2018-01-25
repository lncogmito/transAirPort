package com.spring.henallux.transAirPort.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FormQuantity {
    @NotNull
    @Min(value = 1)
    private Integer quantity;

    public FormQuantity(){}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
