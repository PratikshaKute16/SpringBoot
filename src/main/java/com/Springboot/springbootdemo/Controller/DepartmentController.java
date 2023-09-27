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

    @GetMapping("/")
    public String index() {
        return "index";
    }
    //saving department
    @PostMapping("/save")
    public String save(@ModelAttribute Department department, Model model) {
        Department savedDepartment = service.saveDepartment(department);
        model.addAttribute("department", savedDepartment);
        return "welcome"; // Assuming you have a "welcome.html" view for displaying the saved department details.
    }


    @GetMapping("/list")
    public List<Department> fetch() {
        return service.fetchDepartment();
    }
    //fetching department by getById
    @GetMapping("/{id}")
    public Department getById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return service.getDepartmentById(departmentId);
    }

    //Deleting department by id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long departmentId)
    {
        service.deleteById(departmentId);
        return "record deleted successfully";
    }

    //updating record
    @PutMapping("/{id}")
    public Department update(@PathVariable("id") Long departmentId,@RequestBody Department department)
    {
        return service.updateDepartmet(departmentId,department);
    }
    //updating record by name
    @GetMapping("/name/{name}")
    public Department updateName(@PathVariable("name") String departmentName)
    {
        return service.updateDepartmet(departmentName);
    }
}
