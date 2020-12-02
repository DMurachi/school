package com.bucares.barcode.model;

import java.util.Date;

public class PeriodoDTO {
    private String name;
    private Date dateInicio;
    private Date dateFinal;
    public PeriodoDTO(){}
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

    public PeriodoDTO(String name, Date dateInicio, Date dateFinal) {
        this.name = name;
        this.dateInicio = dateInicio;
        this.dateFinal = dateFinal;
    }
}
