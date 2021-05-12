package com.despegar.hoteles.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.despegar.hoteles.models.entity.ReservaHotelEntity;
import com.despegar.hoteles.models.entity.UsuariosEntity;

public interface IReservaHotelDao extends CrudRepository<ReservaHotelEntity, Long>{
	public List<ReservaHotelEntity> findByUsuario(UsuariosEntity usuario);
}
