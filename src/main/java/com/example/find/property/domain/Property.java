package com.example.find.property.domain;

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
@Document(collection = "property")
public class Property {
	
    @Id
	private int id;
	private String name;
	private String address;
	

}
