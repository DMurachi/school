package com.bucares.barcode.repository;

import java.util.Optional;

import com.bucares.barcode.model.Notas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface NotasRepository extends JpaRepository<Notas, Long>{
    Optional<Notas> findById(Long id);
}
