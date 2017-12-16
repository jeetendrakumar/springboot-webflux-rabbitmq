package com.accion.reactive.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.accion.reactive.model.MovieEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RabbitMQService {
	
	private final RabbitTemplate rabbitTemplate;
	
	@Value("${movie.event.queue.name}")
	private String MESSAGE_QUEUE;

	public RabbitMQService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	
	public void sendMessage(MovieEvent movieEvent) {
		log.info("Sending message to queue: " + movieEvent);
		rabbitTemplate.convertAndSend(MESSAGE_QUEUE, movieEvent);
	}
	

}
