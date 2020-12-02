package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlanEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Materia> materias;

    public PlanEstudio() {/* empty */
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public PlanEstudio(Long id, List<Materia> materias) {
        this.id = id;
        this.materias = materias;
    }
}
