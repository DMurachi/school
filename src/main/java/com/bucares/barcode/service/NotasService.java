package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Notas;
import com.bucares.barcode.repository.NotasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasService {
    @Autowired
    private NotasRepository notasRepository;
  
    public Notas storeNotas(Notas notas) {
      return notasRepository.save(notas);
    }
  
    public List<Notas> getAllNotas() {
      return notasRepository.findAll();
    }
  
  
    public Optional<Notas> getNotasById(Long id) {
      return notasRepository.findById(id);
    }   
}
