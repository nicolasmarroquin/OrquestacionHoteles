package com.despegar.hoteles.auth;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class AuthTokenController {
	

	
	private WebClient webClient1 = WebClient.create();
	
	

	public String obtenerToken() {
		
		Flux<Token> tokenFlux;
		Despegar despegar = new Despegar();
		despegar.setIdDespegar("Despegar_Ucentral");
		tokenFlux = webClient1.post()
        .uri("https://hotel-1-api.azurewebsites.net/api/auth/token")
        .body(Mono.just(despegar), Despegar.class)
        .retrieve()
        .bodyToFlux(Token.class);
		
		List<Token> lista = tokenFlux.collectList().block();
		
		return lista.get(0).getToken();
		
	}
}
