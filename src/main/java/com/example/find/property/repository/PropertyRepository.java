package com.example.find.property.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.find.property.domain.Property;

/**
 * 
 * @author aabdelraouf
 *
 */
public interface PropertyRepository extends MongoRepository<Property, Integer> {

}
