package com.masai.controller;

import com.masai.model.Employee;
import com.masai.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masai/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao empDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee emp){
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
        Employee emps=empDao.save(emp);
        return emps;
    }
    @GetMapping("/admin")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public String admin(){
        return "welcome to MasaiApp for Admin";
    }

}
