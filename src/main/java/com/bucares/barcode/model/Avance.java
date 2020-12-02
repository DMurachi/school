package com.bucares.barcode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avance {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    @Column
    private float nota;

    @ManyToOne
    private Materia materia;

    public Avance(){ super(); }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
