package com.despegar.hoteles.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.despegar.hoteles.models.dao.IReservaHotelDao;
import com.despegar.hoteles.models.entity.ReservaHotelEntity;
import com.despegar.hoteles.models.entity.UsuariosEntity;

@Service
public class ReservaHotelServiceImpl implements IReservaHotelService{

	@Autowired
	private IReservaHotelDao reservaDao;
	
	@Override
	@Transactional
	public ReservaHotelEntity save(ReservaHotelEntity reservaHotel) {
		
		return reservaDao.save(reservaHotel);
		
	}

	@Override
	public List<ReservaHotelEntity> findByUsuario(UsuariosEntity usuario) {
		
		return reservaDao.findByUsuario(usuario);
	}

	@Override
	public ReservaHotelEntity findById(Long id) {
		
		return reservaDao.findById(id).orElse(null);
	}

}
