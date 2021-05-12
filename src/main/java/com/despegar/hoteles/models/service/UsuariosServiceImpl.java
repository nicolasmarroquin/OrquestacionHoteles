package com.despegar.hoteles.models.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.despegar.hoteles.models.dao.IUsuariosDao;
import com.despegar.hoteles.models.entity.UsuariosEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServiceImpl implements IUsuariosService{
	
	@Autowired
	private IUsuariosDao usuariosDao;

	@Override
	@Transactional(readOnly = true)
	public UsuariosEntity findById(Long id) {
		return usuariosDao.findById(id).orElse(null);
	}

}
