package com.Springboot.springbootdemo.service;

import com.Springboot.springbootdemo.entitity.Department;

import java.util.List;

public interface DepartmentService
{
  public  Department saveDepartment(Department department);

  List<Department> fetchDepartment();

  Department getDepartmentById(Long departmentId);

  void deleteById(Long departmentId);

  Department updateDepartmet(Long departmentId, Department department);

  Department updateDepartmet(String departmentName);
}
