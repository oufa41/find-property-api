package com.example.find.property.model;

import java.util.List;

import org.springframework.data.annotation.Id;
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

	private String title;

	private SellingType sellingType;

	private long price;

	private int size;

	private Address address;

	private List<Photo> photos;

	private Agent agent;

	private Amenities amenities;

	private int numberBedrooms;

	private int numberBathrooms;

}
