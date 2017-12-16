package com.accion.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.accion.reactive.model.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}