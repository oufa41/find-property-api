package com.example.find.property.dto;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(value = "Agent", description = "Property Agent DTO")
public class AgentDtoV1 {

	@JsonView(Views.Detail.class)
	private String name;

	@JsonView(Views.Detail.class)
	private String email;

	@JsonView(Views.Detail.class)
	private long phoneNumber;

}
