package com.masai.config;

import com.masai.model.Employee;
import com.masai.model.MyUserDetails;
import com.masai.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeDao empDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Employee opt = empDao.findByUserName(username);
     if(opt!=null){
       return  new MyUserDetails(opt);
     }else{
         throw new UsernameNotFoundException("Username not found");
     }

    }
}
