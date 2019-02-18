package com.amedigital.api.service;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.amedigital.api.model.Planet;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetService {
	 Mono<ResponseEntity<Planet>> addPlanet(Planet newPlanet);

	Flux<Planet> listAll();
	Mono<ResponseEntity<Planet>> findById(UUID id);
	Mono<ResponseEntity<Planet>> findByName(String name);

	Mono<ResponseEntity<Void>> remove(UUID id);
	Flux<Planet> listPlanetsFromSWAPI();
}
