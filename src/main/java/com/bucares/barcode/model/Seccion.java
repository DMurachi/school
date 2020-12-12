package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "seccion")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "seccion",cascade = CascadeType.MERGE)
    private List<Estudiante> estudiante;
   
    public Seccion(){/**/}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }/*
    public List<Estudiante> getEstudiante(){
        return this.estudiante;
    }
    public void setEstudiante(List<Estudiante> estudiante){
        this.estudiante = estudiante;
    }*/
    public Seccion(String name, List<Estudiante> estudiantes) {
        this.name = name;
        this.estudiante = estudiantes;
    }
     
}
