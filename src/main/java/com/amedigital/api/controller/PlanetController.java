package com.amedigital.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amedigital.api.model.Planet;
import com.amedigital.api.service.PlanetService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlanetController {

	@Autowired
	private PlanetService service;
	
	@PostMapping("/api/planets")
	@ResponseStatus(HttpStatus.CREATED)
	public  Mono<ResponseEntity<Planet>> addPlanet(@RequestBody Planet p) {
		return service.addPlanet(p);
	}
	
	@GetMapping("/api/planets")
	public Flux<Planet> listAllPlanets(){
		return service.listAll();
	}
	
	@GetMapping("/api/planets/swapi")
	public Flux<Planet> listAllSWAPIPlanets(){
		return service.listPlanetsFromSWAPI();
	}
	
	@GetMapping(value = "/api/planets/name/{name}")
	public Mono<ResponseEntity<Planet>> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping(value = "/api/planets/{id}")
	public Mono<ResponseEntity<Planet>> findById(@PathVariable UUID id){
		return service.findById(id);
	}

	@DeleteMapping("/api/planets/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 public Mono<ResponseEntity<Void>> delete(@PathVariable UUID id) {
		return service.remove(id);
	}
}
