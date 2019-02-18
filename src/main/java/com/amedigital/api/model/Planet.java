package com.amedigital.api.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("planet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Planet implements Serializable {

	private static final long serialVersionUID = 4732525603615775372L;

	@PrimaryKey
	@Builder.Default
    private UUID id = UUIDs.timeBased();

	private String name;
	private String climate;
	private String terrain;
	
	@JsonProperty(value = "appearances_number")
	@Column(value="appearances_number")
	private Integer appearancesNumber;
}
