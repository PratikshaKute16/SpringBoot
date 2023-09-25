package com.Springboot.springbootdemo.repository;

import com.Springboot.springbootdemo.entitity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>
{

}
