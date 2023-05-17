package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.masai.model.Customer;
import com.masai.repo.CustomerRepository;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private CustomerRepository cr;
	@Autowired
	private PasswordEncoder ps;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=authentication.getName();
		String pwd=authentication.getCredentials().toString();
		System.out.println(username);
		System.out.println(pwd);
		Optional<Customer> opt=cr.findByEmail(username);
		if(!opt.isPresent()) {
			throw new BadCredentialsException("No User Register with this Details");
		}else {
			Customer cust=opt.get();
			if(ps.matches(pwd, cust.getPassword())) {
				List<GrantedAuthority> autority=new ArrayList<>();
				return new UsernamePasswordAuthenticationToken(username, pwd,autority);
				
			}else {
				throw new BadCredentialsException("invalid password");
			}
		}
		
	
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	

}
