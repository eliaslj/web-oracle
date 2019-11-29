package com.hr.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-12T21:10:55.849-0200")
@StaticMetamodel(Location.class)
public class Location_ {
	public static volatile SingularAttribute<Location, Long> locationId;
	public static volatile SingularAttribute<Location, String> city;
	public static volatile SingularAttribute<Location, String> postalCode;
	public static volatile SingularAttribute<Location, String> stateProvince;
	public static volatile SingularAttribute<Location, String> streetAddress;
	public static volatile ListAttribute<Location, Department> departments;
	public static volatile SingularAttribute<Location, Country> country;
}
