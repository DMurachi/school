package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.SeccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SeccionService {
    @Autowired
    private SeccionRepository seccionRepository;

    public Seccion storeSeccion(Seccion seccion) {
      return seccionRepository.save(seccion);
    }
  
    public List<Seccion> getAllSeccion() {
      return seccionRepository.findAll();
    }
  
  
    public Optional<Seccion> getSeccionById(Long id) {
      return seccionRepository.findById(id);
    }
    
    public Optional<Seccion> getSeccionByName(String name){
        return seccionRepository.findByName(name);
    }
}
