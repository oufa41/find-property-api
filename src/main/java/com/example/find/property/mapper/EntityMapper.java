package com.example.find.property.mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author aabdelraouf
 *
 * @param <D> DTO
 * @param <E> Entity
 */

public interface EntityMapper<D,E> {

	
	/**
	 * 
	 * @param entity
	 * @return The DTO after mapping
	 */
	public abstract D toDto(E entity);
	
	
	/**
	 * 
	 * @param entityList entity list to map
	 * @return The list of mapped DTOs
	 */
	public default List<D> toDto(List<E> entityList) {
		return entityList.stream().map(this::toDto).collect(Collectors.toList());
	}
	/**
	 * 
	 * @param dto
	 * @return The Entity after mapping
	 */
	public abstract E toEntity(D dto);
	
	
	
	/**
	 * 
	 * @param dtoList DTO list to map
	 * @return The list of mapped entities
	 */
	public default List<E> toEntity(List<D> dtoList) {
		return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
}
