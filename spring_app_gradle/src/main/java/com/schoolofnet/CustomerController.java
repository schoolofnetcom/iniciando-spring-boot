package com.schoolofnet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolofnet.entity.Customer;
import com.schoolofnet.entity.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	public CustomerController(CustomerRepository customerRepository) {
		this.repository = customerRepository;
	}
	
	@GetMapping
	@ResponseBody
	public List<Customer> findAll() {
		return (List<Customer>) repository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@ResponseBody
	public Customer findOne(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/name/{name}")
	@ResponseBody
	public Customer findByName(@PathVariable String name) {
		return repository.findByName(name);
	}
	
	@PostMapping
	@ResponseBody
	public Customer create(@RequestParam String name, @RequestParam Integer age) {
		Customer customer = new Customer(name, age);
		
		if (name != null && name.length() > 0 && age != null && age > 0) {
			repository.save(customer);			
		}
		
		
		return customer;
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public void destroy(@PathVariable Long id) {
		Customer customer = repository.findById(id).orElse(null);
		
		if (customer != null) {			
			repository.delete(customer);
		}
	}
}
