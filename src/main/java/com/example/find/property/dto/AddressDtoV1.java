package com.example.find.property.dto;

import com.fasterxml.jackson.annotation.JsonView;

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
@ApiModel(value = "Address", description = "Property Address DTO")
public class AddressDtoV1 {

	@JsonView(Views.Basic.class)
	private String city;
	
	@JsonView(Views.Basic.class)
	private String country;
	
	@JsonView(Views.Basic.class)
	private String town;
	
	@JsonView(Views.Detail.class)
	private String streetName;
	
	@JsonView(Views.Detail.class)
	private int houseNumber;
	
	@JsonView(Views.Detail.class)
	private int flatNumber;
	
	@JsonView(Views.Basic.class)
	private double latitude;
	
	@JsonView(Views.Basic.class)
	private double longitude;
}
