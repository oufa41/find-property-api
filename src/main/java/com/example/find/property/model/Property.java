package com.example.find.property.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
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
@Document(collection = "Property")
public class Property {

	@Id
	private int id;

	@TextIndexed(weight = 2)
	private String title;

	
	@TextIndexed(weight = 3)
	private SellingType sellingType;

	
	@TextIndexed(weight = 4)
	private long price;

	private int size;

	@TextIndexed(weight = 5)
	private Address address;

	private List<Photo> photos;

	private Agent agent;

	private Amenities amenities;

	private int numberBedrooms;

	private int numberBathrooms;

}
