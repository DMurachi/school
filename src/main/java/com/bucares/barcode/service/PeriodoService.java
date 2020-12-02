package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.Periodo;
import com.bucares.barcode.repository.PeriodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodoService {
    @Autowired
    private PeriodoRepository periodoRepository;

    public Periodo storePeriodo(Periodo periodo) {
      return periodoRepository.save(periodo);
    }
  
    public List<Periodo> getAllPeriodo() {
      return periodoRepository.findAll();
    }
  
    public Optional<Periodo> getPeriodoById(Long id) {
      return periodoRepository.findById(id);
    }
}
