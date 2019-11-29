package com.hr.api.repository;

import com.hr.api.model.Employee;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource (collectionResourceRel = "employee", path = "employee")
public interface EmployeesRepository extends PagingAndSortingRepository <Employee, Long> {
	
	List<Employee> findByLastName(@Param("name") String name);
}