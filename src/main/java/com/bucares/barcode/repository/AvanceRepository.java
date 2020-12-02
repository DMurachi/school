package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Avance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AvanceRepository extends JpaRepository<Avance, Long> {
    Optional<Avance> findById(Long id);
}
