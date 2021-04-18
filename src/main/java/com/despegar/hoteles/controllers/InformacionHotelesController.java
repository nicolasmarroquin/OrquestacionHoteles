package com.despegar.hoteles.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.despegar.hoteles.auth.AuthTokenController;
import com.despegar.hoteles.auth.Token;
import com.despegar.hoteles.models.entity.Hotel;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class InformacionHotelesController {
	
	@GetMapping("/informacion")
	public String informacionHotel() {
		AuthTokenController auth = new AuthTokenController();
		return auth.obtenerToken();
	}

}
