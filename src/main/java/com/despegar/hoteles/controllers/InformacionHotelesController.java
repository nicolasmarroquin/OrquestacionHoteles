package com.despegar.hoteles.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.despegar.hoteles.auth.AuthTokenController;
import com.despegar.hoteles.auth.Token;
import com.despegar.hoteles.models.entity.Hotel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class InformacionHotelesController {
	
	@GetMapping({"/informacion/{id}"})
	public Hotel informacionHotel(@PathVariable String id) {
		String token;
		AuthTokenController auth = new AuthTokenController();
		token = auth.obtenerToken();
		
		WebClient webClient1 = WebClient.create();
		
		Flux<Hotel> hotel= webClient1.get()
		.uri("https://hotel-1-api.azurewebsites.net/api/hotel")
		.header("Authorization", "Bearer "+token)
		.retrieve()
        .bodyToFlux(Hotel.class);
		
		return hotel.collectList().block().get(0);
	}
	
	@GetMapping({"/informacion"})
	public List<Hotel> informacionHoteles() {
		String token;
		AuthTokenController auth = new AuthTokenController();
		token = auth.obtenerToken();
		
		WebClient webClient1 = WebClient.create();
		
		Flux<Hotel> hotel= webClient1.get()
		.uri("https://hotel-1-api.azurewebsites.net/api/hotel")
		.header("Authorization", "Bearer "+token)
		.retrieve()
        .bodyToFlux(Hotel.class);
		
		return hotel.collectList().block();
	}

}
