package com.bucares.barcode.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bucares.barcode.model.Calification.CalificationId;

@Entity
public class Avance implements Serializable{ 
    @Embeddable
	public static class AvanceId implements Serializable {
        @Column(name = "fk_calification")
        protected CalificationId calificationId;

		public AvanceId() {
			
		}
		
		public AvanceId(CalificationId calificationId) {
			this.calificationId = calificationId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((calificationId == null) ? 0 : calificationId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			AvanceId other = (AvanceId) obj;
			
			if (calificationId == null) {
				if (other.calificationId != null)
					return false;
			} else if (!calificationId.equals(other.calificationId))
				return false;
			return true;
		}
    }
    @EmbeddedId
    private AvanceId avanceId;
    @ManyToOne
    @JoinColumn(name = "fk_calification", insertable = false, updatable = false)
    private Calification calification;
    @Column
    private float nota;
    
    public Avance(){/**/ }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
