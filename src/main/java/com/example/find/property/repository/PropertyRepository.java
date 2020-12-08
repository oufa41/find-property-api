package com.example.find.property.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.find.property.model.Property;
import com.example.find.property.model.SellingType;

/**
 * 
 * @author aabdelraouf
 *
 */
public interface PropertyRepository extends MongoRepository<Property, Integer> {

	List<Property> findBySellingType(SellingType sellingType);

	List<Property> findByTitleLikeIgnoreCase(String title);
	
	List<Property> findByAddressCityIgnoreCase(String city);
	
	List<Property> findByAddressLikeIgnoreCase(String town);
	
}
