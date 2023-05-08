package com.masai.util;

import com.masai.model.Employee;
import com.masai.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class GetCurrentUser {
    @Autowired
    private EmployeeDao empDao;
    public Employee getLoggedInUserDetails(){
        SecurityContext sc= SecurityContextHolder.getContext();
        Authentication auth=sc.getAuthentication();
        String username=auth.getName();
        return empDao.findByUserName(username);
    }
}
