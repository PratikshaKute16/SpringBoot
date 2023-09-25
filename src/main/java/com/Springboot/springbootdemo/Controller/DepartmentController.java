package com.Springboot.springbootdemo.Controller;

import com.Springboot.springbootdemo.entitity.Department;
import com.Springboot.springbootdemo.error.DepartmentNotFoundException;
import com.Springboot.springbootdemo.service.DepartmentService;
import com.Springboot.springbootdemo.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService service;

     //saving department
    @PostMapping("/Department")
    public Department save(@Valid @RequestBody Department department)
    {
        return service.saveDepartment(department);
    }

    //fetching department rom db
   @GetMapping("/Department")
    public List<Department> fetch()
    {
        return service.fetchDepartment();
    }

    //fetching department by getById
    @GetMapping("/Department/{id}")
    public Department getById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return service.getDepartmentById(departmentId);
    }

    //Deleting department by id
    @DeleteMapping("/Department/{id}")
    public String delete(@PathVariable("id") Long departmentId)
    {
        service.deleteById(departmentId);
        return "recoerd deleted successfully";
    }

    //updating record
    @PutMapping("/Department/{id}")
    public Department update(@PathVariable("id") Long departmentId,@RequestBody Department department)
    {
        return service.updateDepartmet(departmentId,department);
    }
    //updating record by name
    @GetMapping("/Department/name/{name}")
    public Department updateName(@PathVariable("name") String departmentName)
    {
        return service.updateDepartmet(departmentName);
    }
}
