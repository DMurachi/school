package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.EstudianteDTO;
import com.bucares.barcode.service.EstudianteService;
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
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;
    private static final Logger logger = LoggerFactory.getLogger(EstudianteController.class);
   
    @GetMapping(value = "/estudiante")
    public ResponseEntity<List<Estudiante>> showAllEstudiante() {
        logger.info("Called resource: showAllEstudiante");
      try{
        List<Estudiante> estudianteList = estudianteService.getAllEstudiante();
        if(estudianteList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(estudianteList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping(value = "/estudiante/{idE}")
    public ResponseEntity<Response<Optional<Estudiante>>> getMateria(@PathVariable("idE") Long idE) {
        logger.info("Called resource: getEstudiante");

        Optional<Estudiante> estudiante = estudianteService.getEstudianteById(idE);

    Response<Optional<Estudiante>> response = new Response<>("0000", estudiante, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/estudiante")
  public ResponseEntity<Estudiante> createEstudiante(@Valid @RequestBody EstudianteDTO estudiante) {
    logger.info("Called resource: createEstudiante");
    try{
        Estudiante persistentEstudiante = new Estudiante();
        if(estudiante != null){
            persistentEstudiante.setLastname(estudiante.getLastname());
            persistentEstudiante.setName(estudiante.getName());
            persistentEstudiante.setTelefono(estudiante.getTelefono());
            estudianteService.storeEstudiante(persistentEstudiante);
            return new ResponseEntity<>(persistentEstudiante,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
