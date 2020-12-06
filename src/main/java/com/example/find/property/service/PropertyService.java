package com.example.find.property.service;
import java.util.List;

import com.example.find.property.dto.PropertyDtoV1;


/**
 * 
 * @author aabdelraouf
 *
 */
public interface PropertyService {

	
	/**
	 * 
	 * Create Property to the database 
	 * 
	 * @param property object details to be saved 
	 * @return the created object to the controller 
	 */
	public PropertyDtoV1 createProperty(final PropertyDtoV1 property);
	
	
	/**
	 * 
	 * Handling deleting property  object by id from database  
	 * @param id property ID to be deleted
	 */
	public void deleteProperty(final int id);
	
	
	/**
	 * 
	 * Retrieving all properties from the database
	 * @return the list of all properties object
	 */
	public List<PropertyDtoV1> getAllProperties();
	
	
	
	/**
	 * 
	 * Get an property object by its ID from the database
	 * 
	 * @param id property ID to be find
	 * @return property object details
	 */
	public PropertyDtoV1 getProperty(final int id);
	
	
	/**
	 * 
	 * Update an property object data in the database
	 * 
	 * @param id property ID to be find
	 * @param property object to be updated
	 * @return the updated property object
	 */
	public PropertyDtoV1 updatePropertyDtoV1(final int id, final PropertyDtoV1 property);

	
	
}
