package com.bucares.barcode.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bucares.barcode.model.PlanEstudio;
import com.bucares.barcode.model.PlanEstudioDTO;
import com.bucares.barcode.service.PlanEstudioService;
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
public class PlanEstudioController {
    @Autowired
    PlanEstudioService planEstudioService;
    private static final Logger logger = LoggerFactory.getLogger(PeriodoController.class);

    @GetMapping(value = "/planestudio")
    public ResponseEntity<List<PlanEstudio>> showAllPlan() {
        logger.info("Called resource: showAllPlan");
      try{
        List<PlanEstudio> planList = planEstudioService.getAllPlanEstudio();
        if(planList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
         return new ResponseEntity<>(planList, HttpStatus.OK);
        }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
       
      }
    @GetMapping(value ="/planestudio/{idP}")
    public ResponseEntity<Response<Optional<PlanEstudio>>> getPlan(@PathVariable("idP") Long idP) {
        logger.info("Called resource: getPlan");

        Optional<PlanEstudio> plan = planEstudioService.getPlanById(idP);

    Response<Optional<PlanEstudio>> response = new Response<>("0000", plan, null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/planestudio")
  public ResponseEntity<PlanEstudio> createPlan(@Valid @RequestBody PlanEstudioDTO planEstudio) {
    logger.info("Called resource: createPlan");
    try{
        PlanEstudio persistentPlanEstudio = new PlanEstudio();
        if(planEstudio != null){
            persistentPlanEstudio.setMaterias(planEstudio.getMaterias());
            persistentPlanEstudio.setId(planEstudio.getId());
            planEstudioService.storePlanEstudio(persistentPlanEstudio);
            return new ResponseEntity<>(persistentPlanEstudio,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          }
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
