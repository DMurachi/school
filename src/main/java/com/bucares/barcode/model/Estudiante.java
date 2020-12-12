package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @ManyToOne
    @JoinColumn(name = "seccion_id", nullable = false)
    private Seccion seccion;
    @OneToOne
    private Notas nota;

    public Estudiante(){ /**/ }
    /*
    public Seccion getSeccion(){
        return seccion;
    }
    public void setSeccion(Seccion seccion){
        this.seccion = seccion;
    }*/
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

    public Estudiante(String name, String lastname, String telefono, Seccion seccion) {
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
        this.seccion = seccion;
    }
    
}
