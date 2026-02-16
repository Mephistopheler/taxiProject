package com.efcon.tripservice.repository;

import com.efcon.tripservice.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {



}
