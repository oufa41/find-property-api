package com.example.find.property.mapper;

import org.springframework.stereotype.Component;

import com.example.find.property.dto.AgentDtoV1;
import com.example.find.property.model.Agent;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author aabdelraouf
 *
 */
@Component
@RequiredArgsConstructor
public class AgentMapperV1 implements EntityMapper<AgentDtoV1, Agent> {

	
	/**
	 * 
	 * @param agent entity
	 * @return DTO agent after mapped 
	 */
	@Override
	public AgentDtoV1 toDto(Agent entity) {
		AgentDtoV1 dto = new AgentDtoV1();
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		return dto;
	}

	
	/**
	 * 
	 * @param agent DTO
	 * @return entity agent after mapped 
	 */
	@Override
	public Agent toEntity(AgentDtoV1 dto) {
		
		Agent entity = new Agent();
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhoneNumber());
		return entity;
	}

}
