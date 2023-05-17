package com.masai.Controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repo.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepository cs;
	
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	@GetMapping("/signIn")
	public Customer getLogInCustomerHandler(Authentication auth) {
		System.out.println(auth);
		Customer  customer=cs.findByEmail(auth.getName()).orElseThrow(()->new BadCredentialsException("Credential Invalid"));
		return customer;
	}

}
