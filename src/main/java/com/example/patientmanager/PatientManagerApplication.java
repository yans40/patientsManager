package com.example.patientmanager;

import com.example.patientmanager.entities.Patient;
import com.example.patientmanager.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
//            patientRepository.save(new Patient(null,"jacques",new Date(),false,23));
//            patientRepository.save(new Patient(null,"leo",new Date(),true,12));
//            patientRepository.save(new Patient(null,"hamza",new Date(),true,40));
//            patientRepository.save(new Patient(null,"emmanuel",new Date(),false,19));

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getNom());
            });

        };
    }
}

