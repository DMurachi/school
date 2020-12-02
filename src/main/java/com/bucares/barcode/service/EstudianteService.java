package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.repository.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
  @Autowired
  private EstudianteRepository estudianteRepository;

  public Estudiante storeEstudiante(Estudiante estudiante) {
    return estudianteRepository.save(estudiante);
  }

  public List<Estudiante> getAllEstudiante() {
    return estudianteRepository.findAll();
  }


  public Optional<Estudiante> getEstudianteById(Long id) {
    return estudianteRepository.findById(id);
  }   
}
