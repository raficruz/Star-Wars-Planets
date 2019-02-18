package com.amedigital.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiSearch {	

	private Integer count;
	
	private SwApiPlanet[] results;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public SwApiPlanet[] getResults() {
		return results;
	}

	public void setResults(SwApiPlanet[] swPlanets) {
		this.results = swPlanets;
	}

}