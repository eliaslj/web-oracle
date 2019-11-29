package com.hr.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-12T21:10:55.709-0200")
@StaticMetamodel(Department.class)
public class Department_ {
	public static volatile SingularAttribute<Department, Long> departmentId;
	public static volatile SingularAttribute<Department, String> departmentName;
	public static volatile SingularAttribute<Department, Employee> employee;
	public static volatile SingularAttribute<Department, Location> location;
	public static volatile ListAttribute<Department, Employee> employees;
	public static volatile ListAttribute<Department, JobHistory> jobHistories;
}
