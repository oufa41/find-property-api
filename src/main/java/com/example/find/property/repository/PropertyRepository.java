package com.example.find.property.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.find.property.model.Property;
import com.example.find.property.model.SellingType;

/**
 * 
 * @author aabdelraouf
 *
 */
public interface PropertyRepository extends MongoRepository<Property, Integer> {

	@Query("{'sellingType': ?0}")
	List<Property> findBySellingType(SellingType sellingType);

}
