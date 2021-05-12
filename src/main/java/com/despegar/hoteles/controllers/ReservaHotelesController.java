package com.despegar.hoteles.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.despegar.hoteles.auth.AuthTokenController;
import com.despegar.hoteles.models.entity.HotelEntity;
import com.despegar.hoteles.models.entity.Huesped;
import com.despegar.hoteles.models.entity.Reserva;
import com.despegar.hoteles.models.entity.ReservaHotelEntity;
import com.despegar.hoteles.models.entity.UsuariosEntity;
import com.despegar.hoteles.models.service.IHotelService;
import com.despegar.hoteles.models.service.IReservaHotelService;
import com.despegar.hoteles.models.service.IUsuariosService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/reserva")
public class ReservaHotelesController {
	
	private final String PREFIX = "Bearer ";
	private final String SECRET = "despegar";
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@Autowired
	private IReservaHotelService reservaHotelService;
	
	@Autowired
	private IHotelService hotelService;
	
	@PostMapping("/realizar")
	public Reserva realizarReserva(@RequestHeader("Authorization") String token,@RequestBody Reserva reserva) {
		
		String jwtToken =token.replace(PREFIX, "");
		
		Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	
		long idusuario=Integer.valueOf(claims.getSubject());
		
		UsuariosEntity usuario = usuariosService.findById(idusuario);
		
		String[] nombres = usuario.getNombres().split(" ");
		String[] apellidos = usuario.getApellidos().split(" ");
		
		Huesped titular = new Huesped();
		
		titular.setIdHuesped(usuario.getIdusuario().toString());
		titular.setTitular(true);
		if(nombres.length >= 2) {
			titular.setPrimerNombre(nombres[0]);
			titular.setSegundoNombre(nombres[1]);
		}else {
			titular.setPrimerNombre(nombres[0]);
		}
		
		if(apellidos.length >= 2) {
			titular.setPrimerApellido(apellidos[0]);
			titular.setSegundoApellido(apellidos[1]);
		}else {
			titular.setPrimerApellido(apellidos[0]);
		}
		
		titular.setCorreoElectronico(usuario.getEmail());
		titular.setTelefono(Long.valueOf(usuario.getTelefonomovil()));
		
		reserva.getReservaHuespedes().add(titular);
		
		String tokenHotel;
		AuthTokenController auth = new AuthTokenController();
		tokenHotel = auth.obtenerToken();
		
		Mono<Reserva> reservaMono;
		WebClient webClient1 = WebClient.create();
		
		reservaMono = webClient1.post()
				.uri("https://hotel-1-api.azurewebsites.net/api/reserva/crear")
				.header("Authorization", "Bearer "+tokenHotel)
				.body(Mono.just(reserva),Reserva.class)
				.retrieve()
				.bodyToMono(Reserva.class);
		Reserva reservaResp = new Reserva();
		reservaResp = reservaMono.block();
		HotelEntity hotelReserva = hotelService.findById(reserva.getIdHotel());
		ReservaHotelEntity reservaHotel = new ReservaHotelEntity();
		reservaHotel.setUsuario(usuario);
		reservaHotel.setHotel(hotelReserva);
		reservaHotel.setIdReservaHotel(reservaResp.getIdReserva());
		try {
			reservaHotel.setFecha_inicio(new SimpleDateFormat("yyyy-MM-dd").parse(reserva.getFechaInicio()));
			reservaHotel.setFecha_fin(new SimpleDateFormat("yyyy-MM-dd").parse(reserva.getFechaFin()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reservaHotel.setEstadoReserva(reservaResp.getEstadoReservas().getDescripcion());
		reservaHotel.setNumeroPersonas(reserva.getNumeroPersonas());
		reservaHotel.setValor(reserva.getValor());
		
		reservaHotelService.save(reservaHotel);
		
		return reservaResp;
		
		
	}
	
	
	@GetMapping("/consultar")
	public List<ReservaHotelEntity> obtenerInfoReservas(@RequestHeader("Authorization") String token){
		
		String tokenHotel;
		AuthTokenController auth = new AuthTokenController();
		tokenHotel = auth.obtenerToken();
		
		
		String jwtToken =token.replace(PREFIX, "");
		
		Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	
		long idusuario=Integer.valueOf(claims.getSubject());
		UsuariosEntity usuario = usuariosService.findById(idusuario);
		
		List<ReservaHotelEntity> reservas = reservaHotelService.findByUsuario(usuario);
		
		WebClient webClient1 = WebClient.builder().baseUrl("https://hotel-1-api.azurewebsites.net/api").build();
		
		for (ReservaHotelEntity reserva : reservas) {
			
			Reserva reservaHotel = webClient1.get()
					.uri(uriBuilder -> uriBuilder
							.path("/reserva/detalle")
							.queryParam("idReserva", reserva.getIdReservaHotel())
							.build())
							.header("Authorization", "Bearer "+tokenHotel)
							.retrieve()
							.bodyToMono(Reserva.class).block();
			if(!reservaHotel.getEstadoReservas().getDescripcion().equals(reserva.getEstadoReserva())) {
				reserva.setEstadoReserva(reservaHotel.getEstadoReservas().getDescripcion());
				reservaHotelService.save(reserva);
			}
		}
		
		
		return reservas;
	} 
	
	@PostMapping({"/cancelar/{id}"})
	public String cancelarReserva(@PathVariable long id) {
		ReservaHotelEntity reserva = reservaHotelService.findById(id);
		
		if(reserva.getEstadoReserva().equals("Cancelada")) {
			return "La reserva ya fue cancelada";
		}else {
			String tokenHotel;
			AuthTokenController auth = new AuthTokenController();
			tokenHotel = auth.obtenerToken();
			
			WebClient webClient1 = WebClient.builder().baseUrl("https://hotel-1-api.azurewebsites.net/api").build();
			
			Reserva reservaHotel = webClient1.get()
					.uri(uriBuilder -> uriBuilder
							.path("/reserva/detalle")
							.queryParam("idReserva", reserva.getIdReservaHotel())
							.build())
							.header("Authorization", "Bearer "+tokenHotel)
							.retrieve()
							.bodyToMono(Reserva.class).block();
			if(reservaHotel.getEstadoReservas().getDescripcion().equals("Cancelada")) {
				return "La reserva ya se encuentra cancelada en el hotel";
			}else {
				Reserva reservaHotelCan = webClient1.post()
						.uri(uriBuilder -> uriBuilder
								.path("/reserva/cancelar")
								.queryParam("idReserva", reserva.getIdReservaHotel())
								.build())
						.header("Authorization", "Bearer "+tokenHotel)
						.retrieve()
						.bodyToMono(Reserva.class).block();
						
				if(reservaHotelCan.getEstadoReservas().getDescripcion().equals("Cancelada")) {
					reserva.setEstadoReserva("Cancelada");
					reservaHotelService.save(reserva);
					return "OK";
					
				}else
					return "ERROR";
			}
			
		}
	}
	
	

}
