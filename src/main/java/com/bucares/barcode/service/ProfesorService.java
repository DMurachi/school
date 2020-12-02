package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Profesor;
import com.bucares.barcode.repository.ProfesorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor storeProfesor(Profesor profesor) {
      return profesorRepository.save(profesor);
    }
  
    public List<Profesor> getAllProfesor() {
      return profesorRepository.findAll();
    }
  
    public Optional<Profesor> getProfesorById(Long id) {
      return profesorRepository.findById(id);
    }
}
