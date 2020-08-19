package com.datastax.astrakathon.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.net.URI;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datastax.astrakathon.model.ApartmentBuildingDetail;
import com.datastax.astrakathon.service.ApartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;;

/**
 * REST Controller for below operations on Apartments in a building
 * 	1. Create apartment in a building
 *  2. Update apartment availability for a lease
 *  3. List all apartment facilities
 *  4. Add new facilities to existing facilities to a apartment in a building
 *  5. Delete facilities for a apartment in a building
 */
@CrossOrigin
@RestController
@Api(
 value = "/api/apartment",
 description = "Operations on apartment lease management system")
@RequestMapping("/api/apartment")
public class ApartmentController {
    
    /** Logger for the class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApartmentController.class);
    
    @Autowired private ApartmentService apartmentService;
    
    /**
     * Create a apartment in a building
     */
    @PostMapping(value = "/create/{apartmentName}/building/{buildingName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Tag a apartment to a building with all apartment details", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment tagged to a building"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<String> createApartmentInBuilding (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="buildingName", value="Building name",example = "tower-8", required=true )
            @PathVariable(value = "buildingName") String buildingName,
            @RequestBody ApartmentBuildingDetail aprtmentDetails) {
    	
    	LOGGER.info("Creating a apartment {} in a building {}", apartmentName, buildingName);
    	
    	apartmentService.createApartmentInBuilding(apartmentName, buildingName, aprtmentDetails);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/api/create/{apartmentName}/building/{buildingName}")
                .buildAndExpand(apartmentName, buildingName)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(buildingName.toString() + "-" + apartmentName.toString());
    }
   
    /**
     * Update apartment availability for a lease in a building
     */
    @PostMapping(value = "/update/{apartmentName}/availbility-for-lease/building/{buildingName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Tag a apartment to a building with all apartment details", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment tagged to a building"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<String> updateApartmentAvailabilityForLease (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="buildingName", value="Building name",example = "tower-8", required=true )
            @PathVariable(value = "buildingName") String buildingName,
            @RequestBody Boolean apartmentAvailabilityForLease) {
    	
    	LOGGER.info("Update apartment {} availability for a lease in a building {}", apartmentName, buildingName);
    	
    	apartmentService.updateApartmentAvailabilityForLease(apartmentName, buildingName, apartmentAvailabilityForLease);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/update/{apartmentName}/availbility-for-lease/building/{buildingName}")
                .buildAndExpand(apartmentName, buildingName)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(buildingName.toString() + "-" + apartmentName.toString());
    }
    
    /**
     * Update apartment facilities in a building
     */
    @PostMapping(value = "/add/{apartmentName}/facilities/building/{buildingName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Add new facilities to apartment in a building", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "New facilities to apartment has been adeed in a building"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<Set<String>> addNewFacilitiesToApartmentInBuilding (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="buildingName", value="Building name",example = "tower-8", required=true )
            @PathVariable(value = "buildingName") String buildingName,
            @RequestBody Set<String> apartmentFacilities) {
    	
    	LOGGER.info("Update apartment {} facilities in a building {}", apartmentName, buildingName);
    	
    	Set<String> newApartmentFacilities = apartmentService.addNewFacilitiesToApartmentInBuilding(apartmentName, buildingName, apartmentFacilities);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/add/{apartmentName}/facilities/building/{buildingName}")
                .buildAndExpand(apartmentName, buildingName)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(newApartmentFacilities);
    }
    
    /**
     * Delete apartment facilities in a building
     */
    @PostMapping(value = "/delete/{apartmentName}/facilities/building/{buildingName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Delete facilities from apartment in a building", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Facilities have been deleted from apartment in a building"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<Set<String>> deleteFacilitiesFromApartmentInBuilding (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="buildingName", value="Building name",example = "tower-8", required=true )
            @PathVariable(value = "buildingName") String buildingName,
            @RequestBody Set<String> apartmentFacilities) {
    	
    	LOGGER.info("Update apartment {} facilities in a building {}", apartmentName, buildingName);
    	
    	Set<String> newApartmentFacilities = apartmentService.deleteFacilitiesFromApartmentInBuilding(apartmentName, buildingName, apartmentFacilities);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/delete/{apartmentName}/facilities/building/{buildingName}")
                .buildAndExpand(apartmentName, buildingName)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(newApartmentFacilities);
    }
    
    /**
     * List apartment facilities in a building
     */
    @GetMapping(value = "/list/{apartmentName}/facilities/building/{buildingName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all apartment facilities in a building", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment facilities listed"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<Set<String>> listApartmentFacilitiesInBuilding(
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="buildingName", value="Building name",example = "tower-8", required=true )
            @PathVariable(value = "buildingName") String buildingName) {
    	
    	Set<String> apartmentFacilities = apartmentService.listAllApartmentFacilities(apartmentName, buildingName);
    	return ResponseEntity.ok(apartmentFacilities) ;
	}
}