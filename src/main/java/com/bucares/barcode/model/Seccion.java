package com.bucares.barcode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "seccion")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    public Seccion(){super();}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seccion(Long id, String name) {
        this.id = id;
        this.name = name;
    }
     
}
