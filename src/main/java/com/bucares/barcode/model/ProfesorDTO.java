package com.bucares.barcode.model;

public class ProfesorDTO {
    private Long id;
    private String name;
    private String lastname;
    private String telefono;
    
    public Long getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfesorDTO() {
    }

    public ProfesorDTO(Long id, String name, String lastname, String telefono) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
    }
}
