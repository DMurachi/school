package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Periodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
   Optional<Periodo> findById(Long id); 
}
