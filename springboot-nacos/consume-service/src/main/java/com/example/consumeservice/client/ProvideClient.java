package com.example.consumeservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("provide")
public interface ProvideClient {
    @GetMapping("/employees")
    List<Object> findAllEmp();
    @GetMapping("/employee")
    Object findEmpById(@RequestParam(value = "id") Integer id);
    @PutMapping("/employee")
    String updateEmp(Object o);
    @DeleteMapping("/employee")
    String deleteEmp(@RequestParam(value = "id")Integer id);
}
