package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.Profesor;
import com.bucares.barcode.model.ProfesorDTO;
import com.bucares.barcode.service.ProfesorService;
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
public class ProfesorController {
    @Autowired
    ProfesorService profesorService;
    private static final Logger logger = LoggerFactory.getLogger(ProfesorController.class);

    @GetMapping(value = "/profesor")
    public ResponseEntity<List<Profesor>> showAllProfesor() {
        logger.info("Called resource: showAllProfesor");
      try{
        List<Profesor> profesorList = profesorService.getAllProfesor();
        if(profesorList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
         return new ResponseEntity<>(profesorList, HttpStatus.OK);
        }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
       
      }
    @GetMapping(value ="/profesor/{idP}")
    public ResponseEntity<Response<Optional<Profesor>>> getProfesor(@PathVariable("idP") Long idP) {
        logger.info("Called resource: getProfesor");

        Optional<Profesor> profesor = profesorService.getProfesorById(idP);

    Response<Optional<Profesor>> response = new Response<>("0000", profesor, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/profesor")
  public ResponseEntity<Profesor> createProfesor(@Valid @RequestBody ProfesorDTO profesor) {
    logger.info("Called resource: createProfesor");
    try{
        Profesor persistentProfesor = new Profesor();
        if(profesor != null){
            persistentProfesor.setLastname(profesor.getLastname());
            persistentProfesor.setName(profesor.getName());
            persistentProfesor.setTelefono(profesor.getTelefono());
            return new ResponseEntity<>(persistentProfesor,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
