package com.hr.api.repository;
 

import com.hr.api.model.Department;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource (collectionResourceRel = "departments", path = "departments")
public interface DepartmentsRepository extends PagingAndSortingRepository <Department, Long> {
	
	List<Department> findByLastName(@Param("name") String name);
	
	
	List<Department>findAll();
}

