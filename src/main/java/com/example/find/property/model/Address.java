package com.example.find.property.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author aabdelraouf
 *
 */
@Getter
@Setter
@Document(collection  = "Address")
public class Address {

	private String city;
	
	private String country;
	
	private String town;
	
	private String streetName;
	
	private int houseNumber;
	
	private int flatNumber;
	
	private double latitude;
	
	private double longitude;
	
}
