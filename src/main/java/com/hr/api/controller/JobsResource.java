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

import com.hr.api.model.Job;
import com.hr.api.repository.JobsRepository;

@RestController
@RequestMapping("jobs")
public class JobsResource {

	@Autowired
	private JobsRepository repository;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String save(@RequestBody Job jobs) {
    	repository.save(jobs);
    	return "Saved- " + jobs.getMaxSalary().shortValue();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public Job get(@PathVariable("id") long id) {
    	return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	@GetMapping(produces = "application/json")
	public Iterable<Job> get() {
    	return repository.findAll();
	}


	@PutMapping(value = "/{id}", produces = "application/json")
	public Job update(@PathVariable("id") long id, @RequestBody Job jobs) {
    	repository.save(jobs);
    	return jobs;
	}

	@DeleteMapping(value = "/{id}", produces = "application/json")
	public Job delete(@PathVariable("id") long id) {
    	Job jobs = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	repository.deleteById(id);
    	return jobs;
	}
}