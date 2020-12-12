package com.bucares.barcode.controller;

import java.util.List;

import com.bucares.barcode.model.Calification;
import com.bucares.barcode.service.CalificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Controller
public class CalificationController {
    @Autowired
    private CalificationService calificationService;
    private static final Logger logger = LoggerFactory.getLogger(CalificationController.class);
   
    @GetMapping(value = "/calification")
    public ResponseEntity<List<Calification>> showAllCalification() {
        logger.info("Called resource: showAllCalification");
      try{
        List<Calification> calificationList = calificationService.getAllCalification();
        if(calificationList.isEmpty()){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
         return new ResponseEntity<>(calificationList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
