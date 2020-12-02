package com.bucares.barcode.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesor {
    @Id
    private Long id;
    private String name;
    private String lastname;
    private String telefono;
    
    // private Email email;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public Profesor(Long id, String name, String lastname, String telefono) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
    }

    public Profesor() {
    }
        
}
