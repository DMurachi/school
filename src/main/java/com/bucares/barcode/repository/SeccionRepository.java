package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Seccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface SeccionRepository extends JpaRepository<Seccion, Long> {
    Optional<Seccion> findById(Long id);
    Optional<Seccion> findByName(String name);
}
