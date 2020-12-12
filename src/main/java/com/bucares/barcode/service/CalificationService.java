package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Calification;
import com.bucares.barcode.repository.CalificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificationService {
    @Autowired
    private CalificationRepository calificationRepository;
  
    public Calification storeCalification(Calification calification) {
      return calificationRepository.save(calification);
    }
  
    public List<Calification> getAllCalification() {
      return calificationRepository.findAll();
    }
  
  
    public Optional<Calification> getCalificationById(Long id) {
      return calificationRepository.findById(id);
    }    
}
