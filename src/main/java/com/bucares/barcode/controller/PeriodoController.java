package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.Periodo;
import com.bucares.barcode.model.PeriodoDTO;
import com.bucares.barcode.service.PeriodoService;
import com.bucares.barcode.utilities.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class PeriodoController {
    @Autowired
    PeriodoService periodoService;
    private static final Logger logger = LoggerFactory.getLogger(PeriodoController.class);

    @GetMapping(value = "/periodo")
    public ResponseEntity<List<Periodo>> showAllPeriodo() {
        logger.info("Called resource: showAllPeriodo");
      try{
        List<Periodo> periodoList = periodoService.getAllPeriodo();
        if(periodoList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
         return new ResponseEntity<>(periodoList, HttpStatus.OK);
        }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
       
      }
    @GetMapping(value ="/periodo/{idP}")
    public ResponseEntity<Response<Optional<Periodo>>> getPeriodo(@PathVariable("idP") Long idP) {
        logger.info("Called resource: getPeriodo");

        Optional<Periodo> periodo = periodoService.getPeriodoById(idP);

    Response<Optional<Periodo>> response = new Response<>("0000", periodo, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/periodo")
  public ResponseEntity<Periodo> createPeriodo(@Valid @RequestBody PeriodoDTO periodo) {
    logger.info("Called resource: createPeriodo");
    try{
        Periodo persistentPeriodo = new Periodo();
        if(periodo != null){
            persistentPeriodo.setName(periodo.getName());
            persistentPeriodo.setDateFinal(periodo.getDateFinal());
            persistentPeriodo.setDateInicio(periodo.getDateInicio());
            periodoService.storePeriodo(persistentPeriodo);
            return new ResponseEntity<>(persistentPeriodo,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
