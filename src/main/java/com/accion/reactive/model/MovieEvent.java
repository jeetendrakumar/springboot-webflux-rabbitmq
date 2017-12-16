package com.accion.reactive.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieEvent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4981161628784858616L;
	
	private String movieId;
	private String theatre;
	private Date date;
}