package com.bucares.barcode;

import com.bucares.barcode.model.Estudiante;
import com.bucares.barcode.model.Seccion;
import com.bucares.barcode.repository.EstudianteRepository;
import com.bucares.barcode.repository.SeccionRepository;

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
    public CommandLineRunner mappingDemo(SeccionRepository seccionRepository, 
                                         EstudianteRepository estudianteRepository) {
        return args -> {

            // create a new book
            Seccion seccion = new Seccion("2U");

            // save the book
            seccionRepository.save(seccion);

            // create and save new pages
            estudianteRepository.save(new Estudiante("John", "Lopez","012031203", seccion));
            estudianteRepository.save(new Estudiante("Murachi", "Rivas", "1231231",seccion));
            estudianteRepository.save(new Estudiante("Lila", "Requena","12356236", seccion));
        };
    }*/

}

