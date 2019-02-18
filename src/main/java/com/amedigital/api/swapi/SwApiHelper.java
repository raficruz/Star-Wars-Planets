package com.amedigital.api.swapi;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import com.amedigital.api.mapper.PlanetMapper;
import com.amedigital.api.model.Planet;
import com.amedigital.api.model.SwapiSearch;

import reactor.core.publisher.Flux;

@Component
public class SwApiHelper {

	@Autowired(required = true)
	private RestOperations operations;

	@Autowired
	private PlanetMapper mapper;

	@Value("${swapi.url}")
	private String baseUrl;

	@Value("${swapi.planets.list.api}")
	private String planetsListApi;

	public Integer getPlanetData(final String name) {
		HttpEntity<SwapiSearch> response = executeRequest(getHttpEntity());

		return Arrays.asList(response.getBody().getResults())
				.stream().filter(p -> p.getName().equals(name))
				.mapToInt(p -> p.getApparitionsCount())
				.findAny()
				.getAsInt();
	}

	public Flux<Planet> getPlanets() {
		try {
			HttpEntity<SwapiSearch> response = executeRequest(getHttpEntity());
			
			return Flux.fromIterable(mapper.castListOfGenericToListOfBase(Arrays.asList(response.getBody().getResults())));
		} catch (Exception ex) {
			return null;
		}
	}

	private HttpEntity<SwapiSearch> executeRequest(HttpEntity<?> entity) {
		HttpEntity<SwapiSearch> response = operations.exchange("https://swapi.co/api/planets", 
																HttpMethod.GET,
																entity,
																SwapiSearch.class);
		return response;
	}

	private HttpEntity<?> getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:55.0) Gecko/20100101 Firefox/55.0");
		HttpEntity<?> entity = new HttpEntity<>(headers);
		return entity;
	}
}
