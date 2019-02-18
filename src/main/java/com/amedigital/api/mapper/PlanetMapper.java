package com.amedigital.api.mapper;

import org.springframework.stereotype.Component;

import com.amedigital.api.model.Planet;
import com.amedigital.api.model.SwApiPlanet;

@Component
public class PlanetMapper extends BaseMapper<Planet, SwApiPlanet> {

	@Override
	public SwApiPlanet toGeneric(Planet base) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planet toBase(SwApiPlanet swPlanet) {
		return Planet.builder()
				.id(null)
				.name(swPlanet.getName())
				.climate(swPlanet.getClimate())
				.terrain(swPlanet.getTerrain())
				.appearancesNumber(swPlanet.getFilms().length)
				.build();
	}

}
