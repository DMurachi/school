package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    Optional<Materia> findById(Long id);
}