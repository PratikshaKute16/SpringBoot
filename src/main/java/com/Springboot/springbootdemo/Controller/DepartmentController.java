package com.Springboot.springbootdemo.Controller;

import com.Springboot.springbootdemo.entitity.Department;
import com.Springboot.springbootdemo.error.DepartmentNotFoundException;
import com.Springboot.springbootdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/form")
    public String index(Model model) {
        model.addAttribute("department", new Department());
        return "index";
    }

    //saving department
    @GetMapping("/save")
    public String save(@ModelAttribute Department department) {
        service.saveDepartment(department);
        return "redirect:/departments/show";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long departmentId,Model model) throws DepartmentNotFoundException {
        model.addAttribute("department", service.getDepartmentById(departmentId));
        return "edit"; // Return the name of your HTML page
    }

    //viewing data of department
    @GetMapping("/show")
    public String departmentList(Model model) {
        List<Department> departments = service.fetchDepartment();
        model.addAttribute("departments", departments);
        return "show"; // Return the name of your HTML page
    }


    //Deleting department by id
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long departmentId) {
        service.deleteById(departmentId);
        return "redirect:/departments/show";
    }

    //updating record
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long departmentId , @ModelAttribute Department department)
    {
        service.updateDepartmet(departmentId, department);
        return "redirect:/departments/show";
    }



}