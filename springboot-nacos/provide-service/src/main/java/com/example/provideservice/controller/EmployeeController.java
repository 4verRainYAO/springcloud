package com.example.provideservice.controller;

import com.example.provideservice.dao.EmployeeDao;
import com.example.provideservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @PostMapping(value = "/employee")
    @ResponseBody
    public String addEmployee(@RequestBody Employee employee){
        String flag = "ok";
        try{
            employeeDao.save(employee);
        }catch (Exception e){
            flag = "failed";
        }
        return flag;
    }
    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> findAllEmp(){
        return employeeDao.findAll();
    }
    @GetMapping("/employee")
    @ResponseBody
    public Employee findEmpById(@RequestParam Integer id){
        return employeeDao.findEmployeeById(id);
    }
    @PutMapping("/employee")
    @ResponseBody
    public String updateEmp(@RequestBody Employee employee){
        String flag = "ok";
        Employee employee1 = employeeDao.findEmployeeById(employee.getId());
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        try{
            employeeDao.save(employee1);
        }catch (Exception e){
            flag = "failed";
        }
        return flag;
    }
    @DeleteMapping("/employee")
    @ResponseBody
    public String deleteEmp(@RequestParam Integer id){
        String flag = "ok";
        try {
            Employee employee = employeeDao.findEmployeeById(id);
            employeeDao.delete(employee);
        }catch (Exception e){
            flag = "failed";
        }
        return flag;
    }
}
