package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "notas")
public class Notas {
    @Id
    private Long id;

    public Notas() {/** */
    }
}
