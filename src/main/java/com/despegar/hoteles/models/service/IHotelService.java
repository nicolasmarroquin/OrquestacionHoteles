package com.despegar.hoteles.models.service;

import com.despegar.hoteles.models.entity.HotelEntity;

public interface IHotelService {
	public HotelEntity findById(String id);
}
