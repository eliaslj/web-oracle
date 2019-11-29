package com.hr.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-12T21:10:55.662-0200")
@StaticMetamodel(Country.class)
public class Country_ {
	public static volatile SingularAttribute<Country, String> countryId;
	public static volatile SingularAttribute<Country, String> countryName;
	public static volatile SingularAttribute<Country, Region> region;
	public static volatile ListAttribute<Country, Location> locations;
}
