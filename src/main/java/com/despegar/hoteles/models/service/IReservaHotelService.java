package com.despegar.hoteles.models.service;

import java.util.List;

import com.despegar.hoteles.models.entity.ReservaHotelEntity;
import com.despegar.hoteles.models.entity.UsuariosEntity;

public interface IReservaHotelService {
	public ReservaHotelEntity save(ReservaHotelEntity reservaHotel);
	public List<ReservaHotelEntity> findByUsuario(UsuariosEntity usuario);
	public ReservaHotelEntity findById(Long id);
}
