package com.masai.repository;

import com.masai.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    public Employee findByUserName(String userName);
}
