package com.hr.api.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hr.api.model.Employee;
import com.hr.api.repository.EmployeesRepository;


@RestController
@RequestMapping("employee")
public class EmployeesResource {

	@Autowired
	private EmployeesRepository repository;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String save(@RequestBody Employee employee) {
    	repository.save(employee);
    	return "Saved- " + employee.getCommissionPct().shortValue();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Employee get(@PathVariable("id") long id) {
    	return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	@GetMapping(produces = "application/json")
	public Iterable<Employee> get() {
    	return repository.findAll();
	}


	@PutMapping(value = "/{id}", produces = "application/json")
	public Employee update(@PathVariable("id") long id, @RequestBody Employee employee) {
    	repository.save(employee);
    	return employee;
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public Employee delete(@PathVariable("id") long id) {
    	Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	repository.deleteById(id);
    	return employee;
	}
}