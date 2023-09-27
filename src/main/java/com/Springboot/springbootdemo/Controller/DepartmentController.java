package com.Springboot.springbootdemo.Controller;

import com.Springboot.springbootdemo.entitity.Department;
import com.Springboot.springbootdemo.error.DepartmentNotFoundException;
import com.Springboot.springbootdemo.service.DepartmentService;
import com.Springboot.springbootdemo.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController
{
    @Autowired
    private DepartmentService service;

    @GetMapping("/form")
    public String index(Model model) {
        model.addAttribute("department", new Department());
        return "departments/form";
    }
    //saving department
    @PostMapping("/save")
    public String save(@ModelAttribute Department department) {
        service.saveDepartment(department);
        return "redirect:/departments/list";
    }


    @GetMapping("/list")
    public String departmentList(Model model) {
        List<Department> departments = service.fetchDepartment();
        model.addAttribute("departments", departments);
        return "department-list"; // Create an HTML template for the list
    }
    //fetching department by getById
//    @GetMapping("/{id}")
//    public Department getById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
//        return service.getDepartmentById(departmentId);
//    }

    //Deleting department by id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long departmentId)
    {
        service.deleteById(departmentId);
        return "redirect:/departments/list";
    }

    //updating record
//    @PutMapping("/{id}")
//    public Department update(@PathVariable Long departmentId,@RequestBody Department department)
//    {
//        return service.updateDepartmet(departmentId,department);
//    }
//    //updating record by name
//    @GetMapping("/name/{name}")
//    public Department updateName(@PathVariable("name") String departmentName)
//    {
//        return service.updateDepartmet(departmentName);
//    }
    @PostMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id, @ModelAttribute Department department) {
        // Perform the update operation here
        Department updatedDepartment = service.updateDepartmet(id, department);
        // You can add logic to handle the update and return to the list page or show a confirmation
        return "redirect:/departments/list"; // Redirect to the list page after updating
    }
}
