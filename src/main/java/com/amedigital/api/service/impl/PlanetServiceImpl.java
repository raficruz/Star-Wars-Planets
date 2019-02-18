package com.amedigital.api.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.amedigital.api.model.Planet;
import com.amedigital.api.repository.PlanetRepository;
import com.amedigital.api.service.PlanetService;
import com.amedigital.api.swapi.SwApiHelper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetRepository repository;

	@Autowired
	private SwApiHelper swClient;

	@Override
	public  Mono<ResponseEntity<Planet>> addPlanet(final Planet newPlanet) {

		Assert.notNull(newPlanet, "New planet must not be null");
		Assert.notNull(newPlanet.getName(), "Name must not be null");
		Assert.notNull(newPlanet.getClimate(), "Climate must not be null");
		Assert.notNull(newPlanet.getTerrain(), "Terrain must not be null");

		Integer appearancesCount = swClient.getPlanetData(newPlanet.getName());
		newPlanet.setAppearancesNumber(appearancesCount);
		
		return repository.save(newPlanet)
				.map(planet -> {
			return ResponseEntity.ok(planet);
		});
	}

	@Override
	public Flux<Planet> listAll() {
		return repository.findAll();
	}

	@Override
	public Mono<ResponseEntity<Planet>> findById(final UUID id) {
		Assert.notNull(id, "Id must not be null");
		return repository.findById(id)
				.map(planet -> {
					return ResponseEntity.ok((Planet) planet);
				});
	}

	@Override
	public Mono<ResponseEntity<Planet>> findByName(String name) {
		Assert.notNull(name, "Name must not be null");
		return repository.findByName(name)
				.map(planet -> {
					return ResponseEntity.ok((Planet) planet);
				});
	}

	@Override
	public Mono<ResponseEntity<Void>> remove(UUID id) {
		return repository.findById(id)
				.flatMap(planet -> 
					repository.delete(planet)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))));
	}

	@Override
	public Flux<Planet> listPlanetsFromSWAPI() {
		return swClient.getPlanets();
	}
}
