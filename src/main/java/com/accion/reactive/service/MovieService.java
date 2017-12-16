package com.accion.reactive.service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.accion.reactive.model.Movie;
import com.accion.reactive.model.MovieEvent;
import com.accion.reactive.repository.MovieRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	private final RabbitMQService rabbitMQService;

	public MovieService(RabbitMQService rabbitMQService, MovieRepository movieRepository) {
		this.rabbitMQService = rabbitMQService;
		this.movieRepository = movieRepository;
	}

	public Flux<MovieEvent> events(String movieId) {
		return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
			String[] theatres = { "PVR", "Gopalan", "Rex", "Big Cinemas", "Multiplex", "Innovative", "Cinepolis" };
			int idx = new Random().nextInt(theatres.length);
			String random = (theatres[idx]);
			MovieEvent movieEvent =  new MovieEvent(movieId, random, new Date());
			publishEvent(movieEvent);
			movieEventSynchronousSink.next(movieEvent);
		}).delayElements(Duration.ofSeconds(5));
	}

	public Mono<Movie> getMovieById(String id) {
		return movieRepository.findById(id);
	}

	public Flux<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	
	private void publishEvent(MovieEvent movieEvent) {
		rabbitMQService.sendMessage(movieEvent);
	}
}