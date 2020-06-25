package com.bucares.barcode.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  private Long id;

  @Column(unique = true, nullable = false)
  private String barcode;

  @Column(nullable = false)
  private String name;

  @Column
  private String ingredients;

  @Column
  private String categories;

  @Column
  private String quantity;

  @Column
  private String picture;
}