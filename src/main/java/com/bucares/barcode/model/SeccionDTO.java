package com.bucares.barcode.model;

public class SeccionDTO {
    private String name;
    public SeccionDTO(){}
    public SeccionDTO(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
