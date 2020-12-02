package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

    @OneToMany
    private List<Avance> avance;

    public Materia() {
        super();
    }
    public Materia(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
}
