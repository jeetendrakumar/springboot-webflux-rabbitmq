package com.accion.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.accion.reactive.model.Movie;
import com.accion.reactive.repository.MovieRepository;

import reactor.core.publisher.Flux;

@Component
public class BootstrapCLR implements CommandLineRunner {

	private final MovieRepository movieRepository;

	public BootstrapCLR(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// clear old data
		movieRepository.deleteAll()
				.thenMany(Flux
						.just("Silence of the Lambs", "Aeon Flux", "Enter the Dragon", "The Terminator",
								"Back to the Future", "Meet the Spartans", "Lord of the Rings")
						.map(title -> new Movie(title)).flatMap(movieRepository::save))
				.subscribe(null, null, () -> {
					movieRepository.findAll().subscribe(System.out::println);
				});
	}
}