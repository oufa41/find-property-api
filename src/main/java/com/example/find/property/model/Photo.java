package com.example.find.property.model;

import com.example.find.property.dto.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author aabdelraouf
 *
 */
@Getter
@Setter
public class Photo {
	
	@JsonView(Views.Basic.class)
	private String url;
	
}
