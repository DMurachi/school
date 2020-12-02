package com.bucares.barcode.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date dateInicio;
    private Date dateFinal;
    @OneToMany
    private List<Seccion> seccion;
    @OneToMany
    private List<Estudiante> estudiante; 
    
    public Periodo(){}
    
    public String getName() {
        return name;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Date getDateInicio() {
        return dateInicio;
    }

    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Periodo(Long id, String name, Date dateInicio, Date dateFinal) {
        this.id = id;
        this.name = name;
        this.dateInicio = dateInicio;
        this.dateFinal = dateFinal;
    }
}
