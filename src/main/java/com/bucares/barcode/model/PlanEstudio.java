package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.CascadeType;
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
    private List<Materia> materia;

    public PlanEstudio() {/* empty */
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id){
        this.id=id;
    }
}
