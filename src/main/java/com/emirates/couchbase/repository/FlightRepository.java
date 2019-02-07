package com.emirates.couchbase.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import com.emirates.couchbase.entity.Flight;

/**
 * @author yogesh.jadhav
 * This interface is an Couchbase Repository which is configured to directly
 * interact with Couchbase nosql database.
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "flight", viewName = "all")
public interface FlightRepository extends CouchbaseRepository<Flight, Integer> {

	@Query("#{#n1ql.selectEntity} where #{#n1ql.filter} AND type = $1")
    List<Flight> findByFlightType(String flightType);
}
