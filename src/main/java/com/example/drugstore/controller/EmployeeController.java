package com.example.drugstore.controller;


import com.example.drugstore.entity.Employee;
import com.example.drugstore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employeesList = (List<Employee>) employeeRepository.findAll();
        model.addAttribute("employeesList", employeesList);
        return "employees";
    }

    @GetMapping("/employees/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{employeeID}")
    public String editEmployee(@PathVariable("employeeID") Long employeeID, Model model) {
        if (employeeRepository.findById(employeeID).isPresent()) {
            Employee employee = employeeRepository.findById(employeeID).get();
            model.addAttribute("employee", employee);
            return "employees-form";
        } else {
            return "error";
        }
    }

    @RequestMapping("/employees/delete/{employeeID}")
    public String deleteEmployee(@PathVariable("employeeID") Long employeeID, Model model) {
        if (employeeRepository.findById(employeeID).isPresent()) {
            employeeRepository.deleteById(employeeID);
            List<Employee> employeesList = (List<Employee>) employeeRepository.findAll();
            model.addAttribute("employeesList", employeesList);
            return "employees";
        } else {
            return "error";
        }
    }
}
