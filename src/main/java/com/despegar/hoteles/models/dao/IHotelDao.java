package com.despegar.hoteles.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.despegar.hoteles.models.entity.HotelEntity;

public interface IHotelDao extends CrudRepository<HotelEntity, Long>{
  public HotelEntity findByIdHotel(String id);
}
