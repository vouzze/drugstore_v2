package com.example.drugstore.controller;

import com.example.drugstore.entity.Medicine;
import com.example.drugstore.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping("/medicines")
    public String listMedicines(Model model) {
        List<Medicine> medicinesList = (List<Medicine>) medicineRepository.findAll();
        model.addAttribute("medicinesList", medicinesList);
        return "medicines";
    }

    @GetMapping("/medicines/add")
    public String addMedicine(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicines-form";
    }

    @PostMapping("/medicines/save")
    public String saveMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return "redirect:/medicines";
    }

    @GetMapping("/medicines/edit/{medicineID}")
    public String editMedicine(@PathVariable("medicineID") Long medicineID, Model model) {
        if (medicineRepository.findById(medicineID).isPresent()) {
            Medicine medicine = medicineRepository.findById(medicineID).get();
            model.addAttribute("medicine", medicine);
            return "medicines-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/medicines/delete/{medicineID}")
    public String deleteCustomer(@PathVariable("medicineID") Long medicineID, Model model) {
        if (medicineRepository.findById(medicineID).isPresent()) {
            medicineRepository.deleteById(medicineID);
            List<Medicine> medicinesList = (List<Medicine>) medicineRepository.findAll();
            model.addAttribute("medicinesList", medicinesList);
            return "medicines";
        } else {
            return "error";
        }
    }
}
