package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.model.SeccionDTO;
import com.bucares.barcode.service.SeccionService;
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
public class SeccionController {
    @Autowired
    SeccionService seccionService;
    private static final Logger logger = LoggerFactory.getLogger(SeccionController.class);
   
    @GetMapping(value = "/seccion")
    public ResponseEntity<List<Seccion>> showAllSeccion() {
        logger.info("Called resource: showAllSeccion");
      try{
        List<Seccion> seccionList = seccionService.getAllSeccion();
        if(seccionList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
         return new ResponseEntity<>(seccionList, HttpStatus.OK);
        }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
       
      }
    @GetMapping(value ="/seccion/{idS}")
    public ResponseEntity<Response<Optional<Seccion>>> getSeccion(@PathVariable("idS") Long idS) {
        logger.info("Called resource: getSeccion");

        Optional<Seccion> seccion = seccionService.getSeccionById(idS);

    Response<Optional<Seccion>> response = new Response<>("0000", seccion, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/seccion")
  public ResponseEntity<Seccion> createSeccion(@Valid @RequestBody SeccionDTO seccion) {
    logger.info("Called resource: createSeccion");
    try{
        Seccion persistentSeccion = new Seccion();
        if(seccion != null){
            persistentSeccion.setName(seccion.getName());
            seccionService.storeSeccion(persistentSeccion);
            return new ResponseEntity<>(persistentSeccion,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
