package com.example.find.property.model;

import com.example.find.property.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amenities {
    
	@JsonView(Views.Detail.class)
	private boolean isFurnitured;
    
	@JsonView(Views.Detail.class)
    private boolean hasParking;
    
	@JsonView(Views.Detail.class)
    private boolean hasSecurity;
    
	@JsonView(Views.Detail.class)
    private boolean hasBalcony;
}
