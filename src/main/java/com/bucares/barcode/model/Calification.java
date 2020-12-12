package com.bucares.barcode.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Calification implements Serializable{
    @Embeddable
    public static class CalificationId implements Serializable{
        @Column(name = "fk_materia")
        protected Long materiaId;
        public CalificationId(){/** */}

        public CalificationId(Long materiaId) {
            this.materiaId = materiaId;
        }
        @Override
        public int hashCode() {
        final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((materiaId == null) ? 0 : materiaId.hashCode());
			return result;
        }
        @Override
        public boolean equals(Object obj){
            if(this==obj)
                return true;
            
            if(obj==null)
                return false;
            
            if(getClass() != obj.getClass())
                return false;
            
            CalificationId other = (CalificationId) obj;
            if(materiaId==null){
                if(other.materiaId != null){
                    return false;
                }
            }else if(!materiaId.equals(other.materiaId)){
                return false;
            }
            return true;
        }
        
    }
    @EmbeddedId
    private CalificationId id;
    @OneToMany(mappedBy = "calification",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Avance> avance;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_materia", insertable = false, updatable = false)
    private Materia materia;
    
    private float nota;

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    public Calification(Materia materia) {
		// create primary key
		this.id = new CalificationId(materia.getId());
		
		// initialize attributes
		this.materia = materia;
		
		// update relationships to assure referential integrity
		p.getBooks().add(this);
		b.getPublishers().add(this);
	}
}
