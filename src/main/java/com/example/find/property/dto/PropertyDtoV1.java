package com.example.find.property.dto;

import java.util.List;

import com.example.find.property.model.Amenities;
import com.example.find.property.model.Photo;
import com.example.find.property.model.SellingType;
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
@ApiModel(value = "Property", description = "Property DTO")
public class PropertyDtoV1 {

	@JsonView(Views.Basic.class)
	private int id;

	@JsonView(Views.Basic.class)
	private String title;

	@JsonView(Views.Basic.class)
	private SellingType sellingType;

	@JsonView(Views.Basic.class)
	private long price;

	@JsonView(Views.Detail.class)
	private int size;

	@JsonView(Views.Basic.class)
	private AddressDtoV1 address;

	@JsonView(Views.Basic.class)
	private List<Photo> photos;

	@JsonView(Views.Detail.class)
	private AgentDtoV1 agent;

	@JsonView(Views.Detail.class)
	private Amenities amenities;

	@JsonView(Views.Basic.class)
	private int numberBedrooms;

	@JsonView(Views.Basic.class)
	private int numberBathrooms;

}
