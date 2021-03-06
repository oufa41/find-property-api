package com.example.find.property.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.find.property.dto.PropertyDtoV1;
import com.example.find.property.dto.Views;
import com.example.find.property.model.SellingType;
import com.example.find.property.service.PropertyService;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiParam;

/**
 * 
 * @author aabdelraouf
 *
 */

@RestController
@RequestMapping(path = "/api/property/")
@CrossOrigin
public class PropertyController {

	@Autowired
	public PropertyService propertyService;

	/**
	 * 
	 * @param propertyDtoV1
	 * @return created Property
	 */
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Detail.class)
	public PropertyDtoV1 createProperty(
			@ApiParam(name = "property", type = "PropertyDtoV1", value = "Property to be created", allowMultiple = false) @RequestBody(required = true) PropertyDtoV1 propertyDtoV1) {
		return propertyService.createProperty(propertyDtoV1);
	}

	/**
	 * 
	 * @return list of all properties with its data
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@JsonView(Views.Basic.class)
	public List<PropertyDtoV1> getAllProperty(
			@ApiParam(value = "Property Address") @RequestParam(value = "address", required = false) String addressKeyword,
			@ApiParam(value = "Selling Type of Property") @RequestParam(value = "type", required = false) SellingType type,
			@ApiParam(value = "Property Title") @RequestParam(value = "title", required = false) String title) {
		return propertyService.getAllProperties(addressKeyword, type, title);
	}

	/**
	 * 
	 * @param propertyId
	 * @return property object data
	 */
	@GetMapping("{propertyId}")
	@ResponseStatus(HttpStatus.OK)
	@JsonView(Views.Detail.class)
	public PropertyDtoV1 getProperty(@PathVariable int propertyId) {
		return propertyService.getProperty(propertyId);
	}

	/**
	 * 
	 * @param propertyId
	 * @param propertyDtoV1
	 * @return the updated property object
	 */
	@PutMapping("{propertyId}")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Detail.class)
	public PropertyDtoV1 updateProperty(@PathVariable int propertyId,
			@ApiParam(name = "property", type = "PropertyDtoV1", value = "Property to be created", allowMultiple = false) @RequestBody(required = true) PropertyDtoV1 propertyDtoV1) {
		return propertyService.updatePropertyDtoV1(propertyId, propertyDtoV1);
	}

	/**
	 * 
	 * @param propertyId
	 *
	 * @return responseEntity for object deletion with its id
	 */
	@DeleteMapping("{propertyId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> deleteProperty(@PathVariable int propertyId) {

		propertyService.deleteProperty(propertyId);
		return new ResponseEntity<Integer>(propertyId, HttpStatus.OK);
	}
}
