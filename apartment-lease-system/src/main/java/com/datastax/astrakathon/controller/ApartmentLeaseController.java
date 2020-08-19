package com.datastax.astrakathon.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.net.URI;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.datastax.astrakathon.model.LeaseDetail;
import com.datastax.astrakathon.service.ApartmentLeaseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;;

/**
 * REST Controller for below operations on Apartment Lease
 * 	1. createOrRenewLeaseForApartment
 *  2. endLeaseBeforeLeaseEndDateForApartment
 *  3. trasnferLeaseForApartment
 *  
 */
@CrossOrigin
@RestController
@Api(
 value = "/api/apartmentLease",
 description = "Operations on apartment lease management system")
@RequestMapping("/api/apartmentLease")
public class ApartmentLeaseController {
    
    @Autowired private ApartmentLeaseService apartmentLeaseService;
    
    /**
     * Create a apartment in a building
     */
    @PostMapping(value = "/create/lease/{apartmentName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Create lease for apartment between Guest and Lessor", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment lease has been done, congratulations!!"),
            @ApiResponse(code = 400, message = "Invalid Apartment name provided")
    })
    public ResponseEntity<LeaseDetail> createOrRenewLeaseForApartment (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @RequestBody LeaseDetail leaseDetail) {
    	
    	apartmentLeaseService.createOrRenewLeaseForApartment(apartmentName, leaseDetail);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/api/apartmentLease/create/lease/{apartmentName}")
                .buildAndExpand(apartmentName)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).body(leaseDetail);
    }
    
    @PostMapping(value = "/end/lease/{apartmentName}/endDate/{leaseEndDate}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "End lease for apartment between Guest and Lesso before end date", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment lease has been ended"),
            @ApiResponse(code = 400, message = "Invalid Apartment name provided")
    })
    public ResponseEntity<String> endLeaseBeforeLeaseEndDateForApartment (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="leaseEndDate", value="lease end date",example = "0801", required=true )
            @PathVariable(value = "leaseEndDate") Date leaseEndDate) {
    	
    	apartmentLeaseService.endLeaseBeforeLeaseEndDateForApartment(apartmentName, leaseEndDate);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/end/lease/{apartmentName}/endDate/{leaseEndDate}")
                .buildAndExpand(apartmentName, leaseEndDate)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).build();
    }
    
    @PostMapping(value = "/transfer/lease/{apartmentName}/newGuest/{newGuestEmailAddress}/existingGuest/{existingGuestEmailAddress}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
    @ApiOperation(value = "Transfer lease for apartment between Guest and new Guest", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Apartment lease has been transfered"),
            @ApiResponse(code = 400, message = "Invalid Apartment name provided")
    })
    public ResponseEntity<String> trasnferLeaseForApartment (
            HttpServletRequest request,
            @ApiParam(name="apartmentName", value="Apartment name",example = "0801", required=true )
            @PathVariable(value = "apartmentName") String apartmentName,
            @ApiParam(name="newGuestEmailAddress", value="New Guest Email Address",example = "abc@gmail.com", required=true )
            @PathVariable(value = "newGuestEmailAddress") String newGuestEmailAddress,
            @ApiParam(name="existingGuestEmailAddress", value="Existing Guest Email Address",example = "abc@gmail.com", required=true )
            @PathVariable(value = "existingGuestEmailAddress") String existingGuestEmailAddress) {
    	
    	apartmentLeaseService.trasnferLeaseForApartment(apartmentName, newGuestEmailAddress, existingGuestEmailAddress);
    	
        URI location = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath("/transfer/lease/{apartmentName}/newGuest/{newGuestEmailAddress}/existingGuest/{existingGuestEmailAddress}")
                .buildAndExpand(apartmentName, newGuestEmailAddress, existingGuestEmailAddress)
                .toUri();
        // HTTP 201 with confirmation number
        return ResponseEntity.created(location).build();
    }
}