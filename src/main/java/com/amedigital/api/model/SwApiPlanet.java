package com.amedigital.api.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SwApiPlanet implements Serializable {

	private static final long serialVersionUID = -7371351589498369545L;

	private String name;
	private String climate;
	private String terrain;
	private String[] films;
		
	public int getApparitionsCount() {
		if (films == null) {
			return 0;
		} 
		return films.length;
	}

}
