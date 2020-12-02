package com.bucares.barcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16)
    private String name;
    @Column(length = 16)
    private String lastname;
    @Column(length = 11)
    private String telefono;

    

    public Estudiante(){ super(); }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Estudiante(Long id, String name, String lastname, String telefono) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
    }
    
}
