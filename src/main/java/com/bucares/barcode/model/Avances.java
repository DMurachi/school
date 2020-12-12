package com.bucares.barcode.model;

import java.util.List;

import javax.persistence.Id;

public class Avances {
    @Id
    private Long id;
    private List<Avance> avance;
}
