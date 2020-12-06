package com.example.find.property.dto;

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
	
	
	public int id;
	
	public String name;
	
	public String address;
	
	
}
