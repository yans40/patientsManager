package com.example.patientmanager.web;

import com.example.patientmanager.entities.Patient;
import com.example.patientmanager.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "5") int size,
                                        @RequestParam(name = "keyword", defaultValue = "")String keyword
    ) {
        Page<Patient> pagePatient = patientRepository.findByNomContains(keyword,PageRequest.of(page, size));
        model.addAttribute("listPatients", pagePatient.getContent());// listPatients est le nom dans le template thymeleaf et patients la variable qui correspont générée par le code
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patients";
    }
}
