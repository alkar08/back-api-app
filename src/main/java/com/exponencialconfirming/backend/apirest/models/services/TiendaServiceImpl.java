package com.exponencialconfirming.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exponencialconfirming.backend.apirest.models.dao.ITiendaDao;
import com.exponencialconfirming.backend.apirest.models.entity.Tienda;

@Service
public class TiendaServiceImpl implements ITiendaService {
	
	@Autowired
	private ITiendaDao tiendaDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> findAll() {
		return (List<Tienda>) tiendaDao.findAll();
	}


	@Override
	public Tienda findById(Long id) {
		return tiendaDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public Tienda save(Tienda tienda) {
		return tiendaDao.save(tienda);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		tiendaDao.deleteById(id);
	}

}
