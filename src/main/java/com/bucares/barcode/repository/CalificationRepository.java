package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Calification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CalificationRepository extends JpaRepository<Calification,Long>{
    Optional<Calification> findById(Long id);
}
