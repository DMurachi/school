package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Materia;
import com.bucares.barcode.repository.MateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MateriaService {
  @Autowired
  private MateriaRepository materiaRepository;

  public Materia storeMateria(Materia materia) {
    return materiaRepository.save(materia);
  }

  public List<Materia> getAllMateria() {
    return materiaRepository.findAll();
  }


  public Optional<Materia> getMateriaById(Long id) {
    return materiaRepository.findById(id);
  }  
    
}
