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
import com.bucares.barcode.model.Materia;
import com.bucares.barcode.model.MateriaDTO;
import com.bucares.barcode.service.MateriaService;
import com.bucares.barcode.utilities.Response;

@Controller
public class MateriaController {
    @Autowired
    private MateriaService materiaService;
    private static final Logger logger = LoggerFactory.getLogger(MateriaController.class);
   
    @GetMapping(value = "/materia")
    public ResponseEntity<List<Materia>> showAllMateria() {
        logger.info("Called resource: showAllMateria");
      try{
        List<Materia> materiaList = materiaService.getAllMateria();
        if(materiaList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(materiaList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping(value = "/materia/{idM}")
    public ResponseEntity<Response<Optional<Materia>>> getMateria(@PathVariable("idM") Long idM) {
        logger.info("Called resource: getMateria");

        Optional<Materia> materia = materiaService.getMateriaById(idM);

    Response<Optional<Materia>> response = new Response<>("0000", materia, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/materia")
  public ResponseEntity<Materia> createMateria(@Valid @RequestBody MateriaDTO materia) {
    logger.info("called resource: createMateria");
    try{
      Materia persistentMateria = new Materia();
      if(materia != null){
          persistentMateria.setName(materia.getName());
          materiaService.storeMateria(persistentMateria);
          return new ResponseEntity<>(persistentMateria,HttpStatus.OK);
      }else{
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
  }catch(Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  }
}
