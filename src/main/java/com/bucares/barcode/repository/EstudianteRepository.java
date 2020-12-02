package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findById(Long id);
}
