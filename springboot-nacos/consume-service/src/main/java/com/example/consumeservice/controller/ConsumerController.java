package com.example.consumeservice.controller;

import com.example.consumeservice.client.ProvideClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConsumerController {
    @Autowired
    ProvideClient provideClient;
    @GetMapping("/testemps")
    @ResponseBody
    public List<Object> findAllEmp(){
        return provideClient.findAllEmp();
    }
    @GetMapping("/testemp")
    @ResponseBody
    public Object findEmpById(@RequestParam(value = "id") Integer id){
        return provideClient.findEmpById(id);
    }
    @PutMapping("/testemp")
    @ResponseBody
    public String updateEmp(@RequestBody Object o){
        return provideClient.updateEmp(o);
    }
    @DeleteMapping("/testemp")
    @ResponseBody
    public String deleteEmp(@RequestParam Integer id){
        return provideClient.deleteEmp(id);
    }
}
