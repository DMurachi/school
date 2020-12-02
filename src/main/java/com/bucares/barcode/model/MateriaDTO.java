package com.bucares.barcode.model;

public class MateriaDTO {
    private Long id;
    private String name;

    public MateriaDTO() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MateriaDTO(String name) {
        this.name = name;
    }

    public MateriaDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
