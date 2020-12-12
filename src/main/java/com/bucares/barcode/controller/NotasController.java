package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.Notas;
import com.bucares.barcode.service.NotasService;
import com.bucares.barcode.utilities.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class NotasController {
    @Autowired
    private NotasService notasService;
    private static final Logger logger = LoggerFactory.getLogger(NotasController.class);
   
    @GetMapping(value = "/notas")
    public ResponseEntity<List<Notas>> showAllNotas() {
        logger.info("Called resource: showAllNotas");
      try{
        List<Notas> notasList = notasService.getAllNotas();
        if(notasList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(notasList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping(value = "notas/{idN}")
    public ResponseEntity<Response<Optional<Notas>>> getNotas(@PathVariable("idM") Long idN) {
        logger.info("Called resource: getNotas");

        Optional<Notas> notas = notasService.getNotasById(idN);

    Response<Optional<Notas>> response = new Response<>("0000", notas, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/notas")
  public ResponseEntity<Notas> createNotas(@Valid @RequestBody NotasDTO notas) {
    logger.info("called resource: createNotas");
    try{
      Notas persistentNotas = new Notas();
      if(notas != null){
          persistentNotas.setCalification(notas.getCalification());
          return new ResponseEntity<>(persistentNotas,HttpStatus.OK);
      }else{
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  }catch(Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  }
}
