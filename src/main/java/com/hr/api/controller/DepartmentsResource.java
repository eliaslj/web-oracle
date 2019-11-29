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

import com.hr.api.model.Department;
import com.hr.api.repository.DepartmentsRepository;


@RestController
@RequestMapping("departments")
public class DepartmentsResource {

	@Autowired
	private DepartmentsRepository repository;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String save(@RequestBody Department departments) {
    	repository.save(departments);
    	return "Saved- " + departments.getDepartmentId();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Department get(@PathVariable("id") long id) {
    	return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	@GetMapping(produces = "application/json")
	public Iterable<Department> get() {
    	return repository.findAll();
	}


	@PutMapping(value = "/{id}", produces = "application/json")
	public Department update(@PathVariable("id") long id, @RequestBody Department departments) {
    	repository.save(departments);
    	return departments;
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public Department delete(@PathVariable("id") long id) {
    	Department departments = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	repository.deleteById(id);
    	return departments;
	}
}
