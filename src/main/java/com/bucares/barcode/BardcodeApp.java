package com.bucares.barcode;

import java.util.ArrayList;
import java.util.List;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.EstudianteRepository;
import com.bucares.barcode.repository.SeccionRepository;
import com.bucares.barcode.service.EstudianteService;
import com.bucares.barcode.service.SeccionService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class BardcodeApp {

    public static void main(String[] args) {
        SpringApplication.run(BardcodeApp.class, args);
    }/*
    @Bean
    public CommandLineRunner mappingDemo(SeccionService seccionService, 
                                         EstudianteService estudianteService) {
        return args -> {


            // create and save new pages7
        
        //    estudianteRepository.save(new Estudiante("Darlin", "Lopez","012031203"));
        //    estudianteRepository.save(new Estudiante("Derwis", "Rivas", "1231231"));
        //    estudianteRepository.save(new Estudiante("Emmanuel", "Requena","12356236"));
         
            // create a new book
            List<Estudiante> estudiantes = new ArrayList<Estudiante>();
            estudianteService.getAllEstudiante().forEach(estudiantes::add);
            Seccion seccion = new Seccion("2U", estudiantes);

            // save the book
            seccionService.storeSeccion(seccion);
        };
    }*/

}

