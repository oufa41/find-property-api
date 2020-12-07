package com.example.find.property.dto;

import java.util.List;

import com.example.find.property.model.Amenities;
import com.example.find.property.model.Photo;
import com.example.find.property.model.SellingType;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 
 * @author aabdelraouf
 *
 */
@Data
@NoArgsConstructor
@ApiModel(value = "Property", description = "Property DTO")
public class PropertyDtoV1 {
	
	
private int id;
    
	private String title;
    
	private SellingType sellingType;
	
	private long price;
	
	private int size;
	
	private AddressDtoV1 address;
	
	private List<Photo> photos;
	
	private AgentDtoV1 agent;
	
	private Amenities amenities;
	
	private int numberBedrooms;
	
	private int numberBathrooms;
	
	
}
