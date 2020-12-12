package com.example.find.property.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
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

	/**
	 * filter by sellingType
	 * 
	 * @param sellingType
	 * @return matching list of properties
	 */
	List<Property> findBySellingType(SellingType sellingType);

	/**
	 * filter by address
	 * 
	 * @param address keyword
	 * @return matching list of properties
	 */
	@Query("{'$or':[ {'address.country': {$regex : ?0, $options: 'i'}}, "
			+ "{'address.city': {$regex : ?0, $options: 'i'}} ," + "{'address.town':{$regex : ?0, $options: 'i'}} ,"
			+ "{'address.streetName':{$regex : ?0, $options: 'i'}} ]}")
	List<Property> findByAddress(String keywoard);

	/**
	 * filter by address and sellingType
	 * 
	 * @param address keyword
	 * @param sellingType
	 * @return matching list of properties
	 */
	@Query("{$and: [" + "{'$or':[ {'address.country': {$regex : ?0, $options: 'i'}}, "
			+ "{'address.city': {$regex : ?0, $options: 'i'}} ," + "{'address.town':{$regex : ?0, $options: 'i'}} ,"
			+ "{'address.streetName':{$regex : ?0, $options: 'i'}} ]}," + "{'sellingType': ?1}" + "] }")
	List<Property> findByAddressAndSellingType(String keyword, SellingType sellingType);
	
	
//	List<Property> findByTitleLikeIgnoreCase(String title);
//
//	List<Property> findByAddressCityIgnoreCase(String city);
	
	// Execute a full-text search and define sorting dynamically
	 
	List<Property> findAllBy(TextCriteria criteria);
	
	List<Property> findByTitleOrderByScoreDesc(String title, TextCriteria criteria);



}
