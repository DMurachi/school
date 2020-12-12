package com.bucares.barcode.controller;

import java.util.List;

import com.bucares.barcode.model.Calification;

public class NotasDTO {
    private List<Calification> calification;

    public List<Calification> getCalification() {
        return calification;
    }

    public void setCalification(List<Calification> calification) {
        this.calification = calification;
    }

    public NotasDTO(List<Calification> calification) {
        this.calification = calification;
    }
}
