package com.amedigital.api.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.amedigital.api.model.Planet;

import reactor.core.publisher.Mono;

@Repository
public interface PlanetRepository extends ReactiveCassandraRepository<Planet, UUID> {

	@AllowFiltering
	Mono<Planet> findByName(String name);
	
}
