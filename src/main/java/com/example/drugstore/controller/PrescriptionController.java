package com.example.drugstore.controller;


import com.example.drugstore.entity.Prescription;
import com.example.drugstore.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PrescriptionController {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/prescriptions")
    public String listPrescriptions(Model model) {
        List<Prescription> prescriptionsList = (List<Prescription>) prescriptionRepository.findAll();
        model.addAttribute("prescriptionsList", prescriptionsList);
        return "prescriptions";
    }

    @GetMapping("/prescriptions/add")
    public String addPrescription(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "prescriptions-form";
    }

    @PostMapping("/prescriptions/save")
    public String savePrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
        return "redirect:/prescriptions";
    }

    @GetMapping("/prescriptions/edit/{prescriptionID}")
    public String editPrescription(@PathVariable("prescriptionID") Long prescriptionID, Model model) {
        if (prescriptionRepository.findById(prescriptionID).isPresent()) {
            Prescription prescription = prescriptionRepository.findById(prescriptionID).get();
            model.addAttribute("prescription", prescription);
            return "prescriptions-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/prescriptions/delete/{prescriptionID}")
    public String deletePrescription(@PathVariable("prescriptionID") Long prescriptionID, Model model) {
        if (prescriptionRepository.findById(prescriptionID).isPresent()) {
            prescriptionRepository.deleteById(prescriptionID);
            List<Prescription> prescriptionsList = (List<Prescription>) prescriptionRepository.findAll();
            model.addAttribute("prescriptionsList", prescriptionsList);
            return "prescriptions";
        } else {
            return "error";
        }
    }
}