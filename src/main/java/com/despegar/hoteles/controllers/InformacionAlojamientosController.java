package com.despegar.hoteles.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.despegar.hoteles.auth.AuthTokenController;
import com.despegar.hoteles.models.entity.Alojamiento;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/alojamientos")
public class InformacionAlojamientosController {
	
	@GetMapping("/fechas")
	public List<Alojamiento> obtenerInformacionAlojamientos(@RequestParam String ingreso,@RequestParam String salida,@RequestParam String destino) {
		String token;
		AuthTokenController auth = new AuthTokenController();
		token = auth.obtenerToken();
		
		List<Alojamiento> alojamientos = new ArrayList<>();
		System.out.print(destino);
		if (destino.equals("BOG")) {
			System.out.print("dgdfgdf");
			WebClient webClient1 = WebClient.builder().baseUrl("https://hotel-1-api.azurewebsites.net/api").build();
			alojamientos = webClient1.get()
					.uri(uriBuilder -> uriBuilder
					.path("/alojamientos")
					.queryParam("checkIn", ingreso)
					.queryParam("checkOut", salida)
					.queryParam("codCiudad", destino)
					.build())
					.header("Authorization", "Bearer "+token)
					.retrieve()
					.bodyToFlux(Alojamiento.class)
					.onErrorReturn(new Alojamiento())
					.collectList().block();
			
			
			
		
		
		
		
		
		for (Alojamiento alojamiento : alojamientos) {
			alojamiento.setIdHotel(new InformacionHotelesController().informacionHotel("90064825-H"));
		}
			
		}	
			
		
		return alojamientos;
		
	}
	
	@GetMapping("/tipo")
	public List<Alojamiento> obtenerInformacionAlojamientos(@RequestParam String tipo) {
		String token;
		AuthTokenController auth = new AuthTokenController();
		token = auth.obtenerToken();
		
		WebClient webClient1 = WebClient.builder().baseUrl("https://hotel-1-api.azurewebsites.net/api").build();
		List<Alojamiento> alojamientos = webClient1.get()
				.uri(uriBuilder -> uriBuilder
				.path("/alojamientos/detalle")
				.queryParam("idTipoAlojamiento", tipo)
				.build())
				.header("Authorization", "Bearer "+token)
				.retrieve()
				.bodyToFlux(Alojamiento.class)
				.collectList().block();
		
		for (Alojamiento alojamiento : alojamientos) {
			alojamiento.setIdHotel(new InformacionHotelesController().informacionHotel("90064825-H"));
		}
		
		return alojamientos;
		
	}

}
