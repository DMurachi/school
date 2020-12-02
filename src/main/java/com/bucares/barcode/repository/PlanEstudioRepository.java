package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.PlanEstudio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {
    Optional<PlanEstudio> findById(Long id);
}
