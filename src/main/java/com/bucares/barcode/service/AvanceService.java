package com.bucares.barcode.service;
import java.util.List;
import java.util.Optional;
import com.bucares.barcode.model.Avance;
import com.bucares.barcode.repository.AvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvanceService {
  @Autowired
  private AvanceRepository avanceRepository;

  public Avance storeAvance(Avance avance) {
    return avanceRepository.save(avance);
  }

  public List<Avance> getAllAvance() {
    return avanceRepository.findAll();
  }


  public Optional<Avance> getAvanceById(Long id) {
    return avanceRepository.findById(id);
  }   
}
