package com.example.provideservice.dao;

import com.example.provideservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
    Employee findEmployeeById(Integer id);

}
