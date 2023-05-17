package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custRepo.save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return custRepo.findByEmail(email).orElseThrow(()->new CustomerException("Customer not found with this Email"));
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		List<Customer> list=custRepo.findAll();
		if(list.isEmpty())throw new CustomerException("Customer not found with this Email");
		return list;
	}

}
