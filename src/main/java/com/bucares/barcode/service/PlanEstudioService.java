package com.bucares.barcode.service;

import java.util.List;
import java.util.Optional;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.repository.PlanEstudioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanEstudioService {
    @Autowired
    private PlanEstudioRepository planEstudioRepository;

    public PlanEstudio storePlanEstudio(PlanEstudio planEstudio) {
      return planEstudioRepository.save(planEstudio);
    }
  
    public List<PlanEstudio> getAllPlanEstudio() {
      return planEstudioRepository.findAll();
    }
  
    public Optional<PlanEstudio> getPlanById(Long id) {
      return planEstudioRepository.findById(id);
    }
}
