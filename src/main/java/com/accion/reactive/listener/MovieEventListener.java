package com.accion.reactive.listener;

import org.springframework.stereotype.Component;

import com.accion.reactive.model.MovieEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MovieEventListener {
	
	public void receiveMessage(MovieEvent message) {
        log.info("Received <" + message + ">");
        log.info("Message processed...");
    }

}
