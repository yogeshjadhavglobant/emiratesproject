package com.emirates.couchbase.outboundcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.couchbase.entity.Flight;
import com.emirates.couchbase.service.FlightService;

/**
 * @author yogesh.jadhav
 * Controller class to map the incoming URLs to respective functionalities.
 */
@RestController
public class EmirateServiceController {

	@Autowired
	FlightService service;
	
	@RequestMapping(method=RequestMethod.GET,
					value="/flightInfo/{flightId}",
					produces=MediaType.APPLICATION_JSON_VALUE)
	public Flight getFlightInfo(@PathVariable("flightId") String flightId) {
		return service.fetchFlightDetails(Integer.valueOf(flightId));
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/flightInfoForType/{flightType}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Flight> getFlightInfoForType(@PathVariable("flightType") String flightType) {
		return service.fetchFlightDetailsForType(flightType);
	}
	
	@RequestMapping(method=RequestMethod.POST,
					value="/updateFlightInfo/")
	public void insertFlightInfo(@RequestBody Flight flight) {
		service.insertFlightInfo(flight);
	}
	
	
}
