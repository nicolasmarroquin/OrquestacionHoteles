package com.despegar.hoteles.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.despegar.hoteles.models.dao.IHotelDao;
import com.despegar.hoteles.models.entity.HotelEntity;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hotelDao;

	@Override
	public HotelEntity findById(String id) {
		
		return hotelDao.findByIdHotel(id);
	}
	
}
