package com.hr.api.repository;




import com.hr.api.model.Job;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource (collectionResourceRel = "job", path = "job")
public interface JobsRepository extends PagingAndSortingRepository <Job, Long> {
	
	
	List<Job> findByLastName(@Param("name") String name);
	
	List<Job>findAll();

}