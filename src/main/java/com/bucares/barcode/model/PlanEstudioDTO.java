package com.bucares.barcode.model;

import java.util.List;

public class PlanEstudioDTO {
    private Long id;
    private List<Materia> materias;

    public PlanEstudioDTO(Long id, List<Materia> materias) {
        this.setId(id);
        this.setMaterias(materias);
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
