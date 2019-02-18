package com.amedigital.api;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.amedigital.api.model.Planet;
import com.amedigital.api.repository.PlanetRepository;

import reactor.core.publisher.Mono;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureWebTestClient
public class PlanetControlletTest {

//	@Autowired
//	private PlanetRepository repository;
//
//	@Autowired
//	private WebTestClient testClient;
//
//	private Planet NABOO;
//	private Planet YAVIN;
//	private Planet ALDERAAN;
//	private Planet CORUSCANT;
//	private Planet KAMINO;
//	private Planet GEONOSIS;
//
//	@Before
//	private void setup() {
//		NABOO = Planet.builder().name("Naboo").terrain("grassy hills, swamps, forests, mountains").climate("temperate ").build();
//		ALDERAAN = Planet.builder().name("Alderaan").terrain("grasslands, mountains").climate("temperate").build();
//		YAVIN = Planet.builder().name("Yavin IV").terrain("jungle, rainforests").climate("temperate, tropical").build();
//		CORUSCANT = Planet.builder().name("Coruscant").terrain("cityscape, mountains").climate("temperate ").build();
//		KAMINO = Planet.builder().name("Kamino").terrain("ocean").climate("temperate ").build();
//		GEONOSIS = Planet.builder().name("Geonosis").terrain("rock, desert, mountain, barren").climate("temperate ").build();
//	};
//	
//	@Test
//	public void addNewPlanet() {
//		newPlanet(NABOO);
//		getPlanetByName(NABOO);
//		deletePlanet(NABOO);
//	}
//
//
//
//	@Test
//	public void testGetAllPlanet() {
//		newPlanet(YAVIN);
//		newPlanet(ALDERAAN);
//
//		getAllPlanets();
//
//		deletePlanet(YAVIN);
//		deletePlanet(ALDERAAN);
//	}
//	
//	@Test
//	public void findPlanetByName() {
//		newPlanet(CORUSCANT);
//
//		getPlanetByName(CORUSCANT);
//		
//
//		deletePlanet(CORUSCANT);
//	}
//
//	@Test
//	public void findPlanetById() {
//
//		testClient.get()
//			.uri("/api/planets/name/{id}", Collections.singletonMap("id", planetInserted.getId()))
//			.exchange()
//			.expectStatus().isOk()
//			.expectBody()
//			.jsonPath("$.id").isNotEmpty()
//			.jsonPath("$.name").isEqualTo("Alderaan");
//
//		testClient.delete()
//		.uri("/planet/{id}", Collections.singletonMap("id", planetInserted.getId()))
//		.exchange()
//		.expectStatus();
//	}
//
//	@Test
//	public void testDeletePlanet() {
//		Planet planetInserted = repository.save(p).block();
//
//		testClient.delete()
//			.uri("/planet/{id}", Collections.singletonMap("id", planetInserted.getId()))
//			.exchange()
//			.expectStatus().isOk();
//
//		testClient.get()
//			.uri("/api/planets/{id}", Collections.singletonMap("id", planetInserted.getId()))
//			.exchange()
//			.expectStatus().isNotFound();
//	}
//
//	private void deletePlanet(Planet p) {
//		repository.findByName(p.getName())
//		.flatMap(planet -> 
//			repository.delete(planet));
//	}
//
//	private void getPlanetByName(Planet p) {
//		testClient.get()
//			.uri("/api/planets/name/{name}", Collections.singletonMap("name", p.getName()))
//			.exchange()
//			.expectStatus().isOk()
//			.expectBody()
//			.jsonPath("$.id").isNotEmpty()
//			.jsonPath("$.name").isEqualTo(p.getName());
//	}
//
//	private void newPlanet(Planet p) {
//		testClient.post()
//			.uri("/api/planets")
//			.contentType(MediaType.APPLICATION_JSON_UTF8)
//			.accept(MediaType.APPLICATION_JSON_UTF8)
//			.body(Mono.just(p), Planet.class)
//			.exchange()
//				.expectStatus()
//				.isOk().expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
//				.expectBody()
//				.jsonPath("$.id").isNotEmpty()
//				.jsonPath("$.appearances_number").isNotEmpty();
//	}
//
//	private void getAllPlanets() {
//		testClient.get()
//			.uri("/api/planets")
//			.accept(MediaType.APPLICATION_JSON_UTF8)
//			.exchange()
//			.expectStatus().isOk()
//			.expectBodyList(Planet.class);
//	}
}
