package com.emirates.couchbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.couchbase.entity.Flight;
import com.emirates.couchbase.repository.FlightRepository;


/**
 * @author yogesh.jadhav
 * Service to interact with Flight information.
 */
@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	/**
	 * @param flightId : Unique identifier for the flight.
	 * @return flight entity
	 */
	public Flight fetchFlightDetails(int flightId) {
		Optional<Flight> flight =  flightRepository.findById(flightId);
		return flight.get()!=null?flight.get():new Flight();
	}
	
	/**
	 * @param flightType : Type of Flight with reference to its make.
	 * @return list of flights
	 */
	public List<Flight> fetchFlightDetailsForType(String flightType) {
		List<Flight> flightList =  flightRepository.findByFlightType(flightType);
		return flightList;
	}
	
	/**
	 * @param flight : Flight entity.
	 * @return boolean for save result.
	 */
	public boolean insertFlightInfo(Flight flight) {
		flightRepository.save(flight);
		return true;
	}
}
