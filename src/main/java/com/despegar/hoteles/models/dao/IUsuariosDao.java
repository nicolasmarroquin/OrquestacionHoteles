package com.despegar.hoteles.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.despegar.hoteles.models.entity.UsuariosEntity;

public interface IUsuariosDao extends CrudRepository<UsuariosEntity, Long>{

}
