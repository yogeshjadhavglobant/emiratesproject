package com.emirates.couchbase.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yogesh.jadhav
 * Entity Class to store flight information. Use of lombok library to simplify
 * access to the entity.
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Flight {

	@NotNull
    @Id
    private int id;
	
	@NotNull
    @Field
	private String name;
	
	@NotNull
    @Field
	private String type;
}
