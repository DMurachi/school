package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.bucares.barcode.model.Avance;
import com.bucares.barcode.model.AvanceDTO;
import com.bucares.barcode.service.AvanceService;
import com.bucares.barcode.utilities.Response;

@Controller
public class AvanceController {
    @Autowired
    private AvanceService avanceService;

    private static final Logger logger = LoggerFactory.getLogger(AvanceController.class);

    @GetMapping(value = "/avance")
    public ResponseEntity<Response<List<Avance>>> showAllAvance() {
        logger.info("Called resource: getAllAvance");

        List<Avance> avanceList = avanceService.getAllAvance();
        Response<List<Avance>> response = new Response<>("0000", avanceList, null);

        logger.info("Called resource: getAllProducts");

        logger.info("Consulted: every product in database");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/avance/{idN}")
    public ResponseEntity<Response<Optional<Avance>>> getAvance(@PathVariable("idN") Long idN) {
        logger.info("Called resource: getAvance");

        Optional<Avance> avance = avanceService.getAvanceById(idN);

    Response<Optional<Avance>> response = new Response<>("0000", avance, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/avance")
  public ResponseEntity<Response<Avance>> createAvance(@Valid @RequestBody AvanceDTO avance) {
    logger.info("Called resource: createAvance");
    Avance persistentAvance = new Avance();
    if(avance != null){
      persistentAvance.setNota(avance.getNota());
      avanceService.storeAvance(persistentAvance);
    }
    Response<Avance> response = new Response<>("0000", persistentAvance, null);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}