package com.datastax.astrakathon.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datastax.astrakathon.model.GuestDetail;
import com.datastax.astrakathon.service.GuestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 value = "/api/apartment/guest",
 description = "Operations on apartment lease management system")
@RequestMapping("/api/apartment/guest")
public class GuestController {
    
    /** Logger for the class. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GuestController.class);
    
    @Autowired private GuestService guestService;
    
    /**
     * Create a apartment in a building
     */
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Create a Guest account", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Guest has been created"),
            @ApiResponse(code = 400, message = "Invalid Apartment name and Building name provided")
    })
    public ResponseEntity<GuestDetail> createApartmentInBuilding (
            HttpServletRequest request,
            @RequestBody GuestDetail guestDetail) {
    	
    	LOGGER.info("Creating a Guest account in society {}", guestDetail.getFirstName());
    	
    	guestService.createGuestAccount(guestDetail);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/api/apartment/guest/create")
                .build()
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(guestDetail);
    }
}